package pd.example.demoprojectproblemtaskApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pd.example.demoprojectproblemtaskApi.model.Status;
@Repository
public interface StatusRepository extends JpaRepository<Status,Long> {
}
