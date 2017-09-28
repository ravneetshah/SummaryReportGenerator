package main.java;

public class JmeterScriptParser {

	public static void main(String[] args) {
		RequestDetails requestDetails = new RequestDetails();
		
		if ( args.length == 0) {
			System.err.println("Error: No log file specified.");
			System.exit(1);
		}
		requestDetails.readRequestsFromLogFile(args[0]);
		requestDetails.createSummaryReport();
	}

}
