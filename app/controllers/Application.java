package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
  
      String pageName = "Home";
      
      return ok(index.render(pageName)); // Runs the index.scala.html page
    }

    public static Result query(String id) {

    	return ok(query.render(id));

    }

}