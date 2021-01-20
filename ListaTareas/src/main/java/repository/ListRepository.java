package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.ListBD;

public interface ListRepository extends JpaRepository<ListBD, Long>{

}
