package ro.travelplan.travelblog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ro.travelplan.travelblog.models.Trip;
import ro.travelplan.travelblog.repositories.TripRepository;

@Service
@Primary
public class TripServiceImpl implements TripService {

	@Autowired
	private TripRepository tripRepository;
	
	@Override
	public List<Trip> findAll(){
		return this.tripRepository.findAll();
	}
	
	@Override
	public Trip findById(Long id) {
		return this.tripRepository.findById(id).get();
	}
	
	@Override
	public Trip create(Trip trip) {
		return this.tripRepository.save(trip);
	}
	
	@Override
	public Trip edit(Trip trip) {
		return this.tripRepository.save(trip);
	}
	
	@Override
	public void deleteById(Long id) {
		this.tripRepository.deleteById(id);
	}
}
