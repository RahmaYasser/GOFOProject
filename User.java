package GOFO2;

/**
 * The user class is a parent class that includes the main details of any user.
 */
public class User {
    private String name, location, email, password, phone;
    private eWallet userEwallet;

    public User() {
        userEwallet = new eWallet();
    }

    public User( String name, String location, String email, String password, String phone, eWallet userEwallet) {
        this.name = name;
        this.location = location;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userEwallet = userEwallet;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public eWallet getUserEwallet() {
        return userEwallet;
    }


}
