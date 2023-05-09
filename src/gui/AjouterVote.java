/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import TemplatesFiles.*;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import services.ServiceVote;
/**
 *
 * @author wael
 */
public class AjouterVote extends com.codename1.ui.Form{
    
    public AjouterVote() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public AjouterVote(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        getTitleArea().setUIID("Container");
        getToolbar().setUIID("Container");
        getToolbar().getTitleComponent().setUIID("SigninTitle");
        FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
        getToolbar().addCommandToLeftBar("", mat, e2 -> {
            System.out.println("close------------------");
            new ListGaleries().show();
    });
        getContentPane().setUIID("SignInForm");
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
    private com.codename1.ui.TextField gui_Text_Field_valeur = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_ID_User = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_ID_Film = new com.codename1.ui.TextField();
    private com.codename1.ui.TextArea gui_Text_Area_commentaire = new com.codename1.ui.TextArea();
    private com.codename1.ui.TextField gui_TextField_dateVote = new com.codename1.ui.TextField();
    private com.codename1.ui.CheckBox gui_checkbox_voteFilm = new com.codename1.ui.CheckBox();
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

            /*if(sourceComponent == gui_Button_2) {
                onButton_2ActionEvent(ev);
            }*/
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setTitle("Ajouter vote");
        setName("SignInForm");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(false);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.addComponent(gui_Component_Group_1);
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Component_Group_1.addComponent(gui_Text_Field_valeur);
        gui_Component_Group_1.addComponent(gui_Text_Field_ID_User);
        gui_Component_Group_1.addComponent(gui_Text_Field_ID_Film);
        gui_Component_Group_1.addComponent(gui_Text_Area_commentaire);
        gui_Component_Group_1.addComponent(gui_TextField_dateVote);
        gui_Component_Group_1.addComponent(gui_checkbox_voteFilm);
        gui_Text_Field_valeur.setText("Valeur");
        gui_Text_Field_valeur.setName("Text_Field_valeur");
        gui_Text_Field_ID_User.setText("ID_User");
        gui_Text_Field_ID_User.setName("Text_Field_ID_User");
        gui_Text_Field_ID_Film.setText("ID_Film");
        gui_Text_Field_ID_Film.setName("Text_Field_ID_Film");
        gui_Text_Area_commentaire.setText("Commentaire");
        gui_Text_Area_commentaire.setName("Text_Field_commentaire");////
        gui_TextField_dateVote.setText("Date_Vote");
        gui_TextField_dateVote.setName("Text_Field_datevote");
        gui_checkbox_voteFilm.setText("Vote_Film");
        gui_checkbox_voteFilm.setName("gui_checkbox_voteFilm");
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
   /* public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        if (gui_Text_Field_couleurHtml.getText().length()==0 || gui_Text_Field_Nom.getText().length()==0 
                || gui_Text_Field_Description.getText().length()==0 || gui_Text_Field_Photographe.getText().length()==0
                || gui_Text_Field_couleurHtml.getText().equals("couleurHtml")
                || gui_Text_Field_Nom.getText().equals("Nom")
                || gui_Text_Field_Description.getText().equals("Description")
                || gui_Text_Field_Photographe.getText().equals("ID Photographe"))
            Dialog.show("Alert", "Veuillez remplir tous les champs", new Command("OK"));
        else
        {
            //gui_Text_Field_couleurHtml gui_Text_Field_Nom gui_Text_Field_Description gui_Text_Field_Photographe
            String couleurHtml = gui_Text_Field_couleurHtml.getText();
            String Nom = gui_Text_Field_Nom.getText();
            String Description = gui_Text_Field_Description.getText();
            String IdUser = gui_Text_Field_Photographe.getText();
            try {
                        if(ServiceVote.getInstance().addVote( film, user,valeur, Date_Vote,commentaire, Vote_Film))
                        {
                           Dialog.show("Success","Connection accepted",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
            new ListVotes().show();
        }
        
    }*/
}
