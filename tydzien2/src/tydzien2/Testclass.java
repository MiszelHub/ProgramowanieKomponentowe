package tydzien2;
//import java.util.*;
import java.util.Arrays;
import java.util.Vector;
import java.util.Date;
import java.util.Scanner;
public class Testclass {

	public static void printArray(int array[])
	{
		System.out.print("[");
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i]+",");
		}
		System.out.print("]");
	}
	public static void bubbleSort(int array[])
	{
		for(int i = 0;i<array.length-1;i++)
		{
			for(int j=0;j<array.length-i-1;j++)
			{
				if(array[j]>array[j+1])
				{
					int tmp=0;
					tmp = array[j];
					array[j]=array[j+1];
					array[j+1] = tmp;
					
				}
			}
		}
	}
	public static void main(String[] args) {
		
		int n=15;

		
		Vector<Integer> vec = new Vector<Integer>();
		for(int i=n;i!=0;i--)
		{
			if(i%2!=0)
			{
				vec.add(i);
			}
		}
		System.out.print("[ ");
		for(int i=0;i<vec.size();i++)
		{
				
				System.out.print(vec.get(i)+", ");		
			
		}
		System.out.print("]");
		 Scanner in = new Scanner(System.in);
	 	int rozmiar = in.nextInt();
		int[] array1 = new int[rozmiar];
		for (int i=0; i< rozmiar; i++)
		{
			array1[i] = (int)(Math.random()*20);
		}
		int[]array2 = new int[rozmiar];
		array2 = array1.clone();
		printArray(array1);
		
		Date przed = new Date();
		Arrays.sort(array1);
		Date po = new Date();
		System.out.println();
		printArray(array1);
		System.out.println();
		System.out.println("Czas operacji sortowania QuickSort "+((double)po.getTime() - (double)przed.getTime()) +"ms");
		
		printArray(array2);
		System.out.println();
		Date przed1 = new Date();
		bubbleSort(array2);
		Date po1 = new Date();
		printArray(array2);
		System.out.println();
		System.out.println("Czas operacji sortowania bubblesort "+((double)po1.getTime() - (double)przed1.getTime()) +"ms");
		
	}

}

