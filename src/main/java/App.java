import Models.Endangered;
import Models.Safe;
import Models.Sightings;

import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        staticFileLocation("/public");

        // home page
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        // animals registry form
        get("/animals-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        // display animals on record
        post("/AnimalDetail", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String type = request.queryParams("type");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            model.put("name", name);
            model.put("type", type);
            model.put("health", health);
            model.put("age",age);

            if(type == "safe"){
                Safe animal = new Safe(name,age,health,type);
                animal.save();
            }
            else {
                Endangered animal = new Endangered(name,age,health,type);
                animal.save();
            }
            return new ModelAndView(model, "displayAnimals.hbs");
        }, new HandlebarsTemplateEngine());

        get("/Animals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Safe> safeAnimal = Safe.all();
            List<Endangered>  unsafeAnimal = Endangered.all();
            model.put("safeAnimal", safeAnimal);
            model.put("unsafeAnimal",unsafeAnimal);
            return new ModelAndView(model, "allAnimals.hbs");
        }, new HandlebarsTemplateEngine());

        // report sightings form
        get("/sightings-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightingsDisplay", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Sightings>  sightings = Sightings.getAll();
            model.put("sightings", sightings);
            return new ModelAndView(model, "displaySighting.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String ranger = request.queryParams("ranger");
            String location = request.queryParams("location");
            int animalId = Integer.parseInt(request.queryParams("animalId"));
            model.put("ranger", ranger);
            model.put("location", location);
            model.put("animalId", animalId);
            Sightings sighting = new Sightings(ranger,location,animalId);
            sighting.save();
            return new ModelAndView(model, "displaySighting.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
