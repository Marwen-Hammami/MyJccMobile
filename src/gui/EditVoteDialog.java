/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Film;
import entities.User;
import entities.Vote;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class EditVoteDialog extends JDialog {
    private JPanel contentPane;
private JButton buttonOK;
private JButton buttonCancel;
private JComboBox<String> comboBoxUser;
private JComboBox<String> comboBoxFilm;
private JTextField textFieldValue;
private JTextField textFieldComment;
private Vote vote;
private boolean okClicked;

    public EditVoteDialog(Frame parent, String title, Vote vote) {
    super(parent, title);
    this.vote = vote;

    setContentPane(contentPane);
    setModal(true);
    getRootPane().setDefaultButton(buttonOK);

    // Initialize the user and film combo boxes with the available choices
    DefaultComboBoxModel<String> userComboBoxModel = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> filmComboBoxModel = new DefaultComboBoxModel<>();
    try {
        // Establish a database connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
        PreparedStatement userStatement = connection.prepareStatement("SELECT nom FROM user ORDER BY nom");
        ResultSet userResultSet = userStatement.executeQuery();
        while (userResultSet.next()) {
            userComboBoxModel.addElement(userResultSet.getString("nom"));
        }
        userResultSet.close();
        userStatement.close();

        PreparedStatement filmStatement = connection.prepareStatement("SELECT titre FROM film ORDER BY titre");
        ResultSet filmResultSet = filmStatement.executeQuery();
        while (filmResultSet.next()) {
            filmComboBoxModel.addElement(filmResultSet.getString("titre"));
        }
        filmResultSet.close();
        filmStatement.close();

        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    comboBoxUser.setModel(userComboBoxModel);
    comboBoxFilm.setModel(filmComboBoxModel);

    // Set the selected values for the user and film combo boxes
    comboBoxUser.setSelectedItem(vote.getUser().getNom());
    comboBoxFilm.setSelectedItem(vote.getFilm().getTitre());

    // Set the value and comment text fields to the values of the selected vote
    textFieldValue.setText(Integer.toString(vote.getValeur()));
    textFieldComment.setText(vote.getCommentaire());

    buttonOK.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            onOK();
        }
    });

    buttonCancel.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            onCancel();
        }
    });

    // Close the dialog when the user clicks on the "X" button
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
}

private void onOK() {
    // Update the vote with the new values
    String selectedUserName = (String) comboBoxUser.getSelectedItem();
    User selectedUser = getUserByName(selectedUserName);

    String selectedFilmTitle = (String) comboBoxFilm.getSelectedItem();
    Film selectedFilm = getFilmByTitle(selectedFilmTitle);

    int value = Integer.parseInt(textFieldValue.getText());
    String comment = textFieldComment.getText();

    vote.setUser(selectedUser);
    vote.setFilm(selectedFilm);
    vote.setValeur(value);
    vote.setCommentaire(comment);

    okClicked = true;

    // Close the dialog
    dispose();
}

private void onCancel() {
    // Close the dialog
    dispose();
}

private User getUserByName(String name) {
    User user = null;
    try {
        // Establish a database connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myjcc", "username", "password");
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE nom = ?");
        statement.setString(1, name);
        PreparedStatement userStatement = connection.prepareStatement("SELECT nom FROM user WHERE nom = ?");
        userStatement.setString(1, name);
        ResultSet userResultSet = userStatement.executeQuery();
        if (userResultSet.next()) {
            String nom = userResultSet.getString("nom");
            user = new User(nom);
        }
        userResultSet.close();
        userStatement.close();

        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return user;
}

private Film getFilmByTitle(String title) {
    Film film = null;
    try {
        // Establish a database connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myjcc", "username", "password");
        PreparedStatement filmStatement = connection.prepareStatement("SELECT titre FROM film WHERE titre = ?");
        filmStatement.setString(1, title);
        ResultSet filmResultSet = filmStatement.executeQuery();
        if (filmResultSet.next()) {
            String titre = filmResultSet.getString("titre");
            film = new Film(titre);
        }
        filmResultSet.close();
        filmStatement.close();

        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return film;
}

public Vote getVote() {
    return vote;
}

public boolean isOkClicked() {
    return okClicked;
}
}