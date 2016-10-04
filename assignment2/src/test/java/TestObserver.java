import is.ru.honn.rutube.Observer.Observer;
import is.ru.honn.rutube.Observer.Subject;
import org.junit.Test;

/**
 * Created by sigmarb on 4.10.2016.
 */
public class TestObserver
{
    @Test
    public void testUpdateFunction()
    {
        Subject subject = new Subject();

        Observer observer = createMock(Observer.class);
        observer.update(eq(subject), anyObject());
        replay(observer);

        subject.observer(observer);
        subject.funcA();

        verify(observer);
    }


}


