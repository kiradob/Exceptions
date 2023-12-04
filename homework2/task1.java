// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, 
// вместо этого, необходимо повторно запросить у пользователя ввод данных.

package homework2;



import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        float number = getInputFloat("Введите дробное число: ");
        System.out.println("Вы ввели: " + number);
    }
    
    public static float getInputFloat(String prompt) {
        Scanner scanner = new Scanner(System.in);
        float inputNumber = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);
            
            if (scanner.hasNextFloat()) {
                inputNumber = scanner.nextFloat();
                validInput = true;
            } else {
                System.out.println("Ошибка ввода. Пожалуйста, введите дробное число.");
                scanner.next(); // Очистка буфера после некорректного ввода
            }
        }

        return inputNumber;
    }
}