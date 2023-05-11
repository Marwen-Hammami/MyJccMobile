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
import entities.Vote;
import entities.User;
import utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Type;
/**
 *
 * @author wael
 */
public class ServiceVote {
    public ArrayList<Vote> Votes;

    public static ServiceVote instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceVote() {
        req = new ConnectionRequest();
    }

    public static ServiceVote getInstance() {
        if (instance == null) {
            instance = new ServiceVote();
        }
        return instance;
    }
    
    public boolean addVote(String film,String user,String valeur,String Date_Vote,String commentaire,String Vote_Film) {    
        // http://127.0.0.1:8000/mobileNew?idfilm=1&iduser=693&valeur=4&dateVote=12/05/2023&commentaire=kys&votefilm=1
        String url = Statics.BASE_URL + "mobileNew?idfilm=" + film + "&iduser=" + user
            + "&valeur=" + valeur+ "&dateVote=" + Date_Vote + "&commentaire=" + commentaire  + "&votefilm=" + Vote_Film;
        System.out.println(url);
        /*String part1 = url.substring(0, url.indexOf("#"));
        String part2 = url.substring(url.indexOf("#") + 1, url.length());
        req.setUrl(part1 + "%23" + part2);*/
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
    
    public boolean updateVote(String film,String user,String valeur,String Date_Vote,String commentaire,String Vote_Film) {    
        // http://127.0.0.1:8000/mobileupdate/30?idfilm=1&iduser=693&valeur=0&dateVote=12/05/2023&commentaire=sssss&votefilm=0
        String url = Statics.BASE_URL + "mobileupdate?idfilm=" + film + "&iduser=" + user
            + "&valeur=" + valeur+ "&dateVote=" + Date_Vote + "&commentaire=" + commentaire  + "&votefilm=" + Vote_Film;
        /*String part1 = url.substring(0, url.indexOf("#"));
        String part2 = url.substring(url.indexOf("#") + 1, url.length());
        req.setUrl(part1 + "%23" + part2);*/
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
    
    public boolean deleteVote(int idVote) {    
        // http://127.0.0.1:8000/mobileDelete/29
        String url = Statics.BASE_URL + "mobileDelete/" + idVote ;
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
    
    
    public ArrayList<Vote> parseVotes(String jsonText) {
        try {
            Votes = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                Vote g = new Vote();
                //pour retirer la vergule sinon : Exception: java.lang.NumberFormatException - For input string: "1.0"
                if (obj.get("ID_Vote") != null) {
    int ID_Vote = Integer.parseInt(obj.get("ID_Vote").toString());
    g.setID_Vote(ID_Vote);
                }
                float Valeur = Float.parseFloat(obj.get("valeur").toString());
                //float Vote_Film = Float.parseFloat(obj.get("votefilm").toString());
                
                if (obj.get("votefilm") != null) {
    int Vote_Film = Integer.parseInt(obj.get("votefilm").toString());
    g.setVote_Film(Vote_Film);
}
                
                //g.setID_Vote((int) ID_Vote);
                g.setValeur((int) Valeur);
                g.setCommentaire(obj.get("commentaire").toString());
                g.setDate_Vote(obj.get("dateVote").toString());
                //g.setVote_Film((int) Vote_Film);
                Map<String, Object> spectateurJson = (Map<String, Object>) obj.get("iduser");
                User spectateur = new User();
               
                
                if (obj.get("iduser") != null) {
    float ID_User = Float.parseFloat(spectateurJson.get("iduser").toString());
                spectateur.setID_User((int) ID_User);
}
               
                Map<String, Object> filmJson = (Map<String, Object>) obj.get("idfilm");
                Film film = new Film();
               
                
                if (obj.get("idfilm") != null) {
    float ID_Film = Float.parseFloat(filmJson.get("idfilm").toString());
                film.setID_film((int) ID_Film);
}
                
                g.setUser(spectateur);
                g.setFilm(film);
                
          
                Votes.add(g);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return Votes;
    }
    
    
    public ArrayList<Vote> getAllVotes() {
        String url = Statics.BASE_URL + "mobileVotes";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Votes = parseVotes(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Votes;
    }
}