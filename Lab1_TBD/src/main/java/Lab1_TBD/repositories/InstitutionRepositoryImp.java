package Lab1_TBD.repositories;

import Lab1_TBD.entities.InstitutionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class InstitutionRepositoryImp implements InstitutionRepository {
    @Autowired
    Sql2o sql2o;

    @Override
    public InstitutionEntity save(InstitutionEntity institutionEntity) {
        String sql = "INSERT INTO institution VALUES (:id, :name)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).addParameter("id", institutionEntity.getId())
                    .addParameter("name", institutionEntity.getName())
                    .executeUpdate();
            return institutionEntity;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<InstitutionEntity> findAll() {
        String sql = "SELECT * FROM institution";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(InstitutionEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public InstitutionEntity findById(Long id) {
        String sql = "SELECT * FROM institution WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(InstitutionEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        String sql = "DELETE FROM institution WHERE id = :id";
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
    public InstitutionEntity update(InstitutionEntity institutionEntity) {
        String sql = "UPDATE institution SET name = :name WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", institutionEntity.getName())
                    .addParameter("id", institutionEntity.getId())
                    .executeUpdate();
            return institutionEntity;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
