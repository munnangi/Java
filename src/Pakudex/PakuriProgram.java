//package Pakudex;

import java.util.Scanner;

public class PakuriProgram {

    public static Integer maxCapacity;
    public static Scanner sc;

    public static void main(String[] args) {

        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");

        // Prompt until a valid value for capacity is entered
        sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter max capacity of the Pakudex: ");
            try{
                Object ob = sc.next();
                maxCapacity = Integer.parseInt(ob.toString());

                if (maxCapacity  < 0) {
                    System.out.println("Please enter a valid size.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid size.");
            }
        }


        System.out.println("\nThe Pakudex can hold " + maxCapacity + " species of Pakuri.");

        Pakudex pakudex = new Pakudex();
        if (maxCapacity != null) {
            pakudex = new Pakudex(maxCapacity);
        }

        whileLoop : while(true) {

            System.out.println("\nPakudex Main Menu");
            System.out.println("-----------------");
            System.out.println("1. List Pakuri\n" +
                    "2. Show Pakuri\n3. Add Pakuri\n4. Evolve Pakuri\n5. Sort Pakuri\n6. Exit\n");
            System.out.print("What would you like to do? ");
            int option;
            try {
                Object obj = sc.next();
                option = Integer.parseInt(obj.toString());
            } catch(Exception e) {
                System.out.println("Unrecognized menu selection!");
                continue;
            }


            switch (option) {
                case 1:
                    if (pakudex.getSpeciesArray() != null) {
                        System.out.println("Pakuri In Pakudex:");
                        for(int i=0; i < pakudex.getSpeciesArray().length; i++) {
                            System.out.println(i+1 + ". " + pakudex.getSpeciesArray()[i]);
                        }
                    } else {
                        System.out.println("No Pakuri in Pakudex yet!");
                    }

                    break;
                case 2:
                    System.out.print("Enter the name of the species to display: ");
                    Object obje = sc.next();
                    String species = obje.toString();
                    int[] stats = pakudex.getStats(species);
                    if (stats != null && stats.length != 0) {
                        System.out.println("Species: " + species);
                        System.out.println("Attack: " + stats[0]);
                        System.out.println("Defense: " + stats[1]);
                        System.out.println("Speed: " + stats[2]);
                    }
                    break;
                case 3:
                    if (pakudex.getSize() >= pakudex.getCapacity()) {
                        System.out.println("Error: Pakudex is full!");
                        break;
                    }

                    System.out.print("Enter the name of the species to add: ");
                    Object objec = sc.next();
                    String speciesName = objec.toString();


                    if (!pakudex.addPakuri(speciesName)) {
                        System.out.println("Error: Pakudex already contains this species!");

                    } else {
                        System.out.println("Pakuri species " + speciesName + " successfully added!");
                    }
                    break;
                case 4:
                    System.out.print("Enter the name of the species to evolve: ");
                    Object obj1 = sc.next();
                    String speciesEvolve = obj1.toString();
                    if (pakudex.evolveSpecies(speciesEvolve)) {
                        System.out.println( speciesEvolve + " has evolved!");
                    } else {
                        System.out.println("Error: No such Pakuri!");
                    }
                    break;
                case 5:
                    pakudex.sortPakuri();
                    System.out.println("Pakuri have been sorted!");
                    break;

                case 6:
                    System.out.println("Thanks for using Pakudex! Bye!");
                    break whileLoop;

                default:
                    System.out.println("Unrecognized menu selection!");
                    break;
            }
        }

    }

}
