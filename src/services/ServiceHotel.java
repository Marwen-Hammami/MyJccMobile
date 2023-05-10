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
import entities.Hotel;
import entities.User;
import utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Type;

/**
 *
 * @author youssef
 */
public class ServiceHotel {
    public ArrayList<Hotel> hotels;

    public static ServiceHotel instance = null;
    public boolean resultOK;
    private ConnectionRequest req;
    
    private ServiceHotel() {
    req = new ConnectionRequest();
    }
    
    public static ServiceHotel getInstance() {
        if (instance == null) {
            instance = new ServiceHotel();
        }
        return instance;
    }
    
// ajouter un hotel
    public boolean addHotel(String libelle, String adresse, int nbreChambres, int telephone, String description) {    
    //   http://127.0.0.1:8000/mobileNewhotel?libelle=testNewLibelle&adresse=testNewAdresse&nbreChambres=10&telephone=12345678&description=testNewDescription
        String url = Statics.BASE_URL + "mobileNewhotel?libelle=" + libelle + "&adresse=" + adresse
            + "&nbreChambres=" + nbreChambres + "&telephone=" + telephone + "&description=" + description;
        
        System.out.println(url);
        String part1 = url.substring(0, url.indexOf("#"));
        String part2 = url.substring(url.indexOf("#") + 1, url.length());
        req.setUrl(part1);
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
    // parseHotel
     public ArrayList<Hotel> parseHotels(String jsonText) {
        try {
            hotels = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                Hotel h = new Hotel();
                //pour retirer la vergule sinon : Exception: java.lang.NumberFormatException - For input string: "1.0"
                float id = Float.parseFloat(obj.get("idHotel").toString());
                h.setId((int) id);
                h.setLibelle(obj.get("libelle").toString());
                h.setAdresse(obj.get("adresse").toString()) ;
                double nbreChambresDouble = Double.parseDouble(obj.get("nbreChambres").toString());
                int nbreChambres = (int) nbreChambresDouble;
                h.setNbre_chambres(nbreChambres);
                
                double telephoneDouble = Double.parseDouble(obj.get("telephone").toString());
                int telephone = (int) telephoneDouble;
                h.setTelephone(telephone);

                h.setDescription(obj.get("description").toString()); 
                hotels.add(h);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return hotels;
    }    
    // afficher tous les hotels
    public ArrayList<Hotel> getAllHotels() {
        String url = Statics.BASE_URL + "mobileAllhotels";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                hotels = parseHotels(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return hotels;
    }
  /*  //modifierrr hotelll
     public boolean modifierHotel(int id, String libelle, String adresse, int nbreChambres, int telephone, String description) {    
// http://127.0.0.1:8000/hotel/mobileUpdate/1?libelle=testNewLibelle&adresse=testNewAdresse&nbreChambres=10&telephone=12345678&description=testNewDescription
        String url = Statics.BASE_URL + "mobileUpdate" + id + "?libelle=" + libelle + "&adresse=" + adresse
            + "&nbreChambres=" + nbreChambres + "&telephone=" + telephone + "&description=" + description;
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
    // supprimer un hotel
    public boolean deleteHotel(String idHotel) {    
        // http://127.0.0.1:8000/mobileDelete/64
        String url = Statics.BASE_URL + "mobileDelete" + idHotel ;
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
    }*/
    
}
