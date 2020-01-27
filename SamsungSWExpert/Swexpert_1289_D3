import java.util.Scanner;
import java.io.FileInputStream;

class swexpert_1289_D3
{
	public static void main(String args[])
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String str = sc.next();
			int i=0;
			int flag = 0;
			int count = 0;
			while(true) {
				if(i==(str.length())) break;
				if(str.charAt(i)=='1'&&flag == 0) {
					flag = 1;
					count++;
				}
				else if(str.charAt(i)=='0'&&flag == 1) {
					flag = 0;
					count++;
				}
				i++;
			}
			System.out.println("#"+test_case+" "+count);
		
		}
	}
}
