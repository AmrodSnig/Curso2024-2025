import Ej2.Dos;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int a;
        int b;
        int c = 0;
        int op;
        boolean bucle;

        Scanner sc= new Scanner(System.in);
        System.out.println("introduce un número");
        a = sc.nextInt();
        System.out.println("introduce otro número");
        b = sc.nextInt();


        do {

            System.out.println("Selecciona opciones\n" +
                    "1 suma\n" +
                    "2 resta\n" +
                    "3 multiplica\n" +
                    "4 divide\n" +
                    "5 ignorar todo");
            op = sc.nextInt();
            bucle=false;
            switch (op) {
                case 1:
                    c = a + b;
                    break;
                case 2:
                    c = a - b;
                    break;
                case 3:
                    c = a * b;
                    break;
                case 4:
                    c = a / b;
                    break;
                default:
                    bucle = true;
                    System.out.println("No está entre mis opciones");

            }
        }while(bucle);


        System.out.println("El resultado es " + c);



    }
    }

