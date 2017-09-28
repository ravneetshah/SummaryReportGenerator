package main.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class RequestDetails {
	private HashMap<String, Request> listOfRequests;
	
	/**
	 * Constructor for class.
	 */
	public RequestDetails() {
		listOfRequests = new HashMap<>();
	}
	
	/**
	 * method to parse log file and the requests to hashmap.
	 * @param file name of the file to be parsed.
	 */
	public void readRequestsFromLogFile(String file) {
		// Scan the file to read line by line
		try (FileInputStream inputStream = new FileInputStream(file);
				Scanner sc = new Scanner(inputStream, "UTF-8")){

			if (sc.hasNextLine()) {
				sc.nextLine();
			} else {
				System.out.println("Error: Empty file");
				return;
			}
			
		    while (sc.hasNextLine()) {
		        String requestLog = sc.nextLine();
		        // Split the line
		        String[] requestParameters = requestLog.split(",");
		        String label = requestParameters[2];
		        
		        // Check if the request with given label already exists
		        Request req = listOfRequests.get(label);
		        if (req == null) {
		        	// if the request with given label does not exist in the list.
		        	listOfRequests.put(label, new Request(label,
		        			Long.parseLong(requestParameters[13]), 1));
		        } else {
		        	// Update the label as it already exist in the list
		        	listOfRequests.put(label, new Request(label,
		        			req.getLatency() + Long.parseLong(requestParameters[13]),
		        			1 + req.getCount()));
		        }
		    }
		} catch ( IOException exp) {
			System.err.println(String.format(
					"Failed to read requests from log file %s - %s ",
					file, exp.getMessage()));
		}
	}
	
	/**
	 * Method to create summary report.
	 */
	public void createSummaryReport() {
		listOfRequests.forEach((k, v)->{System.out.println(k +", Count " + v.getCount()
				+ ", Average " + v.getAverage() + "ms");});
	}
	
	/**
	 * Method to get request details for a label.
	 * @param label label name.
	 * @return parameters for the label
	 */
	public Request getRequestDetails(String label) {
		return listOfRequests.get(label);
	}
}
