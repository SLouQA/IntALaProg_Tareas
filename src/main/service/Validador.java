package main.service;

import main.exeptions.DatosInvalidosException;

public class Validador {
    private Validador(){
    }
    private static final int LONGITUD_MINIMA_PASSWORD = 4;

    public static void validarCampoObligatorio(String valor, String nombreCampo) throws DatosInvalidosException {
        if (valor == null || valor.trim().isEmpty()) {
            throw new DatosInvalidosException("El campo '" + nombreCampo + "' no puede estar vacío.");
        }
    }

    public static void validarLongitudPassword(String password) throws DatosInvalidosException {
        if (password.length() < LONGITUD_MINIMA_PASSWORD) {
            throw new DatosInvalidosException(
                    "La contraseña debe tener al menos " + LONGITUD_MINIMA_PASSWORD + " caracteres.");
        }
    }

    public static void validarFormatoEmail(String email)
            throws DatosInvalidosException {

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new DatosInvalidosException("Formato de email inválido.");
        }
    }

}
