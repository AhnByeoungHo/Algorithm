package work20200129;

import java.util.Arrays;

/*
 * @author AhnByeoungHo
 * @since 2020. 1. 29.
 * @see
 * @mem
 * @time
 * @caution c++ next permutation
 * 
 * */

public class Next_Permutation {

	private static int[] src = {1,2,4,3};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(nP());

		Arrays.sort(src);
		do {
			System.out.println(Arrays.toString(src));
		}
		while(nP());
	}
	private static boolean nP(){
		int point = -1 , point2 = -1;
		for(int i=src.length-2;i>=0;i--){
			if(src[i]<src[i+1]) {
				//System.out.println("Found: "+i);
				point = i;
				break;
			}
		}
		if(point==-1) return false;
		else {
			for(int i=src.length-1;i>=0;i--){
				if(src[i]>src[point]) {
					//System.out.println("Found: "+i);
					point2 = i;
					int temp = src[i];
					src[i] = src[point];
					src[point] = temp;
					//System.out.println(Arrays.toString(src));
					break;
				}
			}
			int[] temp = new int[4];
			for(int i=0;i<=point;i++) {
				temp[i] = src[i];
			}
			int idx = point+1;
			for(int i=src.length-1;i>point;i--) {
				temp[idx++] = src[i];
			}
			src = temp;
			return true;
			
		}
	}

}
