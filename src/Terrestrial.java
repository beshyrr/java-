public class Terrestrial extends Animal implements Omnivore<Food> {
    public Terrestrial(String family, String name, int age, boolean isMammal) {
        super(family, name, age, isMammal);
    }

    @Override
    public void eatMeat(Food meat) {
        if (meat == null) {
            System.out.println("No food provided for " + name);
            return;
        }
        if (meat == Food.MEAT || meat == Food.BOTH) {
            System.out.println(name + " (terrestrial) eats meat.");
        } else {
            System.out.println(name + " (terrestrial) cannot eat plants only when asked to eat meat.");
        }
    }

    @Override
    public void eatPlant(Food plant) {
        if (plant == null) {
            System.out.println("No food provided for " + name);
            return;
        }
        if (plant == Food.PLANT || plant == Food.BOTH) {
            System.out.println(name + " (terrestrial) eats plants.");
        } else {
            System.out.println(name + " (terrestrial) cannot eat meat only when asked to eat plants.");
        }
    }

    @Override
    public void eatPlantAndMeet(Food food) {
        if (food == null) {
            System.out.println("No food provided for " + name);
            return;
        }
        if (food == Food.BOTH) {
            System.out.println(name + " (terrestrial) eats both plants and meat.");
        } else if (food == Food.MEAT) {
            System.out.println(name + " (terrestrial) eats meat.");
        } else {
            System.out.println(name + " (terrestrial) eats plants.");
        }
    }
}


