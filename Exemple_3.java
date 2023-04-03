package Homework_4;

import java.util.LinkedList;
import java.util.Scanner;

public class Exemple_3 {

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        LinkedList<String> turn = null;
        turnConstractor(turn, iScanner);
        
    }

    public static LinkedList<String> enqueue(LinkedList<String> turn, Scanner iScanner){
        String name = scannerStr("Введите новый элемент в очереди", iScanner);
        turn.add(name);

        return turn;
    }

    public static LinkedList<String> dequeue(LinkedList<String> turn){
        String name = turn.removeFirst();
        System.out.println(name + " удален из очереди последний элемент");

        return turn;
    }

    public static void first(LinkedList<String> turn){
        String name = turn.removeFirst();
        System.out.println(name + " последний элемент в очеряди сейчас");
    }

    public static String scannerStr (String message,Scanner iScanner) {
        System.out.println(message);
        String str = null;
        do{
        str = iScanner.nextLine();
        }while(str.isEmpty());


        return str;
    }

    public static LinkedList<String> turnConstractor(LinkedList<String> turn, Scanner iScanner){
        while(true){
            String commands = scannerStr("Введите команду для очереди.\n(A - добавить человека в очеряди, S - показать первого в очеряди, D - удалить первого из очеряди, Q - для выхода, C - счет данных)", iScanner);
            commands.toUpperCase();
            switch(commands){
                case "A":
                enqueue(turn, iScanner);
                turnConstractor(turn, iScanner);
                case "S":
                first(turn);
                turnConstractor(turn, iScanner);
                case "D":
                dequeue(turn);
                turnConstractor(turn, iScanner);
                case "Q":
                break;
                case "C":
                calculatorConstract(turn);
                turnConstractor(turn, iScanner);
            }
        }

    }

    public static String calculator(int x1, int x2, String znac) {
        int v = 0;

        switch(znac) {
            case "+":
            v = x1 + x2;
            break;
            case "-":
            v = x1 + x2;
            break;
            case "*":
            v = x1 * x2;
            break;
            case "/":
            v = x1 / x2;
            break;
            default:
                break;
        }

        String res = String.valueOf(v);

        return res;
    }

    public static void calculatorConstract(LinkedList<String> turn){
        int x1 = Integer.valueOf(turn.removeFirst());
        int x2 = Integer.valueOf(turn.remove(turn.size()-3));
        String znac = turn.remove(turn.size()-2);

        String res = calculator(x1, x2, znac);
        turn.add(res);
    }
}
