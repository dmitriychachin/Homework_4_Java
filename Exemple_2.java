package Homework_4;

import java.util.LinkedList;
import java.util.Scanner;


public class Exemple_2 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        LinkedList<String> turn = null;
        turnConstractor(turn, iScanner);
        
    }

    public static LinkedList<String> enqueue(LinkedList<String> turn, Scanner iScanner){
        String name = scannerStr("Введите имя человека в очереди", iScanner);
        turn.add(name);

        return turn;
    }

    public static LinkedList<String> dequeue(LinkedList<String> turn){
        String name = turn.removeLast();
        System.out.println(name + " удален из очереди. Надеюсь вам понравился наш сервис. Будем ждать вас снова :)");

        return turn;
    }

    public static void first(LinkedList<String> turn){
        String name = turn.removeLast();
        System.out.println(name + " находится первый в очереди и скоро мы ему поможем:)");
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
            String commands = scannerStr("Введите команду для очереди.\n(A - добавить человека в очеряди, S - показать первого в очеряди, D - удалить первого из очеряди, Q - для выхода)", iScanner);
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
            }
        }

    }
}
