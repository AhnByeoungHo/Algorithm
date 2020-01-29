package work20200129;

import java.util.Arrays;

public class BabyginGreedy {

	static int[] data = {1,2,3,1,2,3};
	//4,4,4,4,5,6	true
	//4,4,4,3,4,5	true
	//6,4,4,5,4,4	true
	//1,2,3,1,2,3	true
	//1,1,1,1,2,1	false
	//6,6,7,7,6,7	true
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(babyGreedy());
		
		
		String str ="abcdefg";
		System.out.println(str.contains("bc"));
		
	}
	public static boolean babyGreedy() {
		int[] count = new int[10];
		for(int i=0;i<data.length;i++) {
			count[data[i]]++;
		}
		System.out.println(Arrays.toString(count));
		int triplet=0;
		int run=0;
		
		for(int i=0;i<count.length;i++) {
			if(count[i]>=3 &&count[i]<6) {
				//triplet
				triplet++;
				count[i] -= 3;
			}
			else if(count[i]==6) {
				return true;
			}
		}
		System.out.println(Arrays.toString(count));
		Arrays.sort(count);
		if(count[7]==count[8] && count[8]==count[9] && count[7]==1)
		{
			run++;
		}
		else if(count[7]==count[8] && count[8]==count[9] && count[7]==2){
			return true;
		}
		if(triplet+run ==2) {
			return true;
		}
		
		return false;
			
	}

}
