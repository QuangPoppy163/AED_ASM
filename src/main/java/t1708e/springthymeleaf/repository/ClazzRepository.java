package t1708e.springthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import t1708e.springthymeleaf.entity.Clazz;

@Repository
public interface ClazzRepository extends JpaRepository<Clazz, Integer> {
}
