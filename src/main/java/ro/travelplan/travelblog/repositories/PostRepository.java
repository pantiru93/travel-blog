package ro.travelplan.travelblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.travelplan.travelblog.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>{

}
