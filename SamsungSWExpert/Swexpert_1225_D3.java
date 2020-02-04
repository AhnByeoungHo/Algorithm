package bak20200204;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * @author AhnByeoungHo
 * @since 2020. 2. 4.
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AW_ArldKBSADFAVZ&contestProbId=AV14uWl6AF0CFAYD&probBoxId=AXAPO67KNCQDFAX6+&type=PROBLEM&problemBoxTitle=2020-02-04&problemBoxCnt=1
 * @mem
 * @time
 * @caution 암호생성기
 * 
 * */


public class Swexpert_1225_D3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc<=10;tc++) {
			int t = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			for(int i=0;i<8;i++)
				q.offer(sc.nextInt());
			
			boolean isend = false;
			while(true) {
				for(int i=1;i<=5;i++) {
					int current = q.poll();
					current -= i;
					if(current<=0) {
						q.offer(0);
						isend = true;
						break;
					}
					else {
						q.offer(current);
					}
				}
				if(isend) break;	
			}
			StringBuilder sb = new StringBuilder();
			while(!q.isEmpty()) {
				sb.append(q.poll().toString()).append(" ");
			}
			System.out.println("#"+tc+" "+sb);
			
		}
		
	}

}
