import Models.Endangered;
import Models.Safe;
import Models.Sightings;

import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        staticFileLocation("/public");

        // home page
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        // animals registry
        get("/animals-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());



    }
}
