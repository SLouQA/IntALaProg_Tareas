package main.model;

public class Admin extends Usuario {

    public Admin(String name, String lastname, String email, String password, String country){
        super(name, lastname, email, password, country);

    }
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("Perfil: Admin");
    }
}