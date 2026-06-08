package tareaVC3;

import java.util.Scanner;

public class SistemaUsuario {

    static Usuario [] usuarios = new Usuario[10];
    static int cantidadUsuarios = 0;

    public static void usuariosPrueba() {
        usuarios[cantidadUsuarios++] = new Admin("Silvana", "Loureiro", "sil@ces.uy", "123", "Mdeo");
        usuarios[cantidadUsuarios++] = new Tester("Paula", "Mol", "pau@ces.uy", "1234", "Mdeo");
    }
    public static Usuario validarEmail(String email) {
        for (int i = 0; i < cantidadUsuarios; i++) {
            if (usuarios[i].getEmail().equals(email)) {
                return usuarios[i];
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
            System.out.println("Email ya registrado\n");
            return;
        }

        System.out.println("Ingrese su contraseña:");
        String password = scan.nextLine();

        System.out.println("Ingrese su ciudad:");
        String country = scan.nextLine();

        usuarios [cantidadUsuarios++] = new Admin(name,lastname,email,password, country);
        System.out.println("Admin registrado, acceda al login.\n");

    }

    public static void login(Scanner scan) {

        System.out.println("Ingrese su email:");
        String emailIngresado = scan.nextLine();
        System.out.println("Ingrese su password:");
        String passwordIngresado = scan.nextLine();

        Usuario usuario = validarEmail(emailIngresado);

        if (usuario != null && usuario.getPassword().equals(passwordIngresado)) {
            System.out.println("Bienvenido/a " + usuario.getName() + "\n");
        } else {
            System.out.println("Email o contraseña inválida\n");

        }
    }
}
