package gui;

import TemplatesFiles.*;
import gui.BaseForm;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import entities.Galerie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import services.ServiceGalerie;

public class ListGaleries extends BaseForm {

    public ListGaleries() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }
    
    
    
    public ListGaleries(com.codename1.ui.util.Resources resourceObjectInstance) {
        //get toutes les galeries
        ArrayList<Galerie> galeries = ServiceGalerie.getInstance().getAllGaleries();

        initGuiBuilderComponents(resourceObjectInstance, galeries);
        
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Galeries", "Title")//,
                        //new Label("19", "InboxNumber")
                )
        );
        
        
        
        installSidemenu(resourceObjectInstance);
        
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {});
        
        /* Partie Admin (Ajouter)
        FloatingActionButton fab  = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        RoundBorder rb = (RoundBorder)fab.getUnselectedStyle().getBorder();
        rb.uiid(true);
        fab.bindFabToContainer(getContentPane());
        fab.addActionListener(e -> new AjouterGalerie().show());
        */
    } 


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance, ArrayList<Galerie> galeries) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("InboxForm");
        setName("InboxForm");
        for (Galerie gal : galeries) {
        com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
        com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
        com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
        com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
        com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
        com.codename1.ui.Label gui_Label_separator = new com.codename1.ui.Label();
        //pour l'image utilisateur photographe
        EncodedImage enc = null;
        Image imgs;
        ImageViewer imgv;
        String img_url = gal.getPhotographe().getPhotoB64() ;
        //click event
        gui_Text_Area_1.addPointerPressedListener(e -> {
            elementClicked(resourceObjectInstance, gui_Label_4, gal);
        });
        gui_Label_2.addPointerPressedListener(e -> {
            elementClicked(resourceObjectInstance, gui_Label_4, gal);
        });
        gui_Label_3.addPointerPressedListener(e -> {
            elementClicked(resourceObjectInstance, gui_Label_4, gal);
        });
        gui_Label_1.addPointerPressedListener(e -> {
            elementClicked(resourceObjectInstance, gui_Label_4, gal);
        });
        gui_Label_4.addPointerPressedListener(e -> {
            elementClicked(resourceObjectInstance, gui_Label_4, gal);
        });
        //release click unclick event
        gui_Text_Area_1.addPointerReleasedListener(e -> {
            elementUnClicked(resourceObjectInstance, gui_Label_4);
        });
        gui_Label_2.addPointerReleasedListener(e -> {
            elementUnClicked(resourceObjectInstance, gui_Label_4);
        });
        gui_Label_3.addPointerReleasedListener(e -> {
            elementUnClicked(resourceObjectInstance, gui_Label_4);
        });
        gui_Label_1.addPointerReleasedListener(e -> {
            elementUnClicked(resourceObjectInstance, gui_Label_4);
        });
        gui_Label_4.addPointerReleasedListener(e -> {
            elementUnClicked(resourceObjectInstance, gui_Label_4);
        });
        // gui_Container_1 est la card
        addComponent(gui_Container_1);
        //Ajout à droite les détails du photographe
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2);
        gui_Container_2.addComponent(gui_Label_1);
        gui_Label_1.setText(gal.getPhotographe().getNom()+" "+gal.getPhotographe().getPrenom());
        gui_Label_1.setUIID("SmallFontLabel");
            //partie photographe user picture
        try{
            enc = EncodedImage.create("/loading.png");
        }catch (IOException ex){
            System.out.println("Erreur de load.png IMAGE, lors de l'encodage -- " + ex);
        }
        imgs = URLImage.createToStorage(enc, img_url, img_url, URLImage.RESIZE_SCALE);
        Image scaledImage = imgs.scaled(200, 200);
        imgv = new ImageViewer(scaledImage);
        gui_Container_2.addComponent(imgv);
        //Ajout à gauche icon cercle
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Container_4);
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        gui_Container_4.addComponent(gui_Label_4);
        gui_Label_4.setUIID("Padding2");
        gui_Label_4.setIcon(resourceObjectInstance.getImage("label_round.png"));
        //Ajout au milieu les détails de la galerie
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3);
        gui_Container_3.addComponent(gui_Label_3);
        gui_Container_3.addComponent(gui_Label_2);
        gui_Container_3.addComponent(gui_Text_Area_1);
        gui_Label_3.setText(gal.getNom());
        gui_Label_2.setText(gal.getCouleurHtml());
        gui_Label_2.setUIID("RedLabel");
        gui_Text_Area_1.setText(gal.getDescription());
        gui_Text_Area_1.setEditable(false);
        gui_Text_Area_1.setUIID("SmallFontLabel");
        //Ajout d'unne barre de séparation dans le bas
        gui_Label_separator.setText("―――――――――――――――――――――――――――");
        gui_Container_1.addComponent(BorderLayout.SOUTH, gui_Label_separator);
        }  
    }
    
    private void elementClicked(com.codename1.ui.util.Resources resourceObjectInstance, com.codename1.ui.Label gui_Label_4,Galerie gal){
        gui_Label_4.setIcon(resourceObjectInstance.getImage("label_round-selected.png"));
        new GalerieDetails(gal).show();
        /* Partie admin (modifier & supprimer)
        elementLongClicked(gal);
        */
    }
    
    private void elementUnClicked(com.codename1.ui.util.Resources resourceObjectInstance, com.codename1.ui.Label gui_Label_4){
        gui_Label_4.setIcon(resourceObjectInstance.getImage("label_round.png"));
    }
    
    private void elementLongClicked(Galerie gal){
        Dialog dlg = new Dialog("Galerie: " + gal.getNom(), new BoxLayout(BoxLayout.Y_AXIS));
        Label label = new Label("Veuillez sélectionner une action");
        dlg.add(label);

        Button updateBtn = new Button("Modifier");
        updateBtn.addActionListener(e -> {
            System.out.println("update");
            dlg.dispose();
            new ModifierGalerie(gal).show();;
        });

        Button delBtn = new Button("Supprimer");
        delBtn.addActionListener(e -> {
            ServiceGalerie.getInstance().deleteGalerie(String.valueOf(gal.getID_Galerie()));
            dlg.dispose();
            new ListGaleries().show();
        });
        
        Button annulerBtn = new Button("Annuler");
        annulerBtn.addActionListener(e -> {
            dlg.dispose();
        });

        dlg.add(new Container(new BoxLayout(BoxLayout.X_AXIS)).add(updateBtn).add(delBtn).add(annulerBtn));
        dlg.show();
        
    }
}
