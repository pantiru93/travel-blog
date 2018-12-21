package ro.travelplan.travelblog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ro.travelplan.travelblog.models.City;

@Service
public interface CityService {
	List<City> findAll();
	List<City> findLatest5();
	City findById(Long id);
	City create(City city);
	City edit(City city);
	void deleteById(Long id);
}
