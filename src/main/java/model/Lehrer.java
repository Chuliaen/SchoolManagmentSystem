package model;

public class Lehrer extends Personen {

    private String kuerzel, klassenleher;

    Lehrer(String vorname, String nachname, String geburtsdatum, String geschlecht, String kuerzel, String klassenleher) {
        super(vorname, nachname, geburtsdatum, geschlecht);
        this.kuerzel = kuerzel;
        this.klassenleher = klassenleher;
    }

    //


    //Getter

    public String getKuerzel() {
        return kuerzel;
    }

    public String getKlassenleher() {
        return klassenleher;
    }


    //Setter

    public void setKuerzel(String kuerzel) {
        this.kuerzel = kuerzel;
    }

    public void setKlassenleher(String klassenleher) {
        this.klassenleher = klassenleher;
    }
}
