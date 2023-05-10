/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;



import entities.Vote;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddVoteDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldUser;
    private JTextField textFieldFilm;
    private JSpinner spinnerValue;
    private JTextField textFieldComment;

    private boolean okClicked;
    private Vote vote;

    public AddVoteDialog(JFrame parent, String title) {
        super(parent, title, true);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(400, 250);

        spinnerValue.setModel(new SpinnerNumberModel(0, 0, 10, 1));

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
    }

    private void onOK() {
        // Create a new Vote object from the dialog inputs
        String user = textFieldUser.getText().trim();
        String film = textFieldFilm.getText().trim();
        int value = (int) spinnerValue.getValue();
        String comment = textFieldComment.getText().trim();

        // Validate the inputs
        if (user.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a user.");
            return;
        }
        if (film.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a film.");
            return;
        }

        // Set the vote and mark the dialog as "OK clicked"
        vote = new Vote(user, film, value, comment);
        okClicked = true;
        dispose();
    }

    private void onCancel() {
        // Mark the dialog as "cancel clicked"
        okClicked = false;
        dispose();
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    public Vote getVote() {
        return vote;
    }
}