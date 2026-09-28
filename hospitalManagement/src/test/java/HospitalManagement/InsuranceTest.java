package HospitalManagement;

import HospitalManagement.entities.Insurance;
import HospitalManagement.entities.Patient;
import HospitalManagement.repositry.InsuranceRepository;
import HospitalManagement.repositry.PatientRepository;
import HospitalManagement.services.InsuranceService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testAssignInsuranceToPatience() {
        Insurance insurance = Insurance.builder()
                .provider("HDFC")
                .policyNumber("HDFC_123")
                .validUntil(LocalDate.of(2026, 1, 1))
                .build();

        var updatedInsurance = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.print(updatedInsurance);

        patientRepository.deleteById(1L);

    }

}
