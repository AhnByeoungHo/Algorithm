package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Swexpert_4050_D4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++){
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2.compareTo(o1);
				}
			});
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++){
				pq.add(Integer.parseInt(st.nextToken()));
			}
			int result = 0;
			int count = 0;
			while(!pq.isEmpty()){
				if(count==2){
					pq.poll();
					count = 0;
				} else {
					result += pq.poll();
					count++;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
