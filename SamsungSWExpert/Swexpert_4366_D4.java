package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Swexpert_4366_D4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++){
			sb.append("#"+tc+ " ");
			String bin = br.readLine();
			String tri = br.readLine();
			
			long[] blist = new long[bin.length()];
			long[] tlist = new long[tri.length()*2];
			for (int i = 0; i <bin.length(); i++) {
				String bintemp = bin;
				if(bin.charAt(i)=='1'){
					bintemp = bin.substring(0,i) + '0' +bin.substring(i+1,bin.length());
				} else {
					bintemp = bin.substring(0,i) + '1' +bin.substring(i+1,bin.length());
				}
				blist[i] = Long.parseLong(bintemp,2);
			}
			for (int i = 0; i <tri.length(); i++) {
				String tritemp = tri;
				if(tri.charAt(i)=='0'){
					tritemp = tri.substring(0,i) + '1' +tri.substring(i+1,tri.length());
					tlist[i*2] = Long.parseLong(tritemp,3);
					tritemp = tri.substring(0,i) + '2' +tri.substring(i+1,tri.length());
					tlist[i*2+1] = Long.parseLong(tritemp, 3);
				} else if(tri.charAt(i)=='1'){
					tritemp = tri.substring(0,i) + '0' +tri.substring(i+1,tri.length());
					tlist[i*2] = Long.parseLong(tritemp,3);
					tritemp = tri.substring(0,i) + '2' +tri.substring(i+1,tri.length());
					tlist[i*2+1] = Long.parseLong(tritemp,3);
				} else{
					tritemp = tri.substring(0,i) + '0' +tri.substring(i+1,tri.length());
					tlist[i*2] = Long.parseLong(tritemp,3);
					tritemp = tri.substring(0,i) + '1' +tri.substring(i+1,tri.length());
					tlist[i*2+1] = Long.parseLong(tritemp,3);
				}
			}
			long ans = 0;
			for (int i = 0; i < tlist.length; i++) {
				for (int j = 0; j < blist.length; j++) {
					if(tlist[i]==blist[j]&& tlist[i]>2){
						ans = tlist[i];
					}
				}
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
}
