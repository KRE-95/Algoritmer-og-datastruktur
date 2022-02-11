package no.hiof.alg_data.models;

import java.util.LinkedList;
import java.util.Queue;

public class Flyplass {
    private Queue<Fly> ankomst_Que = new LinkedList<>(); // lande kø
    private Queue<Fly> avgang_Que = new LinkedList<>();  // take off kø
    private int que_Size; {
        
    }

    
    // Avgang = tar av , Amkomst = lander

// Innstansvariabeler for å oppførsel/ egenskap til systemet

    private int n_Antall_FlyAnkomst = 0;
    private int n_Antall_FlyAvvist = 0;  // hvis køene er fulle, vil fly som ankommer bli avvist.
    private int n_Antall_FlyAvgang = 0;

    // Gjennomsnittlige ventetider i køene -  tidsenheter
    private int ledig_TidsEnheter = 0;
    private int antall_Ledig_TidsEnheter = 0;
    // totale kø i størrelse
    private int totale_AnkomstQueueSize = 0;  // size , etter strl
    private int totale_AvgangQueueSize = 0;

    public Flyplass(int que_size) {

    }


    // set values
    public void Flyplass(int que_Size) {
        this.que_Size = que_Size;
    }

    // for fly som lander
    public void fly_Til_Ankomst() {
        this.n_Antall_FlyAnkomst++; // blir lagt til
        Fly n_Neste_Fly = ankomst_Que.poll(); //en fly blir  tatt ut fra ankomst kø
        int queForFly = ankomst_Que.size() + ankomst_Que.size(); // nåværende strl for kø for å fly.
        System.out.println(n_Neste_Fly + "fly til ankomst" + queForFly + "fly som er i kø");
    }

    // for fly som har tatt av
    public void fly_Til_Avgang() {
        this.n_Antall_FlyAvgang++; // blir lagt til
        Fly n_Neste_Fly = avgang_Que.poll(); //en fly blir  tatt ut fra avgang kø
        int queForFly = ankomst_Que.size() + ankomst_Que.size(); // nåværende strl for kø for å fly.
        System.out.println(n_Neste_Fly + "fly til avgang" + queForFly + "fly som er i kø");
    }

    // Oppdaterer køen etter tid og størrelse
    public void oppdater_Que_E_Tid (){
        this.antall_Ledig_TidsEnheter++; // for hver tidsenhet opp
        this.totale_AnkomstQueueSize += this.ankomst_Que.size();
        this.totale_AvgangQueueSize += this.avgang_Que.size();
    }

    /**
     om det er ledig - tid, og om det er tom ved ankomst/ avgang, eller full avvist.

     - viktigst å få flyene ned på bakken - ankomst
     - fly få ta av bare hvis landingskøen er tom - Avgang
     -  Hvis køene er fulle, vil fly som ankommer bli avvist.

     **/


    public  void ledig(){
        this.ledig_TidsEnheter++;
        System.out.println("Flyplassen er tom");

    }

    // hvis køen for fly i ankomst tom iht. boolean
    public boolean is_An_Empty(){      // ankomst
        return ankomst_Que.isEmpty();

    }

    // hvis landekøen er tom - boolean   // tom kø for avgang
    public boolean is_Av_Empty(){
        return avgang_Que.isEmpty();

    }



    public void que_Red_Green_Signal_Ankomst (Fly f){
        if (ankomst_Que.size()== que_Size){
            this.n_Antall_FlyAvvist++;
            System.out.println(f + " Signal Rød: vennligst fly til neste flyplass, landingskøen er full.  ");
        } else {
            ankomst_Que.add(f);
            System.out.println(f + " Grønt Signal: - rullebanen er klar for ankomst");
        }

    }

    public void que_Red_Green_Signal_Avgang (Fly f){
        if (avgang_Que.size()== que_Size){
            this.n_Antall_FlyAvgang++;
            System.out.println(f + " Signal Rødt: Ankomstkø er full, avvist.");
        } else {
            avgang_Que.add(f);
            System.out.println(f + " Grønt Signal - rullebanen er klar for avgang. ");
        }

    }

    // gjennomsnitt ventetid for ankomst og avgang
    public double get_Avrage_ventetid_Ankomst (){
        return (double) totale_AnkomstQueueSize / (double) antall_Ledig_TidsEnheter;
    }

    public double get_Avrage_ventetid_Avgang (){
        return (double) totale_AvgangQueueSize / (double) antall_Ledig_TidsEnheter;
    }


    public int getN_Antall_FlyAnkomst() {
        return n_Antall_FlyAnkomst;
    }

    public int getN_Antall_FlyAvvist() {
        return n_Antall_FlyAvvist;
    }

    public int getN_Antall_FlyAvgang() {
        return n_Antall_FlyAvgang;
    }

    public int getLedig_TidsEnheter() {
        return ledig_TidsEnheter;
    }

    public int getTotale_AnkomstQueueSize() {
        return totale_AnkomstQueueSize;
    }

    public int getTotale_AvgangQueueSize() {
        return totale_AvgangQueueSize;
    }

    // Antall fly klare
   public int getAnkomst_Que_Size() {
        return this.ankomst_Que.size();
   }

    public int getAvgang_Que_Size() {
        return this.avgang_Que.size();
    }
}




