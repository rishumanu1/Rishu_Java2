package sortingtimes;

public class Sortingtimes {

    public static void main(String[] args) {

          int[] a = new int[10];
        for (int i =0; i<10; i++) {
            a[i]=(int) (Math.random()*100);
        }
        int[] b =new int[10];
        for (int i =0; i<10; i++) {
            b[i]=a[i];
        }
         int[] c =new int[10];
        for (int i =0; i<10; i++) {
            c[i]=a[i];
        }
        long startTime = System.nanoTime(); 
        bubbleSort(a);
        long bubbleSortTime = System.nanoTime() - startTime;
        startTime = System.nanoTime(); 
        selectionSort(b);
        long selectionSortTime = System.nanoTime() - startTime;
        startTime = System.nanoTime(); 
         for(int i = 0; i < c.length; i++)
        {
          System.out.print(c[i] + " ");
        }
         System.out.println();
        insertionSort(c);
        long insertionSortTime = System.nanoTime() - startTime;
        System.out.println("Bubble Sort time: "+bubbleSortTime +", Selection Sort time: "+selectionSortTime+", Insertion Sort time: "+insertionSortTime);
        for(int i = 0; i < c.length; i++)
        {
          System.out.print(c[i] + " ");
        }
         
    }

    //this is the main function for bubble sort
    public static void bubbleSort(int array[]) {
        int n = array.length;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (array[i] > array[k]) {
                    swapNumbers(i, k, array);
                }
            }

        }
    }

    public static void bubbleSort(String array[]) {
        int n = array.length;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                int x = array[i].compareTo(array[k]);
                if (x > 0) {
                    swapWords(i, k, array);
                }
            }

        }
    }

    private static void swapWords(int i, int j, String[] array) {

        String temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //this is the helper function for bubble sort
    private static void swapNumbers(int i, int j, int[] array) {

        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //this is the function for selection sort
    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                
                if (arr[j] < arr[index]) {
                    index = j; }
            }

                    int smallerNumber = arr[index];
                    arr[index] = arr[i];
                    arr[i] = smallerNumber;
                
            }
        }
    

    public static void selectionSort(String[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
               
                int x = arr[j].compareTo(arr[index]);
                if (x < 0) {
                    index = j;

                    String smallerWord = arr[index];
                    arr[index] = arr[i];
                    arr[i] = smallerWord;
                }
            }
        }
    }
    
    public static void insertionSort(int[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
           
             while (i > 0 && arr[i] < arr[i-1])
             {
                 
                     int temp = arr[i];
                     arr[i] = arr[i-1];
                     arr[i-1] = temp;
                      i--;
                     
                 }
             }
        }
            
    public static void insertionSort(String[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            int j = 0;
            while (j < i)
            {
                int x = arr[i].compareTo(arr[j]);
                if(x < 0)
                {
                    String largeWord = arr[j];
                    arr[j] = arr[i];
                    arr[i] = largeWord;
                    break;
                }
                j++;
            }
        }
            }
}
