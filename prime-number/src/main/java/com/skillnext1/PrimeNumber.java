package com.skillnext1;
import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        boolean isPrime = true;
        if(n < 2) isPrime = false;
        else {
            for(int i = 2; i <= Math.sqrt(n); i++){
                if(n % i == 0){
                    isPrime = false;
                    break;
                }
            }
        }
        System.out.println(n + (isPrime ? " is Prime" : " is Not Prime"));
    }
}
