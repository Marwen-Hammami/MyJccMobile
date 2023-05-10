package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import utils.Statics;
import entities.ContratSponsoring;
import entities.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.EnumEtatContrat;
import utils.EnumTypeContrat;
import utils.Type;
//PDF imports
/*
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPTable;
*/

public class ServiceContratSponsoring {
    
    public ArrayList<ContratSponsoring> contrats;

    public static ServiceContratSponsoring instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceContratSponsoring() {
        req = new ConnectionRequest();
    }

    public static ServiceContratSponsoring getInstance() {
        if (instance == null) {
            instance = new ServiceContratSponsoring();
        }
        return instance;
    }
    
    public boolean modifierContrat(int ic, int is, int ip, String d, String f, String t, String s) {    
        // http://127.0.0.1:8000/contratsponsoring/mobileUpdate?ic=82&is=727&ip=734&d=2023-05-10&f=2023-06-12&t=ParPhoto&e=Proposition&s=9.2
        String url = Statics.BASE_URL + "contratsponsoring/mobileUpdate?ic=" + ic + "&is=" + is + "&ip=" + ip 
                + "&d=" + d+ "&f=" + f + "&t=" + t + "&e=ContreProposition&s=" + s ;
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
    
    public boolean deleteContrat(String idC) {    
        // http://127.0.0.1:8000/contratsponsoring/mobileDelete/145
        String url = Statics.BASE_URL + "contratsponsoring/mobileDelete/" + idC ;
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
    
    // http://127.0.0.1:8000/contratsponsoring/ncm?is=727&ip=734&d=2023-05-10&f=2023-06-12&t=ParPhoto&e=Proposition&s=9.2
    public boolean addContrat(int is, int ip, String d, String f, String t, String s) {   
        /* Creation pdf
        User sponsor = new User();
        sponsor.setID_User(is);
        User photographe = new User();
        photographe.setID_User(ip);
        ContratSponsoring c = new ContratSponsoring(d, f, EnumTypeContrat.valueOf(t), EnumEtatContrat.Proposition
                , Float.parseFloat(s), t, sponsor, "http://localhost/myjcc/contrats/signatures/def.png", photographe
                , "http://localhost/myjcc/contrats/signatures/def.png");
        try {
            createPdf("C:\\Users\\Marwen\\Desktop\\mercedess.pdf", c);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        */
        String url = Statics.BASE_URL + "contratsponsoring/ncm?is=" + is + "&ip=" + ip + "&d=" + d+ "&f=" + f
            + "&t=" + t + "&e=Proposition&s=" + s ;
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
    
    public ArrayList<ContratSponsoring> parseContrats(String jsonText) {
        try {
            contrats = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                ContratSponsoring c = new ContratSponsoring();
                //pour retirer la vergule sinon : Exception: java.lang.NumberFormatException - For input string: "1.0"
                float id = Float.parseFloat(obj.get("idContrat").toString());
                c.setID_Contrat((int) id);
                c.setDateDebut(obj.get("datedebut").toString());
                c.setDateFin(obj.get("datefin").toString());
                String typeString = obj.get("type").toString();
                EnumTypeContrat type = EnumTypeContrat.valueOf(typeString);
                c.setType(type);
                String etatString = obj.get("etat").toString();
                EnumEtatContrat etat = EnumEtatContrat.valueOf(etatString);
                c.setEtat(etat);
                c.setSalaireDt(Float.parseFloat(obj.get("salairedt").toString()));
                c.setTermesPDF(obj.get("termespdf").toString());
                c.setSignatureSponsor(obj.get("signaturesponsor").toString());
                c.setSignaturePhotographe(obj.get("signaturephotographe").toString());

                //récupérer les attribus de user photographe dans le contart
                Map<String, Object> photographeJson = (Map<String, Object>) obj.get("idPhotographe");
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
                c.setPhotoraphe(photographe);
                
                //récupérer les attribus de user sponsor dans le contrat
                Map<String, Object> sponsorJson = (Map<String, Object>) obj.get("idSponsor");
                User sponsor = new User();
                //pour retirer la vergule sinon : Exception: java.lang.NumberFormatException - For input string: "693.0"
                //photographe.setID_User(Integer.parseInt(photographeJson.get("idUser").toString().substring(0, photographeJson.get("idUser").toString().indexOf("."))));
                float ID_User2 = Float.parseFloat(sponsorJson.get("idUser").toString());
                sponsor.setID_User((int) ID_User2);
                sponsor.setNom(sponsorJson.get("nom").toString());
                sponsor.setPrenom(sponsorJson.get("prenom").toString());
                sponsor.setSexe(sponsorJson.get("genre").toString());
                sponsor.setEmail(sponsorJson.get("email").toString());
                sponsor.setMotDePasse(sponsorJson.get("motdepasse").toString());
                //récupérer le role et le transformer en enum
                String roleString2 = sponsorJson.get("role").toString();
                Type role2 = Type.valueOf(roleString2.toUpperCase());
                sponsor.setRole(role2);
                sponsor.setPhotoB64(sponsorJson.get("photob64").toString());
                //photographe.setNumTel(Integer.parseInt(photographeJson.get("numtel").toString()));
                c.setSponsor(sponsor);
          
                contrats.add(c);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return contrats;
    }

    public ArrayList<ContratSponsoring> getAllContrats(int id) {
        String url = Statics.BASE_URL + "contratsponsoring/mobMesContr?idSponsor=" + id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                contrats = parseContrats(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return contrats;
    }
    /*
    //Créer un pdf avec les informations du contrat
    //exemple dest ‪C:\Users\Marwen\Desktop\testContrat.pdf
    public void createPdf(String dest, ContratSponsoring c) throws Exception {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();

        // Add header
        Paragraph header = new Paragraph("Contrat Sponsoring : " + c.getEtat().toString());
        header.setAlignment(Element.ALIGN_CENTER);
        document.add(header);

        // Create table
        PdfPTable table = new PdfPTable(2);
        Paragraph contentSponsor = new Paragraph("Sponsor : " + c.getSponsor().getNom() + " " + c.getSponsor().getPrenom()
                + "\nEmail : " + c.getSponsor().getEmail());
        table.addCell(contentSponsor);
        Paragraph contentPhotographe = new Paragraph("Sponsor : " + c.getPhotoraphe().getNom() + " " + c.getPhotoraphe().getPrenom()
                + "\nEmail : " + c.getPhotoraphe().getEmail());
        table.addCell(contentPhotographe);
        Image imageSponsor = Image.getInstance(c.getSponsor().getPhotoB64());
        imageSponsor.scaleToFit(200, 200);
        table.addCell(imageSponsor);
        Image imagePhotographe = Image.getInstance(c.getPhotoraphe().getPhotoB64());
        imagePhotographe.scaleToFit(200, 200);
        table.addCell(imagePhotographe);
        table.setSpacingBefore(30f);
        table.setSpacingAfter(30f);

        document.add(table);

        //Add termes du contrat
        Paragraph contentTermes = new Paragraph("Date de début du contrat : " + c.getDateDebut()
                + "\nDate de Fin du contrat : " + c.getDateFin()
                + "\nType de contrat : " + c.getType()
                + "\nSalaire en Dt : " + c.getSalaireDt());
        document.add(contentTermes);

        // Add footer
        Paragraph footer = new Paragraph("Le " + "10/05/2023"
                + "\nSignature Sponsor :");
        footer.setAlignment(Element.ALIGN_CENTER);
        document.add(footer);
        //Signatures***********
        // Create table2
        PdfPTable table2 = new PdfPTable(2);
        Paragraph LeSponsor = new Paragraph("Signature du Sponsor");
        table2.addCell(LeSponsor);
        Paragraph LePhotographe = new Paragraph("Signature du Photographe");
        table2.addCell(LePhotographe);

        //selon etat****************************
            Image SignatureSponsor = Image.getInstance("http://localhost/myjcc/contrats/signatures/def.png");
            imageSponsor.scaleToFit(200, 200);
            table2.addCell(SignatureSponsor);
            Image SignaturePhotographe = Image.getInstance("http://localhost/myjcc/contrats/signatures/def.png");
            imagePhotographe.scaleToFit(200, 200);
            table2.addCell(SignaturePhotographe);
        
        //**************************************

        table2.setSpacingBefore(30f);
        table2.setSpacingAfter(30f);

        document.add(table2);
        //**********************
        document.close();
    }
    //---------------------------------------------
    */
}

/*
// http://127.0.0.1:8000/contratsponsoring/ncm?is=727&ip=734&d=2023-05-10&f=2023-06-12&t=ParPhoto&e=Proposition&s=9.2

{
  "idContrat": 143,
  "datedebut": "2023-05-10T00:00:00+02:00",
  "datefin": "2023-06-12T00:00:00+02:00",
  "type": "ParPhoto",
  "etat": "Proposition",
  "salairedt": 9.2,
  "termespdf": "-",
  "signaturesponsor": "-",
  "signaturephotographe": "-",
  "idSponsor": {
    "idUser": 727,
    "nom": "Trabelsi",
    "prenom": "Saif",
    "genre": "Homme",
    "email": "trabelsisaif@gmail.com",
    "motdepasse": "$2a$10$30ZtUAO5rgKjLx8yglgQn.4wOQMVztMOFPMEjqkpqXimUXWSltpu2",
    "role": "SPONSOR",
    "photob64": "http://localhost/myjcc/profile/21.png",
    "numtel": 12345678
  },
  "idPhotographe": {
    "idUser": 734,
    "nom": "Lajmi",
    "prenom": "Hamza",
    "genre": "Homme",
    "email": "lajmihamza@yahoo.fr",
    "motdepasse": "$2a$10$30ZtUAO5rgKjLx8yglgQn.4wOQMVztMOFPMEjqkpqXimUXWSltpu2",
    "role": "PHOTOGRAPHE",
    "photob64": "http://localhost/myjcc/profile/23.png",
    "numtel": 12345678
  }
}
*/