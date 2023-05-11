/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import TemplatesFiles.*;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import services.ServiceVote;
/**
 *
 * @author wael
 */
public class AjoutVote extends com.codename1.ui.Form{
    public AjoutVote() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public AjoutVote(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        getTitleArea().setUIID("Container");
        getToolbar().setUIID("Container");
        getToolbar().getTitleComponent().setUIID("SigninTitle");
        FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
        getToolbar().addCommandToLeftBar("", mat, e2 -> {
            new ListeVotes().showBack();
    });
        getContentPane().setUIID("SignInForm");
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
    private com.codename1.ui.TextField gui_Text_Field_Valeur = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_User = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_Film = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_Commentaire = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_Date = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_Vote = new com.codename1.ui.TextField();
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
        setTitle("Ajouter Vote");
        setName("SignInForm");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(false);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.addComponent(gui_Component_Group_1);
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Component_Group_1.addComponent(gui_Text_Field_Valeur);
        gui_Component_Group_1.addComponent(gui_Text_Field_User);
        gui_Component_Group_1.addComponent(gui_Text_Field_Film);
        gui_Component_Group_1.addComponent(gui_Text_Field_Commentaire);
        gui_Component_Group_1.addComponent(gui_Text_Field_Date);
        gui_Component_Group_1.addComponent(gui_Text_Field_Vote);
            gui_Text_Field_Valeur.setText("valeur");
        gui_Text_Field_Valeur.setName("Text_Field_Valeur");
        gui_Text_Field_User.setText("idUser");
        gui_Text_Field_User.setName("Text_Field_User");
        gui_Text_Field_Film.setText("idFilm");
        gui_Text_Field_Film.setName("Text_Field_Film");
        gui_Text_Field_Commentaire.setText("commentaire");
        gui_Text_Field_Commentaire.setName("Text_Field_Commentaire");
        
        gui_Text_Field_Date.setText("dateVote");
        gui_Text_Field_Date.setName("Text_Field_Date");
        gui_Text_Field_Vote.setText("voteFilm");
        gui_Text_Field_Vote.setName("Text_Field_Vote");
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
        /*if (gui_Text_Field_Valeur.getText().length()==0 || gui_Text_Field_User.getText().length()==0 
                || gui_Text_Field_Film.getText().length()==0 || gui_Text_Field_Commentaire.getText().length()==0
                || gui_Text_Field_Date.getText().length()==0|| gui_Text_Field_Vote.getText().length()==0
                || gui_Text_Field_Valeur.getText().equals("valeur")
                || gui_Text_Field_User.getText().equals("idUser")
                || gui_Text_Field_Film.getText().equals("idFilm")
                || gui_Text_Field_Commentaire.getText().equals("commentaire")
                || gui_Text_Field_Date.getText().equals("dateVote")
                || gui_Text_Field_Vote.getText().equals("voteFilm"))
            Dialog.show("Alert", "Veuillez remplir tous les champs", new Command("OK"));
        else
        {*/
            //gui_Text_Field_vote gui_Text_Field_Nom gui_Text_Field_Description gui_Text_Field_Photographe
            String valeur = gui_Text_Field_Vote.getText();
            String user = gui_Text_Field_User.getText();
            String film = gui_Text_Field_Film.getText();
            String commentaire = gui_Text_Field_Commentaire.getText();
            String date = gui_Text_Field_Date.getText();
            String vote = gui_Text_Field_Vote.getText();
        
        Float valeur1 = null;
    try {
        valeur1 = Float.parseFloat(valeur);
        if (valeur1 < 0 || valeur1 >5) {
            Dialog.show("Alert", "Le champ Rate doit être supérieur à 0 et inferieur a 5", new Command("OK"));
            return;
        }
    } catch (NumberFormatException e) {
        Dialog.show("Alert", "Le champ Rate doit être un nombre valide", new Command("OK"));
        return;
    }
    
    if (user.isEmpty()) {
        Dialog.show("Alert", "Le champ User est obligatoire", new Command("OK"));
        return;
    }
    
    
    if (film.isEmpty()) {
        Dialog.show("Alert", "Le champ Film est obligatoire", new Command("OK"));
        return;
    }  
    
    
    
    
    if (commentaire.isEmpty()) {
        Dialog.show("Alert", "Le champ commentaire est obligatoire", new Command("OK"));
        return;
    }
    
    
    
    
    
    if (!isValidDate(date)) {
        Dialog.show("Alert", "Le champ Date de réalisation doit être une date valide au format JJ/MM/AAAA", new Command("OK"));
        return;
    }
    
    
    Float vote1 = null;
try {
    valeur1 = Float.parseFloat(valeur);
    vote1 = Float.valueOf(valeur1);
    if (vote1 < 0 || vote1 > 1) {
        Dialog.show("Alert", "Le champ Vote doit être entre 0 ou 1", new Command("OK"));
        return;
    }
} catch (NumberFormatException e) {
    Dialog.show("Alert", "Le champ Vote doit être un nombre valide", new Command("OK"));
    return;
}

            try {
                        if(ServiceVote.getInstance().addVote(film,user,valeur,date,commentaire,vote))
                        {
                           Dialog.show("Success","Connection accepted",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
            new ListeVotes().show();
        }
        
    private boolean isValidDate(String date) {
    if (date.isEmpty()) {
        return false;
    }
    return true;
}
    
    }

