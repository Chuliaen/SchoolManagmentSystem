package model;

public class Schueler extends Personen {

    private int id;
    private String klasse;

    public Schueler(int id, String vorname, String nachname, String geburtsdatum, String geschlecht, String klasse) {
        super(vorname, nachname, geburtsdatum, geschlecht);
        this.id = id;
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
