public class WildBoar extends Animal {
    public WildBoar(int x, int y, Gender gender) {
        super(x, y, gender);
    }

    @Override
    public boolean getHerbivore() {
        return false;
    }

    @Override
    public int getSpeed() {
        return 2;
    }

    @Override
    public Animal newAnimal() {
        return new WildBoar(getRandom().nextInt(99), getRandom().nextInt(1), getNewGender());
    }

    @Override
    public int getPosition() {
        return 11;
    }

    @Override
    public int getMaxSaturation() {
        return 50;
    }

    @Override
    public int getWeight() {
        return 400;
    }
}
