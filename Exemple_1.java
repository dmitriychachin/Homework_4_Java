package Homework_4;

import java.util.LinkedList;
import java.util.Scanner;

public class Exemple_1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        int n = scannerInt("Введите количество элементов в массиве", iScanner);
        int x = scannerInt("Введите Максимальный элемент массива", iScanner);
        LinkedList<Integer> arr = randomLinked(n, x);
        printArray(arr);
        LinkedList<Integer> res = rebuild(arr);
        printArray(res);
    }

    public static LinkedList<Integer> rebuild(LinkedList<Integer> list){
        LinkedList<Integer> res = new LinkedList<>();
        int n = list.size();
        while (n > 0) {
            int x = list.pollLast();
            res.add(x);
            n--;
        }
        return res;
    }

    public static LinkedList<Integer> randomLinked(int n, int x){
        LinkedList<Integer> arr = new LinkedList<>();

        while(n > 0){
            arr.add((int) (Math.random() * x));
            n--;
        }
        return arr;
    }

    public static int scannerInt (String message, Scanner iScanner) {
        System.out.println(message);
        int x = iScanner.nextInt();

        return x;
    }

    public static void printArray(LinkedList<Integer> arr){
        StringBuilder print = new StringBuilder();
        for(int i : arr){
            print.append(i);
            print.append(" ");
        }
        System.out.println(print);
    }
}
