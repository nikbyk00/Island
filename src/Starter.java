import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Starter {
    public static void main(String[] args) {
        WorldCreator worldCreator = new WorldCreator();// создаём объект WorldCreator
        World world = new World(worldCreator.createWorld(100,20));
        Thread move = new Thread(world);
        // создаём нить и передаём в неё worldCreator у которого вызываем метод createWorld (который создаст мир)
        Thread statistics = new Thread(new Statistics(world)); // создаём нить для вывода статистики
        /*
        запускаем нить
         */
        move.start();
        statistics.start();
    }
}
