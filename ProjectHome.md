For this project you will extract association rules from an interesting data set of your choice. Therefore, your project will consist of two main components: (1) defining your data set of choice and (2) implementing the a-priori algorithm for finding association rules.
Data Set Definition

For this project, you will use the official New York City data sets that are available at the NYC Open Data site, at http://www.nyc.gov/html/datamine/html/home/home.shtml. You can access the data sets at http://www.nyc.gov/html/datamine/html/data/data.shtml. There is a wide variety of data sets, and an important part of this project is that you explore these data sets and pick one or more for you to use in the project, as follows:
You can base your project on just one data set from the above web site, or you can combine multiple such data sets (for example, by joining them over a common attribute, such as zip code) into a larger data set. Either way, your association rule mining algorithm will operate over an individual file, which we will refer to as your INTEGRATED-DATASET file in the rest of this description. IMPORTANT: Make sure you pick NYC Open Data data set(s) from which we can derive interesting association rules.
Your INTEGRATED-DATASET file should then always be a single file, which could correspond to just one data set from NYC Open Data or to multiple data sets joined together.
Your INTEGRATED-DATASET file should be formatted as a CSV file, which you will include in your submission. Note that the NYC Open Data files can be downloaded in a variety of formats. Regardless of the format of the original data set(s) that you used to generate your INTEGRATED-DATASET file, the INTEGRATED-DATASET file should be a single CSV file, so you will need to map the original data set(s) that you use into a single CSV file if needed.
The INTEGRATED-DATASET file should consist of (a) at least 1000 rows if this file corresponds to an individual NYC Open Data data set, or (b) at least 10,000 rows if this file corresponds to the combination of multiple such data sets.
Each row in your INTEGRATED-DATASET will be interpreted as a "market basket" and each attribute of each row, intuitively, will correspond to an "item." You will identify association rules from this file (see below) using this interpretation of the rows and attributes in the file.
You do not need to submit any code or scripts that you use to generate the INTEGRATED-DATASET file, or the original NYC Open Data data sets. However, you need to submit:
A single CSV file containing your INTEGRATED-DATASET file.
A detailed description in your README file (see below) explaining: (a) which NYC Open Data data set(s) you used to generate the INTEGRATED-DATASET file; (b) what (high-level) procedure you used to map the original NYC Open Data data set(s) into your INTEGRATED-DATASET file. The explanation should be detailed enough to allow us to recreate your INTEGRATED-DATASET file exactly from scratch from the NYC Open Data site.
Association Rule Mining Algorithm

You should write and submit either a Java or a Python program to find association rules in your INTEGRATED-DATASET file, where each row in your file corresponds to one "market basket" and each attribute of each row corresponds to one "item" (see above). Specifically, you should write a program to do the following:

Accept as input the name of a file from which to extract association rules; we will input here the name of your INTEGRATED-DATASET file. You can assume that we will only test your program with your INTEGRATED-DATASET file, so you can implement variations of the a-priori algorithm that are a good fit for your data (see below). In this case, you must explain in the README file precisely what variation(s) you have implemented and why (see item 3 below for more details on what variations are acceptable).
Prompt the user for a minimum support min\_sup and a minimum confidence min\_conf, which are two values between 0 and 1. These values must be specified in the command line (and not, for example, using  JOptionPane.showInputDialog()). So we should be able to call your program, for example, as:
sh run.sh INTEGRATED-DATASET.csv 0.3 0.5
which specifies min\_sup=0.3 and min\_conf=0.5.
Compute all the "large (i.e., frequent) itemsets," using min\_sup as your support threshold. The large itemsets have support greater than or equal to min\_sup. You should use the a-priori algorithm described in Section 2.1 of the Agrawal and Srikant paper in VLDB 1994 (see class schedule) to compute these large itemsets. You do not need to implement the "subset function" using the hash tree as described in Section 2.1.2. However, you must implement the version of a-priori in Section 2.1.1, which we discussed in class briefly but is slightly more sophisticated than the version that we covered in detail in class.  Note: Your program has to compute all the large itemsets from scratch every time the program is run; you cannot "precompute" anything ahead of time, but rather all computations have to happen each time your program is run. You are welcome to implement variations of the a-priori algorithm that are a good fit for your data, as discussed above (e.g., to account for item hierarchies, as we discussed in class, or numerical items). IMPORTANT NOTE: These variations have to be at least as "sophisticated" as the description of a-priori in Section 2.1 in general, and in Section 2.1.1 in particular (i.e., your variations cannot be more primitive than the algorithm as described in these sections of the paper). A good place to start to search for relevant variations of the original algorithm is Rakesh Agrawal's publications, http://www.informatik.uni-trier.de/~ley/db/indices/a-tree/a/Agrawal:Rakesh.html. Implementing such a variation is strictly optional; if you decide to implement such a variation, you must so indicate in the README file, explaining precisely what variation(s) you have implemented and why.
For each of the large itemsets, build all possible association rules and identify those that have a confidence of at least min\_conf. Generate only association rules with one item on the right hand side and with at least one item on the left hand side. We will call the rules with confidence greater than or equal to min\_conf as the "high-confidence rules."
Output the large itemsets to a file named "output.txt": each line should include one itemset, within square brackets, and its support, separated by a comma (e.g., [item1,item2], 7.4626%). The lines in the file should be listed in decreasing order of their support. Output also in the same output.txt file the high-confidence association rules, in decreasing order of confidence, reporting the support and confidence of each rule (e.g., [item1](item1.md) => [item2](item2.md) (Conf: 100%, Supp: 7.4626%)).
As a "toy" example from class, consider the following INTEGRATED-DATASET file, which is a CSV with four "market baskets":

pen,ink,diary,soap
pen,ink,diary
pen,diary
pen,ink,soap

As a reminder, note that spaces are considered part of the fields in a CSV file. If we run your program with min\_sup=0.7 and min\_conf=0.8, the program should produce a file output.txt with the following information:

==Large itemsets (min\_sup=70%)
[pen](pen.md), 100%
[diary](diary.md), 75%
[diary,pen], 75%
[ink](ink.md), 75%
[ink,pen], 75%

==High-confidence association rules (min\_conf=80%)
[diary](diary.md) => [pen](pen.md) (Conf: 100.0%, Supp: 75%)
[ink](ink.md) => [pen](pen.md) (Conf: 100.0%, Supp: 75%)