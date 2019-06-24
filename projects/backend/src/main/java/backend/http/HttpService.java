package backend.http;

import java.io.IOException;
import java.net.ProtocolException;

import org.springframework.stereotype.Service;

@Service
public interface HttpService {

  HttpService setUrl(String url) throws IOException;

  HttpService setRequestProperty(String key, String value);

  HttpService asJson();

  HttpService setRequestMethod(RequestMethod requestMethod) throws ProtocolException;

  HttpService setContent(String content);

  String send() throws IOException;
}

