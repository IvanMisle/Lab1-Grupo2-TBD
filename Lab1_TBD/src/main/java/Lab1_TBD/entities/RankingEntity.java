package Lab1_TBD.entities;

public class RankingEntity {
    private Long id;
    private Integer level_ranking;
    private Long id_tarea;
    private Long id_voluntario;

    //Constructores
    public RankingEntity() {
    }

    public RankingEntity(Long id, Integer level_ranking, Long id_tarea, Long id_voluntario) {
        this.id = id;
        this.level_ranking = level_ranking;
        this.id_tarea = id_tarea;
        this.id_voluntario = id_voluntario;
    }

    //Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_voluntario() {
        return id_voluntario;
    }

    public void setId_voluntario(Long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public Long getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(Long id_tarea) {
        this.id_tarea = id_tarea;
    }

    public Integer getLevel_ranking() {
        return level_ranking;
    }

    public void setLevel_ranking(Integer nivel_ranking) {
        this.level_ranking = nivel_ranking;
    }
}