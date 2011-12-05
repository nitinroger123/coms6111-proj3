package helper;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DataHelper {
	private static HashMap<String, Integer> frequencyMap;
	private static Integer numberOfTransactions;
	private static Double minSupport;
	private static Double minConfidecne;
	
	public static void init(Double sup, Double conf) {
		frequencyMap = new HashMap<String, Integer>();
		minSupport = sup;
		minConfidecne = conf;
	}
	
	/**
	 * update the frequency of the word
	 * @param word
	 */
	public static void updateFrequency (String word) {
		Integer count = frequencyMap.get(word);
		if (count == null) {
			frequencyMap.put(word, 1);
		}
		else {
			frequencyMap.put(word, count+1);
		}
		
	}
	
	/**
	 * Get the L1 items
	 * @return
	 */
	public static Set<Set<String>> getLOneSet() {
		Set<Set<String>> LOneSet = new HashSet<Set<String>>();
		Set<String> item = null;
		for (String s: frequencyMap.keySet()) {
			Double currSuport = frequencyMap.get(s).doubleValue() / numberOfTransactions.doubleValue();
			if (currSuport >= minSupport) {
				item = new HashSet<String>();
				item.add(s);
				LOneSet.add(item);
			}
		}
		return LOneSet;
	}
	
	public static HashMap<String, Integer> getFrequencyMap() {
		return frequencyMap;
	}
	
	public static void setNumTransactions(Integer n) {
		numberOfTransactions = n;
	}
	
	public static Integer getNumTransactions() {
		return numberOfTransactions;
	}
}
