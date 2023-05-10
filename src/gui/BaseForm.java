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
        
        Button filmButton = new Button("Liste films", trendingImage);
        filmButton.setUIID("SideCommand");
        filmButton.getAllStyles().setPaddingBottom(0);
        Container inbox = FlowLayout.encloseMiddle(filmButton);//, new Label("18", "SideCommandNumber"));
        inbox.setLeadComponent(filmButton);
        inbox.setUIID("SideCommand");
        filmButton.addActionListener(e -> new ListFilms().show());
        getToolbar().addComponentToSideMenu(inbox);
        
        
        Button ajfilmButton = new Button("ajouter films", trendingImage);
        ajfilmButton.setUIID("SideCommand");
        ajfilmButton.getAllStyles().setPaddingBottom(0);
        Container inbox1 = FlowLayout.encloseMiddle(ajfilmButton);//, new Label("18", "SideCommandNumber"));
        inbox1.setLeadComponent(ajfilmButton);
        inbox1.setUIID("SideCommand");
        ajfilmButton.addActionListener(e -> new AjouterFilm().show());
        getToolbar().addComponentToSideMenu(inbox1);
        
        getToolbar().addCommandToSideMenu("Films", statsImage, e -> new StatsForm(res).show());
        getToolbar().addCommandToSideMenu("Stats", statsImage, e -> new StatsForm(res).show());
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
}
