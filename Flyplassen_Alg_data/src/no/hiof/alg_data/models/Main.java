package no.hiof.alg_data.models;
import no.hiof.alg_data.models.Flyplass;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        System.out.println(" Velkommen til Halden Airport, taxfree butikken er dessverre stengt.");
        System.out.println();
        System.out.println("Hvor mange tidsenheter skal simulering gå?  ");
        Scanner scanner = new Scanner( System.in);
        int tidsenhet = scanner.nextInt();
        System.out.println();
        System.out.println("Forventet antall ankomster pr. tidsenhet ? ");
        double ankomst_Forventet = scanner.nextDouble();
        System.out.println();
        System.out.println("Forventet antall avganger pr. tidsenhet ?");
        double avgang_Forventet = scanner.nextDouble();


     // ikke mer enn 10 i kø
        int que_Size = 10;
        Flyplass airport = new Flyplass(que_Size);
        // hvor hvert tidsenhet ittereres
        for (int i = 1; i <= tidsenhet; i++) {
            System.out.println();

            /**
             Trekk et tilfeldig antall nye fly som kommer for å lande - se Flyplass.java
            -   kaller metoden que_Red_Green_Signal_Ankomst som behandler de kriterenene (nesten) som har blitt lagt i README.file

             Trekk et tilfeldig antall nye fly som kommer for å ta av
             - innhenter insirerte metoden que_Red_Green_Signal_Avgang .

             **/

            System.out.println("For hver tidssteg i simuleringen" + "  : " + i + "..." );
            int signal_For_Ankomst = getPoissonRandom(ankomst_Forventet);
            for (int c = 0; c < signal_For_Ankomst; c++);
            airport.que_Red_Green_Signal_Ankomst(new Fly());

            int signal_For_Avgang = getPoissonRandom((avgang_Forventet));
            for (int k = 0; k < signal_For_Avgang; k++) {
                airport.que_Red_Green_Signal_Avgang(new Fly());
            }
            /**
             Hvis landingskøen ikke er tom ....

             Flyplassen er tom for fly....
             */

            if (airport.is_An_Empty()){
                if (airport.is_Av_Empty()){
                    airport.ledig();
                }
                else {
                    airport.fly_Til_Avgang(); // klar for
                }
            }
            else {
                airport.fly_Til_Avgang(); // eller klar for
            }
            airport.oppdater_Que_E_Tid(); // oppdater etter tidsenhet
        }
        System.out.println();
        System.out.println("\n************** Simulering *****************"
                + "\nSimuleringen ferdig etter        : " + tidsenhet + " tidsenheter."
                + "\nTotalt antall fly behandlet      : " + Fly.getN_Fly()
                + "\nAntall fly landet                : " + airport.getN_Antall_FlyAnkomst()
                + "\nAntall fly tatt av               : " + airport.getN_Antall_FlyAvgang()
                + "\nAntall fly avvist                : " + airport.getN_Antall_FlyAvvist()
                + "\nAntall fly klare for landing     : " + airport.getAnkomst_Que_Size()
                + "\nAntall fly klare til å ta av     : " + airport.getAvgang_Que_Size()
                + "\nProsent ledig tid                : " + airport.getLedig_TidsEnheter()
                + "\nGj.snitt. ventetid, landing      : " + airport.get_Avrage_ventetid_Ankomst() +" tidsenheter."
                + "\nGj.snitt. ventetid, avgang       : " + airport.get_Avrage_ventetid_Avgang() +" tidsenheter. "



        );


    }
    // Poisson-fordeling ->  generere tilfeldige tall med en gjennomsnittsverdi lik parameteren mean:

    private static int getPoissonRandom(double mean)
    {
        Random r = new Random();
        double L = Math.exp(-mean);
        int k = 0;
        double p = 1.0;
        do
        {
            p = p * r.nextDouble();
            k++;
        } while (p > L);
        return k - 1;
    }



}
