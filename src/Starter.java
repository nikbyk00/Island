import World.World;
import World.WorldCreator;

public class Starter {
    public static void main(String[] args) {
        WorldCreator worldCreator = new WorldCreator();// создаём объект World.WorldCreator
        World world = new World(worldCreator.createWorld(100,20)); // создаём мир
        Thread move = new Thread(world); // создаём нить и передаём в неё мир
        Thread statistics = new Thread(new Statistics(world)); // создаём нить для вывода статистики
        /*
        запускаем нить
         */
        move.start();
        statistics.start();
    }
}
