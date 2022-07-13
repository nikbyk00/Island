

import java.util.ArrayList;
import java.util.List;

public class BoxAnimal {
    private List<Animal> listAnimal = new ArrayList<>(); // лист для животных
    private List<Plant> listPlant = new ArrayList<>(); // лист для животных

    public void born(Animal animal) {
        listAnimal.add(animal); // добавляем переданный объект в лист
    }

    public void born2(Plant plant) {
        listPlant.add(plant); // добавляем переданный объект в лист
    }

    public void kill(NaturalObjects obj) {
        if(obj instanceof Animal) {
            listAnimal.remove(obj);// удаляем переданный объект из листа
        } else {
            listPlant.remove(obj);
        }
    }
    public void kill(Plant plant) {
        listPlant.remove(plant); // удаляем переданный объект из листа
    }

    public List<Animal> getListFauna() {
        return List.copyOf(listAnimal);
    } // метод возвращает копию листа животных
    public List<Plant> getListFlora() {
        return List.copyOf(listPlant);
    } // метод возвращает копию листа растений
}
