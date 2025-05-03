package mg.miharintsoa.controller;

import lombok.AllArgsConstructor;
import mg.miharintsoa.entity.EmailContent;
import mg.miharintsoa.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
@AllArgsConstructor
public class EmailController {

    private EmailService emailService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody EmailContent emailContent) {
        emailService.sendEmail(
                emailContent.getTo(),
                emailContent.getSubject(),
                emailContent.getBody()
        );

        return ResponseEntity.ok("mail envoyee");
    }
}
