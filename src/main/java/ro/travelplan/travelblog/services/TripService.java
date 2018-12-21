package ro.travelplan.travelblog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ro.travelplan.travelblog.models.Trip;

@Service
public interface TripService {
	List<Trip> findAll();
	Trip findById(Long id);
	Trip create(Trip trip);
	Trip edit(Trip trip);
	void deleteById(Long id);
}
