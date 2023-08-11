package br.com.northwest.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.northwest.hrworker.entities.Worker;
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
