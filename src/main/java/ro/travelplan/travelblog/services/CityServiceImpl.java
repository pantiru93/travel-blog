package ro.travelplan.travelblog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ro.travelplan.travelblog.models.City;
import ro.travelplan.travelblog.repositories.CityRepository;

@Service
@Primary
public class CityServiceImpl implements CityService{

	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public List<City> findAll(){
		return this.cityRepository.findAll();
	}
	
	@Override
	public City findById(Long id) {
		return this.cityRepository.findById(id).get();
	}

	@Override
	public City create(City city) {
		return this.cityRepository.save(city);
	}

	@Override
	public City edit(City city) {
		return this.cityRepository.save(city);
	}

	@Override
	public void deleteById(Long id) {
		this.cityRepository.deleteById(id);
	}

	@Override
	public List<City> findLatest5() {
		// TODO Auto-generated method stub
		return null;
	}
}
