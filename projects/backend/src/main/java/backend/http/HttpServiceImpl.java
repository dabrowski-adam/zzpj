package backend.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class HttpServiceImpl implements HttpService {

  private HttpURLConnection connection;
  private Map<String, String> requestProperties;
  private String content;

  /**
   * Constructor with url parameter.
   *
   * @param url to website.
   * @throws IOException when connection creation fails.
   */
  public HttpServiceImpl(String url) throws IOException {
    this();

    createConnectionFromUrl(url);
  }

  public HttpServiceImpl() {
    this.requestProperties = new HashMap<>();
  }

  private void createConnectionFromUrl(String url) throws IOException {
    this.connection = (HttpURLConnection) new URL(url).openConnection();
  }

  @Override
  public HttpService setUrl(String url) throws IOException {
    createConnectionFromUrl(url);

    return this;
  }

  @Override
  public HttpService setRequestProperty(String key, String value) {
    this.requestProperties.put(key, value);

    return this;
  }

  @Override
  public HttpService asJson() {
    this.setRequestProperty("Content-Type", "application/json");

    return this;
  }

  @Override
  public HttpService setRequestMethod(RequestMethod requestMethod) throws ProtocolException {
    this.connection.setRequestMethod(requestMethod.name());

    return this;
  }

  @Override
  public HttpService setContent(String content) {
    this.content = content;

    return this;
  }

  @Override
  public String send() throws IOException {
    for (Map.Entry<String, String> entry : requestProperties.entrySet()) {
      this.connection.setRequestProperty(entry.getKey(), entry.getValue());
    }

    connection.setUseCaches(false);
    connection.setDoOutput(true);

    if (content != null) {
      writeBody();
    }

    String response = this.getResponse();

    connection.disconnect();

    return response;
  }

  private void writeBody() throws IOException {
    DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
    wr.writeBytes(content);
    wr.flush();
    wr.close();
  }

  private String getResponse() throws IOException {
    StringBuilder response = new StringBuilder();

    InputStream is = connection.getInputStream();
    BufferedReader rd = new BufferedReader(new InputStreamReader(is));

    String line;
    while ((line = rd.readLine()) != null) {
      response.append(line);
      response.append('\r');
    }
    rd.close();
    is.close();

    return response.toString();
  }
}
