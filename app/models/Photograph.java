package models;

import com.google.code.morphia.annotations.Entity;
import play.modules.morphia.Blob;
import play.modules.morphia.Model;

/**
 * Modelo de Photograph.
 *
 * @since 25/04/2016
 * @version 1
 * @author Omar Benítez
 */
@Entity
public class Photograph extends Model {

    public Blob file;

    public String alt;

    public String base64;

    /**
     * Constructor del {@link Photograph}.
     */
    public Photograph() {
    }

}
