package Homework2.DataStructures;

public class MyHashSet<E> {
    public final int DEFAULT_BUCKETS_COUNT;
    private MyLinkedList<E>[] buckets;
    private int count = 0;

    MyHashSet() {
        DEFAULT_BUCKETS_COUNT = 8;
        buckets = new MyLinkedList[DEFAULT_BUCKETS_COUNT];
        for (int i = 0; i < DEFAULT_BUCKETS_COUNT; i++) {
            buckets[i] = new MyLinkedList<E>();
        }
    }


    private MyHashSet(int newBucketsCount) {
        DEFAULT_BUCKETS_COUNT = newBucketsCount;
    }

    private void extendHashSet() {
        //Удваиваем длину
        int newBucketsCount = buckets.length * 2;
        MyLinkedList[] newBuckets = new MyLinkedList[newBucketsCount];

        //Инициализируем новые бакеты
        for (int i = 0; i < newBucketsCount; i++) {
            newBuckets[i] = new MyLinkedList<E>();
        }

        //Переносим все элементы. Перебираем массив бакетов
        for (MyLinkedList bucket : buckets) {
            //Перебираем бакеты
            for (Object element : bucket) {
                int hash = element.hashCode();
                hash = Math.abs(hash); //Пропускаю через модуль чтобы не было отрицательного индекса. Видел способ побитово убрать знак, но пока не разобрался
                int index = hash % newBucketsCount;//Рассчитываем новый индекс по новому количеству

                newBuckets[index].add(element);
            }
            //Новый массив бакетов готов
        }

        //Применяем изменения
        buckets = newBuckets;
    }

    public void add(E element) {
        int hash = element.hashCode();
        hash = Math.abs(hash); //Пропускаю через модуль чтобы не было отрицательного индекса.
        int index = hash % buckets.length;

        //Если в бакете такого значения еще нет, добавляем
        if (!buckets[index].contains(element)) {
            buckets[index].add(element);
            count++;
        }

        if (count > buckets.length) {
            extendHashSet();
        }
    }

    public boolean remove(E element) {
        int hash = element.hashCode();
        hash = Math.abs(hash); //Пропускаю через модуль чтобы не было отрицательного индекса. Видел способ побитово убрать знак, но пока не разобрался
        int index = hash % buckets.length;

        //Если в бакете есть такое значение, удаляем
        if (buckets[index].contains(element)) {
            buckets[index].remove(element);
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HashSet:\n");
        int i = 0;
        for (MyLinkedList bucket : buckets) {
            sb.append("\tbucket" + i + ": " + bucket.toString() + "\n");
            i++;
        }
        return sb.toString();
    }
}