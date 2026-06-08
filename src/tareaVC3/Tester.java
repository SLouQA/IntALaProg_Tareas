package tareaVC3;

public class Tester extends Usuario {
    private String perfil;

    public Tester (String name, String lastname, String email, String password, String country) {
        super (name, lastname, email, password, country);
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}

