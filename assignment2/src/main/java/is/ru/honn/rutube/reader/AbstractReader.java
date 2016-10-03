package is.ru.honn.rutube.reader;

import is.ruframework.process.RuAbstractProcess;
import org.json.simple.JSONObject;

/**
 * Created by Asgeir on 01/10/2016.
 */
abstract public class AbstractReader implements Reader {

    protected ReadHandler readHandler;
    protected  String URI;

    public Object read()throws ReaderException {
        if (readHandler == null) {
            throw new ReaderException("Handler not set");
        }
        ClientRequest clientRequest = new ClientRequest();
        String content = clientRequest.getRequest(this.URI);
        return this.parse(content);
    }

    public void setURI(String URI) {
        this.URI = URI;
    }
    public void setReadHandler(ReadHandler readHandler) {
        this.readHandler = readHandler;
    }
    /**
     *
     * @param jParent Json parent containing an integer field.
     * @param name name of the integer field
     * @return int value of the json int in the jParent object.
     */
    protected int getInt(JSONObject jParent, String name)
    {
        if(jParent == null)
            return 0;
        Long value = (Long)jParent.get(name);
        if(value == null)
            return 0;
        return value.intValue();
    }
}
