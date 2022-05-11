import java.util.LinkedList;

public class Sort {

    // Insert sort av array med heltall - O(n^2)
    public static void  instertionSort(int[] array){ // A
        int n = array.length;

        for  (int i = 1; i < n; i++) { // start with  i = 1 og whole with  1
            int currentValue= array[i];
            int hole = i;
            while ( hole > 0 && array[hole - 1] > currentValue){ // if one of them is false, go out of loop or if its a hole with valuse 0
                array[hole] = array[currentValue - 1]; // Would be overwritten if e.g 7 is bigger then 0.
                hole--;
            }
            array[currentValue]=hole; // Put the value in hole
        }
    }

    /**
     * Rearange the list - pivot (selected number):
     *     // Greater than pivot  on the right side of the list
     *     // less than: is on the left side
     * The rearange of the list called partition of a pivort and rearange the list.
     * subproblem of the less and greater - track of start and end index - solve by partition problem ( kind of recursion - exit)
     * */

     public static void quickSort(int[] array, int start, int end){
    int pIndex; // partiton
    if (end - start > 0) {                // base for the  exit
        pIndex = partition(array,start,end);
        // two recursive call
        quickSort(array,start,pIndex-1); // call the segment left of partition index from start
        quickSort(array,pIndex+ 1, end);// to solve the higher/ right side of pindex til end
    }
}
     private static int partition( int[] array, int start, int end){
    int compare = array[start];
    int left = start;
    int right = end;
    int temp;
    // the partition
    while (left< right){
        // find a element element that is greater than the partition index/ element
        while (array[left] <= compare && left < right){
            left++;
        }
        // find a element element that is less than the partition index/ element
        while (array[right]> compare){
            right--;
        }
        // change if both of them not finish yet
        if (left < right){
            temp = array[left];
            array[left]= array[right];
            array[right]= temp;
        }
        // init partiton element between partitons.
    } array [ start ] = array[right];
    array[right] = compare;
    // return th index to part.element.
    return right;
}

     /** Merge sort - O(nlogn)
 * Recursion  - alike quick sort , but by copy then merge the sub array e.g. left and right of the array.
 * pick the smallest element of R and smallest pick of L then merge to new array. and k for posiston.
 * sorted of the sublist then merge them back - when the list one element is sorted we go back.
 *
 * mid - middel posistion  n/2
 * */
     public static void mergeSort(int [] array, int start , int end){
         // array with int
         if (start == end)
             return;
         int arraySize = end - start + 1;
         int mid = (end + start)/ 2;  // the middel of sub elements devided by two
         int [] temp = new int[arraySize];

         // recursive call ( same as quicksort) - merge sort those sub into of array
         mergeSort(array,start,mid);
         mergeSort(array,mid+1,end);

         // copies of the array over temp array. ( the big diffirence between quicksort)
         for ( int i =0; i < arraySize; i++){
             temp[i]= array[start+i];
         }
         // Merge the sub arrays to sorted to one array
         int left = 0;
         int right = mid - start + 1;
         for (int i = 0; i < arraySize; i++) {
             if (right <= end - start) {
                 if (left <= mid - start) {
                     if (temp[left] > temp[right]) {
                         array[i + start] = temp[right++];
                     }
                     else {
                         array[i + start] = temp[left++];
                     }
                 }
                 else {
                     array[i + start] = temp[right++];
                 }
             }
             else {
                 array[i + start] = temp[left++];
             }
         }

     }


    public static void radixSort(int[] array, int maxValue){
         LinkedList<Integer>[] _Queues = (LinkedList<Integer>[]) new LinkedList[10];
         for (int _Val = 0; _Val <= 9; _Val++ )
             _Queues[_Val]= new LinkedList<Integer>();
         int max_Siffer= Integer.toString(maxValue).length()-1;
         for (int pos = 0; pos <= max_Siffer; pos++){ // for hver siffier - posisjon
             // loops/iterate over the whole array
             for (int itr=0; itr<array.length; itr++){
                 String temp = String.valueOf(array[itr]);
                 if (max_Siffer-(max_Siffer-pos) <= temp.length()-1){

                     int siffer = Character.digit(temp.charAt((temp.length()-1)-pos),10);
                     _Queues[siffer].add(array[itr]);
                 }
                 // if there is missing posistion then put as index 0 in que
                 else {
                     _Queues[0].add(array[itr]);
                 }
             }
             // puts back the numbers back in array.
             int number = 0;
             for (int _Val = 0; _Val <=9; _Val++){
                 while (!(_Queues)[_Val].isEmpty()){
                     array[number]= _Queues[_Val].remove();
                     number++;

                 }
             }
         }
    }
}
