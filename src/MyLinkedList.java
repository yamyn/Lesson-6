public class MyLinkedList<T>  {
    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    public MyLinkedList() {
        last = new Node<T>(first, null, null);
        first = new Node<T>(null, null, last);
    }

    //add(T value) добавляет элемент в конец
    public void add(T value) {
        Node<T> prev = last;
        prev.setElement(value);
        last = new Node<T>(prev, null, null);
        prev.setNext(last);
        size++;
    }

    //clear() очищает коллекцию
    public void clear() {
        Node<T> target = first.getNext();
        for (int i = 0; i < size;i++){
            target = getNextElement(target);
            target.setPrev(null);
            target.setElement(null);
        }
        target.setNext(null);
        first.setNext(last);
        last.setPrev(first);
        size = 0;
    }

    //remove(int index) удаляет элемент под индексом
    public void remove(int index) {
        Node<T> target  = first.getNext();
        for (int i = 0; i < index; i++) {
            target = getNextElement(target);
            target.setPrev(target.getNext());
            target.setNext(target.getPrev());
            target.setNext(null);
            target.setPrev(null);
            target.setElement(null);
            size--;
        }

    }

    //size() возвращает размер коллекции
    public int size() {
        return size;
    }
    //get(int index) возвращает элемент под индексом
    public T get(int index) {
        Node<T> target = first.getNext();
        for (int i = 0; i < index; i++) {
            target = getNextElement(target);
        }
        return target.getElement();
    }
    void show (){
        for (int i =0; i < size(); i++){
            System.out.print(get(i) + ", ");
        }
        System.out.println();
    }

    private Node<T> getNextElement(Node<T> current) {
        return current.getNext();
    }

    private class Node<T> {
        private T element;
        private Node<T> next;
        private Node<T> prev;

        private Node(Node<T> prev, T element, Node<T> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }


    }
}
