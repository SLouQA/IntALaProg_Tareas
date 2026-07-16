package main.service;

import main.exeptions.*;
import main.model.Admin;
import main.model.RolTester;
import main.model.Tester;
import main.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SistemaUsuario {

    private static SistemaUsuario instancia;

    private final List<Usuario> usuarios = new ArrayList<>();
    private Usuario usuarioLogueado;

    private SistemaUsuario(){
    }

    public static SistemaUsuario getInstance(){
        if (instancia == null) {
            instancia = new SistemaUsuario();
        }
        return instancia;
    }

    public Usuario getUsuarioLogueado(){
        return usuarioLogueado;
    }

    public void logout() {
        usuarioLogueado = null;
        System.out.println("Sesión cerrada.\n");
    }

    public void usuariosPrueba() {
        usuarios.add( new Admin("Silvana", "Loureiro", "sil@ces.uy", "123", "Mdeo"));
        usuarios.add( new Tester("Paula", "Mol", "pau@ces.uy", "1234", "Mdeo", RolTester.SR));
    }

    private Usuario validarEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    private void validarEmailNoDuplicado(String email) throws EmailDuplicadoException {
        if (validarEmail(email) != null) {
            throw new EmailDuplicadoException("Ya existe un usuario registrado con el email: " + email + "\n");
        }
    }

    private void validarDatosComunes(String name, String lastname, String email, String password, String country)
            throws DatosInvalidosException {
        Validador.validarCampoObligatorio(name, "Nombre");
        Validador.validarCampoObligatorio(lastname, "Apellido");
        Validador.validarCampoObligatorio(email, "Email");
        Validador.validarCampoObligatorio(password, "Contraseña");
        Validador.validarCampoObligatorio(country, "Ciudad");
        Validador.validarFormatoEmail(email);
        Validador.validarLongitudPassword(password);
    }

    public void registrarAdmin(Scanner scan)
            throws DatosInvalidosException, EmailDuplicadoException, OperacionNoPermitidaException {

        if (usuarioLogueado != null) {
            throw new OperacionNoPermitidaException("Para registrar un admin no puedes tener sesion iniciada.\n");
        }

        System.out.println("Ingrese su nombre:");
        String name = scan.nextLine();

        System.out.println("Ingrese su apellido:");
        String lastname = scan.nextLine();

        System.out.println("Ingrese su email:");
        String email = scan.nextLine();

        validarEmailNoDuplicado(email);

        System.out.println("Ingrese su contraseña:");
        String password = scan.nextLine();

        System.out.println("Ingrese su ciudad:");
        String country = scan.nextLine();

        validarDatosComunes (name, lastname, email, password, country);

        usuarios.add(new Admin(name, lastname, email, password, country));
        System.out.println("Admin registrado, acceda al login.\n");
    }


    public void registrarTester(Scanner scan)
            throws DatosInvalidosException, EmailDuplicadoException, OperacionNoPermitidaException {

        if (!(usuarioLogueado instanceof Admin)) {
            throw new OperacionNoPermitidaException("Solo un usuario Admin puede registrar Tester.\n");
        }


        System.out.println("Ingrese su nombre:");
        String name = scan.nextLine();

        System.out.println("Ingrese su apellido:");
        String lastname = scan.nextLine();

        System.out.println("Ingrese su email:");
        String email = scan.nextLine();

        validarEmailNoDuplicado(email);

        System.out.println("Ingrese su contraseña:");
        String password = scan.nextLine();

        System.out.println("Ingrese su ciudad:");
        String country = scan.nextLine();

        validarDatosComunes(name, lastname, email, password, country);

        System.out.println("Seleccione perfil:");
        System.out.println("1 - JUNIOR");
        System.out.println("2 - SR");
        System.out.println("3 - LEAD");

        RolTester perfil = leerPerfil(scan);

        usuarios.add(new Tester(name, lastname, email, password, country, perfil));
        System.out.println("Tester registrado correctamente.\n");
    }

    private RolTester leerPerfil(Scanner scan) throws DatosInvalidosException{
            String entrada = scan.nextLine();
            int opcion;
            try{
                opcion = Integer.parseInt (entrada);
            } catch (NumberFormatException e) {
                throw new DatosInvalidosException("No es un Rol válido");
            }
            if (opcion == 1) {
                return RolTester.JUNIOR;
            } else if (opcion == 2) {
                return RolTester.SR;
            } else if (opcion == 3) {
                return RolTester.LEAD;
            } else {
                throw new DatosInvalidosException("Debe seleccionar una opción entre 1 y 3.");
            }
    }


    public void login(Scanner scan)
            throws CredencialesInvalidasException, OperacionNoPermitidaException {
            if (usuarioLogueado != null) {
                throw new OperacionNoPermitidaException("Ya hay una sesión iniciada.\n");
            }

            System.out.println("Ingrese su email:");
            String emailIngresado = scan.nextLine();
            System.out.println("Ingrese su password:");
            String passwordIngresado = scan.nextLine();

            Usuario usuario = validarEmail(emailIngresado);

            if (usuario == null || !usuario.getPassword().equals(passwordIngresado)) {
                throw new CredencialesInvalidasException("Email o contraseña inválida.\n");
            }
            if (!(usuario instanceof Admin)){
                throw new OperacionNoPermitidaException("Solo se puede acceder con usuario Admin");
            }
            usuarioLogueado = usuario;
            System.out.println("Bienvenido/a, " + usuario.getName() + ".\n");


    }

    public void buscar(Scanner scan)
        throws UsuarioNoEncontradoException, OperacionNoPermitidaException {
        if (!(usuarioLogueado instanceof Admin)) {
            throw new OperacionNoPermitidaException("Para buscar usuarios es necesario ser Admin\n");
        }

        System.out.println("\n Ingrese mail a buscar:");
        String emailIngresado = scan.nextLine();

        Usuario usuario = validarEmail(emailIngresado);
        if (usuario == null) {
            throw new UsuarioNoEncontradoException("\n Usuario no encontrado." );
        }
        System.out.println("\n Usuario encontrado:");
        usuario.mostrarDatos();
    }

    public void listar(Scanner scan)
        throws OperacionNoPermitidaException{
            if (!(usuarioLogueado instanceof Admin)){
            throw new OperacionNoPermitidaException ("Para listar usuarios es necesario ser Admin\n");
        }

        System.out.println("\n Usuarios registrados:");
        for (Usuario usuario : usuarios){
            System.out.println("\n  ---");
            usuario.mostrarDatos();
        }
        System.out.println("\n  ---");
    }

}


