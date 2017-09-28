package test.java;

import org.junit.Test;

import junit.framework.TestCase;
import main.java.Request;
import main.java.RequestDetails;

public class TestRequestDetails {

	@Test
	public void testReadRequestsFromLogFile() {
		RequestDetails requestDetails = new RequestDetails();
		requestDetails.readRequestsFromLogFile("src/test/resources/Full.log");

		requestDetails.createSummaryReport();
		
		Request req = requestDetails.getRequestDetails("Asset_GotoExistsInstrumentEditPage");
		TestCase.assertEquals("Asset_GotoExistsInstrumentEditPage", req.getLabel());
		TestCase.assertEquals(20, req.getCount().intValue());
		TestCase.assertEquals(570, req.getAverage().longValue());
	}

}
