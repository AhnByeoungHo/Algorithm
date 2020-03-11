package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Swexpert_7701_D4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int tc=1;tc<=T;tc++){
			sb.append("#").append(tc).append("\n");
			int N = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();

			for(int i=0;i<N;i++){
				String name = br.readLine();
				int len = name.length();
				map.put(name, len);
			}
			Iterator it = sortByValue(map).iterator();
			while(it.hasNext()) {
				String ans = (String) it.next();
				sb.append(ans).append('\n');
			}
		}
		System.out.println(sb);
	}

	public static List sortByValue(final Map map) {

		List<String> list = new ArrayList();
		list.addAll(map.keySet());
		Collections.sort(list,new Comparator<String>() {
			public int compare(String o1,String o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);
				if(v1.equals(v2)){
					return o2.compareTo(o1);
				}
				return ((Comparable) v2).compareTo(v1);
			}
		});

		Collections.reverse(list); // 주석시 오름차순
		return list;
	}
}
