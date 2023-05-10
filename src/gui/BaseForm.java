package gui;

import TemplatesFiles.CalendarForm;
import TemplatesFiles.InboxForm;
import TemplatesFiles.StatsForm;
import TemplatesFiles.TrendingForm;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

public class BaseForm extends Form {
    public void installSidemenu(Resources res) {
        Image selection = res.getImage("selection-in-sidemenu.png");
        
        Image galeriesImage = null;
        if(isCurrentInbox()) galeriesImage = selection;

        Image trendingImage = null;
        if(isCurrentTrending()) trendingImage = selection;
        
        Image calendarImage = null;
        if(isCurrentCalendar()) calendarImage = selection;
        
        Image statsImage = null;
        if(isCurrentStats()) statsImage = selection;
        
        Image mesContratsImage = null;
        if(isCurrentContarts()) mesContratsImage = selection;
        
        Button galerieButton = new Button("Liste Galeries", galeriesImage);
        galerieButton.setUIID("SideCommand");
        galerieButton.getAllStyles().setPaddingBottom(0);
        Container inbox = FlowLayout.encloseMiddle(galerieButton);//, new Label("18", "SideCommandNumber"));
        inbox.setLeadComponent(galerieButton);
        inbox.setUIID("SideCommand");
        galerieButton.addActionListener(e -> new ListGaleries().show());
        getToolbar().addComponentToSideMenu(inbox);
        
        
        getToolbar().addCommandToSideMenu("Mes Contrats", mesContratsImage, e -> new ListMesContrats().show());
        getToolbar().addCommandToSideMenu("Stats Contrats", statsImage, e -> new StatistiquePieForm().show());
        getToolbar().addCommandToSideMenu("Calendar", calendarImage, e -> new CalendarForm(res).show());
        getToolbar().addCommandToSideMenu("Map", null, e -> {});
        getToolbar().addCommandToSideMenu("Trending", trendingImage, e -> new TrendingForm(res).show());
        getToolbar().addCommandToSideMenu("Settings", null, e -> {});
        
        // spacer
        getToolbar().addComponentToSideMenu(new Label(" ", "SideCommand"));
        getToolbar().addComponentToSideMenu(new Label(res.getImage("profile_image.png"), "Container"));
        getToolbar().addComponentToSideMenu(new Label("Detra Mcmunn", "SideCommandNoPad"));
        getToolbar().addComponentToSideMenu(new Label("Long Beach, CA", "SideCommandSmall"));
    }

        
    protected boolean isCurrentInbox() {
        return false;
    }
    
    protected boolean isCurrentTrending() {
        return false;
    }

    protected boolean isCurrentCalendar() {
        return false;
    }

    protected boolean isCurrentStats() {
        return false;
    }
    
    protected boolean isCurrentContarts() {
        return false;
    }
}
