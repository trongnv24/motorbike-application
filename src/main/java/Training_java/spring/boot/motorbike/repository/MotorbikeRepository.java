package Training_java.spring.boot.motorbike.repository;

import Training_java.spring.boot.motorbike.entity.MotorbikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorbikeRepository extends JpaRepository <MotorbikeEntity, String> {
}
