package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entities.Photographie;
import entities.User;
import entities.Galerie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Statics;
import utils.Type;

public class ServicePhotographies {
    public ArrayList<Photographie> photographies;

    public static ServicePhotographies instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServicePhotographies() {
        req = new ConnectionRequest();
    }
    
    public static ServicePhotographies getInstance() {
        if (instance == null) {
            instance = new ServicePhotographies();
        }
        return instance;
    }
    
        public ArrayList<Photographie> parsePhotographies(String jsonText) {
        try {
            photographies = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                Photographie f = new Photographie();
                //pour retirer la vergule sinon : Exception: java.lang.NumberFormatException - For input string: "1.0"
                float id = Float.parseFloat(obj.get("idPhotographie").toString());
                f.setID_Photographie((int) id);
                f.setNom(obj.get("nom").toString());
                f.setDescription(obj.get("description").toString());
                f.setPhotographiePath(obj.get("photographiepath").toString());
                //récupérer les attribus de galerie dans photographie
                Map<String, Object> GalerieJson = (Map<String, Object>) obj.get("idGalerie");
                Galerie gal = new Galerie();
                //pour retirer la vergule sinon : Exception: java.lang.NumberFormatException - For input string: "693.0"
                //photographe.setID_User(Integer.parseInt(photographeJson.get("idUser").toString().substring(0, photographeJson.get("idUser").toString().indexOf("."))));
                float id_gal = Float.parseFloat(GalerieJson.get("idGalerie").toString());
                gal.setID_Galerie((int) id_gal);
                gal.setCouleurHtml(GalerieJson.get("couleurhtml").toString());
                gal.setDescription(GalerieJson.get("description").toString());
                gal.setNom(GalerieJson.get("nom").toString());
                //user dans galerie dans photographie
                Map<String, Object> photographeJson = (Map<String, Object>) GalerieJson.get("idPhotographe");
                User photographe = new User();
                //pour retirer la vergule sinon : Exception: java.lang.NumberFormatException - For input string: "693.0"
                //photographe.setID_User(Integer.parseInt(photographeJson.get("idUser").toString().substring(0, photographeJson.get("idUser").toString().indexOf("."))));
                float ID_User = Float.parseFloat(photographeJson.get("idUser").toString());
                photographe.setID_User((int) ID_User);
                photographe.setNom(photographeJson.get("nom").toString());
                photographe.setPrenom(photographeJson.get("prenom").toString());
                photographe.setSexe(photographeJson.get("genre").toString());
                photographe.setEmail(photographeJson.get("email").toString());
                photographe.setMotDePasse(photographeJson.get("motdepasse").toString());
                //récupérer le role et le transformer en enum
                String roleString = photographeJson.get("role").toString();
                Type role = Type.valueOf(roleString.toUpperCase());
                photographe.setRole(role);
                photographe.setPhotoB64(photographeJson.get("photob64").toString());
                //photographe.setNumTel(Integer.parseInt(photographeJson.get("numtel").toString()));
                gal.setPhotographe(photographe);
                
                
                f.setGalerie(gal);
          
                photographies.add(f);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return photographies;
    }

    public ArrayList<Photographie> getAllPhotosUneGalerie(int id) {
        String url = Statics.BASE_URL + "photographie/mobileShowphotos/" + id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                photographies = parsePhotographies(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return photographies;
    }
    
    
    
    
}


/*
{
    "idPhotographie": 12,
    "nom": "Tapis Rouge",
    "description": "New photo Du tapis rouge 16/02\nnouvelle ligne.",
    "photographiepath": "http://localhost/myjcc/photographies/3.jpg",
    "idGalerie": {
      "idGalerie": 1,
      "couleurhtml": "#c9f9a9",
      "nom": "Expérience",
      "description": "Du haut de mes 22 ans,je suis surtout un photogaphe avec plus de 30 ans d'expérience!",
      "idPhotographe": {
        "idUser": 693,
        "nom": "Hammami",
        "prenom": "Marwen",
        "genre": "Homme",
        "email": "marwen.hammami@esprit.tn",
        "motdepasse": "$2a$10$30ZtUAO5rgKjLx8yglgQn.4wOQMVztMOFPMEjqkpqXimUXWSltpu2",
        "role": "PHOTOGRAPHE",
        "photob64": "http://localhost/myjcc/profile/5.jpg",
        "numtel": 20924931
      }
    }
  },
*/