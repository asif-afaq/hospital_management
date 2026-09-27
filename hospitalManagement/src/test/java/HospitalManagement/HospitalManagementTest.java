package HospitalManagement;

import HospitalManagement.dto.BloodGroupStats;
import HospitalManagement.dto.CPatientInfo;
import HospitalManagement.dto.IPatientInfo;
import HospitalManagement.entities.Patient;
import HospitalManagement.repositry.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class HospitalManagementTest {
    @Autowired
    PatientRepository patientRepository;
    @Test
    void getAllPatient() {
        //List<CPatientInfo> patients = patientRepository.getAllPatientsInfoConcrete();
        //List<BloodGroupStats> bloodGroupStats = patientRepository.getBloodGroupStats();
        int updatedPatient = patientRepository.updatePatientNameById("Asif",  4L);
        System.out.println(updatedPatient);
    }
}
