package backend.service.impl;

import backend.dto.EmailDto;
import backend.http.HttpService;
import backend.http.RequestMethod;
import backend.service.EmailService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

  @Value("${api_key}")
  private String apiKey;

  @Value("${email}")
  private String apiUrl;

  private final HttpService httpService;

  @Autowired
  public EmailServiceImpl(HttpService httpService) {
    this.httpService = httpService;
  }

  @Override
  public String send(EmailDto email) throws IOException {
    return httpService.setUrl(apiUrl + "/mail")
        .asJson()
        .setRequestMethod(RequestMethod.POST)
        .setRequestProperty("x-apikey", apiKey)
        .setContent(email.toJson())
        .send();
  }
}
