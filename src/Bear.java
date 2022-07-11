import java.util.Random;

public class Bear extends Animal{
    private Random  random = new Random();
    public Bear(int x, int y, Gender gender) {
        super(x, y, gender);
    }

    @Override
    public int getSpeed() {
        return 2;
    }

    @Override
    public Bear newAnimal() {
        return new Bear(getRandom().nextInt(99), getRandom().nextInt(19), getNewGender());
    }

    @Override
    public int getPosition() {
        return 3;
    }

    @Override
    public int getMaxSaturation() {
        return 80;
    }

    @Override
    public int getWeight() {
        return 500;
    }
}
