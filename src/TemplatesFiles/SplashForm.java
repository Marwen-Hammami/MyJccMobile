/*
 * Ne pas déplacer ce fichier (première interface appelé par le theme)
 */

package TemplatesFiles;

import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Effects;
import com.codename1.ui.util.UITimer;
import gui.WalkthruForm;

/**
* Ce fichier représente la première interface lancé avec l'application
* Le logo qui tourne, ensuite redirection
 */
public class SplashForm extends com.codename1.ui.Form {

    public SplashForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public SplashForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        getTitleArea().setUIID("Container");
        int size = Display.getInstance().convertToPixels(1f);
        Image progress = Effects.dropshadow(resourceObjectInstance.getImage("logo2.png"), 10, 70, size, size);
        gui_Infinite_Progress_1.setAnimation(progress);
        gui_Infinite_Progress_1.setAngleIncrease(1);
        Image logoImage = Effects.dropshadow(resourceObjectInstance.getImage("typo.png"), 10, 70, size, size);
        gui_Label_1.setIcon(logoImage);
        //Redirection apres timer
        UITimer.timer(3000, false, this, () -> new WalkthruForm(resourceObjectInstance).show());
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.components.InfiniteProgress gui_Infinite_Progress_1 = new com.codename1.components.InfiniteProgress();
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setUIID("Splash");
        setTitle("");
        setName("SplashForm");
        ((com.codename1.ui.layouts.BorderLayout)getLayout()).setCenterBehavior(com.codename1.ui.layouts.BorderLayout.CENTER_BEHAVIOR_CENTER);
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Container_2);
        gui_Container_2.setName("Container_2");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_2.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        gui_Container_2.addComponent(gui_Infinite_Progress_1);
        gui_Infinite_Progress_1.setName("Infinite_Progress_1");
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_2.setName("Container_2");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_2.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        gui_Label_1.setName("Label_1");
        gui_Label_1.setIcon(resourceObjectInstance.getImage("logo.png"));
        gui_Container_1.setName("Container_1");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
