package tareaVC4;

public class Tester extends Usuario {
    private RolTester perfil;

    public Tester (String name, String lastname, String email, String password, String country, RolTester perfil) {
        super (name, lastname, email, password, country);
        this.perfil = perfil;
    }


    public RolTester getPerfil() {
        return perfil;
    }

    public void setPerfil(RolTester perfil) {
        this.perfil = perfil;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Perfil: " + perfil);
    }

}

