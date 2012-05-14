package se.chalmers.group11.eventbus;

import java.util.ArrayList;
import java.util.List;

/**
 * Very simple event bus. All observers can register for events and an
 * observable can publish (send) events.
 * 
 * @author hajo
 * 
 */
public enum EventBus {
	INSTANCE;

	private boolean trace = true;

	private final List<IEventHandler> handlers = new ArrayList<IEventHandler>();

	/**
	 * Register as an event handler
	 * 
	 * @param handler
	 *            , object implementing EventHandler interface
	 */
	public void register(IEventHandler handler) {
		handlers.add(handler);
	}

	/**
	 * Unregister as an event handler
	 * 
	 * @param handler
	 *            , object to remove
	 */
	public void unRegister(IEventHandler handler) {
		handlers.remove(handler);
	}

	/**
	 * Publish (send) events to all registered event handlers (broadcast)
	 * 
	 * @param evt
	 *            , the event to broadcast
	 */
	public void publish(Event evt) {
		// Tracking all events is extremely helpful during development
		if (trace) {
			System.out.println(evt);
		}
		for (IEventHandler evh : handlers) {
			evh.onEvent(evt);
		}
	}
}
