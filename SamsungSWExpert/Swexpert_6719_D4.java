package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Swexpert_6719_D4 {
	private static double[] map;
	
	private static int K;
	private static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			map = new double[N];
			for (int i = 0; i < N; i++) {
				map[i] = Double.parseDouble((st.nextToken()));
			}
			
			Arrays.sort(map);
			//System.out.println(Arrays.toString(map));
			double ans = 0;
			for(int i =N-K;i<N;i++){
				ans = (ans+map[i])/2;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
