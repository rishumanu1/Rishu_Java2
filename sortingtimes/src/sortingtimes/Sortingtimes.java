package sortingtimes;

public class Sortingtimes {

    public static void main(String[] args) {

         int[] a = new int[50];
        for (int i =0; i<50; i++) {
            a[i]=(int) (Math.random()*1000);
        }
        int[] b =new int[50];
        for (int i =0; i<50; i++) {
            b[i]=a[i];
        }
         int[] c =new int[50];
        for (int i =0; i<50; i++) {
            c[i]=a[i];
        }
        long startTime = System.nanoTime(); 
        bubbleSort(a);
        long bubbleSortTime = System.nanoTime() - startTime;
        startTime = System.nanoTime(); 
        selectionSort(b);
        long selectionSortTime = System.nanoTime() - startTime;
        
         for(int i = 0; i < c.length; i++)
        {
          System.out.print(c[i] + " ");
        }
         System.out.println();
         startTime = System.nanoTime(); 
        insertionSort(c);
        long insertionSortTime = System.nanoTime() - startTime;
        System.out.println("Bubble Sort time: "+bubbleSortTime +", Selection Sort time: "+selectionSortTime+", Insertion Sort time: "+insertionSortTime);
        for(int i = 0; i < c.length; i++)
        {
          System.out.print(c[i] + " ");
        }
          String[] x = {"ball", "dog", "apple", "cat", "ear", "diamond"};
          insertionSort(x);
         
        String[] y =new String[6];
        for (int i =0; i<6; i++) {
            y[i]=x[i];
        }
         String[] z =new String[6];
        for (int i =0; i<6; i++) {
            z[i]=x[i];
        }
         startTime = System.nanoTime(); 
        bubbleSort(x);
        long bubbleSortStringTime = System.nanoTime() - startTime;
        startTime = System.nanoTime(); 
        selectionSort(y);
        long selectionSortStringTime = System.nanoTime() - startTime;
        
         for(int i = 0; i < x.length; i++)
        {
          System.out.print(x[i] + " ");
        }
         System.out.println();
         startTime = System.nanoTime(); 
        insertionSort(z);
        long insertionSortStringTime = System.nanoTime() - startTime;
        System.out.println("Bubble Sort time: "+bubbleSortStringTime +", Selection Sort time: "+selectionSortStringTime+", Insertion Sort time: "+insertionSortStringTime);
        for(int i = 0; i < z.length; i++)
        {
          System.out.print(z[i] + " ");
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
           int j=i;
             while (j > 1 && arr[j] < arr[j-1])
             {
                 swapNumbers(j,j-1, arr);
                     int temp = arr[j];
                     arr[j] = arr[j-1];
                     arr[j-1] = temp;
                      j--;
                     
                 }
             }
        }
            
    public static void insertionSort(String[] arr)
    {
         for (int i = 1; i < arr.length; i++)
        {
           int j=i;
             while (j > 1 && arr[j].compareTo(arr[j-1])< 0)
             {
                    String temp = arr[j];
                     arr[j] = arr[j-1];
                     arr[j-1] = temp;
                      j--;
                     
                 }
             }
        }
            }

