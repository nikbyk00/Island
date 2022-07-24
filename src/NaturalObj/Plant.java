package NaturalObj;

import NaturalObj.NaturalObjects;

public abstract class Plant extends NaturalObjects {

    public Plant(int x, int y) {
        super(x, y);
    }

    @Override
    public int getWeight() {
        return 1;
    }

    abstract void grow();
}
