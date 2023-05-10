package gui;

import TemplatesFiles.*;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import services.ServiceFilm;
import java.lang.String;

public class AjouterFilm extends com.codename1.ui.Form {

    public AjouterFilm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public AjouterFilm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        getTitleArea().setUIID("Container");
        getToolbar().setUIID("Container");
        getToolbar().getTitleComponent().setUIID("SigninTitle");
        FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
        getToolbar().addCommandToLeftBar("", mat, e2 -> {
            System.out.println("close------------------");
            new ListFilms().show();
    });
        getContentPane().setUIID("SignInForm");
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
    private com.codename1.ui.TextField gui_Text_Field_Titre = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_DateRealisation = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_Genre = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_Resume = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_Duree = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_Prix  = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_ID_producteur = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_Acteur = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_Image = new com.codename1.ui.TextField();
    
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    //private com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button_2.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();
            if(sourceComponent.getParent().getLeadParent() != null) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_Button_2) {
                onButton_2ActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setTitle("Ajouter un film");
        setName("SignInForm");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(false);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.addComponent(gui_Component_Group_1);
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Component_Group_1.addComponent(gui_Text_Field_Titre);
        gui_Component_Group_1.addComponent(gui_Text_Field_DateRealisation);
        gui_Component_Group_1.addComponent(gui_Text_Field_Genre);
        gui_Component_Group_1.addComponent(gui_Text_Field_Resume);
        gui_Component_Group_1.addComponent(gui_Text_Field_Duree);
        gui_Component_Group_1.addComponent(gui_Text_Field_Prix);
        gui_Component_Group_1.addComponent(gui_Text_Field_ID_producteur);
        gui_Component_Group_1.addComponent(gui_Text_Field_Acteur);
        gui_Component_Group_1.addComponent(gui_Text_Field_Image);
        
        gui_Text_Field_Titre.setText("titre");
        gui_Text_Field_Titre.setName("Text_Field_titre");
        gui_Text_Field_DateRealisation.setText("Date");
        gui_Text_Field_DateRealisation.setName("Text_Field_DateRealisation");
        gui_Text_Field_Genre.setText("Genre");
        gui_Text_Field_Genre.setName("Text_Field_Genre");
        gui_Text_Field_Resume.setText("Resume");
        gui_Text_Field_Resume.setName("Text_Field_Resume");
        gui_Text_Field_Duree.setText("Duree");
        gui_Text_Field_Duree.setName("Text_Field_Duree");
        gui_Text_Field_Prix.setText("Prix");
        gui_Text_Field_Prix.setName("Text_Field_Prix");
        gui_Text_Field_ID_producteur.setText("Producteur");
        gui_Text_Field_ID_producteur.setName("Text_Field_ID_producteur");
        gui_Text_Field_Acteur.setText("acteur");
        gui_Text_Field_Acteur.setName("Text_Field_Acteur");
        gui_Text_Field_Image.setText("image");
        gui_Text_Field_Image.setName("Text_Field_Image");
        gui_Container_1.addComponent(gui_Button_2);
        //gui_Container_1.addComponent(gui_Button_3);
        gui_Label_1.setUIID("CenterLabel");
        gui_Label_1.setName("Label_1");
        gui_Label_1.setIcon(resourceObjectInstance.getImage("profile_image.png"));
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Button_2.setText("Ajouter");
        gui_Button_2.setName("Button_Ajouter");
        //gui_Button_3.setText("Forgot Your Password");
        //gui_Button_3.setUIID("CenterLabelSmall");
        //gui_Button_3.setName("Button_3");
        //addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Button_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        //gui_Button_1.setText("Create New Account");
        //gui_Button_1.setUIID("CenterLabel");
        //gui_Button_1.setName("Button_1");
    }

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) {
    String titre = gui_Text_Field_Titre.getText();
    String date = gui_Text_Field_DateRealisation.getText();
    String genre = gui_Text_Field_Genre.getText();
    String resume = gui_Text_Field_Resume.getText();
    String duree = gui_Text_Field_Duree.getText();
    String prixText = gui_Text_Field_Prix.getText();
    String idProducteur = gui_Text_Field_ID_producteur.getText();
    String acteur = gui_Text_Field_Acteur.getText();
    String image = gui_Text_Field_Image.getText();
    
    
    if (titre.isEmpty()) {
        Dialog.show("Alert", "Le champ Titre est obligatoire", new Command("OK"));
        return;
    }
    
    
    if (!isValidDate(date)) {
        Dialog.show("Alert", "Le champ Date de réalisation doit être une date valide au format JJ/MM/AAAA", new Command("OK"));
        return;
    }
    
    
    if (genre.isEmpty()) {
        Dialog.show("Alert", "Le champ Genre est obligatoire", new Command("OK"));
        return;
    }
    
    
    if (resume.isEmpty()) {
        Dialog.show("Alert", "Le champ Résumé est obligatoire", new Command("OK"));
        return;
    }
    
    
    if (duree.isEmpty()) {
        Dialog.show("Alert", "Le champ Durée doit être au format HH:MM", new Command("OK"));
        return;
    }
    
    
    Float prix = null;
    try {
        prix = Float.parseFloat(prixText);
        if (prix <= 0) {
            Dialog.show("Alert", "Le champ Prix doit être supérieur à 0", new Command("OK"));
            return;
        }
    } catch (NumberFormatException e) {
        Dialog.show("Alert", "Le champ Prix doit être un nombre valide", new Command("OK"));
        return;
    }
    
    
    if (idProducteur.isEmpty()) {
        Dialog.show("Alert", "Le champ ID producteur est obligatoire", new Command("OK"));
        return;
    }
    
    
    if (acteur.isEmpty()) {
        Dialog.show("Alert", "Le champ Acteur est obligatoire", new Command("OK"));
        return;
    }
    
    
    try {
        if(ServiceFilm.getInstance().addFilm(titre, date, genre, resume, duree, prix, idProducteur, acteur, image)) {
            Dialog.show("Success","Le film a été ajouté avec succès",new Command("OK"));
        } else {
            Dialog.show("ERROR", "Une erreur s'est produite lors de l'ajout du film", new Command("OK"));
        }
    } catch (Exception e) {
        Dialog.show("ERROR", "Une erreur s'est produite lors de l'ajout du film", new Command("OK"));
    }
    
    new ListFilms().show();
}


private boolean isValidDate(String date) {
    if (date.isEmpty()) {
        return false;
    }
    return true;
}




}