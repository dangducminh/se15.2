package vnu.hus.min.se152.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vnu.hus.min.se152.model.User;

/**
 * @author Minh Dang
 * @created 21/11/2023 - 12:07 AM
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
