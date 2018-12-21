package ro.travelplan.travelblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.travelplan.travelblog.models.City;

@Repository
public interface CityRepository extends JpaRepository<City,Long>{

}
