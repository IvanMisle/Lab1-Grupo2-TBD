package Lab1_TBD.entities;

public class RankingEntity {
    private Long id;
    private Integer level_ranking;
    private Long id_task;
    private Long id_volunteer;

    //Constructores
    public RankingEntity() {
    }

    public RankingEntity(Long id, Long id_task, Long id_volunteer, Integer level_ranking) {
        this.id = id;
        this.id_task = id_task;
        this.id_volunteer = id_volunteer;
        this.level_ranking = level_ranking;
    }

    //Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevel_ranking() {
        return level_ranking;
    }

    public void setLevel_ranking(Integer level_ranking) {
        this.level_ranking = level_ranking;
    }

    public Long getId_task() {
        return id_task;
    }

    public void setId_task(Long id_task) {
        this.id_task = id_task;
    }

    public Long getId_volunteer() {
        return id_volunteer;
    }

    public void setId_volunteer(Long id_volunteer) {
        this.id_volunteer = id_volunteer;
    }
}