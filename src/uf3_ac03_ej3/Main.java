package uf3_ac03_ej3;

import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * @Daniel Migales
 */
public class Main {

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException {

        Scanner teclado = new Scanner(System.in);
        boolean salir = true;

        do {
            System.out.println("\n" + ANSI_BLUE + "----------------MENU PRINCIPAL-------------" + ANSI_RESET + "\n");
            System.out.println("1. Introducir bookmark.");
            System.out.println("2. Ver bookmarks (leer XML con DOM).");
            System.out.println("3.              ");
            System.out.println("4. Salir del programa.");

            System.out.println("\n" + "Elija una opcion.");
            int opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    XML.CrearXML();
                    break;

                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    salir = false;
                    break;
            }
        } while (salir);
    }
}
