package bigram;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Bigram {

	public static void main(String[] args) {
		String s = "aslslslmasjnfasd";
		
		Map<String, Integer> map = stringUHashMapu(s);
		for (Entry<String, Integer> entry : map.entrySet()) {
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
	}

	public static HashMap<String, Integer> stringUHashMapu(String s){
		
		HashMap<String, Integer> hm = new HashMap<>();
		
		for (int i = 0; i < s.length()-1; i++){
			String s1 = s.substring(i, i+2);
			Integer frek = hm.get(s1);
			if (frek != null){
				hm.put(s1, new Integer(frek+1));
			} else {
				hm.put(s1, 1);
			}
		}
		
		return hm;
	}
}