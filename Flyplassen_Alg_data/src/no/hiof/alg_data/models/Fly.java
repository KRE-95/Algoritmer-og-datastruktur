package no.hiof.alg_data.models;

public class Fly {
    // kun for denne fly klassen
    private static  int n_Fly = 0 ; // antall fly
    private int fly_Nr; // hvilket plass i køen flyet er

    // legger til fly - en fly indekser
    public Fly(){
        this.fly_Nr = Fly.n_Fly + 1;  // metode for at Antall fly som kommer inn til hhv. landingskøen og avgangskøen (uten noe restriksjoner foreløpig)
        Fly.n_Fly++;
    }


    public static int getN_Fly() {
        return n_Fly;
    }

    public static void setN_Fly(int n_Fly) {
        Fly.n_Fly = n_Fly;
    }

    public int getFly_Nr() {
        return fly_Nr;
    }

    public void setFly_Nr(int fly_Nr) {
        this.fly_Nr = fly_Nr;
    }

    @Override
    public String toString(){
        return "Fly.nr " + this.fly_Nr;
    }
}

