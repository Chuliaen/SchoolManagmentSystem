package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class Database {

    private Connection connection;

    public Database(){
        connection = null;
    }

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");

            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Programming_Projects\\Java\\School Managment System\\src\\main\\resources\\SchoolDatabase.db");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addSchueler(int id, String vorname, String nachname, String geburtsdatum, String geschlecht, String klasse) {
        try {
            executeSQL(
                    "INSERT INTO Schüler VALUES (" + id + ", '" +
                            vorname + "', '" +
                            nachname + "', '" +
                            geburtsdatum + "', '" +
                            geschlecht + "', '" +
                            klasse +"')"
            );
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getSchueler() {
        try {
            Statement stat = connection.createStatement();

            ResultSet rs = stat.executeQuery("SELECT * FROM Schüler");

            while(rs.next()) {
                System.out.println("ID: " + rs.getInt("ID"));
                System.out.println("Vorname: " + rs.getString("Vorname"));
                System.out.println("Nachname: " + rs.getString("Nachname"));
                System.out.println("Geburtstag: " + rs.getString("Geburtstag"));
                System.out.println("Geschlecht: " + rs.getString("Geschlecht"));
                System.out.println("Klasse: " + rs.getString("Klasse"));
            }

            rs.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void addLehrer(String vorname, String nachname, String geburtsdatum, String geschlecht, String kuerzel, String klassenlehrer) {
        try {
            executeSQL(
                    "INSERT INTO Lehrer VALUES (" + vorname + ", '" +
                            nachname + "', '" +
                            geburtsdatum + "', '" +
                            geschlecht + "', '" +
                            kuerzel + "', '" +
                            klassenlehrer +"')"
            );
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getLehrer() {
        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Lehrer");

            while(resultSet.next()) {
                System.out.println("Vorname: " + resultSet.getString("Vorname"));
                System.out.println("Nachname: " + resultSet.getString("Nachname"));
                System.out.println("Geburtstag: " + resultSet.getString("Geburtsdatum"));
                System.out.println("Geschlecht: " + resultSet.getString("Geschlecht"));
                System.out.println("Kürzel: " + resultSet.getString("Kürzel"));
                System.out.println("Klassenlehrer von: " + resultSet.getString("Klassenlehrer"));
            }

            resultSet.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void addKlasse(String name, String klassenlehrer) {
        try {
            executeSQL(
                    "INSERT INTO Lehrer VALUES (" + name + ", '" +
                            klassenlehrer + "')"
            );
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getKlasse() {
        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Klasse");

            while(resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("Name"));
                System.out.println("Klassenlehrer: " + resultSet.getString("Klassenlehrer"));
            }

            resultSet.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeSQL(String sqlBefehl) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlBefehl);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
