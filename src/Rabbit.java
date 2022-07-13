public class Rabbit extends Animal {
    public Rabbit(int x, int y, Gender gender) {
        super(x, y, gender);
    }

    @Override
    public boolean getHerbivore() {
        return true;
    }

    @Override
    public int getSpeed() {
        return 2;
    }

    @Override
    public Animal newAnimal() {
        return new Rabbit(getRandom().nextInt(99), getRandom().nextInt(1), getNewGender());
    }

    @Override
    public int getPosition() {
        return 7;
    }

    @Override
    public int getMaxSaturation() {
        return 1;
    }

    @Override
    public int getWeight() {
        return 2;
    }
}
