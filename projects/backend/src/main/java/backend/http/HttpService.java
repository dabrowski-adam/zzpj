package backend.http;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.ProtocolException;

@Service
public interface HttpService {
    HttpService setUrl(String url) throws IOException;
    HttpService setRequestProperty(String key, String value);
    HttpService asJSON();
    HttpService setRequestMethod(RequestMethod requestMethod) throws ProtocolException;
    HttpService setContent(String content);
    String send() throws IOException;
}

