public abstract class Aquatic extends Animal {
    String habitat;

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    public abstract void swim();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aquatic other = (Aquatic) obj;
        if (this.age != other.age) return false;
        if (this.name == null) {
            if (other.name != null) return false;
        } else if (!this.name.equals(other.name)) return false;
        if (this.habitat == null) {
            return other.habitat == null;
        } else {
            return this.habitat.equals(other.habitat);
        }
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + age;
        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + (habitat == null ? 0 : habitat.hashCode());
        return result;
    }
}


