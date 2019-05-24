package model;

class Personen {

    private String name, vorname, geburtsdatum, geschlecht;
    private int id;     //id ab: Lehrer: 000, Schüler: 100

    Personen(int id, String vorname, String nachname, String geburtsdatum, String geschlecht) {
        this.vorname = vorname;
        this.name = nachname;
        this.geburtsdatum = geburtsdatum;
        this.geschlecht = geschlecht;
        this.id = id;
    }


    //Getter

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public int getID() {
        return id;
    }


    //Setter

    public void setName(String name) {
        this.name = name;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public void setID(int ID) {
        this.id = ID;
    }

}
