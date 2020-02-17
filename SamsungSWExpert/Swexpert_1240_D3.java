package bak20200217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swexpert_1240_D3 {

	static String[] encode = {"0001101","0011001","0010011","0111101","0100011","0110001"
			,"0101111","0111011","0110111","0001011"};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			String[] code1 = new String[8];
			String[] code2 = new String[8];
			String[] code3 = new String[8];
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<M;j++) {
					if(str.charAt(j)=='1') {
						for(int s=0;s<8;s++) {
							code1[s] = str.substring(j-1,j+6);
							code2[s] = str.substring(j-2,j+5);
							code3[s] = str.substring(j-3,j+4);
							j+=7;
							
						}
						break;
					}
				}
			}
			int[] encoding1 = new int[8];
			int[] encoding2 = new int[8];
			int[] encoding3 = new int[8];
			for(int i=0;i<8;i++) {
				for(int s=0;s<10;s++) {
					if(encode[s].equals(code1[i])) {
						encoding1[i]=s;
					}
					if(encode[s].equals(code2[i])) {
						encoding2[i]=s;
					}
					if(encode[s].equals(code3[i])) {
						encoding3[i]=s;
					}
				}
			}
			int first = (encoding1[1]+encoding1[3]+encoding1[5]+encoding1[7]) + (encoding1[0]+encoding1[2]+encoding1[4]+encoding1[6])*3;
			int second = (encoding2[1]+encoding2[3]+encoding2[5]+encoding2[7]) + (encoding2[0]+encoding2[2]+encoding2[4] +encoding2[6])*3;
			int third = (encoding3[1]+encoding3[3]+encoding3[5]+encoding3[7]) + (encoding3[0]+encoding3[2]+encoding3[4] +encoding3[6])*3;
			
//			System.out.println(first);
//			System.out.println(second);
//			System.out.println(third);
//			System.out.println(Arrays.toString(encoding1));
			if(first%10==0&&first!=0) {
				int sum=0;
				for(int i=0;i<8;i++) {
					sum+=encoding1[i];
				}
				System.out.println("#"+t+" "+sum);
			}
			else if(second%10==0&&second!=0) {
				int sum=0;
				for(int i=0;i<8;i++) {
					sum+=encoding2[i];
				}
				System.out.println("#"+t+" "+sum);
			}
			else if(third%10==0&&third!=0) {
				int sum=0;
				for(int i=0;i<8;i++) {
					sum+=encoding3[i];
				}
				System.out.println("#"+t+" "+sum);
			}
			else {
				System.out.println("#"+t+" 0");
			}

		}
		
	}
}
