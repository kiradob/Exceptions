// 1. Реализуйте метод, принимающий в качестве аргументов двумерный массив.
// Метод должен проверить что длина строк и столбцов с одинаковым индексом одинакова, 
// детализировать какие строки со столбцами не требуется.


package homework1;


import java.util.ArrayList;

public class task1 { 

    public static void main(String[] args) { 
        int[][] exampleArray = { 
            {1, 2, 3}, 
            {4, 5, 6}, 
            {7, 8, 9} 
        }; 

        checkArrayDimensions(exampleArray); 
    } 

    public static void checkArrayDimensions(int[][] array) { 
        int rows = array.length; 
        int cols = rows > 0 ? array[0].length : 0; 

        boolean consistent = true; 
        ArrayList<Integer> ignoreRows = new ArrayList<>(); 
        ArrayList<Integer> ignoreCols = new ArrayList<>(); 

        for (int i = 0; i < rows; i++) { 
            for (int j = 0; j < cols; j++) { 
                if (ignoreRows.contains(i) || ignoreCols.contains(j)) { 
                    continue; 
                } 

                if (array[i].length != cols || array[i][j] != array[j][i]) { 
                    consistent = false; 
                    ignoreRows.add(i); 
                    ignoreCols.add(j); 
                } 
            } 
        } 

        if (consistent) { 
            System.out.println("Массив удовлетворяет условию."); 
        } else { 
            System.out.println("Массив не удовлетворяет условию."); 
            System.out.println("Строки, которые не соответствуют условию: " + ignoreRows); 
            System.out.println("Столбцы, которые не соответствуют условию: " + ignoreCols); 
        } 
    } 
}