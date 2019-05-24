package model;

public class Schueler extends Personen {

    private String klasse;

    public Schueler(int id, String vorname, String nachname, String geburtsdatum, String geschlecht, String klasse) {
        super(id, vorname, nachname, geburtsdatum, geschlecht);
        this.klasse = klasse;
    }

    //


    //Getter

    public String getKlasse() {
        return klasse;
    }


    //Setter

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }
}
