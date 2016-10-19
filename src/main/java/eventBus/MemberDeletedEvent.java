package eventBus;

import java.util.List;

public class MemberDeletedEvent extends SystemEvent {
	private String confCreatorToken;

	private List<String> e164ListToOper;

	private int cmd;

	public MemberDeletedEvent() {
	}

	public MemberDeletedEvent(String eventName) {
		super(eventName);
	}

	public MemberDeletedEvent(String eventName, String confCreatorToken, List<String> e164ListToOper, int cmd) {
		this(eventName);
		this.confCreatorToken = confCreatorToken;
		this.e164ListToOper = e164ListToOper;
		this.cmd = cmd;
	}

	@Override
	public String toString() {
		return "MemberDeletedEvent [confCreatorToken=" + confCreatorToken + ", e164ListToOper=" + e164ListToOper + ", cmd=" + cmd + "]";
	}

	public String getConfCreatorToken() {
		return confCreatorToken;
	}

	public void setConfCreatorToken(String confCreatorToken) {
		this.confCreatorToken = confCreatorToken;
	}

	public List<String> getE164ListToOper() {
		return e164ListToOper;
	}

	public void setE164ListToOper(List<String> e164ListToOper) {
		this.e164ListToOper = e164ListToOper;
	}

	public int getCmd() {
		return cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}
}
