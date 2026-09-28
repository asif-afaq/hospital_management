package HospitalManagement.dto;

import HospitalManagement.entities.type.BloodGroupType;
import lombok.Data;

public record BloodGroupStats(BloodGroupType bloodGroupType, Long count) {
}
