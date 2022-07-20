package NaturalObj;

public class Horse extends Animal {
    public Horse(int x, int y, Gender gender) {
        super(x, y, gender);
    }

    @Override
    public boolean getHerbivore() {
        return true;
    }

    @Override
    public int getMaxSaturation() {
        return 9;
    }

    @Override
    public int getSpeed() {
        return 4;
    }

    @Override
    public Animal newAnimal() {
        return new Horse(getRandom().nextInt(99), getRandom().nextInt(1), getNewGender());

    }

    @Override
    public int getPosition() {
        return 5;
    }

    @Override
    public int getWeight() {
        return 400;
    }
}
