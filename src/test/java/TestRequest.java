package test.java;

import org.junit.Test;

import junit.framework.TestCase;
import main.java.Request;

public class TestRequest {

	@Test
	public void testRequestClass() {
		Request req = new Request("label", (long) 1223, 1);
		
		TestCase.assertEquals("label", req.getLabel());
		TestCase.assertEquals(1223, req.getLatency().longValue());
		TestCase.assertEquals(1, req.getCount().intValue());
		TestCase.assertEquals(1223, req.getAverage().longValue());
	}

}
