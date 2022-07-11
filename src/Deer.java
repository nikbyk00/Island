public class Deer extends Animal{
    public Deer(int x, int y, Gender gender) {
        super(x, y, gender);
    }

    @Override
    public int getSpeed() {
        return 4;
    }

    @Override
    public Animal newAnimal() {
        return new Deer(getRandom().nextInt(99), getRandom().nextInt(1), getNewGender());
    }

    @Override
    public int getPosition() {
        return 6;
    }

    @Override
    public int getMaxSaturation() {
        return 50;
    }

    @Override
    public int getWeight() {
        return 300;
    }
}
