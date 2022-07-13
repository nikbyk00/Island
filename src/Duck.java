public class Duck extends Animal{
    public Duck(int x, int y, Gender gender) {
        super(x, y, gender);
    }

    @Override
    public boolean getHerbivore() {
        return true;
    }

    @Override
    public int getSpeed() {
        return 4;
    }

    @Override
    public Animal newAnimal() {
        return new Duck(getRandom().nextInt(99), getRandom().nextInt(1), getNewGender());
    }

    @Override
    public int getPosition() {
        return 13;
    }

    @Override
    public int getMaxSaturation() {
        return 1;
    }

    @Override
    public int getWeight() {
        return 1;
    }
}
