package backend.http;

import java.io.IOException;
import java.net.ProtocolException;

public interface HttpService {
    HttpService setRequestProperty(String key, String value);
    HttpService asJSON();
    HttpService setRequestMethod(RequestMethod requestMethod) throws ProtocolException;
    HttpService setContent(String content);
    String send() throws IOException;
}

