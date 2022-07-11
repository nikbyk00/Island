import java.util.Random;

public abstract class Animal extends NaturalObjects {
    public static int[][] killProbability = new int[][]
            {{0, 0, 0, 0, 0, 10, 15, 60, 80, 60, 70, 15, 10, 40, 0, 0},
                    {0, 0, 15, 0, 0, 0, 0, 20, 40, 0, 0, 0, 0, 10, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 70, 70, 90, 0, 0, 0, 0, 60, 40, 0},
                    {0, 80, 0, 0, 0, 40, 80, 80, 90, 70, 70, 50, 20, 10, 0, 0},
                    {0, 0, 10, 0, 0, 0, 0, 90, 90, 0, 0, 0, 0, 80, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
                    {0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 90, 100},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100}};
    private final int NORTH = 0;
    private final int SOUTH = 1;
    private final int EAST = 2;
    private final int WEST = 3;
    private float saturation;
    private Gender gender;

    private Random random = new Random();

    int[] vector = new int[]{1, -1, 1, -1};

    public Animal(int x, int y, Gender gender) {
        super(x, y);
        this.gender = gender;
    }

    public abstract int getSpeed();

    public abstract Animal newAnimal();

    public abstract int getPosition();

    public abstract int getMaxSaturation();

    public float getSaturation() {
        return this.saturation;
    }

    public Gender getGender() {
        return gender;
    }

    public Random getRandom() {
        return random;
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }

    public Gender getNewGender() {
        gender = Gender.FEMALE;
        if (random.nextInt(10) < 5) {
            gender = Gender.MALE;
        }
        return gender;
    }

    public void moveDirection(World world) {
        int newX = getX();
        int newY = getY();
        int direction = random.nextInt(4);
        int speed = getSpeed();

        switch (direction) {
            case NORTH:
            case SOUTH:
                newY = getY() + (speed * vector[direction]);
                newY = clamp(newY, 0, world.getWorldMaxY() - 1);

                break;
            case EAST:
            case WEST:
                newX = getX() + (speed * vector[direction]);
                newX = clamp(newX, 0, world.getWorldMaxX() - 1);

        }
        world.moveAnimal(this, newX, newY);
    }

    public static int clamp(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }

    public static float clamp(float val, float min, float max) {
        return Math.max(min, Math.min(max, val));
    }

    public void eat(NaturalObjects animal, World world) {
        int count = random.nextInt(100) + 1;
        int animalPosition = animal.getPosition();
        int pos = this.getPosition();
        int kill = killProbability[pos][animalPosition];
        if (count <= kill) {
            eatable(animal, world);
        }
    }

    public void eatable(NaturalObjects victim, World world) {
        float newSaturation = this.getSaturation() + victim.getWeight();
        float newSaturationClamped = clamp(newSaturation, 0, this.getMaxSaturation());
        this.setSaturation(newSaturationClamped);
        victim.die(world);
        System.out.println(this + " съел " + victim);
    }

    public void reproducing(NaturalObjects animal) {
        if (this.getClass() == animal.getClass() && this.getGender() != animal.getGender()) {
            Animal animal1 = animal.newAnimal();
            System.out.println(" Родился новый " + animal1.getClass().toString());
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
