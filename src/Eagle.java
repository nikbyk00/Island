public class Eagle extends Animal{
    public Eagle(int x, int y, Gender gender) {
        super(x, y, gender);
    }

    @Override
    public int getSpeed() {
        return 3;
    }

    @Override
    public Animal newAnimal() {
        return new Eagle(getRandom().nextInt(99), getRandom().nextInt(1), getNewGender());
    }

    @Override
    public int getPosition() {
        return 4;
    }

    @Override
    public int getMaxSaturation() {
        return 1;
    }

    @Override
    public int getWeight() {
        return 0;
    }
}
