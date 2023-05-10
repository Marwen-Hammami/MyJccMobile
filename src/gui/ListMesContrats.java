package gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import entities.ContratSponsoring;
import entities.Galerie;
import java.io.IOException;
import java.util.ArrayList;
import services.ServiceContratSponsoring;
import services.ServiceGalerie;

public class ListMesContrats extends BaseForm {
    
    int idCurrentUserSponsor = 734;

    public ListMesContrats() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    @Override
    protected boolean isCurrentContarts() {
        return true;
    }
    
    public ListMesContrats(com.codename1.ui.util.Resources resourceObjectInstance) {
        //get toutes les galeries
        ArrayList<ContratSponsoring> contrats = ServiceContratSponsoring.getInstance().getAllContrats(idCurrentUserSponsor);

        initGuiBuilderComponents(resourceObjectInstance, contrats);
        
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Mes Contrats", "Title"),
                        new Label(contrats.size() + " contrats", "InboxNumber")
                )
        );
        
        
        
        installSidemenu(resourceObjectInstance);
        
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {});
    }
    
        private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance, ArrayList<ContratSponsoring> contrats) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        for (ContratSponsoring cont : contrats) {
        com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_1_email = new com.codename1.ui.Label();
        com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
        com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
        com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_salaire = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_type = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_etat = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_separator = new com.codename1.ui.Label();
        //pour l'image utilisateur photographe
        EncodedImage enc = null;
        Image imgs;
        ImageViewer imgv;
        String img_url = cont.getPhotoraphe().getPhotoB64() ;
        //click event
        gui_Label_etat.addPointerPressedListener(e -> {
            elementClicked(resourceObjectInstance, gui_Label_4, cont);
        });
        gui_Label_type.addPointerPressedListener(e -> {
            elementClicked(resourceObjectInstance, gui_Label_4, cont);
        });
        gui_Label_salaire.addPointerPressedListener(e -> {
            elementClicked(resourceObjectInstance, gui_Label_4, cont);
        });
        gui_Label_2.addPointerPressedListener(e -> {
            elementClicked(resourceObjectInstance, gui_Label_4, cont);
        });
        gui_Label_3.addPointerPressedListener(e -> {
            elementClicked(resourceObjectInstance, gui_Label_4, cont);
        });
        gui_Label_1.addPointerPressedListener(e -> {
            elementClicked(resourceObjectInstance, gui_Label_4, cont);
        });
        gui_Label_1_email.addPointerPressedListener(e -> {
            elementClicked(resourceObjectInstance, gui_Label_4, cont);
        });
        gui_Label_4.addPointerPressedListener(e -> {
            elementClicked(resourceObjectInstance, gui_Label_4, cont);
        });
        // gui_Container_1 est la card
        addComponent(gui_Container_1);
        //Ajout à droite les détails du photographe
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2);
        gui_Container_2.addComponent(gui_Label_1);
        gui_Label_1.setText(cont.getPhotoraphe().getNom()+" "+cont.getPhotoraphe().getPrenom());
        gui_Label_1.setUIID("SmallFontLabel");
        gui_Container_2.addComponent(gui_Label_1_email);
        gui_Label_1_email.setText(cont.getPhotoraphe().getEmail());
        gui_Label_1_email.setUIID("SmallFontLabel");
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
        gui_Container_3.addComponent(gui_Label_3);//date debut
        gui_Container_3.addComponent(gui_Label_2);//date fin
        gui_Container_3.addComponent(gui_Label_etat);
        gui_Container_3.addComponent(gui_Label_type);
        gui_Container_3.addComponent(gui_Label_salaire);
        gui_Label_3.setText("Date début: " + cont.getDateDebut());
        gui_Label_2.setText("Date fin: " + cont.getDateFin());
        gui_Label_type.setText("Type: " + cont.getType());
        gui_Label_etat.setText("Etat: " + cont.getEtat());
        gui_Label_etat.setUIID("RedLabel");
        gui_Label_salaire.setText("Salaire: " + cont.getSalaireDt());
        //Ajout d'unne barre de séparation dans le bas
        gui_Label_separator.setText("―――――――――――――――――――――――――――");
        gui_Container_1.addComponent(BorderLayout.SOUTH, gui_Label_separator);
        }  
    }
        
        private void elementClicked(com.codename1.ui.util.Resources resourceObjectInstance, com.codename1.ui.Label gui_Label_4,ContratSponsoring cont){
        gui_Label_4.setIcon(resourceObjectInstance.getImage("label_round-selected.png"));
        //(modifier & supprimer)
        elementLongClicked(cont);
        gui_Label_4.setIcon(resourceObjectInstance.getImage("label_round.png"));
    }
    
    private void elementUnClicked(com.codename1.ui.util.Resources resourceObjectInstance, com.codename1.ui.Label gui_Label_4){
        gui_Label_4.setIcon(resourceObjectInstance.getImage("label_round.png"));
    }
    
    private void elementLongClicked(ContratSponsoring cont){
        Dialog dlg = new Dialog("Contrat: " + cont.getEtat(), new BoxLayout(BoxLayout.Y_AXIS));
        Label label = new Label("Veuillez sélectionner une action");
        dlg.add(label);

        Button updateBtn = new Button("Modifier");
        updateBtn.addActionListener(e -> {
            dlg.dispose();
            new ModifierContrat(cont).show();;
        });

        Button delBtn = new Button("Supprimer");
        delBtn.addActionListener(e -> {
            ServiceContratSponsoring.getInstance().deleteContrat(String.valueOf(cont.getID_Contrat()));
            dlg.dispose();
            new ListMesContrats().showBack();
        });
        
        Button annulerBtn = new Button("Annuler");
        annulerBtn.addActionListener(e -> {
            dlg.dispose();
        });

        dlg.add(new Container(new BoxLayout(BoxLayout.X_AXIS)).add(updateBtn).add(delBtn).add(annulerBtn));
        dlg.show();
        
    }

}
