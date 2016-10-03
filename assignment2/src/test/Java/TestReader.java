import is.ru.honn.rutube.reader.Reader;
import is.ru.honn.rutube.factory.FactoryException;
import is.ru.honn.rutube.factory.ReaderFactory;
import is.ru.honn.rutube.reader.ReaderException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Created by Asgeir on 02/10/2016.
 */
public class TestReader {
    ReaderFactory factory;

    @Before
    public void setup() {
        factory = new ReaderFactory();
    }
    @Test
    public void testFactoryRead() {
        Reader testReader = factory.getReader("userReader");
        assertEquals(testReader.getClass().getSimpleName(),"UserReader");
        Reader testReader2 = factory.getReader("videoReader");
        assertEquals(testReader2.getClass().getSimpleName(),"VideoReader");
    }
    @Test
    public void testWrongURI() {
        try {
            Reader testReader = factory.getReader("iAmWrong");
        } catch (FactoryException e) {
            assertEquals(e.getMessage(), "Finn ekki gildið");
        }
    }
    @Test
    public void testHandlerNotSet (){
        Reader reader = factory.getReader("videoReader");
        try {
            reader.read();
        } catch (ReaderException e) {
            assertEquals(e.getMessage(), "Handler not set");
        }
    }
}
