package Lab1_TBD.controllers;

import Lab1_TBD.entities.RankingEntity;
import Lab1_TBD.services.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/ranking")
@CrossOrigin("*")
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
    public ResponseEntity<RankingEntity> addRanking(@RequestBody RankingEntity ranking) {
        RankingEntity newRanking = rankingService.save(ranking);
        return ResponseEntity.ok(newRanking);
    }
    @PostMapping("/addRankingsByIdTask/{id_task}")
    public ResponseEntity<List<RankingEntity>> addRankingsByIdTask(@PathVariable Long id_task){
        List<RankingEntity> newRanking = rankingService.addRankingsByIdTask(id_task);
        return ResponseEntity.ok(newRanking);
    }



    @PutMapping("/")
    public ResponseEntity<RankingEntity> updateRanking(@RequestBody RankingEntity ranking) {
        RankingEntity newRanking = rankingService.update(ranking);
        return ResponseEntity.ok(newRanking);
    }

    @DeleteMapping("/{id}")
    public boolean deleteRanking(@PathVariable Long id) {
        return rankingService.delete(id);
    }
}
