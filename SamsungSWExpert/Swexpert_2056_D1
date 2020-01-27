import java.util.Scanner;

public class swexpert_2056_D1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		//System.out.print(str);
		
		String year,month,day;
		year = str.substring(0,4);
		month = str.substring(4,6);
		day = str.substring(6,8);
		int monthtemp = Integer.parseInt(month);
		int daytemp = Integer.parseInt(day);
		
		if(monthtemp<1 || monthtemp >12) {
			System.out.print(-1);
			return;
		}
		else if((monthtemp==1||monthtemp==3||monthtemp==5||monthtemp==7||monthtemp==8
				||monthtemp==10||monthtemp==12)&&(daytemp>31||daytemp<1)) {
			System.out.print(-1);
			return;
		}
		else if((monthtemp==4||monthtemp==6||monthtemp==9||monthtemp==11)
				&&(daytemp>30||daytemp<1)) {
			System.out.print(-1);
			return;
		}
		else if (monthtemp==2&&(daytemp>28||daytemp<1)) {
			System.out.print(-1);
			return;
		}
		else {
			System.out.print(year+ "/" + month + "/" + day);
			return;
		}
	}

}
