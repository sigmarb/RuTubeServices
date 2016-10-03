package is.ru.honn.rutube.reader;

/**
 * Created by Asgeir on 01/10/2016.
 */
public interface Reader {
    public Object read() throws ReaderException;
    public Object parse(String content);
    public void setURI(String URI);
    public void setReadHandler(ReadHandler readHandler);
}
