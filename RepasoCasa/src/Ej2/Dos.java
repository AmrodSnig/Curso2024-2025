package Ej2;

import java.util.Scanner;

public class Dos {
    public static void main(String[] args) {

        String fin="chocho";
        String busqueda="o";

        Scanner sc= new Scanner(System.in);
        do {
            System.out.println("Escribe una palabra");
            busqueda = sc.next();
            if (busqueda.equalsIgnoreCase(fin)) {

                System.out.println("Has acertado");

            } else {
                System.out.println("Prueba otra vez");
            }
        }while(!busqueda.equals(fin));
    }
}
