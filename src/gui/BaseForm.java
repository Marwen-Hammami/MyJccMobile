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
        
        Image hotelImage = null;
        if(isCurrentInbox()) hotelImage = selection;

        Image trendingImage = null;
        if(isCurrentTrending()) trendingImage = selection;
        
        Image calendarImage = null;
        if(isCurrentCalendar()) calendarImage = selection;
        
        Image statsImage = null;
        if(isCurrentStats()) statsImage = selection;
        
        Button hotelButton = new Button("Liste Hotels", hotelImage);
        hotelButton.setUIID("SideCommand");
        hotelButton.getAllStyles().setPaddingBottom(0);
        Container inbox = FlowLayout.encloseMiddle(hotelButton);//, new Label("18", "SideCommandNumber"));
        inbox.setLeadComponent(hotelButton);
        inbox.setUIID("SideCommand");
        hotelButton.addActionListener(e -> new ListHotels().show());
        getToolbar().addComponentToSideMenu(inbox);
        
        //bouton reservation
Button reservationsButton = new Button("Mes réservations", hotelImage);
reservationsButton.setUIID("SideCommand");
reservationsButton.getAllStyles().setPaddingBottom(0);
Container reservationsContainer = FlowLayout.encloseMiddle(reservationsButton);
reservationsContainer.setLeadComponent(reservationsButton);
reservationsContainer.setUIID("SideCommand");
reservationsButton.addActionListener(e -> new ListReservationHotels().show());
getToolbar().addComponentToSideMenu(reservationsContainer);



        
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
