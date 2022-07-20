package NaturalObj;

public class Wolf extends Animal {
    public Wolf(int x, int y, Gender gender) {
        super(x, y, gender);
    }

    @Override
    public boolean getHerbivore() {
        return false;
    }

    @Override
    public int getSpeed() {
        return 3;
    }

    @Override
    public Animal newAnimal() {
        return new Wolf(getRandom().nextInt(99), getRandom().nextInt(1), getNewGender());
    }

    @Override
    public int getPosition() {
        return 0;
    }

    @Override
    public int getMaxSaturation() {
        return 8;
    }

    @Override
    public int getWeight() {
        return 50;
    }
}
