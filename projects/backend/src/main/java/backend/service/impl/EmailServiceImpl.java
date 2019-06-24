package backend.service.impl;

import backend.dto.EmailDto;
import backend.http.HttpService;
import backend.http.HttpServiceImpl;
import backend.http.RequestMethod;
import backend.service.EmailService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailServiceImpl implements EmailService {

    private final String API_KEY = "7656bcd3bed13b053dcf1903f1c4265d423b5";
    private final String API_URL = "https://zzpj2019-7029.restdb.io";

    @Override
    public String send(EmailDto email) throws IOException {
        HttpService httpService = new HttpServiceImpl(API_URL + "/mail");

        return httpService.asJSON()
                .setRequestMethod(RequestMethod.POST)
                .setRequestProperty("x-apikey", API_KEY)
                .setContent(email.toJson())
                .send();
    }
}
