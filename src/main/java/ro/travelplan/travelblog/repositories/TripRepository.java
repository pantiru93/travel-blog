package ro.travelplan.travelblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.travelplan.travelblog.models.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip,Long>{

}
