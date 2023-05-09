/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import TemplatesFiles.*;
import gui.BaseForm;
import com.codename1.components.FloatingActionButton;
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
import entities.Vote;
import java.util.ArrayList;
import java.util.List;
import services.ServiceVote;

/**
 *
 * @author wael
 */
public class ListVotes extends BaseForm{
    public ListVotes() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }
    
    
    
    public ListVotes(com.codename1.ui.util.Resources resourceObjectInstance) {
        //get toutes les votes
        ArrayList<Vote> votes = ServiceVote.getInstance().getAllVotes();

        initGuiBuilderComponents(resourceObjectInstance, votes);
        
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Votes", "Title")//,
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
        fab.addActionListener(e -> new AjouterVote().show());
    }
    
    //Ancienne methode pour populer l'affichage des votes
    public void addElement(Vote gal) {
        Container card = new Container(new BorderLayout());
        card.getStyle().setMargin(0, 0, 10, 10);

        
        int rateValue = gal.getValeur();
        Label rate = new Label(String.valueOf(rateValue), "Rate");
        rate.getStyle().setMargin(2, 2, 0, 0);
        card.add(BorderLayout.NORTH, rate);

        Label commentaire = new Label(gal.getCommentaire(), "Commentaire");
        commentaire.getStyle().setMargin(2, 2, 0, 0);
        card.add(BorderLayout.CENTER, commentaire);

        Label date = new Label(gal.getDate_Vote(), "Date");
        date.getStyle().setMargin(2, 2, 0, 0);
        card.add(BorderLayout.SOUTH, date);
        
        int VoteF = gal.getVote_Film();
        Label vote = new Label(String.valueOf(VoteF), "Vote");
        rate.getStyle().setMargin(2, 2, 0, 0);
        card.add(BorderLayout.NORTH, vote);

        // add the card to your form or container
        addComponent(card);

    }
    
    //---------------------------------------------


    


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance, ArrayList<Vote> votes) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("InboxForm");
        setName("InboxForm");
        for (Vote gal : votes) {
        com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
        com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
        com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
        com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
        com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_5 = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
        com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
        com.codename1.ui.Label gui_Label_6 = new com.codename1.ui.Label();
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
        
        addComponent(gui_Container_1);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2);
        gui_Container_2.setName("Container_2");
        gui_Container_2.addComponent(gui_Label_1);
        gui_Label_1.setText(gal.getUser().getNom()+" "+gal.getUser().getPrenom());
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
        int valeur = gal.getValeur();
        gui_Label_3.setText(String.valueOf(valeur));        
        gui_Label_3.setName("Label_3");
        
        gui_Text_Area_1.setText(gal.getCommentaire());
        gui_Text_Area_1.setUIID("SmallFontLabel");
        gui_Text_Area_1.setName("Text_Area_1");
        
        gui_Label_2.setText(gal.getDate_Vote());
        gui_Label_2.setUIID("RedLabel");
        gui_Label_2.setName("Label_2");
        
        int voteF = gal.getVote_Film();
        gui_Label_5.setText(String.valueOf(voteF));        
        gui_Label_5.setName("Label_5");
        
        gui_Container_2.setName("Container_2");
        gui_Container_4.setName("Container_4");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        gui_Container_3.setName("Container_3");
        addComponent(gui_Label_6);
        }
        
        
        
        
    }
    private void elementClicked(com.codename1.ui.util.Resources resourceObjectInstance, com.codename1.ui.Label gui_Label_4,Vote gal){
        gui_Label_4.setIcon(resourceObjectInstance.getImage("label_round-selected.png"));
        elementLongClicked(gal);
        elementUnClicked(resourceObjectInstance, gui_Label_4);
    }
    
    private void elementUnClicked(com.codename1.ui.util.Resources resourceObjectInstance, com.codename1.ui.Label gui_Label_4){
        gui_Label_4.setIcon(resourceObjectInstance.getImage("label_round.png"));
    }
    
    private void elementLongClicked(Vote gal){
        Dialog dlg = new Dialog("Rate: " + gal.getValeur() + " Commentaire : " + gal.getDate_Vote(), new BoxLayout(BoxLayout.Y_AXIS));
        Label label = new Label("Veuillez sélectionner une action");
        dlg.add(label);

        /*Button updateBtn = new Button("Modifier");
        updateBtn.addActionListener(e -> {
            System.out.println("update");
            dlg.dispose();
            new ModifierVote(gal).show();;
        });*/

        Button delBtn = new Button("Supprimer");
        delBtn.addActionListener(e -> {
            ServiceVote.getInstance().deleteVote(String.valueOf(gal.getID_Vote()));
            dlg.dispose();
            new ListVotes().show();
        });
        
        Button annulerBtn = new Button("Annuler");
        annulerBtn.addActionListener(e -> {
            dlg.dispose();
        });

        /*dlg.add(new Container(new BoxLayout(BoxLayout.X_AXIS)).add(updateBtn).add(delBtn).add(annulerBtn));
        dlg.show();*/
        
    }
}
