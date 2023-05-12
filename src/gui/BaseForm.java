package gui;

import TemplatesFiles.CalendarForm;
import TemplatesFiles.InboxForm;
import TemplatesFiles.StatsForm;
import TemplatesFiles.TrendingForm;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import entities.User;
import java.io.IOException;
import services.ServiceLogin;

public class BaseForm extends Form {
    public void installSidemenu(Resources res) {
        User currentUser = ServiceLogin.user;
        
            //pour l'image utilisateur photographe
        EncodedImage enc = null;
        Image imgs;
        String img_url = currentUser.getPhotoB64() ;
        try{
            enc = EncodedImage.create("/loading.png");
        }catch (IOException ex){
            System.out.println("Erreur de load.png IMAGE, lors de l'encodage -- " + ex);
        }
        imgs = URLImage.createToStorage(enc, img_url, img_url, URLImage.RESIZE_SCALE);
        Image scaledImage = imgs.scaled(300, 300);
        
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
        
        Image listFilms = null;
        if(isCurrentListFilm()) mesContratsImage = selection;
        
        Image ajoutFilm= null;
        if(isCurrentAjoutFilm()) mesContratsImage = selection;
        
        Image ListVote= null;
        if(isCurrentListVote()) mesContratsImage = selection;
        
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
        getToolbar().addCommandToSideMenu("ListHotels", calendarImage, e -> new ListHotels().show());
        getToolbar().addCommandToSideMenu("Mes Reservations", trendingImage, e -> new ListReservationHotels().show());
        getToolbar().addCommandToSideMenu("Liste des Films", listFilms, e -> new ListFilms().show());
        getToolbar().addCommandToSideMenu("Ajouter un film", ajoutFilm, e -> new AjouterFilm().show());
        getToolbar().addCommandToSideMenu("Liste des votes", ListVote, e -> new ListeVotes().show());
        
        // spacer
        getToolbar().addComponentToSideMenu(new Label(" ", "SideCommand"));
        getToolbar().addComponentToSideMenu(new Label(scaledImage, "Container"));
        getToolbar().addComponentToSideMenu(new Label(currentUser.getNom()+" "+currentUser.getPrenom(), "SideCommandNoPad"));
        getToolbar().addComponentToSideMenu(new Label(currentUser.getEmail(), "SideCommandSmall"));
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
    protected boolean isCurrentListFilm() {
        return false;
    }
    protected boolean isCurrentAjoutFilm() {
        return false;
    }
    
    protected boolean isCurrentListVote() {
        return false;
    }
}
