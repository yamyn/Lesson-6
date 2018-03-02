public class MyArrayList<T> {
    public Object[] getMyArrayLists() {
        return myArrayLists;
    }

    public void setMyArrayLists(Object[] myArrayLists) {
        this.myArrayLists = myArrayLists;
    }

    private Object[] myArrayLists = new Object[1];


    //............................................ add(T value) Adds an element to the end
    void add(T value) {
        if (getMyArrayLists()[0] == null) {
            getMyArrayLists()[0] = value;
        } else {
            Object[] newArray = new Object[size() + 1];
            System.arraycopy(getMyArrayLists(), 0, newArray, 0, size());
            setMyArrayLists(newArray);
            getMyArrayLists()[size() - 1] = value;
        }
    }

    //............................................. remove(int index) removes the item under the index
    void remove(int index) {
        for (int i = index; i < size() - 1; i++) {
            getMyArrayLists()[i] = getMyArrayLists()[++i];
        }
        Object[] newArray = new Object[size() - 1];
        System.arraycopy(getMyArrayLists(), 0, newArray, 0, size() - 1);
        setMyArrayLists(newArray);
    }

    //....................................................show colection

    void show (){
        for (int i =0; i < size(); i++){
            System.out.print(get(i) + ", ");
        }
        System.out.println();
    }

    //    size() возвращает размер коллекции
    int size() {
        return getMyArrayLists().length;
    }

    //    get(int index) возвращает элемент под индексом
    Object get(int index) {
        return getMyArrayLists()[index];
    }



}
