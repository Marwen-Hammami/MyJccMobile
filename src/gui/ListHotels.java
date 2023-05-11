/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import TemplatesFiles.*;
import gui.BaseForm;
import com.codename1.components.FloatingActionButton;
import com.codename1.io.Preferences;

import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import entities.Hotel;
import java.util.ArrayList;
import java.util.List;

import services.ServiceHotel;

/**
 *
 * @author youssef
 */
public class ListHotels  extends BaseForm {
   public ListHotels() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    @Override
    protected boolean isCurrentCalendar() {
        return true;
    }

    public ListHotels(com.codename1.ui.util.Resources resourceObjectInstance) {
        //get toutes les galeries
        ArrayList<Hotel> hotels = ServiceHotel.getInstance().getAllHotels();

        initGuiBuilderComponents(resourceObjectInstance, hotels);
        
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Hotels", "Libelle")//,
                        //new Label("19", "InboxNumber")
                )
        );
        
        
        installSidemenu(resourceObjectInstance);
        
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {});
        
        
        //gui_Label_6.setShowEvenIfBlank(true);
        
        /*
        gui_Text_Area_1.setRows(2);
        gui_Text_Area_1.setColumns(100);
        gui_Text_Area_1.setEditable(false);*/

        FloatingActionButton fab  = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        RoundBorder rb = (RoundBorder)fab.getUnselectedStyle().getBorder();
        rb.uiid(true);
        fab.bindFabToContainer(getContentPane());
     //   fab.addActionListener(e -> new AjouterHotel().show());
    }
    
    //Ancienne methode pour populer l'affichage des galeries
    public void addElement(Hotel hotel) {
        Container card = new Container(new BorderLayout());
        card.getStyle().setMargin(0, 0, 10, 10);

        Label title = new Label(hotel.getLibelle(), "Libelle");
        title.getStyle().setMargin(2, 2, 0, 0);
        card.add(BorderLayout.NORTH, title);

        Label description = new Label(hotel.getDescription(), "Description");
        description.getStyle().setMargin(2, 2, 0, 0);
        card.add(BorderLayout.CENTER, description);

        Label tel = new Label(hotel.getAdresse(), "Adresse");
        tel.getStyle().setMargin(2, 2, 0, 0);
        card.add(BorderLayout.SOUTH, tel);

        // add the card to your form or container
        addComponent(card);

    }
     //---------------------------------------------
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance, ArrayList<Hotel> hotels) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("InboxForm");
        setName("InboxForm");
        for (Hotel hot : hotels) {
        com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
        com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
        com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
        com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
        com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
        com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
        com.codename1.ui.Label gui_Label_6 = new com.codename1.ui.Label();
        //click event
        gui_Text_Area_1.addPointerPressedListener(e -> {
            elementClicked(resourceObjectInstance, gui_Label_4, hot);
        });
        gui_Label_2.addPointerPressedListener(e -> {
            elementClicked(resourceObjectInstance, gui_Label_4, hot);
        });
        gui_Label_3.addPointerPressedListener(e -> {
            elementClicked(resourceObjectInstance, gui_Label_4, hot);
        });
        gui_Label_1.addPointerPressedListener(e -> {
            elementClicked(resourceObjectInstance, gui_Label_4, hot);
        });
        gui_Label_4.addPointerPressedListener(e -> {
            elementClicked(resourceObjectInstance, gui_Label_4, hot);
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
        
        addComponent(gui_Container_1);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2);
        gui_Container_2.setName("Container_2");
        gui_Container_2.addComponent(gui_Label_1);
       // gui_Label_1.setText(hot.getPhotographe().getNom()+" "+gal.getPhotographe().getPrenom());
        gui_Label_1.setUIID("SmallFontLabel");
        gui_Label_1.setName("Label_1");
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Container_4);
        gui_Container_4.setName("Container_4");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        gui_Container_4.addComponent(gui_Label_4);
        gui_Label_4.setUIID("Padding2");
        gui_Label_4.setName("Label_4");
        gui_Label_4.setIcon(resourceObjectInstance.getImage("label_round.png"));
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3);
        gui_Container_3.setName("Container_3");
        gui_Container_3.addComponent(gui_Label_3);
        gui_Container_3.addComponent(gui_Label_2);
        gui_Container_3.addComponent(gui_Text_Area_1);
        gui_Label_3.setText(hot.getLibelle());
        gui_Label_3.setName("Label_3");
        gui_Label_2.setText(hot.getDescription());
        gui_Label_2.setUIID("RedLabel");
        gui_Label_2.setName("Label_2");
        gui_Text_Area_1.setText(hot.getAdresse());
        gui_Text_Area_1.setUIID("SmallFontLabel");
        gui_Text_Area_1.setName("Text_Area_1");
        gui_Container_2.setName("Container_2");
        gui_Container_4.setName("Container_4");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        gui_Container_3.setName("Container_3");
        addComponent(gui_Label_6);
        }
        
        
        
        
    }
    private void elementClicked(com.codename1.ui.util.Resources resourceObjectInstance, com.codename1.ui.Label gui_Label_4,Hotel hot){
        gui_Label_4.setIcon(resourceObjectInstance.getImage("label_round-selected.png"));
        elementLongClicked(hot);
        elementUnClicked(resourceObjectInstance, gui_Label_4);
    }
    
    private void elementUnClicked(com.codename1.ui.util.Resources resourceObjectInstance, com.codename1.ui.Label gui_Label_4){
        gui_Label_4.setIcon(resourceObjectInstance.getImage("label_round.png"));
    }
    
    private void elementLongClicked(Hotel hot){
        Dialog dlg = new Dialog("Hotel: " + hot.getLibelle(), new BoxLayout(BoxLayout.Y_AXIS));
        Label label = new Label("Veuillez sélectionner une action");
        dlg.add(label);
        
        Button reserverBtn = new Button("Réserver");
        reserverBtn.addActionListener(e -> {
        dlg.dispose();
        AjouterReservationHotel ajouterReservationHotel = new AjouterReservationHotel(hot.getId());
        ajouterReservationHotel.show();
    });



      /*  Button updateBtn = new Button("Modifier");
        updateBtn.addActionListener(e -> {
            System.out.println("update");
            dlg.dispose();
            new ModifierGalerie(gal).show();;
        });*/

      /*  Button delBtn = new Button("Supprimer");
        delBtn.addActionListener(e -> {
            ServiceGalerie.getInstance().deleteGalerie(String.valueOf(gal.getID_Galerie()));
            dlg.dispose();
            new ListGaleries().show();
        });*/
        
        Button annulerBtn = new Button("Annuler");
        annulerBtn.addActionListener(e -> {
            dlg.dispose();
        });

        dlg.add(new Container(new BoxLayout(BoxLayout.X_AXIS)).add(reserverBtn)./*add(updateBtn).add(delBtn).*/add(annulerBtn));
        dlg.show();
        
    }
}
        
