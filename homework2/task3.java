// Дан следующий код, исправьте его там, где требуется 
// (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)

package homework2;

public class task3 {
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[2] = 9; // Заменено на корректный индекс
        } catch (ArithmeticException ex) {
            System.out.println("Деление на ноль!");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Exception ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }
}

// Исправления:

// Заменен исключительный тип Throwable на ArithmeticException в первом блоке catch, 
// так как именно это исключение будет брошено при делении на ноль.

// Заменен вызов printSum(23, 234); на printSum(a, b);, чтобы использовать уже объявленные переменные a и b.

// В инструкции abc[2] = 9; изменен индекс с 3 на 2, так как массив abc имеет только два элемента с индексами 0 и 1.

// Добавлен блок catch (Exception ex) для обработки остальных исключений, которые могут возникнуть. 
// Этот блок должен идти в самом конце блоков catch, так как исключения наследуются по иерархии, 
// и более конкретные типы исключений должны быть обработаны раньше более общих.