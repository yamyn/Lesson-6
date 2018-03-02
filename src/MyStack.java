public class MyStack<T> {
    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    private int top = 0;//счетчик положения верхниго элемента

    public Object[] getMyStak() {
        return myStak;
    }

    public void setMyStak(Object[] myStak) {
        this.myStak = myStak;
    }

    private Object[] myStak = new Object[10];

    //    push(T value) добавляет элемент в конец
    public void push(T value) {
            if (getTop() < size()) {
                getMyStak()[getTop()]= value;
                setTop(getTop()+1);
                return;
            }
            if (getTop()== size()){
                Object[]newStak = new Object[size()+1];
                System.arraycopy(getMyStak(),0,newStak,0,size());
                setMyStak(newStak);
                setTop(getTop()+1);
            }
        }


    //    remove(int index) удаляет элемент под индексом
    public void remove(int index) {
        for (int i = index; i < getTop()-1 ; i++) {
            getMyStak()[i] = getMyStak()[i+1];
        }
        Object[] newArray = new Object[size()];
        System.arraycopy(getMyStak(), 0, newArray, 0, getTop() - 1);
        setMyStak(newArray);
        setTop(getTop()-1);
    }

    //    clear() очищает коллекцию
    public void clear() {
        for (int i = 0; i < size(); i++) {
            getMyStak()[i] = null;
        }
        setTop(0);
    }

    //    size() возвращает размер коллекции
    public int size() {
        return getMyStak().length;
    }

    //    peek() возвращает первый элемент в стеке (LIFO)
    public Object peek() {
        return getMyStak()[getTop()-1];
    }

    //    pop() возвращает первый элемент в стеке и удаляет его из коллекции
    public Object pop() {
        Object up = getMyStak()[getTop() - 1];
        Object[] newArray = new Object[size()];
        System.arraycopy(getMyStak(), 0, newArray, 0, getTop()-1);
        setMyStak(newArray);
        setTop(getTop()-1);
        return up;
    }

    public void show(){
        for (Object i : getMyStak()) {
            System.out.print( i + " ");
        }
        System.out.println();
    }

}
