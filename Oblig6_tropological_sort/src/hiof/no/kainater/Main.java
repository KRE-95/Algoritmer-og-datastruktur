package hiof.no.kainater;

import hiof.no.kainater.models.topSort;
import java.io.IOException;

public class Main {
    public static void main(String[] args)
    {
        // testprogram
        // Leser navnet pÃ¥ en fil med grafdata som input fra
        // kommandolinjen
        String filNavn = "";
        try
        {
            if (args.length != 1) {
                throw new IOException("Mangler filnavn");
            }
            filNavn = args[0]; // første fil
        }
        catch (Exception e)
        {
            System.err.println(e);
            System.exit(1);
        }

        // method
        topSort T = new topSort(filNavn);
        T.findAndPrint();
    }
}
