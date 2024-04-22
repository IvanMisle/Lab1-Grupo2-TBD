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
    public RankingEntity save(RankingEntity rankingEntity) {
        String sql = "INSERT INTO ranking VALUES (:id, :id_task, :id_volunteer, :level_ranking)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).addParameter("id", rankingEntity.getId())
                    .addParameter("level_ranking", rankingEntity.getLevel_ranking())
                    .addParameter("id_task", rankingEntity.getId_task())
                    .addParameter("id_volunteer", rankingEntity.getId_volunteer())
                    .executeUpdate();
            return rankingEntity;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
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
    public boolean deleteById(Long id) {
        String sql = "DELETE FROM ranking WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public RankingEntity update(RankingEntity rankingEntity) {
        String sql = "UPDATE ranking " +
                "SET level_ranking = :level_ranking, id_task = :id_task, id_volunteer = :id_volunteer" +
                " WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("level_ranking", rankingEntity.getLevel_ranking())
                    .addParameter("id_task", rankingEntity.getId_task())
                    .addParameter("id_volunteer", rankingEntity.getId_volunteer())
                    .addParameter("id", rankingEntity.getId())
                    .executeUpdate();
            return rankingEntity;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Integer getMaxId() {
        String sql = "SELECT id FROM ranking r ORDER BY id DESC LIMIT 1";
        try (Connection con = sql2o.open()){
            Integer value = con.createQuery(sql).executeScalar(Integer.class);
            if (value == null){
                return 0;
            }
            return value;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
