public class MyHashMap<T, K> {

    public int getSize() {
        return size;
    }

    private int size = 0;
    private Node last;
    private Node first;

    MyHashMap() {
        last = new Node(null, null, null);
        first = new Node(null, null, last);
    }

    private class Node {
        private T value;
        private K key;
        private Node next;

        private Node(K key, T value, Node next) {
            this.value = value;
            this.key = key;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        private K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        private Node getNext() {
            return next;
        }

        private void setNext(Node next) {
            this.next = next;
        }
    }

    //    put(K key, T value) добавляет пару ключ + значение
    public void put(K key, T value) {
        Node next = new Node(key, value, null);
        if (checkKey(key)) {
            System.out.println("Invalid value for key: " + key);
        } else if (first.getNext() == null) {
            first.setNext(next);
            next.setNext(last);
            size++;
        } else {
            last.setNext(next);
            last = next;
            size++;
        }
    }

    //    remove(K key) удаляет пару по ключу
    public boolean remove(K key) {
        Node prev = null;
        Node current = first.getNext();
        for (int i = 0; i < getSize(); i++) {
            prev = current;
            current = getNextElement(current);
            if (current.getKey().equals(key)) {
                prev.setNext(current.getNext());
                current.setNext(null);
                size--;
                return true;
            }

        }
        return false;
    }

//    clear() очищает коллекцию
    public void clear(){
        Node  current = first;
        while (current.getNext()== null){
            current.setNext(null);
            current.setValue(null);
            current.setKey(null);
            current = getNextElement(current);
        } first.setNext(null);
    }

    //    size() возвращает размер коллекции
    public int size() {
        return getSize();
    }

    //    get(K key) возвращает значение(T value) по ключу
    public T get(K key) {
        T target = null;
        if (first.getNext()== null)return null;
        else {
        Node current = first.getNext();
        for (int i = 0; i < getSize(); i++) {
            current = getNextElement(current);
            if (current.getKey().equals(key)) {
                target = current.getValue();
                break;
            }}
        }
        return target;
    }

    //    проверяет значение ключа
    private boolean checkKey(K key) {
        Node target = first.getNext();
        for (int i = 0; i < getSize(); i++) {
            target = getNextElement(target);
            if (target.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }


    private Node getNextElement(Node current) {
        return current.getNext();
    }


}
