package controllers;

import models.Usuario;

/**
 * Controlador de {@link AuxiliarCobro}.
 *
 * @since 29/02/2016
 * @version 1
 * @author Omar Benítez
 */
public class Security extends Secure.Security {
    
    /**
     * Método que verifica el acceso a la aplicación.
     *
     * @param username Correo electrónico registrado con el usuario.
     * @param password Cadena de seguridad que el usuario asigno para acceder a
     * la aplicación.
     *
     * @return TRUE si la aplicación acepta el acceso, FALSE si el modelo
     * rechaza la combinación.
     */
    public static boolean authenticate(String username, String password) {
        return Usuario.conectar(username, password);
    }
    
}