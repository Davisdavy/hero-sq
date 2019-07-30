package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
    @Test
    public void hero_instantiatesCorrectlyAndReturnTrue() {
        Hero newHero = Hero.createHero();
        assertTrue(newHero instanceof Hero);
    }

    @Test
    public void hero_getPowerThatIsString() {
        Hero newHero = Hero.createHero();
        assertEquals("yyy",newHero.getPower());
    }
    @Test
    public void hero_getWeaknessThatIsAString() {
        Hero newHero = Hero.createHero();
        assertEquals("yyy",newHero.getWeakness());
    }
    @Test
    public void hero_getIdInt() {
        Hero.clearAllHeroes();
        Hero newHero = Hero.createHero();
        Hero another = Hero.createHero();
        Hero another1 = Hero.createHero();
        assertEquals(3,another1.getId());
    }
    @Test
    public void hero_findById() {
        Hero.clearAllHeroes();
        Hero newHero = Hero.createHero();
        Hero another = Hero.createHero();
        assertEquals(2,Hero.findById(another.getId()).getId());
    }
    @Test
    public void hero_getNameThatIsAString() {
        Hero newHero = Hero.createHero();
        assertEquals("XXX",newHero.getName());
    }
    @Test
    public void hero_getAgeThatIsAnInteger() {
        Hero newHero = Hero.createHero();
        assertEquals(23,newHero.getAge());
    }


    @Test
    public void hero_getAllInstancesReturnTrue() {
        Hero newHero = Hero.createHero();
        Hero another = Hero.createHero();
        assertTrue(Hero.getAllInstances().contains(newHero));
        assertTrue(Hero.getAllInstances().contains(another));
    }


}