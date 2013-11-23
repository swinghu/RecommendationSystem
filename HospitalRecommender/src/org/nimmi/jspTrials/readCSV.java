package org.nimmi.jspTrials;

import java.io.FileReader;
import java.io.IOException;

import org.apache.hadoop.fs.Path;


public class readCSV {

	/**
	 * @param latLon 
	 * @param args
	 * @return 
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static String findCity(double[] latLon) throws IOException, InterruptedException, ClassCastException {
		 String mypath = "/Users/nimmicv/Documents/workspaceMahout/HospitalRecommender/testData";
		String state = null; //= "95051";
		String csvFilename = mypath+"/data/zipcode.csv";
		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
		String[] row = null;
	//	Writer writer = null;
		Path output = new Path(mypath+"/output");
 //   Path clustersIn = new Path(output, "random-seeds");
		String[] headerLine =csvReader.readNext();

		while((row = csvReader.readNext()) != null) 
				{
					if ((Double.parseDouble(row[3]) == latLon[0]) && (Double.parseDouble(row[4])==(latLon[1])))
				
					{
						state = row[2];
						System.out.println("State: " + row[2]  );
						break;
					}
				}
		

	
		csvReader.close();
		return state;
	}
	

}

