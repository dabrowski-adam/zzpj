package backend.service;

import backend.dto.EmailDto;
import java.io.IOException;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

  String send(EmailDto email) throws IOException;
}
