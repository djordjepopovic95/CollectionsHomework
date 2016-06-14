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
		
		
		String ulazni = "mala";
		char c = predvidiSledeci(ulazni, (HashMap) map);
		String izlazni = ulazni + c;
		c = predvidiSledeci(izlazni, (HashMap) map);
		izlazni = izlazni + c;
		c = predvidiSledeci(izlazni, (HashMap) map);
		izlazni = izlazni + c;
		
		System.out.println(izlazni);
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
	
	public static char predvidiSledeci(String s, HashMap<String, Integer> map){
		
		char res = '\u0000';
		int maxVal = -1;
		char c = s.charAt(s.length()-1);
		for (Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			int val = entry.getValue();
			
			if (key.charAt(0) == c){
				if (val > maxVal){
					maxVal = val;
					res = key.charAt(1);
				}
			}
		}
		
		return res;
	}
}