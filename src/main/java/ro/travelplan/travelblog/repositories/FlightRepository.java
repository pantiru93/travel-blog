package ro.travelplan.travelblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.travelplan.travelblog.models.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long>{

}
