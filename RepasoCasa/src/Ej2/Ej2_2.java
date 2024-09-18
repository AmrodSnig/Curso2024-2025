package Ej2;

import java.util.Scanner;

public class Ej2_2 {
    public static void main(String[] args) {

        String fin="chocho";
        String busqueda="o";

        Scanner sc= new Scanner(System.in);
        for (int i=0; i<5 ;i++) {
            System.out.println("Escribe una palabra");
            busqueda = sc.next();
            if (busqueda.equalsIgnoreCase(fin)) {

                System.out.println("Has acertado");
            break;
            } else {
                System.out.println("Prueba otra vez");
            }
        }
    }
}

