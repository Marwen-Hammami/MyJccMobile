/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;
import utils.Type;

/**
 *
 * @author youssef
 */
public class User {
    private int ID_User;
    private String Nom;
    private String Prenom;
    private String Genre;
    private String Email;
    private String MotDePasse;
    private Type Role;
    private String PhotoB64;
    private int NumTel;
    private String QRcode;



    public User() {
    }

    public User(int ID_User, String Nom, String Prenom, String Genre, String Email, String MotDePasse, Type Role, String PhotoB64) {
        this.ID_User = ID_User;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Genre = Genre;
        this.Email = Email;
        this.MotDePasse = MotDePasse;
        this.Role = Role;
        this.PhotoB64 = PhotoB64;
    }

    public User(String Nom, String Prenom, String Genre, String Email, String MotDePasse,Type Role, String PhotoB64,int NumTel) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Genre = Genre;
        this.Email = Email;
        this.MotDePasse = MotDePasse;
        this.Role = Role;
        this.PhotoB64 = PhotoB64;
        this.NumTel=NumTel;
    }


    

    public int getID_User() {
        return ID_User;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getGenre() {
        return Genre;
    }

    public String getEmail() {
        return Email;
    }

    public String getMotDePasse() {
        return MotDePasse;
    }

    public Type getRole() {
        return Role;
    }

    public String getPhotoB64() {
        return PhotoB64;
    }
    

    public void setID_User(int ID_User) {
        this.ID_User = ID_User;
    }

    public void setNumTel(int NumTel) {
        this.NumTel = NumTel;
    }

    public void setQRcode(String QRcode) {
        this.QRcode = QRcode;
    }

    public int getNumTel() {
        return NumTel;
    }

    public String getQRcode() {
        return QRcode;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setMotDePasse(String MotDePasse) {
        this.MotDePasse = MotDePasse;
    }

    public void setRole(Type Role) {
        this.Role = Role;
    }

    public void setPhotoB64(String PhotoB64) {
        this.PhotoB64 = PhotoB64;
    }

    @Override
    public String toString() {
        return "User{Nom=" + Nom + ", Prenom=" + Prenom + ", Genre=" + Genre + ", Email=" + Email + ", MotDePasse=" + MotDePasse + ", Role=" + Role + ", PhotoB64=" + PhotoB64 + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.MotDePasse);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return true;
    }
}

