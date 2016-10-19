package eventBus;

import com.alibaba.fastjson.JSON;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

public class TestEventListener implements EventListener {

	@Subscribe
	@AllowConcurrentEvents
	public void action(SystemEvent event) {
		System.out.println(String.format("[TestEventListener ] action, listener=" + this.toString() + " event=" + event.toString()));
		TestEvent subEvent = (TestEvent) event;
		invoke(subEvent);
	}

	public void invoke(TestEvent testEvent) {
		System.out.println(JSON.toJSONString(testEvent, true));
		System.out.println(String.format("[TestEventListener ] action testEvent=" + testEvent.toString()));
	}

}
