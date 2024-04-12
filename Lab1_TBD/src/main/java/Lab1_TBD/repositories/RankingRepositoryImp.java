package Lab1_TBD.repositories;

import Lab1_TBD.entities.RankingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RankingRepositoryImp implements RankingRepository {
    @Autowired
    Sql2o sql2o;

    @Override
    public void save(RankingEntity rankingEntity) {
        String sql = "INSERT INTO ranking VALUES (:id, :level_ranking, :id_tarea, :id_voluntario)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).addParameter("id", rankingEntity.getId())
                    .addParameter("level_ranking", rankingEntity.getLevel_ranking())
                    .addParameter("id_tarea", rankingEntity.getId_tarea())
                    .addParameter("id_voluntario", rankingEntity.getId_voluntario())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<RankingEntity> findAll() {
        String sql = "SELECT * FROM ranking";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(RankingEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public RankingEntity findById(Long id) {
        String sql = "SELECT * FROM ranking WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(RankingEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM ranking WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
