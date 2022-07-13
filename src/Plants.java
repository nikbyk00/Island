import java.util.Random;

public class Plants extends Plant{
    private Random random = new Random();

    public Plants(int x, int y) {
        super(x, y);
    }

    @Override
    public int getWeight() {
        return 1;
    }

    @Override
    void grow() {
        for (int i = 0; i < 5; i++) {
            new Plants(random.nextInt(100), random.nextInt(20));
        }
    }
}
