/**
 * Hasan Semih AKTAŞ
 * @since 12.01.2021
*/

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class NumberOfCombinations {

    public static void main(String[] args) {
        System.out.println("Enter a value");
        Scanner scanner = new Scanner(System.in);
        int number=scanner.nextInt();
        int size=(int)(factorial(number)/(factorial(2)*factorial(number-2)));
        int[][] temp = new int[size][2];
        combination(temp,number,size);

        System.out.println("Number of combinations: "+size);
    }
    public static double factorial(int number){
        double result=1;
        for(int i=1;i<=number;i++)
            result*=i;

        return result;
    }
    public static void combination(int[][] temp,int number,int size)
    {
        int count = 1;
        int count2 = 2;

        for (int i = 0; i < size; i++) {
            if (i != 0 && count2 % (number+1) == 0) {
                count++;
                count2 = count + 1;
            }
            temp[i][0] = count;
            if (count2 <= number) {
                temp[i][1] = count2;
                count2++;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
    }
}