package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class EventLog implements Iterable<model.Event> {

    private static EventLog theLog;
    private Collection<model.Event> events;

    private EventLog() {
        events = new ArrayList<model.Event>();
    }


    public static EventLog getInstance() {
        if (theLog == null) {
            theLog = new EventLog();
        }
        return theLog;
    }

    public void logEvent(model.Event e) {
        events.add(e);
    }

    public void clear() {
        events.clear();
        logEvent(new model.Event("Event log cleared."));
    }

    @Override
    public Iterator<model.Event> iterator() {
        return events.iterator();
    }
}
