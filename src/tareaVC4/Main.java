package tareaVC4;
import java.util.Scanner;
import static tareaVC4.SistemaUsuario.usuarioLogueado;

public class Main {
    public static void main(String[] args) {
        SistemaUsuario.usuariosPrueba();

        Scanner scan = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {
            if (usuarioLogueado == null) {
            System.out.println("1 - Registrar Admin.");
            System.out.println("2 - Login.");
            System.out.println("0 - Salir");
            } else {
                System.out.println("\n" + usuarioLogueado.getName() + ". Qué deseas hacer?\n");
                System.out.println("3 - Listar usuarios");
                System.out.println("4 - Buscar usuarios.");
                System.out.println("5 - Registrar Tester");
                System.out.println("0 - Salir");
            }

                System.out.print("\n Seleccione una opción: \n");
            opcion = scan.nextInt();
            scan.nextLine();

            if (opcion == 1) {
                SistemaUsuario.registro(scan);
            } else if (opcion == 2) {
                SistemaUsuario.login(scan);
            } else if (opcion == 3) {
                SistemaUsuario.listar(scan);
            } else if (opcion == 4) {
                SistemaUsuario.buscar(scan);
            } else if (opcion == 5) {
                SistemaUsuario.registro(scan);
            } else if (opcion == 0) {
                SistemaUsuario.logout();

                System.out.println("Gracias por tu visita.\n");
            } else {

                System.out.println("Opción inválida\n");

            }
        }

    }
}
