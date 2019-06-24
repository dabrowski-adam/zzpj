package backend.service;

import backend.dto.EmailDto;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface EmailService {
    String send(EmailDto email) throws IOException;
}
