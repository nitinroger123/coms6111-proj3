package apriori;

import helper.DataHelper;

import java.io.IOException;

/**
 * The Main class where everything starts
 * @author nitin kanna
 *
 */
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
		Double minSupport = 0.1;
		Double minConfidence = 0.3;
		DataHelper.init(minSupport, minConfidence);
		Apriori aprioriHelper = new Apriori();
		
		try {
			aprioriHelper.doApriori(minSupport, minConfidence, filename);
		} catch (IOException e) {
			System.err.println("I/O failed "+ e.toString());
		}
	}

}
