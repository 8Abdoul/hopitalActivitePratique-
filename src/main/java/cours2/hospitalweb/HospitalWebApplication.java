package cours2.hospitalweb;

import cours2.hospitalweb.entities.Patient;
import cours2.hospitalweb.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HospitalWebApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {

        SpringApplication.run(HospitalWebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null,"Hassane", new Date(),false, 213));
        patientRepository.save(new Patient(null,"Aicha", new Date(),false, 219));
        patientRepository.save(new Patient(null,"Isma", new Date(),false, 220));
    }
}
