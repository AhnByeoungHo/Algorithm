package work20200128;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class StackTest {

	public static void main(String[] args) {
		// stack to recursive
		//recursive(4);
		//System.out.println(getMulti(2, 4));
		//System.out.println(getPower(2, 4));
		String str = "abcdefg";
		System.out.println(getLen(str, 1));
		printCharArr(str);
		System.out.println();
		printReverse(str);
		System.out.println();
		int digit = 100;
		digitTobinary(digit);
		System.out.println();
		
		int[] arr = {1,2,50,3,0};
		System.out.println(arrSum(arr,0));
		System.out.println(arrMax(arr,0,Integer.MIN_VALUE));
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("found 0 : "+binarySearch(arr, 0, arr.length, 0));
		System.out.println("found 1 : "+binarySearch(arr, 0, arr.length, 1));
		System.out.println("found 2 : "+binarySearch(arr, 0, arr.length, 2));
		System.out.println("found 3 : "+binarySearch(arr, 0, arr.length, 3));
		System.out.println("found 50 : "+binarySearch(arr, 0, arr.length, 50));
		System.out.println("found 12 : "+binarySearch(arr, 0, arr.length, 12));
		
		String str2 = "소주만병만주소";
		System.out.println(palindrome(str2,0,str2.length()-1));
		String str3 = "abca";
		System.out.println(palindrome(str3,0,str3.length()-1));
	}
	public static void recursive(int k) {
		//base case(end)
		if(k==0) {
			System.out.println("end recursive");
			return;
		}
		//recursive
		else {
			System.out.println("Before : " + k);
			recursive(k-1);
			System.out.println("After : " + k);
		}
	}
	
	@Test
	public void recursiveObjectTest() {
		int[] arr = new int[1];
		recursiveObject(0, 3, arr);
	}
	
	public void recursiveObject(int k,int n,int[] arr) {
		if(k==n)
			return;
		arr[0] = k;
		System.out.println(k + " : " + arr[0]);
		recursiveObject(k+1, n, arr);
		arr[0] = k;
		System.out.println(k + " : " + arr[0]);
	}
	
	int cnt=0;
	@Test
	public void recur5Test() {
		
		recur5(0, 3);
		System.out.println(cnt);
	}
	public void recur5(int k,int n) {
		if(k==n) {
			cnt++;
			return;
		}
		recur5(k+1,n);
	}
	int cnt2 = 0;
	@Test
	public void recur6Test() {
		recur6(0,3);
		System.out.println(cnt2);
	}
	public void recur6(int k,int n) {
		if(k==n) {
			cnt2++;
			return;
		}
		recur6(k+1,n);
		recur6(k+1,n);
	}
	public static int getMulti(int n,int m) {
		if(n==(m+1)) return 1;
		else {
			return n*getMulti(n+1,m);
		}
	}
	public static int getPower(int n,int m) {
		if(m==0) return 1;
		else {
			return n*getPower(n, m-1);
		}
	}
	
	public static int getLen(String s,int n) {
		if(s.equals("")) return n-1;
		else {
			System.out.println(s.substring(1));
			return getLen(s.substring(1), n+1);
		}
	}
	public static void printCharArr(String s) {
		if(s.equals("")) return;
		else {
			System.out.print(s.charAt(0));
			printCharArr(s.substring(1));
		}
	}
	public static void printReverse(String s) {
		if(s.equals("")) return;
		else {
			System.out.print(s.charAt(s.length()-1));
			printReverse(s.substring(0, s.length()-1));
		}
	}
	public static void digitTobinary(int n) {
		if(n==0) return;
		else {
			digitTobinary(n/2);
			System.out.print(n%2);
		}
	}
	public static int arrSum(int[] arr,int n) {
		if(n==arr.length) return 0;
		else {
			return arr[n] + arrSum(arr,n+1);
		}
	}
	public static int arrMax(int[] arr,int n,int max) {
		if(n==arr.length) return max;
		else {
			if(arr[n]>max) {
				max = arr[n];
			}
			return arrMax(arr,n+1,max);
		}
	}
	public static int binarySearch(int[] arr, int low,int high, int key) {
		int mid = (low+high)/2;
		if(high<low) return -1;
		else if(arr[mid]==key) return mid;
		else if(arr[mid]>key)
			return binarySearch(arr,low,mid-1,key);
		else
			return binarySearch(arr,mid+1,high,key);

	}
	public static boolean palindrome(String s1,int from,int to) {
		if(from==to) return true;
		else if(from+1==to){
			return s1.charAt(from)==s1.charAt(to);
		}
		else {
			return s1.charAt(from)==s1.charAt(to) && palindrome(s1,from+1,to-1);
		}
	}

}
