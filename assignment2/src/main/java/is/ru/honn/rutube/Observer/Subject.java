package is.ru.honn.rutube.Observer;

/**
 * Created by sigmarb on 3.10.2016.
 */
import is.ru.honn.rutube.domain.User;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observers = new ArrayList<Observer>();

    public void attach(Observer observer)
    {
        observers.add(observer);
    }

    public void notifyAllObservers(User user)
    {
        for (Observer observer : observers) {
            observer.update(user);
        }
    }
}