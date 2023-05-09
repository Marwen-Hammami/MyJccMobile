package entities;


/**
 *
 * @author wael
 */
public class Vote {

    private int ID_Vote;
    private int valeur;
    private Film film;
    private User user;
    private String commentaire;
    private String Date_Vote;
    private int Vote_Film;

    public Vote() {
    }

    public Vote(User user, Film film,  String commentaire, String Date_Vote) {
        this.film = film;
        this.user = user;
        this.commentaire = commentaire;
        this.Date_Vote = Date_Vote;
    }

    public Vote(int ID_Vote,int valeur,  User user,Film film, String commentaire, String Date_Vote) {
        this.ID_Vote = ID_Vote;
        this.valeur = valeur;
        this.film = film;
        this.user = user;
        this.commentaire = commentaire;
        this.Date_Vote = Date_Vote;
    }

    public Vote(int ID_Vote, User user,Film film, String commentaire, String Date_Vote, int Vote_Film) {
        this.ID_Vote = ID_Vote;
        this.film = film;
        this.user = user;
        this.commentaire = commentaire;
        this.Date_Vote = Date_Vote;
        this.Vote_Film = Vote_Film;
    }
    
    public int getID_Vote() {
        return ID_Vote;
    }

    public void setID_Vote(int ID_Vote) {
        this.ID_Vote = ID_Vote;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public String getDate_Vote() {
        return Date_Vote;
    }

    public void setDate_Vote(String Date_Vote) {
        this.Date_Vote = Date_Vote;
    }

    public int getVote_Film() {
        return Vote_Film;
    }

    public void setVote_Film(int Vote_Film) {
        this.Vote_Film = Vote_Film;
    }

    @Override
    public String toString() {
        return "Vote{" + "film=" + film + ", user=" + user + ", valeur=" + valeur + ", commentaire=" + commentaire + ", Date_Vote=" + Date_Vote + ", Vote_Film=" + Vote_Film + '}';
    }

}
