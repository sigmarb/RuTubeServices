package is.ru.honn.rutube.factory;

import is.ru.honn.rutube.reader.Reader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Asgeir on 01/10/2016.
 */
public class ReaderFactory
{
    private ApplicationContext context;

    public ReaderFactory() {
        context = new ClassPathXmlApplicationContext("reader.xml");
    }

    public Reader getReader(String className)
    {
        Reader reader = null;
        try
        {
            reader = (Reader)context.getBean(className);
        }
        catch (Exception e)
        {
            System.out.print(e.getMessage() + ' ' +  e.getCause());
            throw new FactoryException("Finn ekki gildið", e);
        }
        return reader;
    }
}

