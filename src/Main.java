import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Animal lion = new Animal("Félin", "Lion", 5, true);
        Animal lion1 = new Animal("Félin", "lion", 5, true);
        Animal lapin = new Animal("Rongeur", "Lapin", 2, true);
        Animal elephant = new Animal("Éléphantidé", "Éléphant", 10, true);
        Animal girafe = new Animal("Giraffidé", "Girafe", 8, true);
        Zoo z1 = new Zoo("ZooFrance", "Paris");
        try {
            z1.addAnimal(lion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Nombre d'animaux z1: " + z1.compterAnimaux());
        }
        try {
            z1.addAnimal(elephant);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Nombre d'animaux z1: " + z1.compterAnimaux());
        }
        try {
            z1.addAnimal(lapin);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Nombre d'animaux z1: " + z1.compterAnimaux());
        }

        /*myZoo.displayZoo();*/
        Zoo z2 = new Zoo("ZooTunis", "Paris");
        try {
            z2.addAnimal(lion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Nombre d'animaux z2: " + z2.compterAnimaux());
        }
        try {
            z2.addAnimal(elephant);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Nombre d'animaux z2: " + z2.compterAnimaux());
        }
        try {
            z2.addAnimal(lapin);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Nombre d'animaux z2: " + z2.compterAnimaux());
        }

        if(Zoo.comparerZoo(z1,z2)== null){
            System.out.println("egale");
        }
        else{
            System.out.println(Zoo.comparerZoo(z1, z2));
        }

        /*int test=myZoo.searchAnimal(lion);
        System.out.println(test);
        int test1=myZoo.searchAnimal(lion1);
        System.out.println(test1);*/

        //myZoo.removeAnimal(girafe);
        /*z1.isZooFull();*/

        // Prosit 6 demo: add aquatic animals and show behaviors
        Dolphin d1 = new Dolphin("Delphinidae", "Flipper", 6, true, "Sea", 30.5f);
        Dolphin d2 = new Dolphin("Delphinidae", "Echo", 4, true, "Ocean", 28.0f);
        Penguin p1 = new Penguin("Spheniscidae", "Pingo", 3, false, "Antarctica", 50.0f);
        Penguin p2 = new Penguin("Spheniscidae", "Chilly", 2, false, "Antarctica", 65.5f);

        z1.addAquaticAnimal(d1);
        z1.addAquaticAnimal(d2);
        z1.addAquaticAnimal(p1);
        z1.addAquaticAnimal(p2);

        // Instruction 27: call swim() on all aquatics
        z1.swimAllAquatics();
        // Observation: polymorphism — each type executes its own swim()

        // Instruction 29: max penguin depth
        System.out.println("Max penguin depth: " + z1.maxPenguinSwimmingDepth());

        // Instruction 30: display numbers by type
        z1.displayNumberOfAquaticsByType();
    }
}