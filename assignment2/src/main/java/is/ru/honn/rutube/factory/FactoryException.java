package is.ru.honn.rutube.factory;

/**
 * Created by Asgeir on 01/10/2016.
 */
public class FactoryException extends RuntimeException
{
    public FactoryException()
    {
    }

    public FactoryException(String s)
    {
        super(s);
    }

    public FactoryException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public FactoryException(Throwable throwable)
    {
        super(throwable);
    }
}
