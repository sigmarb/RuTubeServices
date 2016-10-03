package is.ru.honn.rutube.Observer;

import is.ru.honn.rutube.domain.User;

/**
 * Created by sigmarb on 3.10.2016.
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update(User u);
}