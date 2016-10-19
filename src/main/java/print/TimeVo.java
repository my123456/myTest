package print;

public class TimeVo {
	private String service;
	private Object result;
	private long logTime;

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public long getLogTime() {
		return logTime;
	}

	public void setLogTime(long logTime) {
		this.logTime = logTime;
	}
}
