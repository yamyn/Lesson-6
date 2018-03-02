import java.util.Scanner;

public class Main {

    public static void ArraylistExam(){
        MyArrayList<Integer> myArray = new MyArrayList<>();
        myArray.add(3);
        myArray.add(5);
        myArray.add(9);
        myArray.add(54);
        System.out.println(myArray.size());
        myArray.show();
        System.out.println(myArray.get(3));
        myArray.remove(2);
        myArray.show();
    }

    public static void LinkedlistExam(){
        MyLinkedList<String> linkList = new MyLinkedList<>();
        linkList.add("a");
        linkList.add("b");
        linkList.add("c");
        linkList.add("d");
        System.out.println(linkList.size());
        linkList.show();
        System.out.print(linkList.get(0)+ " ");
        linkList.clear();
    }

    public static void FiFO(){
        MyQueue<Character> FiFO = new MyQueue<>();
        FiFO.add('M');
        FiFO.add('A');
        FiFO.add('X');
        System.out.println(FiFO.peek());
        System.out.println(FiFO.poll());
        System.out.println(FiFO.peek());
    }

    public static void LiFO(){
        MyStack<Float> floatMyStack = new MyStack<>();
        floatMyStack.push(1f);
        floatMyStack.push(2.1f);
        floatMyStack.push(3f);
        floatMyStack.push(4.5f);
        floatMyStack.push(5.6f);
        System.out.println(floatMyStack.size());
        floatMyStack.show();
    }

    public static void HashMapExam(){
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(1, "I");
        myHashMap.put(2, "am");
        myHashMap.put(3, "hashmap");
        myHashMap.put(4, " .");
        for (int i = 0; i < myHashMap.size(); i++){
            System.out.print(myHashMap.get(i) + " ");
        }
        System.out.println();
        System.out.println(myHashMap.size());
        myHashMap.clear();
        System.out.println(myHashMap.get(2));
    }

    public static void main(String[] args) {
        int reapeet = 1;
        while (reapeet == 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Would you like to see a work of?\n" +
                    "1 - Arraylist\n" +
                    "2 - LinkedList\n" +
                    "3 - FiFO\n" +
                    "4 - LiFO\n" +
                    "5 - HashMap");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    ArraylistExam();
                    break;
                case 2:
                    LinkedlistExam();
                    break;
                case 3:
                    FiFO();
                    break;
                case 4:
                    LiFO();
                    break;
                case 5:
                    HashMapExam();
                    break;
                default:
                    System.out.println("error!!!");
            }
            System.out.println("To doing the work again?\n" +
                    "1 - Yes\n" +
                    "2 - No");
            reapeet = scanner.nextInt();
        }
    }
}