package models;

import com.google.code.morphia.annotations.Entity;
import java.util.List;
import play.modules.morphia.Model;

/**
 * Modelo de Post.
 *
 * @since 25/04/2016
 * @version 1
 * @author Omar Benítez
 */
@Entity
public class Post extends Model {

    public String title;

    public String content;

    public String hexColor;

    public Photograph banner;

    public List<Photograph> photos;

    /**
     * Constructor del {@link Post}.
     */
    public Post() {
    }

}
