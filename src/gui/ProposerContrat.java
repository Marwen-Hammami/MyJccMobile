package gui;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
import entities.ContratSponsoring;
import entities.User;
import entities.Galerie;
import services.ServiceContratSponsoring;

public class ProposerContrat extends BaseForm{
    //current user connecté
    int idSponsor = 734;
    Galerie G = new Galerie();

    public ProposerContrat(Galerie G) {
        this(com.codename1.ui.util.Resources.getGlobalResources(), G);
    }
    
    public ProposerContrat(com.codename1.ui.util.Resources resourceObjectInstance, Galerie G) {
        this.G = G;
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Proposer un contrat", "Title")
                )
        );
        initGuiBuilderComponents(resourceObjectInstance, G);
        
        installSidemenu(resourceObjectInstance);
        
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {});
        
        FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
        getToolbar().addCommandToLeftBar("", mat, e2 -> {
            new GalerieDetails(G).showBack();
        });
        
    }
    
    // http://127.0.0.1:8000/contratsponsoring/ncm?is=727&ip=734&d=2023-05-10&f=2023-06-12&t=ParPhoto&e=Proposition&s=9.2
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_Text_Field_dateDebut = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_dateFin = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_type = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_salaire = new com.codename1.ui.TextField();
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();

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
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance, Galerie G) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(false);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Label_1);
        gui_Label_1.setUIID("CenterLabel");
        gui_Label_1.setName("Label_1");
        gui_Label_1.setText(G.getPhotographe().getNom()+" "+G.getPhotographe().getPrenom());
        gui_Container_1.addComponent(gui_Component_Group_1);
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Component_Group_1.addComponent(gui_Text_Field_dateDebut);
        gui_Component_Group_1.addComponent(gui_Text_Field_dateFin);
        gui_Component_Group_1.addComponent(gui_Text_Field_type);
        gui_Component_Group_1.addComponent(gui_Text_Field_salaire);
        gui_Text_Field_dateDebut.setText("2023-06-10");
        gui_Text_Field_dateFin.setText("2024-06-10");
        gui_Text_Field_type.setText("ParPhoto");
        gui_Text_Field_salaire.setText("12.3");
        gui_Container_1.addComponent(gui_Button_2);
        gui_Button_2.setText("Proposer");
        gui_Button_2.setName("Button_Ajouter");
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
    }

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        if (gui_Text_Field_dateDebut.getText().length()==0 || gui_Text_Field_dateFin.getText().length()==0 
                || gui_Text_Field_type.getText().length()==0 || gui_Text_Field_salaire.getText().length()==0)
            Dialog.show("Alert", "Veuillez remplir tous les champs", new Command("OK"));
        else
        {
            //gui_Text_Field_couleurHtml gui_Text_Field_Nom gui_Text_Field_Description gui_Text_Field_Photographe
            String dd = gui_Text_Field_dateDebut.getText();
            String df = gui_Text_Field_dateFin.getText();
            String type = gui_Text_Field_type.getText();
            String salaire = gui_Text_Field_salaire.getText();
            try {
                        if(ServiceContratSponsoring.getInstance().addContrat(idSponsor, G.getPhotographe().getID_User()
                                , dd, df, type, salaire))
                        {
                           Dialog.show("Success","Connection accepted",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
            new GalerieDetails(G).showBack();
        }
        
    }
}
