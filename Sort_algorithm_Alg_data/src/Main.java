
import java.util.ArrayList;
import java.util.Random;

public class Main {
    // fills the array
    private static int[] fills_Array(int length, int highestV){
        Random r = new Random();
        int[] array = new int[length];
        for (int i =0; i<length; i++){
            array[i] = r.nextInt(highestV);
        }
        return array;
    }

    public static void main(String[] args) {
        // checks it the valid is 3 parameter
        if (args.length !=3){
            System.out.println(
                    " Krever 3 parameter: " + "\n" +
                    "\n Antallet tall som skal sorteres (lengden på arrayen)."
                    + "\n Hvilken metode som skal brukes til sorteringen: " +
                            "\n 1 = insert , 2 = quicksort, 3 = mergesort, 4 = radixsort"
                    + "\n Hva slags test av sorteringsmetoden som skal gjøres: " +
                            "\n 1 = time , 2 = estimering"


            );
        }

        int[] n = new  int[3]; // intArgs - Parser parameters
        for (int i =0; i<args.length; i++){
            n[i] = Integer.parseInt(args[i]);
        }

        // sorts by time
        if (n[2] ==1){
            //  creates random nr within an array
            int[] r_Nr= fills_Array(n[0], 2*n[0]);
            long start_Time = System.currentTimeMillis();

            // select sorting algorthim and sorts the array.
            switch (n[1]){
                case 1:
                    Sort.instertionSort(r_Nr);
                    break;

                case 2:
                    Sort.quickSort(r_Nr,0,r_Nr.length-1);
                    break;

                case 3:
                    Sort.mergeSort(r_Nr,0,r_Nr.length-1);

                case 4:
                    Sort.radixSort(r_Nr, 2 * n[0]);
                    break;


                default:
                    System.out.println("Error skriv parameter på nytt. ");
                    return;
            }
               // calculate and print the time of the sort algorithm
               long end_Time = System.currentTimeMillis();
            // formel
               long time_Used = end_Time - start_Time;
               System.out.println("Kjøre tid for sorteringen: " + time_Used + "milisekunder" );
        }
        // konstanten C - Estimering of value C
        else if (n[2]==2){
            ArrayList<Float> C_konst = new ArrayList<>();
            for (int nn = 10000; nn<=40000; nn += 3000){   // call it nn , for not confusing the parser n of parameter and the n for size.
                int[] a = fills_Array(nn,2* nn);
                float _C = 0;
                long _Time= System.currentTimeMillis();

                // Give selection option
                switch (n[1]){
                    case 1:
                        Sort.instertionSort(a);
                        _Time =System.currentTimeMillis() - _Time;
                        _C = ((float) (_Time)/(nn*nn));
                        C_konst.add(_C);
                        break;

                    case 2:
                        Sort.quickSort(a,0,a.length-1);
                        _Time= System.currentTimeMillis()- _Time;
                        _C = ((float)(_Time)/(float)(nn * Math.log((double)(nn))));
                        C_konst.add(_C);
                        break;

                    case 3:
                        Sort.mergeSort(a,0,a.length-1);
                        _Time= System.currentTimeMillis()- _Time;
                        _C = ((float)(_Time)/(float) (nn*Math.log((double)(nn))));
                        C_konst.add(_C);
                        break;

                    case 4:
                        Sort.radixSort(a, 2 * n[0]);
                        _Time = System.currentTimeMillis() -_Time;
                        _C = ((float)(_Time)/(nn));
                        C_konst.add(_C);
                        break;


                    default:
                        System.out.println(" Error , skriv parameter på nytt");
                        return;
                }
                System.out.println("n:" + nn + "tid: " + _Time + "tc: "+ _C);

            }
            // calculate the avarage of C
            float _AvgC = 0;
            for (float val : C_konst){
                _AvgC +=val; // val is value
            }
            _AvgC /= C_konst.size();
            System.out.println(" Avarage: " + _AvgC);

        }
        else {
            System.out.println("Error, skriv parameter på nytt");
        }
    }
}
