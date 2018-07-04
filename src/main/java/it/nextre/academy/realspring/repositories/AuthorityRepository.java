package it.nextre.academy.realspring.repositories;

import it.nextre.academy.realspring.entities.Authority;
import it.nextre.academy.realspring.models.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(AuthorityName name);

}//end class
