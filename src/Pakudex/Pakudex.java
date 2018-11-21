// package Pakudex;

import java.util.*;

 public class Pakudex {
    private int capacity;
    private List<String> speciesArray = new ArrayList<>();
    private HashMap<String, Pakuri> pakuriMap = new HashMap<String, Pakuri>();
    private int[] stats = new int[3];

    // getters and setters
    public String[] getSpeciesArray() {
        if (this.speciesArray.size() == 0) {
            return null;
        }
        String[] speciesArr = new String[this.speciesArray.size()];
        return this.speciesArray.toArray(speciesArr);

    }

    /**
     * @param species Species Name
     *
     * Set the species array with the species name provided
     * Also update the hash map
     */

    public void setSpeciesArray(String species) {
        Pakuri pakuri = new Pakuri(species);
        this.pakuriMap.put(species, pakuri);
        this.speciesArray.add(species);
    }

    /**
     * @return int
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * @param capacity capacity of the array
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // constructor
    public Pakudex() {
        setCapacity(20);
    }

    // constructor
    public Pakudex(int capacity) {
        setCapacity(capacity);
    }

    public int getSize() {
        return this.speciesArray.size();
    }

    /**
     * @param species Species Name
     * @return int[]
     */
    public int[] getStats(String species) {
        // Fetch the pakuri object from hash map and return the int array

        if (pakuriMap.containsKey(species)) {
            Pakuri pak = pakuriMap.get(species);
            this.stats[0] = pak.getAttack();
            this.stats[1] = pak.getDefense();
            this.stats[2] = pak.getSpeed();
            return this.stats;
        } else {
            System.out.println("Error: No such Pakuri!");
            return null;
        }
    }

    /**
     * Sort the pakuri array
     */
    public void sortPakuri() {
        Collections.sort(this.speciesArray);
    }

    /**
     * @param species Species Name
     * @return boolean
     */
    public boolean addPakuri(String species) {
        if (this.getSpeciesArray() == null || !Arrays.asList(this.getSpeciesArray()).contains(species)) {
            this.setSpeciesArray(species);
            return true;
        }
        return false;
    }
    /**
     * @param species Species Name
     * @return boolean
     */
    public boolean evolveSpecies(String species) {
        if (this.getSpeciesArray() != null && Arrays.asList(this.getSpeciesArray()).contains(species)) {
            // Get the existing values from the hash map and evolve the species
            // and put the values back in the hash map
            Pakuri pakObj = new Pakuri(species);
            pakObj.evolve();
            pakuriMap.put(species, pakObj);
            return true;
        }
        return false;
    }
}
