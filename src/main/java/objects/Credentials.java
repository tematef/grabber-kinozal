package objects;

import util.Properties;

public class Credentials {

    private String username;
    private String password;

    private Credentials() {
        this.username = Properties.getProperty("username");
        this.password = Properties.getProperty("password");
    }

    public static Credentials getCredentials() {
        return new Credentials();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}