package uz.ksan.socialmedia.backend.socialnetwork1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages = "uz.ksan.socialmedia.backend.socialnetwork1")
@EnableCaching
public class SocialNetwork1Application {

    public static void main(String[] args) {
        SpringApplication.run(SocialNetwork1Application.class, args);
    }

}
