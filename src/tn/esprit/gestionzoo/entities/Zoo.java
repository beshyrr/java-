package tn.esprit.gestionzoo.entities;

public class Zoo {
    private Animal[] animals;
    private String name;
    private String city;
    private static final int nbrCages = 25;
    int nbrAnimals;

    public Zoo(String name, String city) {
        animals = new Animal[nbrCages];
        setName(name);
        this.city = city;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("ne doit pas etre vide");
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void displayZoo() {
        System.out.println("Zoo Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Number of cages: " + nbrCages);
        System.out.println("Animals in the zoo:");
        for (Animal a : animals) {
            if (a != null) {
                System.out.println("Name: " + a.getName() + ", Family: " + a.getFamily() + ", Age: " + a.getAge() + ", Mammal: " + a.isMammal());
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Zoo Name: ").append(name)
                .append(", City: ").append(city)
                .append(", Number of cages: ").append(nbrCages)
                .append("\nAnimals:\n");
        for (Animal a : animals) {
            if (a != null) {
                sb.append(a).append("\n");
            }
        }
        return sb.toString();
    }

    public boolean addAnimal(Animal animal) {
        if (animal == null) {
            System.out.println("Cannot add null animal");
            return false;
        }
        if (isZooFull()) {
            System.out.println("Zoo est plein !");
            return false;
        }
        if (searchAnimal(animal) != -1) {
            System.out.println("Animal présent : " + animal.getName());
            return false;
        }
        // Find first empty slot
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                animals[i] = animal;
                nbrAnimals++;
                return true;
            }
        }
        return false;
    }

    public int searchAnimal(Animal animal) {
        if (animal == null) {
            return -1;
        }
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null && animals[i].getName().equals(animal.getName())) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index != -1) {
            animals[index] = null;
            nbrAnimals--;
            System.out.println("Animal supprimé : " + animal.getName());
            return true;
        }
        System.out.println("Animal non trouvé : " + (animal != null ? animal.getName() : "null"));
        return false;
    }

    public boolean isZooFull() {
        int nombreAnimaux = 0;
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null) {
                nombreAnimaux++;
            }
        }
        if (nombreAnimaux == nbrCages) {
            System.out.println("Zoo is full");
            return true;
        } else {
            System.out.println("Zoo is not full");
            return false;
        }
    }

    public int compterAnimaux() {
        int nombreAnimaux = 0;
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null) {
                nombreAnimaux++;
            }
        }
        return nombreAnimaux;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        int animauxZ1 = z1.compterAnimaux();
        int animauxZ2 = z2.compterAnimaux();

        if (animauxZ1 > animauxZ2) {
            return z1;
        } else if (animauxZ2 > animauxZ1) {
            return z2;
        } else {
            return null;
        }
    }


}

