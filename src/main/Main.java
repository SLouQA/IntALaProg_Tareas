package main;

import main.exeptions.*;
import main.service.SistemaUsuario;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaUsuario sistema = SistemaUsuario.getInstance();
        sistema.usuariosPrueba();

        Scanner scan = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {
            mostrarMenu(sistema);

            try {
                opcion = scan.nextInt();
                scan.nextLine();

                if (opcion == 1) {
                    sistema.registrarAdmin(scan);
                } else if (opcion == 2) {
                    sistema.login(scan);
                } else if (opcion == 3) {
                    sistema.listar(scan);
                } else if (opcion == 4) {
                    sistema.buscar(scan);
                } else if (opcion == 5) {
                    sistema.registrarTester(scan);
                } else if (opcion == 6) {
                    sistema.logout();
                } else if (opcion == 0) {
                    sistema.logout();
                    System.out.println("Gracias por tu visita.\n");
                } else {
                    System.out.println("Opción inválida\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nDebe ingesar un número.\n");
                scan.nextLine();
                opcion = -1;
            } catch (DatosInvalidosException | EmailDuplicadoException | CredencialesInvalidasException
                     | UsuarioNoEncontradoException | OperacionNoPermitidaException e) {
                System.out.println("\n" + e.getMessage() + "\n");
            } catch (Exception e) {
                System.out.println("\n Ocurrió un error inesperado: " + e.getMessage() + "\n");
            }
        }
    }

    private static void mostrarMenu(SistemaUsuario sistema){
            if (sistema.getUsuarioLogueado() == null) {
            System.out.println("1 - Registrar Admin.");
            System.out.println("2 - Login.");
            System.out.println("0 - Salir");
            } else {
                System.out.println("\n" + sistema.getUsuarioLogueado().getName() + ". Qué deseas hacer?\n");
                System.out.println("3 - Listar usuarios");
                System.out.println("4 - Buscar usuarios.");
                System.out.println("5 - Registrar Tester");
                System.out.println("6 - Cerrar sesión");
                System.out.println("0 - Salir");
            }

                System.out.print("\n Seleccione una opción: \n");

        }

    }

