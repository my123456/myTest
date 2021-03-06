package eventBus;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.google.common.eventbus.EventBus;

/**
 * 事件总线工厂 将EventBus封装为单例模式使用
 * 
 * @author Jack
 *
 */
public class EventBusFactory {

	private volatile static EventBusFactory INSTANCE;

	/**
	 * 保存已经注册的监听器，防止监听器重复注册
	 */
	private Map<String, Class<? extends EventListener>> registerListenerContainers = Maps.newConcurrentMap();

	private EventBusFactory() {
	}

	public static EventBusFactory build() {
		if (INSTANCE == null) {
			synchronized (EventBusFactory.class) {
				if (INSTANCE == null) {
					INSTANCE = new EventBusFactory();
				}
			}
		}
		return INSTANCE;
	}

	private final EventBus EVENTBUS = new EventBus();

	/**
	 * 事件转发
	 * 
	 * @param event
	 */
	public void postsEvent(SystemEvent event) {
		EVENTBUS.post(event);
	}

	/**
	 * 监听器注册
	 * 
	 * @param clazz
	 */
	public void register(Class<? extends EventListener> clazz, String value) {
		String clazzName = clazz.getSimpleName();
		if (registerListenerContainers.containsKey(clazzName)) {
			return;
		}
		try {
			registerListenerContainers.put(clazzName, clazz);
			MemberDeletedEventListener obj = (MemberDeletedEventListener)registerListenerContainers.get(clazzName).newInstance();
			obj.setValue(value);
			EVENTBUS.register(obj);
			System.out.println(JSON.toJSON(registerListenerContainers));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}