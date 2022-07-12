

import java.util.ArrayList;
import java.util.List;

public class BoxAnimal {
    private List<Animal> listAnimal = new ArrayList<>(); // лист для животных

    public void born(Animal animal) {
        listAnimal.add(animal); // добавляем переданный объект в лист
    }

//    public void born2(Plant plant) {
//        listAnimal.add(plant); // добавляем переданный объект в лист
//    }

    public void kill(NaturalObjects obj) {
        listAnimal.remove(obj); // удаляем переданный объект из листа
    }

    public List<Animal> getListFauna() {
        return List.copyOf(listAnimal);
    } // метод возвращает копию листа
}
