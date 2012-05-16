package se.chalmers.group11.eventbus;

/**
 * A single event
 * 
 * @author hajo
 * @author Anton Palmqvist added new constructor
 * 
 */
public class Event {
    // All possible types of events listed
    public enum Tag {
        PLAYER_KILLED,
        MUSIC_STARTER, 
        MUSIC_STOPPER,
        MENUMUSIC_STARTER,
        MENUMUSIC_STOPPER,
        WINNINGMUSIC_STARTER, 
        ENEMY_KILLED, 
        EXPLODE_BOMB,
        PLACE_BOMB,
        MORE_FIRE,
        MORE_BOMBS
    }
    
    private final Tag tag;
    // The new value (sent to GUI)
    private final Object value;
    public Event(Tag tag, Object value){
        this.tag = tag;
        this.value = value;
    }
    public Event(Tag tag){
        this.tag = tag;
        this.value = null;
    }
    public Tag getTag() {
        return tag;
    }
    public Object getValue() {
        return value;
    }
    @Override
    public String toString() {
        return "Event [tag=" + tag + ", value=" + value + "]"; // Useful for debug
    } 
}
