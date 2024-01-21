package PractiseQuestions;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];
        int i;
        int n = sc.nextInt();
        for (i = 0; n > 0; i++) {
            arr[i] = n % 2;
            n = n / 2;
        }
        System.out.println(1%2);
        for(int j = 0; j < arr.length; j++){
            System.out.print(arr[j]);
        }
        System.out.println("Binary to decimal: ");
        for(i = i - 1; i >= 0; i--){
            System.out.print(arr[i]);
        }
    }
}
