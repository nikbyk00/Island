import java.util.List;

public class Statistics implements Runnable {
    private World world;

    public Statistics(World world) {
        this.world = world;
    }

    private static void accept(Animal animal) {
        int a = animal.getDie();
        int b = animal.getMove();
        int c = animal.getReproduce();
        System.out.println(" Умерло: " + a );
        System.out.println(" Перешло: " + b );
        System.out.println(" Родилось: " + c );
        System.out.println();
    }

    @Override
    public void run() {
        BoxAnimal[][] boxAnimal = world.getBoxAnimal();
        for (int j = 0; j < boxAnimal.length; j++) { // с помощью цикла выводим на экран boxAnimal
            for (int k = 0; k < boxAnimal[j].length; k++) {
                List<Animal> animals = boxAnimal[j][k].getListFauna();
                animals.forEach(Statistics::accept);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
