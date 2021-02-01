package task.job.restApi.controller;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import task.job.restApi.model.Opcina;
import task.job.restApi.model.Rating;
import task.job.restApi.model.Znamenitost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import task.job.restApi.service.OpcinaService;
import task.job.restApi.service.RatingService;
import task.job.restApi.service.ZnamenitostService;

import java.util.List;

@RestController
public class ZnamenitostController {
    @Autowired
    private ZnamenitostService znamenitostService;
    @Autowired
    private RatingService ratingService;
    @Autowired
    private OpcinaService opcinaService;

    @GetMapping("/znamenitosti")
    public ResponseEntity<List<Znamenitost>> getAllZnamenitosti(){
        return ResponseEntity.ok().body(znamenitostService.getAllZnamenitosti());
    }
    @GetMapping("/znamenitosti/{znamenitostId}")
    public ResponseEntity<Znamenitost> getZnamenitost(@PathVariable long znamenitostId){
        return ResponseEntity.ok().body(znamenitostService.getZnamenitost(znamenitostId));
    }
    @GetMapping("/znamenitosti/{znamenitostId}/rating")
    public ResponseEntity<List<Rating>> getRatingsForZnamenitost(@PathVariable long znamenitostId){
        return ResponseEntity.ok().body(ratingService.getRatingsForZnamenitost(znamenitostId));
    }

    @PostMapping("/znamenitosti")
    public ResponseEntity<Znamenitost> addZnamenitost(@RequestBody Znamenitost znamenitost){
        return ResponseEntity.ok().body(znamenitostService.createZnamenitost(znamenitost));
    }
    @PostMapping("znamenitosti/{znamenitostId}/rating")
    public ResponseEntity<Rating> rateZnamenitost(@RequestBody Rating ocjena, @PathVariable long znamenitostId){
        Rating rating=new Rating();
        rating.setOcjena(ocjena.getOcjena());
        rating.setZnamenitostId(znamenitostId);
        return ResponseEntity.ok().body(this.ratingService.rateZnamenitost(rating));
    }

    @DeleteMapping("/znamenitosti/{id}")
    public void deleteZnamenitost(@PathVariable long id){
        this.znamenitostService.deleteZnamenitost(id);

    }




    /** opcina controller */

    @GetMapping("/opcina")
    public ResponseEntity<List<Opcina>> getAllOpcine(){
        return ResponseEntity.ok().body(this.opcinaService.getAllOpcine());
    }

    @PostMapping("/opcina")
    public ResponseEntity<Opcina> addOpcina(@RequestBody Opcina opcina){
        return ResponseEntity.ok().body(this.opcinaService.addOpcina(opcina));
    }


    /**@DeleteMapping("/znamenitosti/{id}")
    public ResponseEntity<?> updateZnamenitost(@PathVariable long id){
        this.znamenitostService.deleteZnamenitost(id);
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
    }*/

}
