package ro.travelplan.travelblog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ro.travelplan.travelblog.models.Country;
import ro.travelplan.travelblog.repositories.CountryRepository;

@Service
@Primary
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	public List<Country> findAll(){
		return this.countryRepository.findAll();
	}
	
	@Override
	public Country findById(Long id) {
		return this.countryRepository.findById(id).get();
	}

	@Override
	public Country create(Country country) {
		return this.countryRepository.save(country);
	}

	@Override
	public Country edit(Country country) {
		return this.countryRepository.save(country);
	}

	@Override
	public void deleteById(Long id) {
		this.countryRepository.deleteById(id);
	}

	@Override
	public List<Country> findLatest5() {
		// TODO Auto-generated method stub
		return null;
	}
}
