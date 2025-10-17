package tn.esprit.gestionzoo.entities;

public class Lion extends Terrestrial {
    
    public Lion(String family, String name, int age, boolean isMammal, int nbrLegs) {
        super(family, name, age, isMammal, nbrLegs);
    }
    
    @Override
    public String toString() {
        return super.toString() + " (Lion)";
    }
}
