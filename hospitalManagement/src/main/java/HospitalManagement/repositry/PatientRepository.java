package HospitalManagement.repositry;

import HospitalManagement.dto.BloodGroupStats;
import HospitalManagement.dto.CPatientInfo;
import HospitalManagement.dto.IPatientInfo;
import HospitalManagement.entities.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("select p.id as id, p.name as name, p.email as email from Patient p")
    List<IPatientInfo> getAllPatientsInfo();

    @Query("select new HospitalManagement.dto.CPatientInfo (p.id, p.name) from Patient p")
    List<CPatientInfo> getAllPatientsInfoConcrete();

    @Query("select new HospitalManagement.dto.BloodGroupStats (p.bloodGroupType, COUNT(p)) from Patient p " +
            "group by p.bloodGroupType order by COUNT(p) DESC")
    List<BloodGroupStats> getBloodGroupStats();

    @Modifying
    @Transactional
    @Query("UPDATE Patient p set p.name=:name where p.id=:id")
    int updatePatientNameById(@Param("name") String name, @Param("id") Long id);
}
