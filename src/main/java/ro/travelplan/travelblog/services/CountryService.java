package ro.travelplan.travelblog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ro.travelplan.travelblog.models.Country;

@Service
public interface CountryService {
	List<Country> findAll();
	List<Country> findLatest5();
	Country findById(Long id);
	Country create(Country country);
	Country edit(Country country);
	void deleteById(Long id);
}
