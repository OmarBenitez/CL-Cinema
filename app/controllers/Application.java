package controllers;

import java.util.*;

import models.*;
import play.*;
import play.modules.morphia.Blob;
import play.modules.paginate.ValuePaginator;
import play.mvc.*;

public class Application extends Controller {

    public static void index() {
        List<Post> posts = Post.findAll();
        ValuePaginator objects = new ValuePaginator(posts);
        objects.setPageSize(3);
        render(objects);
    }

    public static void newPost() {
        render();
    }

    public static void savePost(Post object) {
        try {
            object.banner.save();
            object.photos.forEach(p -> {
                p.save();
            });
            object.save();
        } catch (Exception e) {
            newPost();
        }
        index();
    }

    public static void attach(String postId) {
        Post post = Post.findById(postId);
        Blob b = post.banner.file;
        renderBinary(b.get());
    }
    
    public static void getPhoto(String id) {
        Photograph p = Photograph.findById(id);
        renderBinary(p.file.get());
    }

}
