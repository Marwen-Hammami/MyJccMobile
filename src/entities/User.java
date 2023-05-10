/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

//import Utilities.Type;

//import Utilities.Type;
import java.util.Objects;
import utils.Type;

//import javax.management.relation.Role;

/**
 *
 * @author moene
 */
public class User {
    private int ID_User;
    private String username;

    private String Genre;
    private String Email;
    private String password;
    private Type Role;
    private String PhotoB64;
    private int NumTel;
    private String QRcode;

    public User(int ID_User) {
        this.ID_User = ID_User;
    }

    

    public User() {
    }

    public User(int ID_User, String username, String Genre, String Email, String password, Type Role, String PhotoB64) {
        this.ID_User = ID_User;
        this.username = username;
  
        this.Genre = Genre;
        this.Email = Email;
        this.password = password;
        this.Role = Role;
        this.PhotoB64 = PhotoB64;
    }

    public User(String username, String Genre, String Email, String password,Type Role, String PhotoB64,int NumTel) {
        this.username = username;

        this.Genre = Genre;
        this.Email = Email;
        this.password = password;
        this.Role = Role;
        this.PhotoB64 = PhotoB64;
        this.NumTel=NumTel;
    }


    

    public int getID_User() {
        return ID_User;
    }

    public String getUsername() {
        return username;
    }


    public String getGenre() {
        return Genre;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return password;
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

    public void setUsername(String username) {
        this.username = username;
    }



    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Type Role) {
        this.Role = Role;
    }

    public void setPhotoB64(String PhotoB64) {
        this.PhotoB64 = PhotoB64;
    }

    @Override
    public String toString() {
        return "User{Nom=" + username +  ", Genre=" + Genre + ", Email=" + Email + ", MotDePasse=" + password + ", Role=" + Role + ", PhotoB64=" + PhotoB64 + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.password);
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
