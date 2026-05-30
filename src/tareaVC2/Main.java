package tareaVC2;

import java.util.Scanner;


public class Main {
    Scanner scan = null;
    String name;
    String lastname;
    String email;
    String password;
    String country;

    public  void main(String[] args) {
       scan = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {
        System.out.println("1 - Registro");
        System.out.println("2 - Login");
        System.out.println("0 - Salir");

        System.out.print("Seleccione una opción: \n");
            opcion = scan.nextInt();
            scan.nextLine();

            if (opcion == 1) {
                registro();
            } else if (opcion == 2){
                login();
            } else if (opcion == 0){

                System.out.println("Gracias por tu visita\n");
            } else {

                System.out.println("Opción inválida\n");

            }
        }
    }
    void registro() {

        System.out.println("Ingrese su nombre:");
        name = scan.nextLine();

        System.out.println("Ingrese su apellido:");
        lastname = scan.nextLine();

        System.out.println("Ingrese su email:");
        email = scan.nextLine();

        System.out.println("Ingrese su contraseña:");
        password = scan.nextLine();

        System.out.println("Ingrese su ciudad:");
        country = scan.nextLine();

    }

    public void login(){

        System.out.println("Ingrese su email:");
         String emailIngresado = scan.nextLine();
        System.out.println("Ingrese su password:");
         String passwordIngresado = scan.nextLine();

        if (emailIngresado.equals(email) && passwordIngresado.equals(password) || emailIngresado.equals("hola@ces.com") && passwordIngresado.equals("123")){
            System.out.println("Bienvenido\n");
        }
        else {
            System.out.println("Email o contraseña inválida\n");

        }

    }

}
