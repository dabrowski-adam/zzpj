package backend.controllers;

import backend.dto.EmailDto;
import backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("emails")
public class EmailsController {

    private final EmailService emailService;

    @Autowired
    public EmailsController(EmailService emailService) {
        this.emailService = emailService;
    }

    /**
     * Send email
     *
     * @param emailDto email Data
     * @return ResponseEntity
     */
    @PostMapping("send")
    public ResponseEntity send(@RequestBody EmailDto emailDto) {
        String message;
        try {
            message = this.emailService.send(emailDto);
        } catch (IOException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }

        return ResponseEntity.ok()
                .body(message);
    }
}
