package task.job.restApi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import task.job.restApi.model.Znamenitost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import task.job.restApi.service.ZnamenitostService;

import java.util.List;

@RestController
public class ZnamenitostController {
    @Autowired
    private ZnamenitostService znamenitostService;

    @GetMapping("/znamenitosti")
    public ResponseEntity<List<Znamenitost>> getAllZnamenitosti(){
        return ResponseEntity.ok().body(znamenitostService.getAllZnamenitosti());
    }
    @GetMapping("/znamenitosti/{id}")
    public ResponseEntity<Znamenitost> getZnamenitost(@PathVariable long id){
        return ResponseEntity.ok().body(znamenitostService.getZnamenitost(id));
    }
    @PostMapping("/znamenitosti")
    public ResponseEntity<Znamenitost> addZnamenitost(@RequestBody Znamenitost znamenitost){
        return ResponseEntity.ok().body(znamenitostService.createZnamenitost(znamenitost));
    }
    @DeleteMapping("/znamenitosti/{id}")
    public ResponseEntity<?> updateZnamenitost(@PathVariable long id){
        this.znamenitostService.deleteZnamenitost(id);
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
    }

}
