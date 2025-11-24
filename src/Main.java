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

        // Prosit 8: test food interfaces and implementations
        Terrestrial t1 = new Terrestrial("Canidae", "Fox", 4, true);
        // Aquatic (Dolphin) eating behaviors
        d1.eatMeat(Food.MEAT);
        d2.eatMeat(Food.PLANT);
        // Penguin (Aquatic) eating behaviors
        p1.eatMeat(Food.BOTH);
        // Terrestrial omnivore behaviors
        t1.eatPlant(Food.PLANT);
        t1.eatMeat(Food.MEAT);
        t1.eatPlantAndMeet(Food.BOTH);

        // Prosit 11: gestion des affectations Employé -> Département
        AffectationHashMap affectationHashMap = new AffectationHashMap();

        Employee emp1 = new Employee(1, "Ali", "Ben Salah", "IT", 3);
        Employee emp2 = new Employee(2, "Sara", "Trabelsi", "Finance", 2);
        Employee emp3 = new Employee(3, "Mehdi", "Ayari", "HR", 4);

        Departement depIT = new Departement(101, "Informatique", 15);
        Departement depFinance = new Departement(102, "Finance", 8);
        Departement depHR = new Departement(103, "Ressources Humaines", 12);

        affectationHashMap.ajouterEmployeDepartement(emp1, depIT);
        affectationHashMap.ajouterEmployeDepartement(emp2, depFinance);
        affectationHashMap.ajouterEmployeDepartement(emp3, depHR);

        System.out.println("--- Affectations initiales ---");
        affectationHashMap.afficherEmployesEtDepartements();

        // Tentative d'ajouter le même employé dans un autre département
        affectationHashMap.ajouterEmployeDepartement(emp1, depFinance);
        System.out.println("--- Après tentative de double affectation ---");
        affectationHashMap.afficherEmployesEtDepartements();

        // Recherche et suppression
        System.out.println("Emp1 présent ? " + affectationHashMap.rechercherEmploye(emp1));
        System.out.println("Département IT présent ? " + affectationHashMap.rechercherDepartement(depIT));

        affectationHashMap.supprimerEmployeEtDepartement(emp2, depFinance);
        System.out.println("--- Après suppression stricte ---");
        affectationHashMap.afficherEmployesEtDepartements();

        affectationHashMap.supprimerEmploye(emp3);
        System.out.println("--- Après suppression d'un employé ---");
        affectationHashMap.afficherEmployesEtDepartements();

        System.out.println("--- Employés triés ---");
        affectationHashMap.trierMap().forEach((employee, departement) ->
                System.out.printf("%s -> %s%n", employee.getNom(), departement.getNom()));

        System.out.println("--- Employés enregistrés ---");
        affectationHashMap.afficherEmployes();
        System.out.println("--- Départements enregistrés ---");
        affectationHashMap.afficherDepartements();
    }
}