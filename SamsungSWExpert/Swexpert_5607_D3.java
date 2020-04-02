package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swexpert_5607_D3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		StringTokenizer ST = new StringTokenizer(br.readLine()); 
		int T = Integer.parseInt(ST.nextToken());
		for(int tc=1;tc<=T;tc++){
			ST = new StringTokenizer(br.readLine()); 
			long N = Long.parseLong(ST.nextToken()); 
			long K = Long.parseLong(ST.nextToken()); 
			long MOD = 1234567891; 
			long A = N-K; 
			long n = 1; 
			long a = 1;
			long k = 1; 
			//N! 
			for (int i = 1; i <= N; i++){ n *= i; n %= MOD; } 
			//K! 
			for (int i = 1; i <= K; i++){ k *= i; k %= MOD; } 
			//(N-K)! 
			for (int i = 1; i <= A; i++){ k *= i; k %= MOD; } 
			//a^98 = (a^49)^2 
			long POW = MOD-2; 
			while (POW >= 1){ 
				if (POW%2 == 1){ n = (n*k)%MOD; } 
				k = (k*k)%MOD; 
				POW /= 2; 
			} 
			System.out.println("#"+tc+" "+n);
		}
	}
}
