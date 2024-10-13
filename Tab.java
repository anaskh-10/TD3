package TD3;

import java.util.Scanner;

public class Tab {
	public static int Nmax=40;
	public static void remplir(float t[]) {
		Scanner in=new Scanner(System.in);
		for(int i = 0;i<t.length;i++) {
			System.out.println("donner l'element #"+(i+1)+" : ");
			t[i]=in.nextFloat();
		}	
	}
	public static float somme_element(float t[]) {
		float sum=0;
		for(int i=0;i<t.length;i++) {
			sum=sum+t[i];
		}
		return sum;
	}
	public static float[] additionner(float t1[],float t2[]) {
		if(t1.length != t2.length)
			System.out.println("les deux tabs soit etre en meme taille");
		float res[]=new float[t1.length];
		for(int i=0;i<t1.length;i++) {
			res[i]=t1[i]+t2[i];
		}
		return res;
	}
		public static float[] produit(float x,float t[]) {
			float res[]=new float[t.length];
			for(int i = 0;i<t.length;i++) {
				res[i]=t[i]*x;
			}
			return res;
		}
		
	
	

}
