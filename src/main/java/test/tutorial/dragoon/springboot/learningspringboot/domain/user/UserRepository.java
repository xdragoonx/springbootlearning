package test.tutorial.dragoon.springboot.learningspringboot.domain.user;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, UUID> {
}
