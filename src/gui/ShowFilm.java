/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import entities.Film;

/**
 *
 * @author dhia
 */
public class ShowFilm extends BaseForm {

    public ShowFilm(Film film) {
        setTitle(film.getTitre());

        // Create components to display the film details
        Label titleLabel = new Label("Title: " + film.getTitre());
        Label genreLabel = new Label("Genre: " + film.getGenre());
        Label dureeLabel = new Label("Duration: " + film.getDuree());
        Label resumeLabel = new Label("Summary: " + film.getResume());
        Label acteurLabel = new Label("Actor: " + film.getActeur());
        Label prodLabel = new Label("Producer: " + film.getID_producteur());
        Label dateLabel = new Label("Date: " + film.getDateRealisation());
        Label prixLabel = new Label("Price: " + film.getPrix());
        Label imageLabel = new Label("Price: " + film.getImage());

        // Add components to the Form
        addAll(titleLabel, genreLabel, dureeLabel, resumeLabel, acteurLabel, prodLabel, dateLabel, prixLabel);

        // Add a back button
        Button backButton = new Button("Back");
        backButton.addActionListener(e -> {
            showBack();
        });
        addComponent(BorderLayout.SOUTH, backButton);
    }
}
