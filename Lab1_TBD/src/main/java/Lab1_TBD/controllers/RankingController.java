package Lab1_TBD.controllers;

import Lab1_TBD.entities.RankingEntity;
import Lab1_TBD.services.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/ranking")
public class RankingController {
    @Autowired
    private RankingService rankingService;

    @GetMapping("/{id}")
    public ResponseEntity<RankingEntity> getRanking(@PathVariable Long id) {
        RankingEntity ranking = rankingService.getById(id);
        return ResponseEntity.ok(ranking);
    }

    @GetMapping("/")
    public ResponseEntity<List<RankingEntity>> getAllRanking() {
        List<RankingEntity> rankings = rankingService.getAll();
        return ResponseEntity.ok(rankings);
    }

    @PostMapping("/")
    public void addRanking(@RequestBody RankingEntity ranking) {
        rankingService.save(ranking);
    }

    @DeleteMapping("/{id}")
    public void deleteRanking(@PathVariable Long id) {
        rankingService.delete(id);
    }
}
