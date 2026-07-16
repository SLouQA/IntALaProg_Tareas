package main.model;


public abstract class Usuario {

    private String name;
    private String lastname;
    private String email;
    private String password;
    private String country;

    public Usuario(String name, String lastname, String email, String password, String country) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void mostrarDatos() {
        System.out.println("\nNombre: " + name);
        System.out.println("Apellido: " + lastname);
        System.out.println("Email: " + email);
        System.out.println("Ciudad: " + country);
    }

}

