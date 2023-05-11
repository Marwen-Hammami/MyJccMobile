/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import java.util.Date;

import services.ServiceReservationHotel;

/**
 *
 * @author youssef
 */
public class AjouterReservationHotel extends Form{
 private int idHotel;
                
        public AjouterReservationHotel(int idHotel) {
        super("Nouvelle réservation", BoxLayout.y());
         this.idHotel = idHotel;
        
        TextField dateDebutField = new TextField("", "Date de début (YYYY-MM-DD)");
        TextField dateFinField = new TextField("", "Date de fin (YYYY-MM-DD)");
        TextField tarifTotalField = new TextField("", "Tarif total");
        TextField qrpathField = new TextField("", "Chemin du code QR");
        Button submitButton = new Button("Réserver");
        
        submitButton.addActionListener(evt -> {
            if (dateDebutField.getText().isEmpty() || dateFinField.getText().isEmpty() ||
                    tarifTotalField.getText().isEmpty() || qrpathField.getText().isEmpty()) {
                Dialog.show("Erreur", "Tous les champs doivent être remplis", "OK", null);
            } else {
                boolean success = ServiceReservationHotel.getInstance().addReservationHotel (new Date().toString(),
                        dateDebutField.getText(), dateFinField.getText(),
                        Float.parseFloat(tarifTotalField.getText()), qrpathField.getText(),
                        699, idHotel); // remplacer 734 et 123 par les IDs de l'utilisateur et de l'hôtel souhaités
                if (success) {
                    Dialog.show("Confirmation", "La réservation a été ajoutée avec succès", "OK", null);
                    new ListHotels().showBack(); // retour à la forme ListeHotels
                } else {
                    Dialog.show("Erreur", "Une erreur s'est produite lors de l'ajout de la réservation", "OK", null);
                }
            }
        });
        
        addAll(dateDebutField, dateFinField, tarifTotalField, qrpathField, submitButton);
    }

    

}

    

