package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entities.Post;
import utils.statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServicePost {

    public ArrayList<Post> posts;

    public static ServicePost instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServicePost() {
        req = new ConnectionRequest();
    }

    public static ServicePost getInstance() {
        if (instance == null) {
            instance = new ServicePost();
        }
        return instance;
    }

    public boolean addGalerie(String title, String description, String image, String postdate) {    
        // http://127.0.0.1:8000/mobileNew?title=testNom&description=testDesc&image=test&postdate=03/06/18
        String url = statics.BASE_URL + "/mobileNew?title=" + title + "&description=" + description
            + "&image=" + image + "postdate=" + postdate;
        System.out.println(url);
        String part1 = url.substring(0, url.indexOf("#"));
        String part2 = url.substring(url.indexOf("#") + 1, url.length());
        req.setUrl(part1 + "%23" + part2);
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
    
    public boolean modifierpost(int id,String title, String description, String image, String postdate) {    
        // http://127.0.0.1:8000/mobileUpdate/3?title=testNom&description=testDesc&image=test&postdate=03/06/18
        String url = statics.BASE_URL + "/mobileupdate/title=" + title + "&description=" + description
            + "&image=" + image + "postdate=" + postdate;
        String part1 = url.substring(0, url.indexOf("#"));
        String part2 = url.substring(url.indexOf("#") + 1, url.length());
        req.setUrl(part1 + "%23" + part2);
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
    
    public boolean deleteGalerie(String idGal) {    
        // http://127.0.0.1:8000/galerie/mobileDelete/729
        String url = statics.BASE_URL + "/mobileDelete" + idGal ;
        System.out.println(url);
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

    public ArrayList<Post> parseGaleries(String jsonText) {
        try {
            posts = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                Post g = new Post();
                //pour retirer la vergule sinon : Exception: java.lang.NumberFormatException - For input string: "1.0"
                float id = Float.parseFloat(obj.get("id").toString());
                g.setId((int) id);
                g.setTitle(obj.get("title").toString());
                g.setDescription(obj.get("description").toString());
                g.setImage(obj.get("Image").toString());
                g.setPostdate(obj.get("postdate").toString());

                //récupérer les attribus de user photographe dans galerie
            
                //pour retirer la vergule sinon : Exception: java.lang.NumberFormatException - For input string: "693.0"
                //photographe.setID_User(Integer.parseInt(photographeJson.get("idUser").toString().substring(0, photographeJson.get("idUser").toString().indexOf("."))));
         
                //récupérer le role et le transformer en enum
              
          
                posts.add(g);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return posts;
    }

    public ArrayList<Post> getAllPost() {
        String url = statics.BASE_URL + "/mobileAll";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                posts = parseGaleries(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return posts;
    }
}

/* exemple json
{
    "idGalerie": 1,
    "couleurhtml": "#c9f9a9",
    "nom": "Expérience",
    "description": "Du haut de mes 53 ans,je suis surtout un photogaphe avec plus de 30 ans d'expérience!",
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
  },


*/