/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entities.Film;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Statics;


/**
 *
 * @author dhia
 */
public class ServiceFilm {
    public ArrayList<Film> films;

    public static ServiceFilm instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceFilm() {
        req = new ConnectionRequest();
    }
    public static ServiceFilm getInstance() {
        if (instance == null) {
            instance = new ServiceFilm();
        }
        return instance;
    }
    public boolean addFilm(String Titre, String DateRealisation, String Genre, String Resume, String Duree, float Prix,String ID_producteur,String Acteur,String Image) {    
    // http://127.0.0.1:8000/film/mobileNew?titre=testNom&genre=test$&date=2000&duree=1h&prix=12&prod=test&resume=test&acteur=test&image=http://localhost/myjcc/films/dachra.png
    String url = Statics.BASE_URL + "film/mobileNew?titre=" + Titre + "&genre=" + Genre
        + "&date=" + DateRealisation  + "&duree=" + Duree + "&prix=" + Prix + "&prod=" + ID_producteur + "&resume=" + Resume +"&acteur=" + Acteur + "&image=" + Image ;
    System.out.println(url);
    int index = url.indexOf("#");
    if (index >= 0) {
        String part1 = url.substring(0, index);
        String part2 = url.substring(index + 1, url.length());
        req.setUrl(part1 + "%23" + part2);
    } else {
        req.setUrl(url);
    }
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

    public boolean updateFilm(int id,String Titre, String DateRealisation, String Genre, String Resume, String Duree, float Prix,String ID_producteur,String Acteur,String Image) {    
        // http://127.0.0.1:8000/film/mobileupdate/24?titre=testNom12345&genre=test&resume=test$&date=2000&duree=1h&prix=12&prod=test&resume=test&acteur=test&image=http://localhost/myjcc/films/dachra.png
        String url = Statics.BASE_URL + "film/mobileupdate/"+ id + "?titre=" + Titre + "&genre=" + Genre
            + "&date=" + DateRealisation  + "&duree=" + Duree + "&prix=" + Prix + "&prod=" + ID_producteur + "&resume=" + Resume +"&acteur=" + Acteur + "&image=" + Image ;
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
    
    public boolean deleteFilm(String id) {    
        /// http://127.0.0.1:8000/film/mobileDelete/21
        String url = Statics.BASE_URL + "film/mobileDelete/" + id ;
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
    
    public ArrayList<Film> parseFilms(String jsonText) {
        try {
            films = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                Film g = new Film();
                //pour retirer la vergule sinon : Exception: java.lang.NumberFormatException - For input string: "1.0"
                float id = Float.parseFloat(obj.get("idFilm").toString());
                g.setID_film((int) id);
                if (obj.get("date") != null) {
    g.setDateRealisation(obj.get("date").toString());
}

                g.setGenre(obj.get("genre").toString());
                g.setDuree(obj.get("duree").toString());
                g.setResume(obj.get("resume").toString());
                g.setTitre(obj.get("titre").toString());
                g.setActeur(obj.get("acteur").toString());
                if (obj.get("prod") != null) {
    g.setDateRealisation(obj.get("prod").toString());
}
                if (obj.get("image") != null) {
    g.setDateRealisation(obj.get("image").toString());
}
               g.setPrix(Float.parseFloat(obj.get("prix").toString()));

                
               
          
                films.add(g);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return films;
    }
    public ArrayList<Film> getAllFilms() {
        String url = Statics.BASE_URL + "film/filmsmobile";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                films = parseFilms(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return films;
    }
    public void DeleteFilm(int id) {
     
        String url = Statics.BASE_URL + "film/mobileDelete/" + id;

        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

    }


}
