package ro.travelplan.travelblog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ro.travelplan.travelblog.models.Flight;

@Service
public interface FlightService {
	List<Flight> findAll();
	List<Flight> findLatest5();
	Flight findById(Long id);
	Flight create(Flight flight);
	Flight edit(Flight flight);
	void deleteById(Long id);
}
