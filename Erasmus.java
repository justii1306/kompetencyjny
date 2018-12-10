public class Erasmus {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String facebook;
    private String nativeLanguage;
    private String password;
    private String dateofbirth;
    private String phonenumber;
    private String gender;

    public Erasmus(int id, String name, String surname, String email,
                   String facebook, String nativeLanguage, String password,
                   String dateofbirth, String phonenumber, String gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.facebook = facebook;
        this.nativeLanguage = nativeLanguage;
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

    public String getNativeLanguage() {
        return nativeLanguage;
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
