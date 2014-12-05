package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Team Fantastic 404 for #Hack4Humanity"));
    }

}
