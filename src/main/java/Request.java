package main.java;

public class Request{
	private String label;
	private Long latency;
	private Integer count;
	
	public Request(String label, Long latency, Integer count) {
		this.label = label;
		this.latency = latency;
		this.count = count;
	}
	
	/**
	 * method to set label.
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * methos to set total latency for request.
	 */
	public void setLatency(Long latency) {
		this.latency = latency;
	}
	
	/**
	 * method to set number of times request has been made.
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	
	/**
	 * method to get label.
	 * @return
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * method to get latency for request.
	 * @return
	 */
	public Long getLatency() {
		return latency;
	}
	
	/**
	 * method to get number of times request has been made.
	 * @return
	 */
	public Integer getCount() {
		return count;
	}
	
	public Long getAverage() {
		return latency/count;
	}
}
