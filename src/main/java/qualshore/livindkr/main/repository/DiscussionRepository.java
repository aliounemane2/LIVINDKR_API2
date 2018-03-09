package qualshore.livindkr.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import qualshore.livindkr.main.entities.Message;
import qualshore.livindkr.main.entities.User;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created by User on 14/02/2018.
 */
public interface DiscussionRepository extends JpaRepository<Message, Integer> {

  @Async
  @Query("select m from Message m where m.idEnvoyeur.idUser=:id OR m.idReceveur.idUser=:id order by m.dateMessage asc ")
  CompletableFuture<List<Message>> findTopByIdEnvoyeur(@Param("id") Integer IdEnvoyeur);
}
