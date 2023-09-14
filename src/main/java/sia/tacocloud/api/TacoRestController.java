package sia.tacocloud.api;

// After adding Spring Data REST to the build, this class became obsolete. Keep for reference

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sia.tacocloud.Taco;
import sia.tacocloud.data.TacoRepository;

import java.util.Optional;

//@RestController
//@RequestMapping(path = "/api/tacos", produces = "application/json")
//@CrossOrigin(origins = "http://tacocloud:8080")
public class TacoRestController {
//    private final TacoRepository tacoRepository;
//
//    public TacoRestController(TacoRepository tacoRepository) {
//        this.tacoRepository = tacoRepository;
//    }
//
//    @GetMapping(params = "recent")
//    public Iterable<Taco> recentTacos() {
//        PageRequest pageRequest = PageRequest.of(0, 12, Sort.by("createdAt").descending());
//
//        return tacoRepository.findAll(pageRequest).getContent();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
//        Optional<Taco> optionalTaco = tacoRepository.findById(id);
//
//        return optionalTaco.map(taco -> new ResponseEntity<>(taco, HttpStatus.OK))
//                           .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
//    }
//
//    @PostMapping(consumes = "application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Taco postTaco(@RequestBody Taco taco) {
//        return tacoRepository.save(taco);
//    }

}
