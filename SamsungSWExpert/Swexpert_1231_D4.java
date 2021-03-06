import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Swexpert_1231_D4 {
	static Node root;
	private static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1;tc<=10;tc++) {
			StringBuilder sb = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			root = new Node(1);
			root.makeNode(0);
			for(int i=0;i<N;i++) {
				
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				int now = Integer.parseInt(st.nextToken());
				char data = st.nextToken().charAt(0);
				root.addData(now, data);
				
			}

			System.out.print("#"+tc+ " ");
			inOrder(root);
			System.out.println();

		}
		
	}
	
	static class Node{
		char data;
		int id;
		Node left,right;
		Node(int id){
			this.id = id;
		}
		void makeNode(int n) {
			if(this.id>N) return;
			left = new Node(2*id);
			right = new Node(2*id+1);
			left.makeNode(2*n);
			right.makeNode(2*n+1);
		}	
		void addData(int id,char data) {
			
			if(this.id>id) return;
			if(this.id==id) this.data = data;
			if(this.left==null&&this.right==null) return;
			this.left.addData(id, data);
			this.right.addData(id, data);
		}


	}
	public static void inOrder(Node t) {
		if(t==null) return;
		inOrder(t.left);
		if(t.data!=0)
			System.out.print(t.data);
		inOrder(t.right);
	}

}