package NaturalObj;

public class Sheep extends Animal {
    public Sheep(int x, int y, Gender gender) {
        super(x, y, gender);
    }

    @Override
    public boolean getHerbivore() {
        return true;
    }

    @Override
    public int getSpeed() {
        return 3;
    }

    @Override
    public Animal newAnimal() {
        return new Sheep(getRandom().nextInt(99), getRandom().nextInt(1), getNewGender());
    }

    @Override
    public int getPosition() {
        return 10;
    }

    @Override
    public int getMaxSaturation() {
        return 15;
    }

    @Override
    public int getWeight() {
        return 70;
    }
}
