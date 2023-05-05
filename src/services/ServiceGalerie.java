package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entities.Galerie;
import entities.User;
import utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServiceGalerie {

    public ArrayList<Galerie> galeries;

    public static ServiceGalerie instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceGalerie() {
        req = new ConnectionRequest();
    }

    public static ServiceGalerie getInstance() {
        if (instance == null) {
            instance = new ServiceGalerie();
        }
        return instance;
    }

    public boolean addGalerie(Galerie g) {

        String Nom = g.getNom();
        String couleurHtml = g.getCouleurHtml();
        String Description = g.getDescription();
        User Photographe = g.getPhotographe();
        
        // http://127.0.0.1:8000/galerie/mobileNew?nom=testNom&description=testDesc&color=%23ff00&idUser=734
        String url = Statics.BASE_URL + "galerie/mobileNew?nom=" + Nom + "&description=" + Description
                + "color=" + couleurHtml + "&iduser=" + Photographe.getID_User();

        req.setUrl(url);
        req.setPost(false);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<Galerie> parseGaleries(String jsonText) {
        try {
            galeries = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                Galerie g = new Galerie();
                float id = Float.parseFloat(obj.get("idGalerie").toString());
                g.setID_Galerie((int) id);
                g.setCouleurHtml(obj.get("couleurhtml").toString());
                g.setDescription(obj.get("description").toString());
                g.setNom(obj.get("nom").toString());
                //g.setPhotographe((User) obj.get("idPhotographe"));
          
                galeries.add(g);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return galeries;
    }

    public ArrayList<Galerie> getAllGaleries() {
        String url = Statics.BASE_URL + "galerie/mobileAll";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                galeries = parseGaleries(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return galeries;
    }
}
