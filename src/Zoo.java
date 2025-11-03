public class Zoo {
    Animal [] animals;
    Aquatic [] aquaticAnimals;
    String name;
    String city;
    static final int nbrCages = 25;
    public Zoo(String name, String city) {
        animals = new Animal[nbrCages];
        aquaticAnimals = new Aquatic[10];
        this.name = name;
        this.city = city;
    }
    public void displayZoo() {
        System.out.println("Zoo Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Number of cages: " + nbrCages);
        System.out.println("Animals in the zoo:");
        for (Animal a : animals) {
            if (a != null) {
                System.out.println("name " + a.name + ", Family: " + a.family + ", Age: " + a.age + ", Mammal: " + a.isMammal);
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

    public void addAquaticAnimal(Aquatic aquatic){
        for (int i = 0; i < aquaticAnimals.length; i++) {
            if (aquaticAnimals[i] == null) {
                aquaticAnimals[i] = aquatic;
                return;
            }
        }
        System.out.println("Aquatic section is full");
    }

    public void swimAllAquatics(){
        for (Aquatic a : aquaticAnimals) {
            if (a != null) {
                a.swim();
            }
        }
    }

    public float maxPenguinSwimmingDepth(){
        float max = 0f;
        for (Aquatic a : aquaticAnimals) {
            if (a instanceof Penguin) {
                float depth = ((Penguin) a).getSwimmingDepth();
                if (depth > max) {
                    max = depth;
                }
            }
        }
        return max;
    }

    public void displayNumberOfAquaticsByType(){
        int dolphins = 0;
        int penguins = 0;
        for (Aquatic a : aquaticAnimals) {
            if (a instanceof Dolphin) dolphins++;
            if (a instanceof Penguin) penguins++;
        }
        System.out.println("Number of dolphins: " + dolphins);
        System.out.println("Number of penguins: " + penguins);
    }

    public boolean addAnimal(Animal animal){
        if (searchAnimal(animal) != -1) {
            System.out.println("Animal present : " + animal.name);
            return false;
        }
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                animals[i] = animal;
                return true;
            }
        }
        return false;
    }
    public int searchAnimal(Animal animal){
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null && animals[i].name.equals(animal.name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index != -1) {
            animals[index] = null;
            System.out.println("Animal supprimer : " + animal.name);
            return true;
        }
        return false;
    }

    public boolean isZooFull() {
        int nombreAnimaux = 0;
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null) {
                nombreAnimaux++;
            }
        }
        if(nombreAnimaux == nbrCages){
            System.out.println("Zoo is full");
            return true;
        }
        else {
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

