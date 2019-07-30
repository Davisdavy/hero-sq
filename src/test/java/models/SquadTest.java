package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void squad_instantiatesCorrectlyAndReturnTrue() {
        Squad newSquad = Squad.createSquad();
        assertTrue(newSquad instanceof Squad);
    }
    @Test
    public void squad_getNameThatIsString() {
        Squad newSquad = Squad.createSquad();
        assertEquals("XXX",newSquad.getSquadName());
    }
    @Test
    public void squad_getSizeThatIsAnInteger() {
        Squad newSquad = Squad.createSquad();
        assertEquals(5,newSquad.getSize());
    }
    @Test
    public void squad_getPowerThatIsAString() {
        Squad newSquad = Squad.createSquad();
        assertEquals("XXX",newSquad.getCause());
    }
    @Test
    public void squad_getInstancesThatIsTrue() {
        Squad newSquad = Squad.createSquad();
        Squad another = Squad.createSquad();
        assertTrue(Squad.getInstances().contains(newSquad));
        assertTrue(Squad.getInstances().contains(another));
    }
    @Test
    public void squad_getSquadPlayersInAnArray() {
        Squad newSquad = Squad.createSquad();
        Hero newHero = Hero.createHero();
        Hero newHero1 = Hero.createHero();
        newSquad.setSquadPlayers(newHero);
        assertEquals("XXX",newSquad.getSquadPlayers().get(0).getName());
    }

    @Test
    public void squad_allTestSquadPlayersInAnArray() {
        Hero newHero = Hero.createHero();
        Squad newSquad = Squad.createSquad();
        newSquad.clearAllSquadMembers();
        newSquad.getSquadPlayers().add(newHero);
        newSquad.getSquadPlayers().add(newHero);
        assertEquals("XXX",newSquad.getSquadPlayers().get(0).getName());
    }
    @Test
    public void addPlayers_addPlayersToSquadInTheHero(){
        Hero newHero = Hero.createHero();
        Squad testSquad = Squad.createSquad();
        Squad newSquad = Squad.findBySquadId(1);
        newSquad.clearAllSquadMembers();
        newSquad.getSquadPlayers().add(newHero);
        newSquad.getSquadPlayers().add(newHero);
        assertEquals(2,newSquad.getSquadPlayers().size());
    }

    @Test
    public void setNewPlayerWhichIsAHero(){
        Hero.clearAllHeroes();
        Hero newHero = Hero.createHero();
        Squad testSquad = Squad.createSquad();
        testSquad.setSquadPlayers(newHero);

        assertEquals(1,testSquad.getSquadPlayers().get(0).getId());
    }

}