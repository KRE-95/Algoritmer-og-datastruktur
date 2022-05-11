package hiof.no.kainater;


import hiof.no.kainater.module.BST;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Standard input
        if (args.length == 0) {
            BST bst = new BST(); // tre

            Scanner scan = new Scanner(System.in); // input
            scan.useDelimiter("[^a-zæøåA-ZÆØÅ]"); // kategoriserer input: starter fra a alfabetisk rekkfølge, godkjenner ikke ")" og ender med zæøå

            System.out.println(" Kopier teksten fra dummy.txt eller skriv egen: " + "\n" +
                    " Avslutt = Exit.\n");

            while (scan.hasNext()) {
                String word = scan.next();
                if (word.equals("Exit")) {
                    break;
                }
                bst.insert(word.toUpperCase());
            }

            System.out.println();
            bst._InOrder();

            //TODO: den skriver forekom 23 ganger, prøvd å lete etter årsaken hvor jeg gikk feil. den var ikke slikt .

        }



    }
}
