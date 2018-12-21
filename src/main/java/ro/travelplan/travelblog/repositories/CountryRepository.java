package ro.travelplan.travelblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.travelplan.travelblog.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long>{

}
