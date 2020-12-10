package nl.novi.dpcc.observerpattern.subject;

import nl.novi.dpcc.observerpattern.domain.Message;
import nl.novi.dpcc.observerpattern.observer.Observer;

/**
 * A receiver of notification. In other words one of the subscribers to a certain publisher.
 */
public interface Subject {

    /**
     * Adds the observer to the collection
     * @param o observer to be added.
     */
    void attach(Observer o);


    /**
     * Removes the observer from the collection.
     * @param o observer to be removed.
     */
    void detach(Observer o);

    /**
     * Notifies all observers with given message.
     * @param message that is being sent to all subscribers.
     */
    void notifyUpdate(Message message);
}
