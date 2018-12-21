package ro.travelplan.travelblog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ro.travelplan.travelblog.models.Flight;
import ro.travelplan.travelblog.repositories.FlightRepository;

@Service
@Primary
public class FlightServiceImpl implements FlightService{

	@Autowired
	private FlightRepository flightRepository;
	
	@Override
	public List<Flight> findAll(){
		return this.flightRepository.findAll();
	}
	
	@Override
	public Flight findById(Long id) {
		return this.flightRepository.findById(id).get();
	}

	@Override
	public Flight create(Flight flight) {
		return this.flightRepository.save(flight);
	}

	@Override
	public Flight edit(Flight flight) {
		return this.flightRepository.save(flight);
	}

	@Override
	public void deleteById(Long id) {
		this.flightRepository.deleteById(id);
	}

	@Override
	public List<Flight> findLatest5() {
		// TODO Auto-generated method stub
		return null;
	}
}
