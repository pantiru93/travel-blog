package ro.travelplan.travelblog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ro.travelplan.travelblog.models.Accommodation;

@Service
public interface AccommodationService {
	List<Accommodation> findAll();
	List<Accommodation> findLatest5();
	Accommodation findById(Long id);
	Accommodation create(Accommodation accommodation);
	Accommodation edit(Accommodation accommodation);
	void deleteById(Long id);
}
