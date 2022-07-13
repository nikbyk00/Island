import java.util.Arrays;
import java.util.List;

/*
Класс World реализует интерфейс Runnable.
Хранит двумерный массив, который инициализируется в конструкторе.
 */
public class World implements Runnable {
    private BoxAnimal[][] boxAnimal; // массив для хранения List с животными.

    public World(BoxAnimal[][] boxAnimals) { // конструктор принемает и инициализирует boxAnimal.
        this.boxAnimal = boxAnimals;
    }

    public int getWorldMaxX() {
        return boxAnimal.length; // вернуть диогональ.
    }

    public int getWorldMaxY() {
        return boxAnimal[0].length; // вернуть вертикаль.
    }

    public BoxAnimal[][] getBoxAnimal() {
        return boxAnimal;
    }

    public void kill(NaturalObjects obj) {
        boxAnimal[obj.getX()][obj.getY()].kill(obj);// по текущим координатам вызывается метод kill и передаётся obj.
    }

    @Override
    public void run() {
        try {
            step(); // вызываем метод step и обрабатываем в нём исключение.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void step() throws InterruptedException {
        for (int i = 0; i < 20; i++) { // вызываем методы в цикле
            callMove(); // делаем переход
            callEatAnimal(); // едим животных
            callEatPlant(); // едим растиния
            reproduce(); // размножаемся
        }
    }

    private void callMove() {
        for (int i = 0; i < boxAnimal.length; i++) {
            for (int j = 0; j < boxAnimal[i].length; j++) { // с помощью цикла будем обращаться к каждой ячейки массива.
                boxAnimal[i][j].getListFauna().forEach(animal -> {
                    animal.moveDirection(this);
                    /* с помощью метода getListFauna возвращаем лист, в цикле вызываем
                     у каждого animal метод moveDirection и передаём в него текущий мир.
                    */
                });
            }
        }
    }

    public void moveAnimal(Animal animal, int x, int y) {
        boxAnimal[animal.getX()][animal.getY()].kill(animal); // убираем животное по старым координатам.
        animal.setX(x); // записываем новую координату x.
        animal.setY(y); // записываем новую координату y.
        boxAnimal[x][y].born(animal); // добавляем animal по новым координатам.
        System.out.println(animal + " перешёл на " + animal.getY() + ", " + animal.getX());
    }

    private void callEatAnimal() {
        for (int i = 0; i < boxAnimal.length; i++) {
            for (int j = 0; j < boxAnimal[i].length; j++) { // с помощью цикла будем обращаться к каждой ячейки массива
                int finalI = i;
                int finalJ = j;
                boxAnimal[i][j].getListFauna().forEach(animal -> {
                    boxAnimal[finalI][finalJ].getListFauna().forEach(animal1 -> {
                        /* с помощью метода getListFauna возвращаем лист, в цикле для каждого animal
                        возвращаем другого animal из списка.
                          */
                        if (animal == animal1){ // проверяем что это не один и тот же объект

                        } else{
                            animal.eat(animal1,this); // пробуем съесть с помощью метода eat
                        }
                    });
                });
            }
        }
    }
    private void callEatPlant() { //todo
        for (int i = 0; i < boxAnimal.length; i++) {
            for (int j = 0; j < boxAnimal[i].length; j++) { // с помощью цикла будем обращаться к каждой ячейки массива
                int finalI = i;
                int finalJ = j;
                boxAnimal[i][j].getListFauna().forEach(animal -> {
                    for (Plant plant : boxAnimal[finalI][finalJ].getListFlora()) {
                        animal.eatPlant(plant, this);
                        /* циклично возвращаем animal и у каждого животного вызываем метод eatPlant и передаём туда
                        растения, которые мы получаем во внутреннем цикле.

                          */
                    }
                });
            }
        }
    }

    private void reproduce() {
        for (int i = 0; i < boxAnimal.length; i++) {
            for (int j = 0; j < boxAnimal[i].length; j++) { // с помощью цикла будем обращаться к каждой ячейки массива
                int finalI = i;
                int finalJ = j;
                boxAnimal[i][j].getListFauna().forEach(animal -> {
                    boxAnimal[finalI][finalJ].getListFauna().forEach(animal1 -> {
                         /* с помощью метода getListFauna возвращаем лист, в цикле для каждого animal
                        возвращаем другого animal из списка.
                          */
                        if (animal == animal1){ // проверяем что это не один и тот же объект

                        } else{
                            animal.reproducing(animal1);
                        }
                    });
                });
            }
        }
    }
}
