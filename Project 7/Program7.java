/*  Rhodes Ferris
    CS-2050 Program 7
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.*;
public class Program7 {

    //insertion sort for the integers
    public static void insertionSortInt(int x[], int n){
        for (int i = 1; i < n; ++i) {
            int key = x[i];
            int j = i - 1;
            while (j >= 0 && x[j] > key) {
                x[j + 1] = x[j];
                j = j - 1;
            }
            x[j + 1] = key;
        }
    }

    //insertion sort for the Strings
    public static void insertionSortString(String x[], int n){
        for (int i = 1; i < n; ++i) {
            String key = x[i];
            int j = i - 1;
            while (j >= 0 && x[j].compareTo(key) > 0) {
                x[j + 1] = x[j];
                j = j - 1;
            }
            x[j + 1] = key;
        }
    }
    //bubble sort for the integers
    public static void bubbleSortInt(int x[], int n){
        boolean isSwapped;
        for(int i=0; i<n-1; i++){
            isSwapped=false;
            for(int j=0; j<n-i-1; j++){
                if(x[i] > x[j+1]){
                    int temp1=x[j];
                    int temp2=x[j+1];
                    x[j]=temp2;
                    x[j+1]=temp1;
                    isSwapped=true;
                }
            }
            if(isSwapped==false){
                break;
            }
        }
    }
    //bubble sort for the Strings
    public static void bubbleSortString(String x[], int n){
        boolean isSwapped;
        for(int i=0; i<n-1; i++){
            isSwapped=false;
            for(int j=0; j<(n-i-1); j++){
                if(x[i].compareTo(x[j+1])>0){
                    String temp1=x[j];
                    String temp2=x[j+1];
                    x[j]=temp2;
                    x[j+1]=temp1;
                    isSwapped=true;
                }
            }
            if(isSwapped==false){
                break;
            }
        }
    }
    //selection sort for integers
    public static void selectionSortInt(int x[], int n){
        for(int i=0; i<n-1; i++){
            int smallestElementIndex=i;
            for(int j=i+1; j<n; j++){
                if(x[j] < x[smallestElementIndex]){
                    smallestElementIndex=j;
                }
            }
            int temp1= x[smallestElementIndex];
            int temp2 = x[i];
            x[smallestElementIndex]=temp2;
            x[i]=temp1;
        }
    }
    //selection sort for Strings
    public static void selectionSortString(String x[], int n){
        for(int i=0; i<n-1; i++){
            int smallestElementIndex=i;
            for(int j=i+1; j<n; j++){
                if(x[j].compareTo(x[smallestElementIndex]) < 0){
                    smallestElementIndex=j;
                }
            }
            String temp1= x[smallestElementIndex];
            String temp2 = x[i];
            x[smallestElementIndex]=temp2;
            x[i]=temp1;
        }
    }
    public static void main(String[] args) {
        int[] bubbleInt = new int[20000];
        int[] selectionInt = new int[20000];
        int[] insertionInt = new int[20000];
        ArrayList<Integer> x = new ArrayList<Integer>();
        String[] bubbleString = new String[10000];
        String[] selectionString = new String[10000];
        String[] insertionString = new String[10000];
        ArrayList<String> y = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("NumbersInFile.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt"));
            for (int i = 0; i < "NumbersInFile".length(); i++) {
                String currentLine = reader.readLine();
                bubbleInt[i] = Integer.parseInt(currentLine);
                selectionInt[i] = Integer.parseInt(currentLine);
                insertionInt[i] = Integer.parseInt(currentLine);
                x.add(Integer.valueOf(currentLine));
            }
            writer.write("Rhodes Ferris" + '\n' + "CS-2050 Program 7");
            long startTime = System.nanoTime();
            bubbleSortInt(bubbleInt, bubbleInt.length);
            long endTime = System.nanoTime();
            writer.write('\n' + "Type of sort: Bubble Sort    Type of data: int    time: " + (endTime - startTime));
            startTime = System.nanoTime();
            selectionSortInt(selectionInt, selectionInt.length);
            endTime = System.nanoTime();
            writer.write('\n' + "Type of sort: Selection Sort    Type of date: int    time: " + (endTime - startTime));
            startTime = System.nanoTime();
            insertionSortInt(insertionInt, insertionInt.length);
            endTime = System.nanoTime();
            writer.write('\n' + "Type of sort: Insertion Sort    Type of data: int    time: " + (endTime - startTime));

            BufferedReader reader2 = new BufferedReader(new FileReader("StringsInFile.txt"));
            for (int i = 0; i < bubbleString.length; i++) {
                String currentLine = reader2.readLine();
                bubbleString[i] = currentLine;
                selectionString[i] = currentLine;
                insertionString[i] = currentLine;
                y.add(currentLine);
            }
            reader.close();
            reader2.close();
            startTime = System.nanoTime();
            bubbleSortString(bubbleString, bubbleString.length);
            endTime = System.nanoTime();
            writer.write('\n' + "Type of sort: Bubble Sort    Type of data: String    time: " + (endTime - startTime));
            startTime = System.nanoTime();
            selectionSortString(selectionString, selectionString.length);
            endTime = System.nanoTime();
            writer.write('\n' + "Type of sort: Selection Sort    Type of data: String    time: " + (endTime - startTime));
            startTime = System.nanoTime();
            insertionSortString(insertionString, insertionString.length);
            endTime = System.nanoTime();
            writer.write('\n' + "Type of sort: Insertion Sort    Type of data: String    time: " + (endTime - startTime));
            startTime = System.nanoTime();
            Collections.sort(y);
            endTime = System.nanoTime();
            writer.write('\n' + "Type of sort: Collections.sort    Type of data: String    time: " + (endTime - startTime));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}