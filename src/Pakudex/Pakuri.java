//package Pakudex;

public class Pakuri {

    private String species;
    private int attackLevel;
    private int defenseLevel;
    private int speed;

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAttack() {
        return this.attackLevel;
    }

    public void setAttack(int attackLevel)
    {
        this.attackLevel = attackLevel;
    }

    public int getDefense()
    {
        return this.defenseLevel;
    }

    public void setDefenseLevel(int defenseLevel) {
        this.defenseLevel = defenseLevel;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * @param species Constructor for the Pakuri class
     */
    public Pakuri(String species) {
        this.setSpecies(species);
        this.setAttack((this.getSpecies().length() * 7) + 9);
        this.setDefenseLevel((this.getSpecies().length() * 5) + 17);
        this.setSpeed((this.getSpecies().length() * 6) + 13);
    }

    // evolve the pakuri species
    public void evolve() {
        this.setAttack(this.getAttack() * 2);
        this.setDefenseLevel(this.getDefense() * 4);
        this.setSpeed(this.getSpeed() * 3);
    }
}
