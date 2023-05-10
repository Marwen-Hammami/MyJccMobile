package entities;

import utils.EnumEtatContrat;
import utils.EnumTypeContrat;
//import java.sql.Date;

public class ContratSponsoring {
    //var
    private int ID_Contrat;
    private String DateDebut;
    private String DateFin;
    private EnumTypeContrat Type;
    private EnumEtatContrat Etat;
    private float SalaireDt;
    private String TermesPDF;
    private User Sponsor;
    private String SignatureSponsor;
    private User Photoraphe;
    private String SignaturePhotographe;

    //Constructeurs
    public ContratSponsoring() {
    }

    public ContratSponsoring( EnumTypeContrat Type, EnumEtatContrat Etat, float SalaireDt, String TermesPDF, User Sponsor, String SignatureSponsor, User Photoraphe, String SignaturePhotographe) {
        
        this.Type = Type;
        this.Etat = Etat;
        this.SalaireDt = SalaireDt;
        this.TermesPDF = TermesPDF;
        this.Sponsor = Sponsor;
        this.SignatureSponsor = SignatureSponsor;
        this.Photoraphe = Photoraphe;
        this.SignaturePhotographe = SignaturePhotographe;
    }

    public ContratSponsoring(String DateDebut, String DateFin, EnumTypeContrat Type, EnumEtatContrat Etat, float SalaireDt, String TermesPDF, User Sponsor, String SignatureSponsor, User Photoraphe, String SignaturePhotographe) {
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.Type = Type;
        this.Etat = Etat;
        this.SalaireDt = SalaireDt;
        this.TermesPDF = TermesPDF;
        this.Sponsor = Sponsor;
        this.SignatureSponsor = SignatureSponsor;
        this.Photoraphe = Photoraphe;
        this.SignaturePhotographe = SignaturePhotographe;
    }
    

    public ContratSponsoring(int ID_Contrat, EnumTypeContrat Type, EnumEtatContrat Etat, float SalaireDt, String TermesPDF, User Sponsor, String SignatureSponsor, User Photoraphe, String SignaturePhotographe) {
        this.ID_Contrat = ID_Contrat;
        
        this.Type = Type;
        this.Etat = Etat;
        this.SalaireDt = SalaireDt;
        this.TermesPDF = TermesPDF;
        this.Sponsor = Sponsor;
        this.SignatureSponsor = SignatureSponsor;
        this.Photoraphe = Photoraphe;
        this.SignaturePhotographe = SignaturePhotographe;
    }

    public ContratSponsoring(int ID_Contrat, String DateDebut, String DateFin, EnumTypeContrat Type, EnumEtatContrat Etat, float SalaireDt, String TermesPDF, User Sponsor, String SignatureSponsor, User Photoraphe, String SignaturePhotographe) {
        this.ID_Contrat = ID_Contrat;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.Type = Type;
        this.Etat = Etat;
        this.SalaireDt = SalaireDt;
        this.TermesPDF = TermesPDF;
        this.Sponsor = Sponsor;
        this.SignatureSponsor = SignatureSponsor;
        this.Photoraphe = Photoraphe;
        this.SignaturePhotographe = SignaturePhotographe;
    }

    public String getDateDebut() {
        return DateDebut;
    }

    public void setDateDebut(String DateDebut) {
        this.DateDebut = DateDebut;
    }

    public String getDateFin() {
        return DateFin;
    }

    public void setDateFin(String DateFin) {
        this.DateFin = DateFin;
    }
    

    public int getID_Contrat() {
        return ID_Contrat;
    }

    public void setID_Contrat(int ID_Contrat) {
        this.ID_Contrat = ID_Contrat;
    }



    public EnumTypeContrat getType() {
        return Type;
    }

    public void setType(EnumTypeContrat Type) {
        this.Type = Type;
    }

    public EnumEtatContrat getEtat() {
        return Etat;
    }

    public void setEtat(EnumEtatContrat Etat) {
        this.Etat = Etat;
    }

    public float getSalaireDt() {
        return SalaireDt;
    }

    public void setSalaireDt(float SalaireDt) {
        this.SalaireDt = SalaireDt;
    }

    public String getTermesPDF() {
        return TermesPDF;
    }

    public void setTermesPDF(String TermesPDF) {
        this.TermesPDF = TermesPDF;
    }

    public User getSponsor() {
        return Sponsor;
    }

    public void setSponsor(User Sponsor) {
        this.Sponsor = Sponsor;
    }

    public String getSignatureSponsor() {
        return SignatureSponsor;
    }

    public void setSignatureSponsor(String SignatureSponsor) {
        this.SignatureSponsor = SignatureSponsor;
    }

    public User getPhotoraphe() {
        return Photoraphe;
    }

    public void setPhotoraphe(User Photoraphe) {
        this.Photoraphe = Photoraphe;
    }

    public String getSignaturePhotographe() {
        return SignaturePhotographe;
    }

    public void setSignaturePhotographe(String SignaturePhotographe) {
        this.SignaturePhotographe = SignaturePhotographe;
    }

    @Override
    public String toString() {
        return "ContratSponsoring{" + "ID_Contrat=" + ID_Contrat +  ", Type=" + Type + ", Etat=" + Etat + ", SalaireDt=" + SalaireDt + ", TermesPDF=" + TermesPDF + ", Sponsor=" + Sponsor + ", SignatureSponsor=" + SignatureSponsor + ", Photoraphe=" + Photoraphe + ", SignaturePhotographe=" + SignaturePhotographe + '}';
    }


}