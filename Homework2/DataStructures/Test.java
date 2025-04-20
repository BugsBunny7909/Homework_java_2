package Homework2.DataStructures;

public class Test {
    public static void main(String[] args) {
        //ТЕСТ СВЯЗНОГО СПИСКА
        MyLinkedList<String> names = new MyLinkedList<>();

        names.add("Сергей");
        names.add("Никита");
        names.add("Лера");
        names.add("Денис");
        System.out.println(names.toString());


        names.remove("Лера");
        System.out.println(names.toString());


        System.out.println("Содержит Леру: " + names.contains("Лера"));
        System.out.println("Содержит Никиту: " + names.contains("Никита"));


        //ТЕСТ ХЭШСЕТА
        MyHashSet<String> cats = new MyHashSet<>();
        System.out.println("Пустой\n" + cats.toString());

        cats.add("Мурзилка");
        cats.add("Пушок");
        cats.add("Киса");
        cats.add("Том");
        System.out.println("Немного котов\n" + cats.toString());

        cats.remove("Мурзилка");
        cats.remove("Пушок");
        System.out.println("Теперь без Мурзилки и Пушка\n" + cats.toString());

        cats.add("Васька");
        cats.add("Китти");
        cats.add("Пушок1");
        cats.add("Том2");
        System.out.println("Побольше котов\n" + cats.toString());

        for (int i = 0; i < 24; i++) {
            cats.add("Кот №" + (i + 1));
        }
        System.out.println("Совсем много котов\n" + cats.toString());
    }
}
