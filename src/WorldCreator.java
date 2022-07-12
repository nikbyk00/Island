
public class WorldCreator {

    public BoxAnimal[][] createWorld(int x, int y) {
        BoxAnimal[][] boxAnimals = new BoxAnimal[x][y]; // создаём массив и передаём в него x,y
        addAnimalsToList(boxAnimals); // заполняем массив листами с животными
        System.out.println("Создался мир!! ");
        return boxAnimals; // создаём мир и передаём в конструктор массив
    }

    private BoxAnimal createAnimal(int x, int y) { // возвращает заполненный BoxAnimal
        BoxAnimal boxAnimal = new BoxAnimal(); // создаём объект BoxAnimal
        for (int j = 0; j < 10; j++) {
            // заполняем List который хранится в BoxAnimal животными и растениями с помощью метода born

            boxAnimal.born(new Horse(x, y, Animal.Gender.FEMALE));
            boxAnimal.born(new Wolf(x, y, Animal.Gender.FEMALE));
            boxAnimal.born(new Buffalo(x,y, Animal.Gender.FEMALE));
            boxAnimal.born(new Bear(x,y,Animal.Gender.FEMALE));
            boxAnimal.born(new Boa(x,y,Animal.Gender.FEMALE));
            boxAnimal.born(new Caterpillar(x,y,Animal.Gender.FEMALE));
            boxAnimal.born(new Deer(x,y,Animal.Gender.FEMALE));
            boxAnimal.born(new Duck(x,y,Animal.Gender.FEMALE));
            boxAnimal.born(new Eagle(x,y,Animal.Gender.FEMALE));
            boxAnimal.born(new Fox(x,y,Animal.Gender.FEMALE));
            boxAnimal.born(new Goat(x,y,Animal.Gender.FEMALE));
            boxAnimal.born(new Mouse(x,y,Animal.Gender.FEMALE));
            //boxAnimal.born2(new Plants(x,y));
            boxAnimal.born(new Rabbit(x,y,Animal.Gender.FEMALE));
            boxAnimal.born(new Sheep(x,y,Animal.Gender.FEMALE));
            boxAnimal.born(new WildBoar(x,y,Animal.Gender.FEMALE));

            boxAnimal.born(new Horse(x, y, Animal.Gender.MALE));
            boxAnimal.born(new Wolf(x, y, Animal.Gender.MALE));
            boxAnimal.born(new Buffalo(x,y, Animal.Gender.MALE));
            boxAnimal.born(new Bear(x,y,Animal.Gender.MALE));
            boxAnimal.born(new Boa(x,y,Animal.Gender.MALE));
            boxAnimal.born(new Caterpillar(x,y,Animal.Gender.MALE));
            boxAnimal.born(new Deer(x,y,Animal.Gender.MALE));
            boxAnimal.born(new Duck(x,y,Animal.Gender.MALE));
            boxAnimal.born(new Eagle(x,y,Animal.Gender.MALE));
            boxAnimal.born(new Fox(x,y,Animal.Gender.MALE));
            boxAnimal.born(new Goat(x,y,Animal.Gender.MALE));
            boxAnimal.born(new Mouse(x,y,Animal.Gender.MALE));
            //boxAnimal.born(new Plants(x,y));
            boxAnimal.born(new Rabbit(x,y,Animal.Gender.MALE));
            boxAnimal.born(new Sheep(x,y,Animal.Gender.MALE));
            boxAnimal.born(new WildBoar(x,y,Animal.Gender.MALE));

        }
        return boxAnimal;
    }

    private BoxAnimal[][] addAnimalsToList(BoxAnimal[][] array) { // метод возвращает массив
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = createAnimal(i,j);
                /* с помощью цикла для каждой ячейки массива вызываем метод createAnimal,
                который возврощает объект класса BoxAnimal */
                System.out.println(array[i][j]);
            }
        }
        return array;
    }
}
