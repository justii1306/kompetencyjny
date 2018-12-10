public class Mentor {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String facebook;
    private String language;
    private int numberOfErasmus;
    private String password;
    private String dateofbirth;
    private String phonenumber;
    private String gender;

    public Mentor(int id, String name, String surname,
                  String email, String facebook, String language,
                  int numberOfErasmus, String password, String dateofbirth,
                  String phonenumber, String gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.facebook = facebook;
        this.language = language;
        this.numberOfErasmus = numberOfErasmus;
        this.password = password;
        this.dateofbirth = dateofbirth;
        this.phonenumber = phonenumber;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getLanguage() {
        return language;
    }

    public int getNumberOfErasmus() {
        return numberOfErasmus;
    }

    public String getPassword() {
        return password;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getGender() {
        return gender;
    }
}
