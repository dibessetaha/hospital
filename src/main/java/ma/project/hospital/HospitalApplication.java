package ma.project.hospital;

import ma.project.hospital.entities.Patient;
import ma.project.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HospitalApplication implements CommandLineRunner {

    @Autowired
    PatientRepository patientRepository ;
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Patient patient1 = new Patient() ;
        patient1.setId(null);
        patient1.setNom("Mohammed");
        patient1.setDateOfBirth(new Date());
        patient1.setSick(false);
        patient1.setScore(156);

        Patient patient2 = new Patient(null,"Taha",new Date(), false, 123);

        Patient patient3 = Patient.builder()
                .nom("Ahmad")
                .dateOfBirth(new Date())
                .score(145)
                .sick(false)
                .build();

        patientRepository.save(patient2) ;
        patientRepository.save(patient1);
        patientRepository.save(patient3) ;

    }
}
