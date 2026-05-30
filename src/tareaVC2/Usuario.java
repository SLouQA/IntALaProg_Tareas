package tareaVC1;


public class Usuario {

    public String name;
    public String lastname;
    public String email;
    public String password;
    public String country;
    public enum Rol {
        ADMIN,
        TESTERJR,
        TESTERSR,
        TESTERLEADER
    }
}

