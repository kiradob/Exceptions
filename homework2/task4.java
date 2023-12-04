// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

package homework2;


import java.util.Scanner;

public class task4 {
    public static void main(String[] args)
// В методе main() определяется блок try-catch. 
    {
// В блоке try вызывается метод getInput() и результат сохраняется в переменную input.
        try {
            String input = getInput("Введите строку: ");
            System.out.println("Вы ввели: " + input); 
// Выводится сообщение "Вы ввели: " и значение переменной input.
// Если при вызове метода getInput() был выброшен исключение EmptyInputException, переходим к блоку catch.
// В блоке catch выводится сообщение об ошибке, полученное с помощью метода getMessage() исключения e.
        } catch (EmptyInputException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String getInput(String prompt) throws EmptyInputException 
// Определяется метод getInput(), который принимает строку prompt в качестве аргумента и выбрасывает исключение EmptyInputException. 
// В методе getInput() определяется блок try-with-resources для создания объекта Scanner. 
    {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print(prompt);
            String input = scanner.nextLine();
// Если строка input пустая, выбрасывается исключение EmptyInputException с сообщением "Пустые строки вводить нельзя".
            if (input.isEmpty()) {
                throw new EmptyInputException("Пустые строки вводить нельзя");
            }
// Возвращается значение переменной input.
            return input;
        }
    }
}
// Определяется класс EmptyInputException, который наследуется от класса Exception.
// В классе EmptyInputException определяется конструктор, который принимает строку message и 
// вызывает конструктор суперкласса Exception, передавая ему значение message.
class EmptyInputException extends Exception {
    public EmptyInputException(String message) {
        super(message);
    }
}