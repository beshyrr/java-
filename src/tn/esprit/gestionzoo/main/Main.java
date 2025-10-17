package tn.esprit.gestionzoo.main;
import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;
import tn.esprit.gestionzoo.entities.Aquatic;
import tn.esprit.gestionzoo.entities.Dolphin;
import tn.esprit.gestionzoo.entities.Penguin;
import tn.esprit.gestionzoo.entities.Lion;
public class Main {
    public static void main(String[] args) {

        Animal lion = new Animal("Félin", "Lion", 5, true);
        Animal lion1 = new Animal("Félin", "lion", 5, true);
        Animal lapin = new Animal("Rongeur", "Lapin", 2, true);
        Animal elephant = new Animal("Éléphantidé", "Éléphant", 10, true);
        Animal girafe = new Animal("Giraffidé", "Girafe", 8, true);
        Zoo z1 = new Zoo("ZooFrance", "Paris");
        z1.addAnimal(lion);
        z1.addAnimal(elephant);
        z1.addAnimal(lapin);

        z1.displayZoo();
        Zoo z2 = new Zoo("ZooTunis", "Paris");
        z2.addAnimal(lion);
        z2.addAnimal(elephant);
        z2.addAnimal(lapin);

        if(Zoo.comparerZoo(z1,z2)== null){
            System.out.println("egale");
        }
        else{
            System.out.println(Zoo.comparerZoo(z1, z2));
        }
        lion.setAge(7);
        System.out.println("setAge(7) : " + lion);


        System.out.println("setAge(-3) : " + lion);
        lion.setAge(-3);


        Zoo zoo2 = new Zoo("aaaa", "Sfax");
        System.out.println("Nom du zoo : " + zoo2.getName());
        zoo2.setName(null);
        System.out.println("Nom après setName : " + zoo2.getName());
        zoo2.setName("");
        System.out.println("Nom après setName : " + zoo2.getName());

        zoo2.addAnimal(lion);
        zoo2.addAnimal(elephant);
        zoo2.addAnimal(lapin);
        System.out.println("Nom du zoo : " + zoo2);
        /*int test=myZoo.searchAnimal(lion);
        System.out.println(test);
        int test1=myZoo.searchAnimal(lion1);
        System.out.println(test1);*/

        // Test removing animal
        z1.removeAnimal(girafe);
        z1.isZooFull();

        // Creating instances of each class
        System.out.println("\n=== Creating instances of the new animal classes ===");
        
        // Note: Aquatic and Terrestrial are abstract classes, so we can't instantiate them directly
        // We can only instantiate their concrete subclasses
        
        Dolphin dolphin = new Dolphin("Cétacé", "Dauphin", 8, true, "Océan", 25.5f);
        Penguin penguin = new Penguin("Spheniscidae", "Pingouin", 5, true, "Antarctique", 50.0f);
        Lion lionTerrestrial = new Lion("Félin", "Lion Terrestre", 6, true, 4);
        
        System.out.println("=== Displaying all created objects with toString() ===");
        System.out.println("Dolphin: " + dolphin);
        System.out.println("Penguin: " + penguin);
        System.out.println("Lion (Terrestrial): " + lionTerrestrial);
        
        System.out.println("\n=== Demonstrating toString() inheritance hierarchy ===");
        System.out.println("1. Animal base class attributes: Name, Family, Age, Mammal");
        System.out.println("2. Aquatic adds: Habitat");
        System.out.println("3. Terrestrial adds: Number of Legs");
        System.out.println("4. Dolphin adds: Swimming Speed");
        System.out.println("5. Penguin adds: Swimming Depth");
        System.out.println("6. Lion adds: (Lion) identifier");
        
        System.out.println("\n=== Detailed toString() output ===");
        System.out.println("Dolphin toString(): " + dolphin);
        System.out.println("  - Inherits from Animal: Name, Family, Age, Mammal");
        System.out.println("  - Inherits from Aquatic: Habitat");
        System.out.println("  - Own attribute: Swimming Speed");
        
        System.out.println("\nPenguin toString(): " + penguin);
        System.out.println("  - Inherits from Animal: Name, Family, Age, Mammal");
        System.out.println("  - Inherits from Aquatic: Habitat");
        System.out.println("  - Own attribute: Swimming Depth");
        
        System.out.println("\nLion toString(): " + lionTerrestrial);
        System.out.println("  - Inherits from Animal: Name, Family, Age, Mammal");
        System.out.println("  - Inherits from Terrestrial: Number of Legs");
        System.out.println("  - Own identifier: (Lion)");
        
        // Testing getter and setter methods
        System.out.println("\n=== Testing getter and setter methods ===");
        
        // Test Dolphin getters and setters
        System.out.println("Dolphin habitat: " + dolphin.getHabitat());
        System.out.println("Dolphin swimming speed: " + dolphin.getSwimmingSpeed() + " km/h");
        
        dolphin.setSwimmingSpeed(30.0f);
        dolphin.setHabitat("Mer Méditerranée");
        System.out.println("After modification - Dolphin: " + dolphin);
        
        // Test Penguin getters and setters
        System.out.println("Penguin habitat: " + penguin.getHabitat());
        System.out.println("Penguin swimming depth: " + penguin.getSwimmingDepth() + " m");
        
        penguin.setSwimmingDepth(75.0f);
        penguin.setHabitat("Arctique");
        System.out.println("After modification - Penguin: " + penguin);
        
        // Testing swim() method polymorphism
        System.out.println("\n=== Testing swim() method polymorphism ===");
        
        // Create references of different types
        Aquatic aquatic1 = new Dolphin("Cétacé", "Dauphin Aquatique", 7, true, "Océan Atlantique", 20.0f);
        Aquatic aquatic2 = new Penguin("Spheniscidae", "Pingouin Aquatique", 4, true, "Antarctique", 45.0f);
        Dolphin dolphin3 = new Dolphin("Cétacé", "Dauphin Direct", 9, true, "Océan Pacifique", 35.0f);
        
        System.out.println("Calling swim() on Aquatic reference (Dolphin object):");
        aquatic1.swim();
        
        System.out.println("\nCalling swim() on Aquatic reference (Penguin object):");
        aquatic2.swim();
        
        System.out.println("\nCalling swim() on Dolphin reference (Dolphin object):");
        dolphin3.swim();
        
        System.out.println("\n=== Polymorphism Analysis ===");
        System.out.println("1. aquatic1 (Aquatic reference, Dolphin object) -> Uses Dolphin's swim() method");
        System.out.println("2. aquatic2 (Aquatic reference, Penguin object) -> Uses Aquatic's swim() method (inherited)");
        System.out.println("3. dolphin3 (Dolphin reference, Dolphin object) -> Uses Dolphin's swim() method");
        System.out.println("\nObservation: The actual object type determines which swim() method is called,");
        System.out.println("not the reference type. This demonstrates polymorphism!");

    }
}