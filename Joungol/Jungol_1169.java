import java.util.Arrays;
import java.util.Scanner;
//1:중복조합 2:조합 3:순열
public class Jungol_1169 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] data = new int[6];
		for(int i=0;i<6;i++)
			data[i] = i+1;
		boolean[] visit = new boolean[6];
		int[] output = new int[n];
		if(m==1) {
			M1(n, 0, data, output);
		}
		else if(m==2) {
			M2(n, 0, data, output);
		}
		else if(m==3) {
			M3(n, 0, data, visit, output);
		}
		
	}
	public static void mapPrint(int[] map) {
		for(int i=0;i<map.length;i++)
			System.out.print(map[i]+" ");
		System.out.println();

	}
	public static void M3(int r, int depth,int[] data,boolean[] visit,int[] output) {
		if(r==depth) {
			mapPrint(output);
			return;
		}
		else {
			for(int i=0;i<data.length;i++) {
				if(!visit[i]) {
					visit[i] = true;
					output[depth] = data[i];
					M3(r,depth+1,data,visit,output);
					output[depth] = 0;
					visit[i] = false;
				}
			}
		}
	}
	
	public static void M2(int r, int depth,int[] data,int[] output) {
		if(r==depth) {
			for(int i=0;i<output.length-1;i++)
				if(output[i]>output[i+1])
					return;
			mapPrint(output);
			return;
		}
		else {
			for(int i=0;i<data.length;i++) {
				output[depth] = data[i];
				M2(r,depth+1,data,output);
				output[depth] = 0;
			}
		}
	}
	
	
	public static void M1(int r, int depth,int[] data,int[] output) {
		if(r==depth) {
			mapPrint(output);
			return;
		}
		else {
			for(int i=0;i<data.length;i++) {
				output[depth] = data[i];
				M1(r,depth+1,data,output);
				output[depth] = 0;
			}
		}
	}
	

}
