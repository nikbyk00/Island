package NaturalObj;

public class Boa extends Animal {
    public Boa(int x, int y, Gender gender) {
        super(x, y, gender);
    }

    @Override
    public boolean getHerbivore() {
        return false;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public Animal newAnimal() {
        return new Boa(getRandom().nextInt(99),getRandom().nextInt(1),getNewGender());
    }

    @Override
    public int getPosition() {
        return 1;
    }

    @Override
    public int getMaxSaturation() {
        return 3;
    }

    @Override
    public int getWeight() {
        return 15;
    }
}
