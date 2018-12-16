import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        final String connectionUrl="jdbc:sqlserver://localhost:1433;databaseName=ERASMUS;user=root;password=root";
        int noErasmus=0;
        int maxErasmus=0;
        LinkedList<Erasmus> erasmus = new LinkedList<>();
        LinkedList<Mentor> mentors = new LinkedList<>();


        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM Erasmus";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            System.out.println("Erasmus:");
            while(rs.next()){
                //Retrieve by column name
                noErasmus++;
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                String facebook = rs.getString("facebook");
                String nativeLanguage = rs.getString("nativeLanguage");
                String password = rs.getString("password");
                String dateofbirth = rs.getString("dateofbirth");
                String phonenumber = rs.getString("phonenumber");
                String gender = rs.getString("gender");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Name: " + name);
                System.out.print(", Surname: " + surname);
                System.out.print(", Email: " + email);
                System.out.print(", Facebook: " + facebook);
                System.out.print(", Native language: " + nativeLanguage);
                System.out.print(", Password: " + password);
                System.out.print(", Date of birth: " + dateofbirth);
                System.out.print(", Phone number: " + phonenumber);
                System.out.println(", Gender: " + gender);
                erasmus.add(new Erasmus(id, name, surname,
                        email, facebook, nativeLanguage,
                        password, dateofbirth, phonenumber,
                        gender));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println();

        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM Mentor";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            System.out.println("Mentors:");
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                String facebook = rs.getString("facebook");
                int numberofErasmus = rs.getInt("numberofErasmus");
                String language = rs.getString("language");
                String password = rs.getString("password");
                String dateofbirth = rs.getString("dateofbirth");
                String phonenumber = rs.getString("phonenumber");
                String gender = rs.getString("gender");

                //Display values
                maxErasmus+=numberofErasmus;
                System.out.print("ID: " + id);
                System.out.print(", Name: " + name);
                System.out.print(", Surname: " + surname);
                System.out.print(", Email: " + email);
                System.out.print(", Facebook: " + facebook);
                System.out.print(", Number of erasmus: " + numberofErasmus);
                System.out.print(", Language: " + language);
                System.out.print(", Password: " + password);
                System.out.print(", Date of birth: " + dateofbirth);
                System.out.print(", Phone number: " + phonenumber);
                System.out.println(", Gender: " + gender);
                mentors.add(new Mentor(id, name, surname,
                        email, facebook, language,
                        numberofErasmus, password, dateofbirth,
                        phonenumber, gender));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

        Sort sort = new Sort(noErasmus, maxErasmus, erasmus, mentors);
        for (Mentor key : sort.getWynik().keySet()) {
            System.out.print(key.getName() + " " + key.getSurname() + "(" + key.getLanguage() + ", " + key.getId() + ")" + ": ");
            for (int i = 0; i < sort.getWynik().get(key).size(); i++){
                System.out.print(sort.getWynik().get(key).get(i).getName() + " " +
                        sort.getWynik().get(key).get(i).getSurname() + "(" + key.getId() + ")" + ", ");
            }
            System.out.println();
        }
        System.out.println("Osoby nieprzydzielone: ");
        for(int k=0;k<sort.getErasmusLeft().size();k++)
            System.out.println(sort.getErasmusLeft().get(k).getName() + " " +
            sort.getErasmusLeft().get(k).getSurname() + "(" +
            sort.getErasmusLeft().get(k).getNativeLanguage() + ", " +
            sort.getErasmusLeft().get(k).getId() + ")");
    }
}
