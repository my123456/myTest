package eventBus;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

public class MemberDeletedEventListener implements EventListener {

	private String value;

	@Subscribe
	@AllowConcurrentEvents
	public void action(SystemEvent event) {
		System.out.println(String.format("[MemberDeletedEventListener ] action event=" + event.toString())+" value="+this.value);
		MemberDeletedEvent subEvent = (MemberDeletedEvent) event;
		invoke(subEvent);
	}

	public void invoke(MemberDeletedEvent memberDeletedEvent) {
		if (1 == memberDeletedEvent.getCmd()) {
			System.out.println(memberDeletedEvent.getCmd());
		}
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
