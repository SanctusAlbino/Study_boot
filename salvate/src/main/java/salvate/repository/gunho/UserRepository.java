package salvate.repository.gunho;

import org.springframework.data.jpa.repository.JpaRepository;
import salvate.entity.gunho.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
}
