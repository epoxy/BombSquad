package se.chalmers.group11.eventbus;

/**
 * Contract for an observer (i.e. the GUI panels)
 * @author hajo
 *
 */

public interface IEventHandler {
    public void onEvent(Event evt);
}
