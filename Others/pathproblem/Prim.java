package pathproblem;

import java.util.Arrays;
import java.util.Scanner;

import javax.sound.midi.Synthesizer;

public class Prim {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V  = sc.nextInt();
		int E = sc.nextInt();
		int[][] adj = new int[V][V];
		for(int i=0;i<E;i++){
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			int c = sc.nextInt();
			adj[a][b] = c;
			adj[b][a] = c;
		}
		boolean[] check = new boolean[V];
		int[] key = new int[V]; //현재 선택된 정점들로부터 도달할수 있는 최소거리
		int[] p = new int[V]; // 최소신장트리의 구조를 저장할 배열
		Arrays.fill(key, Integer.MAX_VALUE);
		//키의 초기값은 무한대
		
		//아무거나 하나 선택(처음선택되는 친구가 루트이므로 부모가 없는걸로 거리는0)
		p[0] = -1;
		key[0] = 0;
		//이미하나골랏으니 나머지 V-1개고르자
		for(int i=0;i<V-1;i++){
			int min = Integer.MAX_VALUE;
			//안골라진 친구들중에서 key가 가장 작은 친구를 뽑자
			int index = -1;//찾으면 idx기억
			for(int j=0;j<V;j++){
				//일단 안골라진지 검사 key의최소값을 기억해야함
				if(!check[j] && key[j] <min){
					index = j;
					min = key[j];
				}
			}
			//index : 선택이 안도니 정점중 key가 제일 작은 곳이 들어있다
			check[index] = true;
			for(int j=0;j<V;j++){
				//check안되있으면서 간선은존재하고 그 간선이 key값보다 작다면 key값을 업데이트
				if(!check[j] && adj[index][j] != 0 && key[j] > adj[index][j]){
					p[j] = index;
					key[j] = adj[index][j];
				}
			}
		
		}
		
		int result = 0;
		for(int i=0;i<V;i++){
			result+= key[i];
		}
		System.out.println(result);
		//System.out.println(Arrays.toString(p));
		
	}
}
