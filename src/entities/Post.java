/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author hiche
 */
public class Post {
    private int id;
    private String title ; 
    private String description ; 
    private String image ; 
    private String postdate;

    public Post(int id, String title, String description, String image, String postdate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.postdate = postdate;
    }

    public Post(String title, String description, String image, String postdate) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.postdate = postdate;
    }

    public Post() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getPostdate() {
        return postdate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPostdate(String postdate) {
        this.postdate = postdate;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", title=" + title + ", description=" + description + ", image=" + image + ", postdate=" + postdate + '}';
    }

   
    
    
}
