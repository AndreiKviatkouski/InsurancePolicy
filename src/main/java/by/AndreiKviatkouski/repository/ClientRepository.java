package by.AndreiKviatkouski.repository;

import by.AndreiKviatkouski.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {
    
    boolean existsByPhone(String phone);

}
