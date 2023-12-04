package homework3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class task {
    public static void main(String[] args) {
        try {
            String input = getUserInput();
            String[] userData = input.split(" ");

            if (userData.length != 6) {
                System.out.println("Ошибка: Неверное количество данных!");
                return;
            }

            String surname = userData[0];
            String name = userData[1];
            String patronymic = userData[2];
            String dateOfBirth = userData[3];
            long phoneNumber;
            char gender;

            try {
                phoneNumber = Long.parseLong(userData[4]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Ошибка: Неверный формат номера телефона!", e);
            }

            if (userData[5].length() != 1 || (!userData[5].equalsIgnoreCase("f") && !userData[5].equalsIgnoreCase("m"))) {
                throw new IllegalArgumentException("Ошибка: Неверный формат пола!");
            }

            gender = userData[5].charAt(0);

            saveUserDataToFile(surname, name, patronymic, dateOfBirth, phoneNumber, gender);
            System.out.println("Данные успешно сохранены в файл!");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите данные в формате 'Фамилия Имя Отчество дата_рождения номер_телефона пол': ");
        return scanner.nextLine();
    }

    public static void saveUserDataToFile(String surname, String name, String patronymic, String dateOfBirth,
                                          long phoneNumber, char gender) throws IOException {
        String fileName = "userdata.txt";
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));

            String userData = surname + " " + name + " " + patronymic + " " + dateOfBirth + " " + phoneNumber + " " + gender;
            writer.write(userData);
            writer.newLine();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}