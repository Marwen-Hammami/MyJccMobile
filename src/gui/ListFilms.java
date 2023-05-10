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
import entities.Film;
import java.util.ArrayList;
import java.util.List;
import services.ServiceFilm;
import com.codename1.ui.events.SelectionListener;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;


public class ListFilms extends BaseForm {
    
    private static final int LONG_PRESS_DURATION = 1000; // milliseconds


    public ListFilms() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }
    
    
    
    public ListFilms(com.codename1.ui.util.Resources resourceObjectInstance) {
        //get toutes les films
        ArrayList<Film> films = ServiceFilm.getInstance().getAllFilms();

        initGuiBuilderComponents(resourceObjectInstance, films);
        
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("films", "Title")//,
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
        //fab.addActionListener(e -> new AjouterGalerie().show());
        
    }
    
    //Ancienne methode pour populer l'affichage des films
    public void addElement(Film gal) {
        Container card = new Container(new BorderLayout());
        card.getStyle().setMargin(0, 0, 10, 10);

        Label title = new Label(gal.getTitre(), "Title");
        title.getStyle().setMargin(2, 2, 0, 0);
        card.add(BorderLayout.NORTH, title);

        Label description = new Label(gal.getGenre(), "Description");
        description.getStyle().setMargin(2, 2, 0, 0);
        card.add(BorderLayout.CENTER, description);

        Label date = new Label(gal.getDateRealisation(), "Date");
        date.getStyle().setMargin(2, 2, 0, 0);
        card.add(BorderLayout.SOUTH, date);

        // add the card to your form or container
        addComponent(card);

    }
    
    //---------------------------------------------


    


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance, ArrayList<Film> films) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("InboxForm");
        setName("InboxForm");
        MultiList filmsList = new MultiList();
DefaultListModel model = new DefaultListModel();
        for (Film gal : films) {
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
            elementClicked(resourceObjectInstance, gui_Label_4, gal);
            model.addItem(gal);
        });
        
gui_Label_4.addPointerPressedListener((evt)->{ 
    elementClicked(resourceObjectInstance, gui_Label_4, gal); 
});
filmsList.setModel(model);
filmsList.addSelectionListener(new SelectionListener() {
    @Override
    public void selectionChanged(int oldSelected, int newSelected) {
        // get the selected film object
        Film selectedFilm = (Film) model.getItemAt(newSelected);
        // open the new form and pass the selected film object to it
        new ShowFilm(selectedFilm).show();
    }
});



        
        addComponent(gui_Container_1);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2);
        gui_Container_2.setName("Container_2");
        gui_Container_2.addComponent(gui_Label_1);
        gui_Label_1.setText(gal.getTitre());
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
        
        gui_Label_3.setText(gal.getTitre());
        gui_Label_3.setName("Label_3");
        gui_Label_2.setText(gal.getDuree());
        gui_Label_2.setUIID("RedLabel");
        gui_Label_2.setName("Label_2");
        gui_Text_Area_1.setText(gal.getDateRealisation());
        gui_Text_Area_1.setUIID("SmallFontLabel");
        gui_Text_Area_1.setName("Text_Area_1");
        gui_Container_2.setName("Container_2");
        gui_Container_4.setName("Container_4");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        gui_Container_3.setName("Container_3");
        addComponent(gui_Label_6);
        
        }
        
        
        
        
        
    }
    private void elementClicked(com.codename1.ui.util.Resources resourceObjectInstance, com.codename1.ui.Label gui_Label_4,Film gal){
    gui_Label_4.setIcon(resourceObjectInstance.getImage("label_round-selected.png"));
    elementLongClicked(gal);
    elementUnClicked(resourceObjectInstance, gui_Label_4);
}

    
    private void elementUnClicked(com.codename1.ui.util.Resources resourceObjectInstance, com.codename1.ui.Label gui_Label_4){
        gui_Label_4.setIcon(resourceObjectInstance.getImage("label_round.png"));
        System.out.println("Pointer pressed!");

    }
    
   private void elementLongClicked(Film gal) {
       ServiceFilm service = new ServiceFilm();
    Dialog dlg = new Dialog("Film: " + gal.getTitre(), new BoxLayout(BoxLayout.Y_AXIS));
    Label label = new Label("Veuillez sélectionner une action");
    dlg.add(label);

    Button annulerBtn = new Button("Annuler");
    annulerBtn.addActionListener(e -> {
        dlg.dispose();
    });
    Button detailsBtn = new Button("Modifier");
    detailsBtn.addActionListener(e -> {
        ModifierFilm modfilm = new ModifierFilm();
        modfilm.show();
    });
    
    Button suppbtn = new Button("supprimer");
    suppbtn.addActionListener(e -> {
    service.DeleteFilm(gal.getID_film());
    dlg.dispose();
    ListFilms listfilm = new ListFilms();
    listfilm.show();
    });
    dlg.addAll(detailsBtn, annulerBtn, suppbtn);
    dlg.show();
}

}
