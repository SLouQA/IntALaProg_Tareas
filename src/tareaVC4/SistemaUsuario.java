package tareaVC4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SistemaUsuario {

    public static Usuario usuarioLogueado = null;

    public static void logout() {
        usuarioLogueado = null;
        System.out.println("Sesión cerrada.\n");
    }

    static List<Usuario> usuarios = new ArrayList<>();

    public static void usuariosPrueba() {
        usuarios.add( new Admin("Silvana", "Loureiro", "sil@ces.uy", "123", "Mdeo"));
        usuarios.add( new Tester("Paula", "Mol", "pau@ces.uy", "1234", "Mdeo", RolTester.SR));
    }
    public static Usuario validarEmail(String email) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getEmail().equals(email)) {
                return usuarios.get(i);
            }
        }
        return null;

    }

    public static void registro(Scanner scan) {

        System.out.println("Ingrese su nombre:");
        String name = scan.nextLine();

        System.out.println("Ingrese su apellido:");
        String lastname = scan.nextLine();

        System.out.println("Ingrese su email:");
        String email = scan.nextLine();
        if (validarEmail(email) != null) {
            System.out.println("Email ya registrado.\n");
            return;
        }

        System.out.println("Ingrese su contraseña:");
        String password = scan.nextLine();

        System.out.println("Ingrese su ciudad:");
        String country = scan.nextLine();

        if (usuarioLogueado != null) {
            System.out.println("Seleccione perfil:");
            System.out.println("1 - JUNIOR");
            System.out.println("2 - SR");
            System.out.println("3 - LEAD");

            int opcion = scan.nextInt();
            scan.nextLine();

            RolTester perfil;

            if (opcion == 1) {
                perfil = RolTester.JUNIOR;
            } else if (opcion == 2) {
                perfil = RolTester.SR;
            } else {
                perfil = RolTester.LEAD;
            }

            usuarios.add(new Tester(name, lastname, email, password, country, perfil));
            System.out.println("Tester registrado, acceda al login.\n");
        } else {
            Admin nuevoAdmin = new Admin(name,lastname,email,password, country);
            usuarios.add(nuevoAdmin);
            System.out.println("Admin registrado, acceda al login.\n");
        }



    }

    public static void login(Scanner scan) {

        System.out.println("Ingrese su email:");
        String emailIngresado = scan.nextLine();
        System.out.println("Ingrese su password:");
        String passwordIngresado = scan.nextLine();

        Usuario usuario = validarEmail(emailIngresado);

        if (usuario != null && usuario.getPassword().equals(passwordIngresado)) {
            usuarioLogueado = usuario;
            System.out.println("Bienvenido/a, " + usuario.getName() + ".\n");
        } else {
            System.out.println("Email o contraseña inválida.\n");

        }
    }
    public static void buscar(Scanner scan){
        System.out.println("\n Ingrese mail a buscar:");
        String emailIngresado = scan.nextLine();

        Usuario usuario = validarEmail(emailIngresado);
        if (usuario != null) {
            System.out.println("\n Usuario encontrado:" );
            usuario.mostrarDatos();
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public static void listar(Scanner scan){
        System.out.println("\n Usuarios registrados:");
        for (Usuario usuario : usuarios){
            System.out.println("\n  ---");
            usuario.mostrarDatos();
        }
        System.out.println("\n  ---");
    }

}
