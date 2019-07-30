package models;

import java.util.ArrayList;

    public class Hero {

        private int id;
        private String name;
        private int age;
        private String power;
        private String weakness;
        private static ArrayList<Hero> instances = new ArrayList<>();

        public Hero(String name, Integer age, String power, String weakness) {
            this.name = name;
            this.age = age;
            this.power = power;
            this.weakness = weakness;
            instances.add(this);
            this.id = instances.size();
        }
        // name
        public String getName() {return this.name;}

        //age
        public int getAge() {
            return this.age;
        }
        //power
        public String getPower() {
            return this.power;
        }
        //weakness
        public String getWeakness() {
            return this.weakness;
        }
        public static ArrayList<Hero> getAllInstances() {
            return instances;
        }
        public static void clearAllHeroes(){
            instances.clear();
        }

        public int getId(){
            return id;
        }
        public static Hero findById(int id) {
            return instances.get(id-1);
        }

        public static Hero createHero(){

            return new Hero("XXX",23,"yyy","yyy");
        }
        public static Hero createAnotherHero(){

            return new Hero("LLL",30,"XXX","ZZZ");
        }


    }
