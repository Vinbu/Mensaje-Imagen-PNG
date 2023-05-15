package com.mycompany.taller2;
import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Encode [1] or Decode [2]");
        int codification = scanner.nextInt();

        if (codification <3){
            switch (codification) {
                case 1:
                    System.out.println("Encode");
                    break;
                case 2:
                    System.out.println("Decode");
                    break;
            }
        }
        else {
            while (codification > 2){
            System.out.println("Ingrese un numero valido");
            codification = scanner.nextInt();

            }
        }
        
        
    }
}
