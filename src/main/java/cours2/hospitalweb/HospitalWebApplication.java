package cours2.hospitalweb;

import cours2.hospitalweb.entities.Patient;
import cours2.hospitalweb.repositories.PatientRepository;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class HospitalWebApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {

        SpringApplication.run(HospitalWebApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(new Patient(null,"Abdoul", new Date(),true, 213));
            patientRepository.save(new Patient(null,"Aicha", new Date(),false, 219));
            patientRepository.save(new Patient(null,"Khalid", new Date(),false, 220));
        };
        }
    @Override
    public void run(String... args) throws Exception {

    }

}

