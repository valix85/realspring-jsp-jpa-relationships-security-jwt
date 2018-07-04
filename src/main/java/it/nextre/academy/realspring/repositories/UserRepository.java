package it.nextre.academy.realspring.repositories;

import it.nextre.academy.realspring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);

}//end class
