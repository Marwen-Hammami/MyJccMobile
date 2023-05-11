/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Hotel;
import entities.ReservationHotel;
import entities.User;
import java.io.IOException;
import java.util.ArrayList;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;

import com.codename1.ui.events.ActionListener;

import java.util.List;
import java.util.Map;


import utils.Statics;


/**
 *
 * @author youssef
 */
public class ServiceReservationHotel {
    
    public ArrayList<ReservationHotel> reservationHotels;

    public static ServiceReservationHotel instance = null;
    public boolean resultOK;
    private ConnectionRequest req;   
    
    private ServiceReservationHotel() {
    req = new ConnectionRequest();
   }
    public static ServiceReservationHotel getInstance() {
        if (instance == null) {
            instance = new ServiceReservationHotel();
        }
        return instance;
    }
    
       public boolean addReservationHotel(String Datereservation , String DateDebut, String DateFin, float TarifTotal, String qrpath, int IdUser, int IdHotel) {    
        // http://127.0.0.1:8000
        //mobileNewReservation?idUser=ID_UTILISATEUR&idHotel=ID_HOTEL&dateDebut=DATE_DEBUT&dateFin=DATE_FIN&tariftotale=TARIF_TOTAL&qrpath=QR_PATH
        String url = Statics.BASE_URL + "mobileNewReservation?idUser=" + IdUser + "&idHotel=" + IdHotel
            + "&dateDebut=" + DateDebut + "&dateFin=" + DateFin+ "&tariftotale=" + TarifTotal+ "&qrpath=" + qrpath ;
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
       
 // parseHotel
 public ArrayList<ReservationHotel> parseEntitie(String jsonText){
      try {
         reservationHotels = new ArrayList<>();
         JSONParser j = new JSONParser();
         Map<String, Object> ProduitListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
         List< Map<String, Object>> list = (List< Map<String, Object>>) ProduitListJson.get("root");
         for (Map<String, Object> obj : list) {
             ReservationHotel p = new ReservationHotel();
             Map<String, Object> idUserObj = (Map<String, Object>) obj.get("idUser");
             Map<String, Object> idHotelObj = (Map<String, Object>) obj.get("idHotel");

             // float idTrajet = Float.parseFloat(obj.get("idTrajet").toString());
             float idReservation = Float.parseFloat(obj.get("idReservationh").toString());
             p.setIdReservationH((int) idReservation);
             //   p.setIdReservation((int)idReservation);
             /* SET USER */

             User u = new User();
             float id = Float.parseFloat(idUserObj.get("idUser").toString());
             float num = Float.parseFloat(idUserObj.get("numtel").toString());
             u.setID_User((int) id);
             u.setNom(idUserObj.get("nom").toString());
             u.setPrenom(idUserObj.get("prenom").toString());

             u.setEmail(idUserObj.get("email").toString());

             //u.setNumTel((int) num);
             p.setUser(u);
             /* End Set User */
                /*SET Hotel*/
             float idHotel = Float.parseFloat(idHotelObj.get("idHotel").toString());
             Hotel h = new Hotel();
             h.setLibelle(idHotelObj.get("libelle").toString());
             h.setAdresse(idHotelObj.get("adresse").toString());
             float nbre_chambres = Float.parseFloat(idHotelObj.get("nbreChambres").toString());
             h.setNbre_chambres((int) nbre_chambres);
             float telephone = Float.parseFloat(idHotelObj.get("telephone").toString());
             h.setTelephone((int) telephone);
             h.setDescription(idHotelObj.get("description").toString());
             p.setHotel(h);
             /* End Set Trajet */

             reservationHotels.add(p);          
        } }
           catch (IOException ex) {
//            Logger.getLogger(ServiceOeuvre.class.getName()).log(Level.SEVERE, null, ex);            
        }
          return reservationHotels;
 }

        public ArrayList<ReservationHotel> getAllResevationsHotel() {
        String url = Statics.BASE_URL + "reservationmobileAll";
            System.out.println("servicessss "+url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               reservationHotels = parseEntitie(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reservationHotels;
    }
            public ArrayList<ReservationHotel> getReservationByID(String idRes) {
        String url = Statics.BASE_URL + "reservationmobile/" + idRes;
            System.out.println("servicessss "+url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               reservationHotels = parseEntitie(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reservationHotels;
    }
       public boolean deleteReservation(String idRes) {    
        // http://127.0.0.1:8000/galerie/mobileDelete/729
        String url = Statics.BASE_URL + "mobileDeletereservationhotel/" + idRes ;
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

      
}
    

