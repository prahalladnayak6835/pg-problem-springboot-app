package pd.example.demoprojectproblemtaskApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pd.example.demoprojectproblemtaskApi.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
