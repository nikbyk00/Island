package NaturalObj;

import java.util.Random;
import World.World;

public abstract class Animal extends NaturalObjects {
    /**
    Массив для хранения вероятности поедания животными
     */
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
    /*
    константы для выбора стороны при движении
     */
    private final int NORTH = 0;
    private final int SOUTH = 1;
    private final int EAST = 2;
    private final int WEST = 3;
    private float saturation; // переменная для уровня насышения
    private Gender gender; // переменная для хранения гендора

    private Random random = new Random();

    int[] vector = new int[]{1, -1, 1, -1}; // массив для выбора направления

    private int die;
    private int reproduce;
    private int move;

    public Animal(int x, int y, Gender gender) {
        super(x, y);
        this.gender = gender;
    }

    public int getDie() {
        return die;
    }

    public int getReproduce() {
        return reproduce;
    }

    public int getMove() {
        return move;
    }

    public abstract boolean getHerbivore();

    public abstract int getSpeed(); // вернуть скорость

    public abstract Animal newAnimal(); // создать новое животное

    public abstract int getPosition(); // позиция в массиве killProbability

    public abstract int getMaxSaturation(); // максимальное насыщение

    public float getSaturation() { // вернуть saturation
        return this.saturation;
    }

    public Gender getGender() { // вернуть gender
        return gender;
    }

    public Random getRandom() { // вернуть random
        return random;
    }

    public void setSaturation(float saturation) { // меняем saturation
        this.saturation = saturation;
    }

    public Gender getNewGender() { // гениррируем рандомный гендер с помощью random
        gender = Gender.FEMALE;
        if (random.nextInt(10) < 5) {
            gender = Gender.MALE;
        }
        return gender;
    }

    public void moveDirection(World world) {
        int newX = getX(); // возвращаем у объекта координату x
        int newY = getY(); // возвращаем у объекта координату y
        int direction = random.nextInt(4); // генирируем число в диапозоне 4
        int speed = getSpeed(); // возвращаем скорость животного

        switch (direction) {  // выбор направления
            case NORTH:
            case SOUTH:
                newY = getY() + (speed * vector[direction]); // создаём новую координату
                newY = clamp(newY, 0, world.getWorldMaxY() - 1); // функция не даёт выйти за пределы массива

                break;
            case EAST:
            case WEST:
                newX = getX() + (speed * vector[direction]); // создаём новую координату
                newX = clamp(newX, 0, world.getWorldMaxX() - 1); // функция не даёт выйти за пределы массива

                /*
                берём старую координату и прибавляем к ней скорость умноженную на значения из массива
                 */

        }
        move++;
        world.moveAnimal(this, newX, newY); // добовляем по новым координатам
    }

    public static int clamp(int val, int min, int max) { // для перемещения
        return Math.max(min, Math.min(max, val));
    }

    public static float clamp(float val, float min, float max) { // для поедания
        return Math.max(min, Math.min(max, val));
    }

    public void eat(Animal animal, World world) {
        int count = random.nextInt(100) + 1; // генирируем число в диапозоне 100
        int animalPosition = animal.getPosition(); // возвращаем у переданного животного индекс в массиве killProbability
        int pos = this.getPosition(); // возвращаем у текущего животного индекс в массиве killProbability
        int kill = killProbability[pos][animalPosition]; // смотрим вероятность по индексам
        if (count <= kill) { // если count меньше или равно kill, вызываем метод eatable
            eatable(animal, world);
        }
    }
    public void eatPlant(Plant plant, World world) {
        if (this.getHerbivore() == true){ // если животное травоядное
            float newSaturation = this.getSaturation() + plant.getWeight(); // создаём новое насыщение
            // проверяем что оно не выходит за пределы maxSaturation
            float newSaturationClamped = clamp(newSaturation, 0, this.getMaxSaturation());
            this.setSaturation(newSaturationClamped); //меняем насыщение у текущего
            plant.die(world); // удаляем растение
            plant.grow();
            System.out.println(this.toString() + " съел растение " + plant);
        }
    }
    public void eatable(Animal victim, World world) {
        float newSaturation = this.getSaturation() + victim.getWeight(); // создаём новое насыщение
        // проверяем что оно не выходит за пределы maxSaturation
        float newSaturationClamped = clamp(newSaturation, 0, this.getMaxSaturation());
        this.setSaturation(newSaturationClamped); //меняем насыщение у текущего
        victim.die(world);// удаляем животного
        die++;
        System.out.println(this + " съел " + victim);
    }

    public void reproducing(Animal animal) {
        // если животные одного класса и разного гендера создаём нового животного
        if (this.getClass() == animal.getClass() && this.getGender() != animal.getGender()) {
            // метод для создания нового животного (переопределён во всех классах наследниках)
            Animal animal1 = animal.newAnimal();
            reproduce++;
            System.out.println(" Родился новый " + animal1.getClass().toString());
        }
    }

     public enum Gender { // гендер
        MALE, FEMALE
    }
}
