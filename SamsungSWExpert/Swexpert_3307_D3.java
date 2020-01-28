import java.util.Scanner;

public class swexpert_3307_D3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N = sc.nextInt();
			int arr[] = new int[N];
			int as = 0;
			
			for(int i=0;i<N;i++)
				arr[i] = sc.nextInt();
			
			
			int max=0;
			for(int i=0;i<N;i++) {
				int maxlen = 0;
				int temp = 0;
				for(int j=i;j<N;j++) {
					if(arr[j]>temp) {
						maxlen++;
						temp = arr[j];
						System.out.print(temp + " ");
					}
					else
						continue;
				}
				System.out.println();
				if(maxlen>max)
					max = maxlen;
			}
			//System.out.println(max);
			System.out.println("#"+test_case+" "+ max);
		}

	}
}
