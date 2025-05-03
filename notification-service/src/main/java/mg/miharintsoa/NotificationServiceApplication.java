package mg.miharintsoa;


import mg.miharintsoa.service.EmailService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }


   /* @Bean
    CommandLineRunner commandLineRunner(EmailService emailService){
        return args -> {
            emailService.sendEmail("kelouchmi@gmail.com", "email test", "email body");
        };
    }*/

}
