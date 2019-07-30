package models;


import java.util.ArrayList;


public class Squad {

    private int squadId;
    private String squadName;
    private int squadSize;
    private String cause;
    private ArrayList<Hero>  squadPlayers;
    private static ArrayList<Squad> instances = new ArrayList<>();


    public Squad(String name, int size, String cause ){
        squadName = name;
        squadSize = size;
        this.squadPlayers = new ArrayList<>();
        this.cause = cause;
        instances.add(this);
        this.squadId = instances.size();

    }
    public int getSquadId(){

        return squadId;}
    public static Squad findBySquadId(int id) {
        return instances.get(id-1);
    }
    public String getSquadName() {return squadName;
    }
    public int getSize() {
        return squadSize;
    }
    public String getCause() {
        return this.cause;
    }
    public static ArrayList<Squad> getInstances(){
        return instances;
    }
    public ArrayList<Hero> getSquadPlayers(){
        return squadPlayers;
    }
    public void setSquadPlayers(Hero newPlayer) {
        squadPlayers.add(newPlayer);
    }
    public static void clearAllSquads(){
        instances.clear();
    }
    public void clearAllSquadMembers(){
        getSquadPlayers().clear();
    }

    public static Squad createSquad(){
        return new Squad("XXX",5,"XXX");
    }
    public static Squad createAnotherSquad(){
        return new Squad("XXx",5,"XX");
    }

}
