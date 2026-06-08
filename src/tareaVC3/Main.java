package tareaVC3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaUsuario.usuariosPrueba();

        Scanner scan = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("1 - Registrar Admin");
            System.out.println("2 - Login");
            System.out.println("0 - Salir");

            System.out.print("Seleccione una opción: \n");
            opcion = scan.nextInt();
            scan.nextLine();

            if (opcion == 1) {
                SistemaUsuario.registro(scan);
            } else if (opcion == 2) {
                SistemaUsuario.login(scan);
            } else if (opcion == 0) {

                System.out.println("Gracias por tu visita\n");
            } else {

                System.out.println("Opción inválida\n");

            }
        }

    }
}