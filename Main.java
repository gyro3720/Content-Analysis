package aprsrch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Article {
	
	static ArrayList<String> negative;
	static ArrayList<String> positive;
	
	public Main() {
		super();
	}
	
	public static void main(String[] args) throws IOException
	{
		//https://www.cs.uic.edu/~liub/FBS/sentiment-analysis.html
		File negs = new File("C:\\Users\\flash\\eclipse-workspace\\aprsrch\\negative-words.txt");
		File pos = new File("C:\\Users\\flash\\eclipse-workspace\\aprsrch\\positive-words.txt");
		//String tempFile = "C:\\Users\\flash\\Desktop\\1.txt";
		
		//Array declarations
		ArrayList<String> negative2 = new ArrayList<String>();
		ArrayList<String> positive2 = new ArrayList<String>();
		File[] directory;
		ArrayList<String[]> formattedDirectory = new ArrayList<String[]>();
		
		
		ArrayList<Article> collection = new ArrayList<Article>();
		
		Scanner p = new Scanner(pos);
		Scanner n = new Scanner(negs);
		
		String Connotation;
		
		//Directory Initialization
		String directory1 = "C:\\Users\\flash\\Desktop\\APRSCH";
		int iterator = 0;
		File dir = new File(directory1);
		File[] directoryContents = dir.listFiles();
		if(directoryContents != null) {
			for(File child : directoryContents) {
				iterator++;
			}
		}
		
		File[] prereqDirectory = new File[iterator];
		int i = 0;
		
		if(directoryContents != null) {
			for(File child : directoryContents) {
				prereqDirectory[i] = child;
				i++;
			}
		}
		
		directory = prereqDirectory;
		//Directory Initialization--------
		
		
		//List initialization
		while(n.hasNextLine())
		{
			negative2.add(n.nextLine());
		}
		while(p.hasNextLine())
		{
			positive2.add(p.nextLine());
		}
	
		positive = positive2;
		negative = negative2;
		//List initialization--------

		
		//Article y = analyze(finalList);
		
		
		//Micro-Analysis
		for(int j = 0; j < directory.length; j++) {
			formattedDirectory.add(format(directory[j]));
		}
		
		for(int j = 0; j < formattedDirectory.size(); j++) {
			Article x = analyze(formattedDirectory.get(j));
			collection.add(x);
		}
		//(Optional) Results:
		//for(Article x : collection) {
		//	System.out.println(x.toString());
		//}
		//Micro-Analysis----------
		
		//Macro-Analysis
		int numPos = 0;
		int numNeg = 0;
		double avgNeg;
		double avgPos;
		double highPos;
		double highNeg;
		double lowPos;
		double lowNeg;
		
		for(int j = 0; j < collection.size(); j++) {
			if(collection.get(j).getCon() == true) {
				numPos++;
			}
			else {
				numNeg++;					
			}
		}
		
		double a1 = 0;
		for(int j = 0; j < collection.size(); j++) {
			a1+=collection.get(j).getNeg();
		}
		avgNeg = (a1/(double)(collection.size()));
		
		double a2 = 0;
		for(int j = 0; j < collection.size(); j++) {
			a2+=collection.get(j).getPos();
		}
		avgPos = (a2/(double)(collection.size()));
		
		double a3 = 0;
		for(int j = 0; j < collection.size(); j++) {
			if (collection.get(j).getPos() > a3) {
				a3 = collection.get(j).getPos();
			}
		}
		highPos = a3;
		
		double a4 = 0;
		for(int j = 0; j < collection.size(); j++) {
			if(collection.get(j).getNeg() > a4) {
				a4 = collection.get(j).getNeg();
			}
		}
		highNeg = a4;
		
		double a5 = 100;
		for(int j = 0; j < collection.size(); j++) {
			if(collection.get(j).getNeg() < a5) {
				a5 = collection.get(j).getNeg();
			}
		}
		lowPos = a5;
		
		double a6 = 100;
		for(int j = 0; j < collection.size(); j++) {
			if(collection.get(j).getPos() < a6) {
				a6 = collection.get(j).getPos();
			}
		}
		lowNeg = a6;
		
		String[] miscSummary = new String[8];
		miscSummary[0] = ("Positive Results: " + numPos);
		miscSummary[1] = ("Negative Results: " + numNeg);
		miscSummary[2] = ("Average Positive Connotation: " + avgPos);
		miscSummary[3] = ("Average Negative Connotation: " + avgNeg);
		miscSummary[4] = ("Highest Positive Result: " + highPos);
		miscSummary[5] = ("Highest Negative Result: " + highNeg);
		miscSummary[6] = ("Lowest Positive Result: " + lowPos);
		miscSummary[7] = ("Lowest Negative Result: " + lowNeg);
		//(Optional) Results:
		//for(String x : miscSummary) {
		//	System.out.println(x);
		//}
		//Macro-Analysis----------
		
		//Stats-Analysis
		
		//Positive
		ArrayList<Article> clone1 = (ArrayList<Article>) collection.clone();
		ArrayList<Article> ascendPos = new ArrayList<Article>();
		
		double q1Pos = 0;
		double medianPos = 0;
		double q3Pos = 0;

		while(clone1.size() > 0)
		{
			double x1 = 100;
			int position = 0;
			int updPos = 0;
			
			for(int j = 0; j < clone1.size(); j++) {
				if((clone1.get(j).getPos()) < x1) {
					x1 = clone1.get(j).getPos();
					position = j;
				}
			}
			ascendPos.add(clone1.get(position));
			clone1.remove(position);
		}
		//Negative
		ArrayList<Article> clone2 = (ArrayList<Article>) collection.clone();
		ArrayList<Article> ascendNeg = new ArrayList<Article>();
		
		double q1Neg = 0;
		double medianNeg = 0;
		double q3Neg = 0;

		
		while(clone2.size() > 0)
		{
			double x2 = 100;
			int position2 = 0;
			int updPos2 = 0;
			
			for(int j = 0; j < clone2.size(); j++) {
				if((clone2.get(j).getNeg()) < x2) {
					x2 = clone2.get(j).getNeg();
					position2 = j;
				}
			}
			ascendNeg.add(clone2.get(position2));
			clone2.remove(position2);
		}
		//Stats-Analysis---------
		
		
	}
	
	public static String[] format(File x) throws IOException
	{
		ArrayList<String> temp = new ArrayList<String>();
		ArrayList<String[]> temp2 = new ArrayList<String[]>();
		String[] finalList = {};
		
		BufferedReader reader = new BufferedReader(new FileReader(x));
		String currentLine = reader.readLine();
		while((currentLine = reader.readLine()) != null) {
			temp.add(currentLine);
		}		
		
		for(int i = 0; i < temp.size(); i++) {
			temp2.add(temp.get(i).split(" "));
		}
		
		for(int i = 0; i < temp2.size(); i++) {
			if(i == 0) {
				finalList = combineArray(temp2.get(0), temp2.get(1));
			}
			else if (i>1){
				finalList = combineArray(finalList, temp2.get(i));
			}
		}
		finalList = removePunct(finalList);
		return finalList;
	}
	
	public static Article analyze(String[] finalL)
	{
		int posCount = 0;
		int negCount = 0;
		boolean possers = false;
		for(int i = 0; i < finalL.length; i++) {
			for(int j = 0; j < positive.size(); j++) {
				if (finalL[i].equals(positive.get(j))) { posCount++; }
			}
		}
		for(int i = 0; i < finalL.length; i++) {
			for(int j = 0; j < negative.size(); j++) {
				if (finalL[i].equals(negative.get(j))) { negCount++; }
			}
		}
		if (posCount>negCount) {
			possers = true;
		}
		
		Article x = new Article(finalL, (((double)negCount/finalL.length) * 100.0), (((double)posCount/finalL.length) * 100.0), finalL.length, possers);
		return(x);
		
	}
	
	//Combines two arrays
	public static String[] combineArray(String[] arr1, String[] arr2) {
		String[] toReturn = new String[arr1.length + arr2.length];
		for(int i = 0; i < arr1.length; i++) {
			toReturn[i] = arr1[i];
		}
		for(int i = arr1.length; i < arr2.length + arr1.length; i++) {
			toReturn[i] = arr2[i - arr1.length];
		}
		return toReturn;
	}
	
	//Reads a String array and returns a replica without punctuation
	public static String[] removePunct(String[] arr) {
		String[] puncts = {",",";","!","?","."};
		String[] toReturn = new String[arr.length];
		for(int i = 0; i < arr.length; i++) {
			String x = arr[i];
			boolean cont = false;
			for(int j = 0; j < puncts.length; j++) {
				if (x.contains(puncts[j])) { cont = true; }
			}
			if(cont) {
				String y = x.substring(0, x.length()-1);
				toReturn[i] = y;
			}
			else {
				toReturn[i] = x;
			}
		}
		return toReturn;
	}
}
