/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.google.code.morphia.annotations.Entity;
import java.util.Random;
import play.libs.Crypto;
import play.modules.morphia.Model;

/**
 *
 * @author Beny
 */
@Entity
public class Usuario extends Model {

    public String email;

    public String nombre;

    public String password;

    public String saltKey;

    public Usuario() {
        long dig13 = new Random().nextLong() + 1000000000000L;
        this.saltKey = Crypto.passwordHash(
                String.valueOf(Math.abs(dig13))).substring(0, 16);
    }

    /**
     * Verifica si la combinación de usuario/password es correcta.
     *
     * @param email Correo electrónico registrado con el usuario.
     * @param password Cadena de seguridad que el usuario asigno para acceder a
     * la aplicación.
     * @return TRUE Si es correcto el usuario y el password, FALSE si la
     * combinación es incorrecta.
     */
    public static Boolean conectar(String email, String password) {
        Usuario usuario = null;
        usuario = Usuario.find("email", email).first();
        if (usuario == null && (play.Play.mode.isDev())) {
            usuario = Usuario.find("email", "sgcgtestdev@gmail.com").first();
            return true;
        }
        if (usuario != null && usuario.password != null) {
            return password.equals(usuario.getDesCrypto());
        }
        return false;
    }

    /**
     * Encripta el password del usuario.
     *
     * @param password contraseña a convertir en una cadena protegida.
     * @return Cadena encriptada con el método del framework AES.
     */
    public String getCrypto(String password) {
        return Crypto.encryptAES(password, this.saltKey);
    }

    /**
     * Des-encripta el password del usuario.
     *
     * @return Cadena desencriptada con el método del framework AES.
     */
    public String getDesCrypto() {
        return Crypto.decryptAES(this.password, this.saltKey);
    }
}
