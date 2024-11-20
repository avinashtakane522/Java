package Recursion;

import java.util.Scanner;

public class PrintNameNTimes {
    static void print(int i, int n){
        if (i>n) return;
        System.out.println("avi");
        print(i+1,n);
    }
    public static void main(String[] args) {
        int n;
        System.out.print("Enter the count that u want to print u r name: ");
        n=new Scanner(System.in).nextInt();
        print(1,n);
    }
}
