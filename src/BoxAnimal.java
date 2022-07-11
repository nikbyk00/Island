

import java.util.ArrayList;
import java.util.List;

public class BoxAnimal {
    private ArrayList<NaturalObjects> listAnimal = new ArrayList<>(); // лист для животных

    public void born(NaturalObjects naturalObjects) {
        listAnimal.add(naturalObjects); // добовляум переданный объект в лист
    }

    public void kill(NaturalObjects obj) {
        listAnimal.remove(obj); // удаляем переданный объект из листа
    }

    public List<NaturalObjects> getListFauna() {
        return List.copyOf(listAnimal);
    } // метод возвращает копию листа
}
