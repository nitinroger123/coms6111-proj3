package apriori;

import helper.DataHelper;

import java.io.IOException;

public class Main {
	public static void main(String args[]) {
		/**
		String filename = args[0];
		Double minSupport = Double.parseDouble(args[1]);
		Double minConfidence = Double.parseDouble(args[2]);
		**/
		/**
		 * Test code. Remove and uncomment above
		 */
		
		String filename = "INTEGRATED-DATASET.csv";
		Double minSupport = 0.7;
		Double minConfidence = 0.5;
		DataHelper.init(minSupport, minConfidence);
		Apriori aprioriHelper = new Apriori();
		
		try {
			aprioriHelper.doApriori(minSupport, minConfidence, filename);
		} catch (IOException e) {
			System.err.println("I/O failed "+ e.toString());
		}
	}

}
