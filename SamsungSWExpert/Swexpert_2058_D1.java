import java.util.Scanner;

public class swexpert_2058_D1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
        boolean flag = true;
        int total = 0;
        int temp;
        while(flag){
            
            if(num == 0) flag = false;
            temp = num%10;
            total += temp;
            num = num/10;
        }
        System.out.println(total);
	}

}
