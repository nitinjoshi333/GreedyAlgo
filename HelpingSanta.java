import java.util.*;
import java.lang.*;
import java.io.*;

class MainClass
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    
        //assuming the input is given in below format (including the brackets & commas):
        /*
            { 
                "hood_capacity": 93,
                "present_weights": [10, 5, 2, 50, 100] 
            }
        */
	    InputStreamReader inpStrReader = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(inpStrReader);
        String[] in = bf.readLine().split(" ");
        
        in = bf.readLine().split(":");
        String in1 = in[1].trim();
        int hoodCapicity = Integer.parseInt(in1.substring(0,(in1.length()) - 1));

        in = bf.readLine().split(":");
        in1 = in[1].trim();
        String temp1 = in1.substring(1,in1.length()-1);
        String[] in2 = temp1.split(",");

        int size=0;
        for(int i=0; i<in2.length; i++){
            int tempInt = Integer.parseInt((in2[i]).trim());
            if(tempInt <= hoodCapicity)
                size++;
        }
        
        int arr[] = new int[size];
        int j1=0;
        //reading the array
        for(int i=0; i<in2.length; i++){
            int tempInt = Integer.parseInt((in2[i]).trim());
            if(tempInt <= hoodCapicity){
                arr[j1++] = tempInt;
            }
        }
        Arrays.sort(arr);       //sorting the array
        int totalSum = hoodCapicity;
        //using greedy algo to find best possible solution
        for(int i=size-1; i>=0; i--){
            int totalDivisor = totalSum/arr[i];
            for(int j=0; j<totalDivisor; j++){
                System.out.print(arr[i] + "\t");
                totalSum -= arr[i];
            }
            if(totalSum == 0){
                break;
            }
        }
	}
}
