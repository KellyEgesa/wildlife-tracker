import dao.*;
import models.Animal;
import models.Sightings;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.staticFileLocation;
import static spark.route.HttpMethod.get;

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
    }
}
