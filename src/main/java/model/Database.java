package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Arrays;


public class Database {

    private Connection connection;

    public Database(){
        connection = null;
    }

    public static void main(String[] args) {
        Database database = new Database();
        database.connect();
        database.closeConnection();
    }

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");

            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Programming_Projects\\Java\\School Managment System\\SchoolDatabase.db");

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

    public void addSchueler(int id, String vorname, String nachname, String geburtsdatum,
                            String geschlecht, String klasse) {
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

    public ObservableList<String> getSchueler() {
        try {
            Statement stat = connection.createStatement();

            ResultSet rs = stat.executeQuery("SELECT * FROM Schüler");
            ObservableList data = FXCollections.observableArrayList();

            while (rs.next()) {
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                data.add(row);
                return data;
            }

            /* Idk what to do with this now (Just don't delete it)
            while(rs.next()) {
                int id = rs.getInt("ID");
                String fn = rs.getString("Vorname");
                String ln = rs.getString("Nachname");
                String bd = rs.getString("Geburtsdatum");
                String gn = rs.getString("Geschlecht");
                String cl = rs.getString("Klasse");

                Schueler tmp = new Schueler(id, fn, ln, bd, gn, cl);
                list.add(tmp);
            }

            rs.close();
            return list;
             */

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ObservableList<String> getSchueler(String whereSearch) {
        try {
            Statement stat = connection.createStatement();

            String sql = whereSearch;
            ResultSet rs = stat.executeQuery(sql);
            ObservableList data = FXCollections.observableArrayList();

            while (rs.next()) {
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                data.add(row);
            }
            return data;

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addLehrer(String vorname, String nachname, String geburtsdatum,
                          String geschlecht, String kuerzel, String klassenlehrer) {
        try {
            executeSQL(
                    "INSERT INTO Lehrer VALUES (" + vorname + ", '" +
                            nachname + "', '" +
                            geburtsdatum + "', '" +
                            geschlecht + "', '" +
                            kuerzel + "', '" +
                            klassenlehrer +"')" //Klassenlehrer von: #KLASSE#
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
                            klassenlehrer + "')" //#Kürzel von Klassenlehrer
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
                System.out.println("Klassenlehrer Kürzel: " + resultSet.getString("Klassenlehrer"));
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

    public Connection getConnection() {
        return connection;
    }
}
