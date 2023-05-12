package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entities.ContratSponsoring;
import entities.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Statics;

public class ServiceLogin {
    //Current user
    public static User user = new User();
    
    public static ServiceLogin instance = null;
    public boolean resultOK;
    private ConnectionRequest req;
    
    private ServiceLogin() {
        req = new ConnectionRequest();
    }

    public static ServiceLogin getInstance() {
        if (instance == null) {
            instance = new ServiceLogin();
        }
        return instance;
    }
    
    
    public void Login(String email) {
        String url = Statics.BASE_URL + "user/Mobilelogin?email=" + email;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    String result = new String(req.getResponseData());
                    ///
                    JSONParser j = new JSONParser();
                    Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(result.toCharArray()));
                    
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
                    for (Map<String, Object> obj : list) {
                    user.setNom(obj.get("nom").toString());
                    user.setPrenom(obj.get("prenom").toString());
                    user.setEmail(obj.get("email").toString());
                    user.setPhotoB64(obj.get("photob64").toString());
                    }
                    ////

                    req.removeResponseListener(this);
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
}
