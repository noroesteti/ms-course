package br.com.northwest.hrworker.resources;

import br.com.northwest.hrworker.repositories.WorkerRepository;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.northwest.hrworker.entities.Worker;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value= "/workers")
public class WorkerResource {
    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = workerRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Worker> findWorker(@PathVariable Long id){
        Worker worker = workerRepository.findById(id).get();
        return ResponseEntity.ok(worker);

    }

    @PostMapping
    public ResponseEntity<Worker> updateWorker(@RequestBody Worker request){
        Worker worker = workerRepository.save(request);
        return ResponseEntity.accepted().body(worker);
    }

}
