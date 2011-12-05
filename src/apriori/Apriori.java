package apriori;

import helper.DataHelper;
import helper.FileHelper;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import valueObjects.LargeItemSetVO;

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
		currentItemSet = DataHelper.getLOneSet();
		largeItemSet.addAll(currentItemSet);
		while(currentItemSet.size() > 0) {
			currentItemSet = getNextLevelItemSet(currentItemSet);
		}
		printLargeItemSet();
	}
	
	public void printLargeItemSet() {
		for(LargeItemSetVO vo: DataHelper.getLargeItemSetWithSupport()) {
			System.out.print("[ ");
			for(String s: vo.getItems()) {
				System.out.print(s+ ",");
			}
			System.out.println(" ]  Support is " + vo.getSupport()*100 + "%");
		}
	}
	
	public Set<Set<String>> getNextLevelItemSet(Set<Set<String>> curItemSet){
		Set<Set<String>> cloneSet = new HashSet<Set<String>>(curItemSet);
		Set<Set<String>> nextLevel = new HashSet<Set<String>>();
		
		for(Set<String> set : curItemSet) {
			for(Set<String> set1 : cloneSet){
				if (!set.equals(set1)) {
					Set<String> toAdd = new HashSet<String>(set);
					toAdd.addAll(set1);
					nextLevel.add(toAdd);
				}
			}
		}
		nextLevel = DataHelper.getFrequentItems(nextLevel, fileMap);
		largeItemSet.addAll(nextLevel);
		return nextLevel;
	}
	
}
