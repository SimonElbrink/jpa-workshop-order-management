package se.lexicon.simon.jpaworkshopordermanagement.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.simon.jpaworkshopordermanagement.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUser,Integer> {

    List<AppUser> findAll();

    Optional<AppUser> findByEmailIgnoreCase(String email);
}
