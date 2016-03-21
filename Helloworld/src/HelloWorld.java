import javax.swing.*;


public class HelloWorld
{
	public static  int silnia(int n)
	{
//		if(n == 0 || n == 1) 
//		{
//			return 1;
//		}else{
//			return n*silnia(n-1);
//		}
		int wynik=1;
		for(int i=1;i<=n;i++)
		{
			wynik=wynik*i;
		}
		return wynik;
			
	}
	public static int newton(int n, int k)
	{
		int wynik;
		wynik = silnia(n)/silnia(k)*silnia(n-k);
		return wynik;
	}
	
	public static int pascal(int n, int k)
	{
		   if(n == k || k==0)
			      return 1;
			   if(k==1 || k==n-1)
			      return n;
			   return pascal(n-1,k-1)+pascal(n-1,k);
		 
	}
	public static void  p(int n){
		int tab[][] = new int[n][];
        for (int i=0;i<n;i++)
        {
        	System.out.print(i + " | ");
        	tab[i] = new int [i+1];
        	for (int j=0;j<i+1;j++)
        	{
        		
        		if(j==0 || j==i) 
    			{
        			tab[i][j] = 1;
    			}
        		else 
    			{
        			tab[i][j]=tab[i-1][j-1] + tab[i-1][j];
    			}
        		System.out.print(tab[i][j] + " ");
        	
        		//if(j!=i) System.out.print("(" + tab[i-1][j] + " , " + tab[i-1][j] + ")");
        	}
        	System.out.println();
        }
	}
	public static void main(String[] args)
	{

		
		System.out.println("Hello World");
		double a = 4;
		double b = 5;
		System.out.println(a+b);
		
		if (b != 0)
		{
			System.out.println(a/b);
		}else {
			System.out.println("nie dziel przez zero");
		}
		
//		String txt1; //deklaracja zmiennej tekstowej
//		txt1 = JOptionPane.showInputDialog("Wprowadz pierwsza liczbe");
//		
//		String txt2; //deklaracja zmiennej tekstowej
//		txt2 = JOptionPane.showInputDialog("Wprowadz druga liczbe");
//		
//		System.out.println(txt1 + txt2); // ???
//		
//		
//		
//		// Konwersja tekstu na liczbe
//		double 	liczba1 = Double.parseDouble(txt1);
//		int		liczba2 = Integer.parseInt(txt2); 
//	
//		System.out.println(liczba1 + liczba2);
		
		String txt3;
		txt3 = JOptionPane.showInputDialog("Podaj liczbe wierszy");
		
		int rozmiar = Integer.parseInt(txt3);
		System.out.println(silnia(3));
		
		//int tab[] = new int[rozmiar];
//		for(int i = 1 ; i < rozmiar; i++)
//		{
// 
//			for(int j = 1;j <= i; j++)
//			{
//				System.out.print(pascal(i,j));
//				//System.out.print(newton(j,i));
//				
//			}
//			System.out.print("\n");
//			
//		}
		p(rozmiar);
		
		
		
		


}
}