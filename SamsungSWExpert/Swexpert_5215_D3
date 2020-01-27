import java.util.ArrayList;
import java.util.Scanner;


public class swexpert_5215_D3 {

	static ArrayList<Integer> x = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1;test_case<=T;test_case++) {
			int N;
			int L;
			N = sc.nextInt();
			L = sc.nextInt();
			int score[] = new int[N];
			int kcal[] = new int[N];
			int map[] = new int[N];
			boolean[] visited = new boolean[N];
			for(int i=0;i<N;i++) {
				score[i]=sc.nextInt();
				kcal[i]=sc.nextInt();
				visited[i] = false;
				map[i] = i;
			}

			
			int scoremax=0;

			for(int i=1;i<=N;i++) {
				x.clear();
				combination(map,visited,0,N,i);
				//System.out.println(x);
				for(int j=0;j<x.size();j+=i) {
					int kcalmax = 0;
					int smax=0;
					for(int k=0;k<i;k++) {
						//System.out.print(score[x.get(k+j)]);
						smax += score[x.get(k+j)];
						kcalmax += kcal[x.get(k+j)];
						if(kcalmax>L)
						{
							smax=0;
							break;
						}
					}
					
					if(scoremax<smax && kcalmax<L)
						scoremax = smax;
				}

			}
			System.out.println("#"+test_case+" " +scoremax);
		}
	}
	public static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
	    if(r == 0) {
	    	//print(arr,visited,n);
	    	getarr(arr,visited,n);
	        return;
	    } else {
	        for(int i=start; i<n; i++) {
	            visited[i] = true;
	            combination(arr, visited, i + 1, n, r - 1);
	            visited[i] = false;
	        }
	    }
	}
	static void print(int[] arr, boolean[] visited, int n) {
        for(int i=0; i<n; i++) {
            if(visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
	static void getarr(int[] arr, boolean[] visited, int n) {
		ArrayList<Integer> a= new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(visited[i] == true)
                x.add(arr[i]);
        }
    }

}
