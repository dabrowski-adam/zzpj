package backend.http;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpServiceImpl implements HttpService {

    private final HttpURLConnection connection;
    private Map<String, String> requestProperties;
    private String content;

    public HttpServiceImpl(String url) throws IOException {
        this.connection = (HttpURLConnection) new URL(url).openConnection();
        this.requestProperties = new HashMap<>();
    }

    @Override
    public HttpService setRequestProperty(String key, String value) {
        this.requestProperties.put(key, value);

        return this;
    }

    @Override
    public HttpService asJSON() {
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
    public void send() throws IOException {
        for (Map.Entry<String, String> entry : requestProperties.entrySet()) {
            this.connection.setRequestProperty(entry.getKey(), entry.getValue());
        }

        connection.setUseCaches(false);
        connection.setDoOutput(true);

        if (content != null) {
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(content);
            wr.flush();
            wr.close();
        }

        connection.disconnect();
    }
}
