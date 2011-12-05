package apriori;

import helper.DataHelper;
import helper.FileHelper;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Apriori {
	/*Hold the resultant large itemset */
	Set<Set<String>> largeItemSet;
	Set<Set<String>> currentItemSet;
	
	/*Maps the file into memory */
	Map<Integer, Set<String>> fileMap;
	
	public Apriori() {
		largeItemSet = new HashSet<Set<String>>();
		fileMap = new HashMap<Integer, Set<String>>();
		currentItemSet = new HashSet<Set<String>>();
	}
	
	/**
	 * Does the Apriori Algo
	 * @param minSupport
	 * @param minConfidence
	 * @throws IOException 
	 */
	public void doApriori(Double minSupport, Double minConfidence, String filename) throws IOException {
		fileMap = FileHelper.parseFile(filename);
		largeItemSet.addAll(DataHelper.getLOneSet());
		printLargeItemSet();
	}
	
	public void printLargeItemSet() {
		for (Set<String> set: largeItemSet) {
			for(String s: set) {
				System.out.print(s+", ");
			}
			System.out.println();
		}
	}
}