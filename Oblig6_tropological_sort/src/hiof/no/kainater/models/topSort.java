package hiof.no.kainater.models;

import java.util.ArrayList;
// implement unweighted graphs
public class topSort extends enkelGraf {
    boolean[] oppsokt;  // V , // visited
    int[] inngrad;// indentation
    ArrayList<Integer> S = new ArrayList<>(); // mengde s

    // constructer for the super class
    public topSort(String filNavn) {
        super(filNavn);
        oppsokt = new boolean[n]; // noder
        inngrad = new int[n];
    }

    /**
     * Methode for finding and printing one topological sort of graogh that is read from
     * file when create the new topSort object.
     */

    public void findAndPrint() {  // main
        // arrays
        for (int i = 0; i < n; i++) {
            oppsokt[i] = false;
            inngrad[i] = 0;
        }

        // finds indentation of every nodes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(nabo[i][j] && i != j) {
                    inngrad[j] += 1;
                }
            }
            // init all nodes with indentation 0 to S and backtracking kinda but saying been here like maze  = oppsøkt
            if(inngrad[i] == 0) {
                S.add(i);
                oppsokt[i] = true;
            }
        } // end of for-loop

        System.out.println("Topologisk sortering:");
        while (S.size() > 0) {
            int a = S.remove(0);
            System.out.println(data[a]);

            // For each neighbor of a
            for (int j = 0; j < n; j++) {
                //Reduces the degree to the neighbor by 1
                if (nabo[a][j] && a != j) {
                    inngrad[j]--;
                }
                // If this neighbor has now been graded equal to 0, it is added to S ,and marked as oppsokt
                if (inngrad[j] == 0  && !oppsokt[j]) {
                    S.add(j);
                    oppsokt[j] = true;
                }
            } // end for loop for neighbor a
        } // end of while-loop
    } // end of methode
} // end of the class