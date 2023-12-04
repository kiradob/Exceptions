// Создайте класс Счетчик, у которого есть метод add(),
// увеличивающий значение внутренней int переменной на 1.
// Сделайте так, чтобы с объектом такого типа можно было работать в блоке
// try-with-resources.
// Подумайте, что должно происходить при закрытии этого ресурса?
// Напишите метод для проверки, закрыт ли ресурс.
// При попытке вызвать add() у закрытого ресурса, должен выброситься IOException

package seminar3;

import java.io.IOException;

public class task2 {

    public static void main(String[] args) {

        Counter c1 = new Counter();
        try {
            c1.add();
            System.out.println("Счетчик: " + c1.getCount());
            c1.close();
            System.out.println("Закрыт ли ресурс: " + c1.isClosed());
            c1.add();
            System.out.println("Счетчик: " + c1.getCount());
        } catch (IOException e) {

            e.printStackTrace();
        }

        try (Counter c2 = new Counter()) {
            c2.add();
            System.out.println("Счетчик: " + c2.getCount());
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}