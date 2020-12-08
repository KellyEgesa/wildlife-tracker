import dao.*;
import jdk.jfr.Enabled;
import models.*;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.staticFileLocation;
import static spark.route.HttpMethod.get;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        Sql2oSightings sightingsDao = new Sql2oSightings();
        Sql2oNonEndangeredSpecie nonEndangeredSpecieDao = new Sql2oNonEndangeredSpecie();
        Sql2oEndangeredSpecie endangeredSpecieDao = new Sql2oEndangeredSpecie();
        Sql2oLocation locationDao = new Sql2oLocation();
        Sql2oRangers rangersDao = new Sql2oRangers();
        Sql2oAnimal animalDao = new Sql2oAnimal();

        Spark.get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sightings> allSightings = sightingsDao.getAll();
            model.put("sightings", allSightings);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        Spark.get("/animals", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> allAnimals = animalDao.getAll();
            model.put("animals", allAnimals);
            return new ModelAndView(model, "animal.hbs");
        }, new HandlebarsTemplateEngine());

        Spark.get("/location", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Location> allLocations = locationDao.getAll();
            model.put("locations", allLocations);
            return new ModelAndView(model, "location.hbs");
        }, new HandlebarsTemplateEngine());

        Spark.get("/rangers", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Rangers> allRangers = rangersDao.getAll();
            model.put("rangers", allRangers);
            return new ModelAndView(model, "ranger.hbs");
        }, new HandlebarsTemplateEngine());

        Spark.get("add/animals", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "animalform.hbs");
        }, new HandlebarsTemplateEngine());

        Spark.get("add/endangered", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "form-endagered.hbs");
        }, new HandlebarsTemplateEngine());

        Spark.get("add/nonendangered", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "form-nonendangered.hbs");
        }, new HandlebarsTemplateEngine());

        Spark.get("add/ranger", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "form-rangers.hbs");
        }, new HandlebarsTemplateEngine());

        Spark.get("add/location", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "form-location.hbs");
        }, new HandlebarsTemplateEngine());

        Spark.get("add/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> allAnimals = animalDao.getAll();
            model.put("animals", allAnimals);
            List<Location> allLocations = locationDao.getAll();
            model.put("locations", allLocations);
            List<Rangers> allRangers = rangersDao.getAll();
            model.put("rangers", allRangers);
            return new ModelAndView(model, "form-sightings.hbs");
        },new HandlebarsTemplateEngine());

        post("/post/new/sighting", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int animalId = Integer.parseInt(request.queryParams("animalId"));
            int locationId = Integer.parseInt(request.queryParams("locationId"));
            int rangerId = Integer.parseInt(request.queryParams("rangerId"));
            Sightings newSightings = new Sightings(rangerId, locationId, animalId);
            sightingsDao.save(newSightings);
            response.redirect("/");
            return new ModelAndView(model, "index.hbs");
        }), new HandlebarsTemplateEngine());

        Spark.get("/post/delete/sighting/:id", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int sightingsId = Integer.parseInt(request.params("id"));
            sightingsDao.deleteById(sightingsId);
            response.redirect("/");
            return new ModelAndView(model, "index.hbs");
        }), new HandlebarsTemplateEngine());

        Spark.get("/post/delete/animal/:id", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int animalId = Integer.parseInt(request.params("id"));
            animalDao.deleteById(animalId);
            response.redirect("/animals");
            return new ModelAndView(model, "index.hbs");
        }), new HandlebarsTemplateEngine());

        Spark.get("/post/delete/location/:id", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int locationId = Integer.parseInt(request.params("id"));
            locationDao.deleteById(locationId);
            response.redirect("/location");
            return new ModelAndView(model, "index.hbs");
        }), new HandlebarsTemplateEngine());

        Spark.get("/post/delete/ranger/:id", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int rangerId = Integer.parseInt(request.params("id"));
            rangersDao.deleteById(rangerId);
            response.redirect("/rangers");
            return new ModelAndView(model, "index.hbs");
        }), new HandlebarsTemplateEngine());

        post("/post/new/location", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Location newLocation = new Location(request.queryParams("location"));
            locationDao.save(newLocation);
            response.redirect("/location");
            return new ModelAndView(model, "form-location.hbs");
        }), new HandlebarsTemplateEngine());

        post("/post/new/ranger", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int badgeNumber = Integer.parseInt(request.queryParams("badgeNumber"));
            Rangers newRanger = new Rangers(request.queryParams("name"),
                    request.queryParams("contactInfo"),
                    badgeNumber);
            rangersDao.save(newRanger);
            response.redirect("/rangers");
            return new ModelAndView(model, "form-rangers.hbs");
        }), new HandlebarsTemplateEngine());

        post("/post/new/animal", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            if (request.queryParams("health") != null) {
                EndangeredSpecie newEndangered = new EndangeredSpecie(request.queryParams("name"),
                        request.queryParams("age"),
                        request.queryParams("health"));
                endangeredSpecieDao.save(newEndangered);
            } else {
                NonEndangeredSpecie newNonEndangered = new NonEndangeredSpecie(request.queryParams("name")
                        , request.queryParams("age"));
                nonEndangeredSpecieDao.save(newNonEndangered);
            }
            response.redirect("/animals");
            return new ModelAndView(model, "animal.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
