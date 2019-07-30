import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());
        Hero.createHero();
        get("/h-form",(request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "h-form.hbs");
        }, new HandlebarsTemplateEngine());
        Hero.createAnotherHero();
        get("/hero",(request, response) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> hero = Hero.getAllInstances();
            model.put("hero",hero);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());
        Squad.createSquad();
        get("/new/:id",(request, response) ->{
            Map<String, Object> model = new HashMap<>();
            int idOfHero = Integer.parseInt(request.params(":id"));
            Hero foundHero = Hero.findById(idOfHero);
            model.put("hero",foundHero);
            return new ModelAndView(model, "more.hbs");
        }, new HandlebarsTemplateEngine());

        get("/s-form",(request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "s-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad",(request, response) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getInstances();
            model.put("squads",squads);
            ArrayList<Hero> players = Hero.getAllInstances();
            model.put("heroes",players);
            Squad newSquad = Squad.findBySquadId(1);
            model.put("allSquadPlayers;", newSquad.getSquadPlayers());
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());


        post("/new/hero",(request, response) ->{
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            Integer age = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero newHero = new Hero(name,age,power,weakness);
            request.session().attribute("item",name);
            model.put("item",request.session().attribute("item"));
            model.put("newHero",newHero);
            return new ModelAndView(model, "message.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squad/new",(request,res)-> {
            Map<String, Object> model = new HashMap<>();
            String squadName = request.queryParams("squadName");
            Integer size = Integer.parseInt(request.queryParams("size"));
            String cause = request.queryParams("cause");
            Squad newSquad = new Squad(squadName,size,cause);
            request.session().attribute("item",squadName);
            model.put("item",request.session().attribute("item"));
            return new ModelAndView(model,"message.hbs");
        }, new HandlebarsTemplateEngine());


        get("/squad/new/:id",(request,response)->{
            Map<String, Object> model = new HashMap<>();
            int id= Integer.parseInt(request.params(":id"));
            Hero newPlayer = Hero.findById(id);
            Squad newSquad = Squad.findBySquadId(1);
            newSquad.setSquadPlayers(newPlayer);
            model.put("item", newPlayer.getName());
            model.put("newHero",newSquad.getSquadName());
            return new ModelAndView(model, "message.hbs");
        }, new HandlebarsTemplateEngine());

        get("/new/member/:squadId",(request,response)->{
            Map<String, Object> model = new HashMap<>();
            request.session().attribute("selectedSquad",request.params("squadId"));
            model.put("selectedSquad", request.session().attribute("selectedSquad"));
            model.put("item",1);
            return new ModelAndView(model, "message.hbs");
        },new HandlebarsTemplateEngine());

    }
}
