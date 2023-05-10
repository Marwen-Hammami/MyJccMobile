package gui;

import com.codename1.components.ImageViewer;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.ImageIO;
import java.util.ArrayList;
import entities.Galerie;
import entities.Photographie;
import java.io.IOException;
import java.io.OutputStream;
import services.ServicePhotographies;

public class GalerieDetails extends BaseForm{
    
    Galerie thisGalerie = new Galerie();

    public GalerieDetails(Galerie G) {
        this(com.codename1.ui.util.Resources.getGlobalResources(), G);
    }
    
    public GalerieDetails(com.codename1.ui.util.Resources resourceObjectInstance, Galerie G) {
        thisGalerie = G;
        
        //get toutes les photographies de la galerie G
        ArrayList<Photographie> photographies = ServicePhotographies.getInstance().getAllPhotosUneGalerie(G.getID_Galerie());
        
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label(G.getNom(), "Title"),
                        new Label(photographies.size() + " Photos", "InboxNumber")
                )
        );
        
        initDetailsGalerie(resourceObjectInstance, G);
        
        initListPhotographies(resourceObjectInstance, photographies);
        
        installSidemenu(resourceObjectInstance);
        
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {});
        
        FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
        getToolbar().addCommandToLeftBar("", mat, e2 -> {
            new ListGaleries().showBack();
    });
    }
    
    public void initDetailsGalerie(com.codename1.ui.util.Resources resourceObjectInstance, Galerie gal){
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        //ajouter details galerie
        com.codename1.ui.Label gui_gal_nom = new com.codename1.ui.Label();
        addComponent(gui_gal_nom);
        gui_gal_nom.setText("Galerie : "+gal.getNom());
        com.codename1.ui.Label gui_gal_couleur = new com.codename1.ui.Label();
        addComponent(gui_gal_couleur);
        gui_gal_couleur.setText("Code couleur Html : "+gal.getCouleurHtml());
        com.codename1.ui.Label gui_gal_description = new com.codename1.ui.Label();
        addComponent(gui_gal_description);
        gui_gal_description.setText("Description : "+gal.getDescription());
        com.codename1.ui.Label gui_Label_separator = new com.codename1.ui.Label();
        addComponent(gui_Label_separator);
        gui_Label_separator.setText("―――――――――――――――――――――――――――");
        //ajouter details photographe
            //pour l'image utilisateur photographe
        EncodedImage enc = null;
        Image imgs;
        ImageViewer imgv;
        String img_url = gal.getPhotographe().getPhotoB64() ;
        try{
            enc = EncodedImage.create("/loading.png");
        }catch (IOException ex){
            System.out.println("Erreur de load.png IMAGE, lors de l'encodage -- " + ex);
        }
        imgs = URLImage.createToStorage(enc, img_url, img_url, URLImage.RESIZE_SCALE);
        Image scaledImage = imgs.scaled(400, 400);
        imgv = new ImageViewer(scaledImage);
        addComponent(imgv);
            //reste user
        com.codename1.ui.Label gui_user_nompren = new com.codename1.ui.Label();
        addComponent(gui_user_nompren);
        gui_user_nompren.setUIID("CenterLabel");
        gui_user_nompren.setText(gal.getPhotographe().getNom() + " " + gal.getPhotographe().getPrenom());
        com.codename1.ui.Label gui_user_email = new com.codename1.ui.Label();
        addComponent(gui_user_email);
        gui_user_email.setUIID("CenterLabel");
        gui_user_email.setText(gal.getPhotographe().getEmail());
        com.codename1.ui.Label gui_Label_separator2 = new com.codename1.ui.Label();
        addComponent(gui_Label_separator2);
        gui_Label_separator2.setText("―――――――――――――――――――――――――――");
        com.codename1.ui.Label gui_Label_list = new com.codename1.ui.Label();
        addComponent(gui_Label_list);
        gui_Label_list.setText("Liste des Photographies :");
        com.codename1.ui.Label gui_Label_separator3 = new com.codename1.ui.Label();
        addComponent(gui_Label_separator3);
        gui_Label_separator3.setText("―――――――――――――――――――――――――――");
    }
   
     private void initListPhotographies(com.codename1.ui.util.Resources resourceObjectInstance, ArrayList<Photographie> photos) {
        
        for (Photographie photo : photos) {
        //pour l'image utilisateur photographe
        EncodedImage enc = null;
        Image imgs;
        ImageViewer imgv;
        String img_url = photo.getPhotographiePath() ;
        try{
            enc = EncodedImage.create("/loading.png");
        }catch (IOException ex){
            System.out.println("Erreur de load.png IMAGE, lors de l'encodage -- " + ex);
        }
        imgs = URLImage.createToStorage(enc, img_url, img_url, URLImage.RESIZE_SCALE);
        Image scaledImage = imgs.scaled(900, 600);
        imgv = new ImageViewer(scaledImage);
        imgv.addPointerPressedListener(e -> {
            // Enregistrer l'image sur le téléphone
            downloadImageToPhone(imgs, img_url);
        });
        addComponent(imgv);
        //autres details photo
        com.codename1.ui.Label gui_Label_nom = new com.codename1.ui.Label();
        addComponent(gui_Label_nom);
        gui_Label_nom.setText("Nom : "+photo.getNom());
        gui_Label_nom.addPointerPressedListener(e -> {
            // Enregistrer l'image sur le téléphone
            downloadImageToPhone(imgs, img_url);
        });
        com.codename1.ui.Label gui_Label_description = new com.codename1.ui.Label();
        addComponent(gui_Label_description);
        gui_Label_description.setText("Description : "+photo.getDescription());
        com.codename1.ui.Label gui_Label_separator3 = new com.codename1.ui.Label();
        addComponent(gui_Label_separator3);
        gui_Label_separator3.setText("―――――――――――――――――――――――――――");
        }
    }
     
     
    private void downloadImageToPhone(Image imgs, String img_url){
        System.out.println("clic DL");
        // Enregistrer l'image sur le téléphone
            OutputStream os = null;
            try {
                String fileName = System.currentTimeMillis() + ".png";
                String filePath = FileSystemStorage.getInstance().getAppHomePath() + fileName;
                os = FileSystemStorage.getInstance().openOutputStream(filePath);
                ImageIO.getImageIO().save(imgs, os, ImageIO.FORMAT_PNG, 1);
                os.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
    }

}
