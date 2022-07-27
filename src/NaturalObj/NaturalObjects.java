package NaturalObj;
import World.World;

/*
Класс родитель для NaturalObj.Animal и NaturalObj.Plant
 */

public abstract class NaturalObjects {
    /**
    каждое животное и растение будет хранить свои координаты,
    уметь менять их и возврощать
     */
    private int x;
    private int y;
    public NaturalObjects(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setY(int y) { // поменять y
        this.y = y;
    }

    public void setX(int x) { // поменять x
        this.x = x;
    }

    public int getY() { // вернуть y
        return y;
    }

    public int getX() { // вернуть x
        return x;
    }
    // абстрактный метод который будет возврощать вес
    public abstract int getWeight();

    // метод die принемает мир и вызывает у него метод kill и передаёт туда текущий NaturalObj.NaturalObjects
    public void die(World world) {
        world.kill(this);
    }
}
