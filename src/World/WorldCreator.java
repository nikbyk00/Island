package World;

import NaturalObj.*;

public class WorldCreator {

    public BoxAnimal[][] createWorld(int x, int y) {
        BoxAnimal[][] boxAnimals = new BoxAnimal[x][y]; // создаём массив и передаём в него x,y
        addAnimalsToList(boxAnimals); // заполняем массив листами с животными
        System.out.println("Создался мир!! ");
        return boxAnimals; // создаём мир и передаём в конструктор массив
    }

    private BoxAnimal createAnimal(int x, int y) { // возвращает заполненный World.BoxAnimal
        BoxAnimal boxAnimal = new BoxAnimal(); // создаём объект World.BoxAnimal
        for (int j = 0; j < 10; j++) {
            // заполняем List который хранится в World.BoxAnimal животными и растениями с помощью метода born

            boxAnimal.bornAnimal(new Horse(x, y, Animal.Gender.FEMALE));
            boxAnimal.bornAnimal(new Wolf(x, y, Animal.Gender.FEMALE));
            boxAnimal.bornAnimal(new Buffalo(x,y, Animal.Gender.FEMALE));
            boxAnimal.bornAnimal(new Bear(x,y,Animal.Gender.FEMALE));
            boxAnimal.bornAnimal(new Boa(x,y,Animal.Gender.FEMALE));
            boxAnimal.bornAnimal(new Caterpillar(x,y,Animal.Gender.FEMALE));
            boxAnimal.bornAnimal(new Deer(x,y,Animal.Gender.FEMALE));
            boxAnimal.bornAnimal(new Duck(x,y,Animal.Gender.FEMALE));
            boxAnimal.bornAnimal(new Eagle(x,y,Animal.Gender.FEMALE));
            boxAnimal.bornAnimal(new Fox(x,y,Animal.Gender.FEMALE));
            boxAnimal.bornAnimal(new Goat(x,y,Animal.Gender.FEMALE));
            boxAnimal.bornAnimal(new Mouse(x,y,Animal.Gender.FEMALE));
            boxAnimal.bornAnimal(new Rabbit(x,y,Animal.Gender.FEMALE));
            boxAnimal.bornAnimal(new Sheep(x,y,Animal.Gender.FEMALE));
            boxAnimal.bornAnimal(new WildBoar(x,y,Animal.Gender.FEMALE));

            boxAnimal.bornAnimal(new Horse(x, y, Animal.Gender.MALE));
            boxAnimal.bornAnimal(new Wolf(x, y, Animal.Gender.MALE));
            boxAnimal.bornAnimal(new Buffalo(x,y, Animal.Gender.MALE));
            boxAnimal.bornAnimal(new Bear(x,y,Animal.Gender.MALE));
            boxAnimal.bornAnimal(new Boa(x,y,Animal.Gender.MALE));
            boxAnimal.bornAnimal(new Caterpillar(x,y,Animal.Gender.MALE));
            boxAnimal.bornAnimal(new Deer(x,y,Animal.Gender.MALE));
            boxAnimal.bornAnimal(new Duck(x,y,Animal.Gender.MALE));
            boxAnimal.bornAnimal(new Eagle(x,y,Animal.Gender.MALE));
            boxAnimal.bornAnimal(new Fox(x,y,Animal.Gender.MALE));
            boxAnimal.bornAnimal(new Goat(x,y,Animal.Gender.MALE));
            boxAnimal.bornAnimal(new Mouse(x,y,Animal.Gender.MALE));
            boxAnimal.bornAnimal(new Rabbit(x,y,Animal.Gender.MALE));
            boxAnimal.bornAnimal(new Sheep(x,y,Animal.Gender.MALE));
            boxAnimal.bornAnimal(new WildBoar(x,y,Animal.Gender.MALE));

            for (int i = 0; i < 15; i++) {
                boxAnimal.bornPlant(new Plants(x,y));
            }
        }
        return boxAnimal;
    }

    private BoxAnimal[][] addAnimalsToList(BoxAnimal[][] array) { // метод возвращает массив
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = createAnimal(i,j);
                /* с помощью цикла для каждой ячейки массива вызываем метод createAnimal,
                который возврощает объект класса World.BoxAnimal */
                System.out.println(array[i][j]);
            }
        }
        return array;
    }
}
