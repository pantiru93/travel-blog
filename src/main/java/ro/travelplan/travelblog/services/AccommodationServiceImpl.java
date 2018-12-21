package ro.travelplan.travelblog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ro.travelplan.travelblog.models.Accommodation;
import ro.travelplan.travelblog.repositories.AccommodationRepository;

@Service
@Primary
public class AccommodationServiceImpl implements AccommodationService{

	@Autowired
	private AccommodationRepository accommodationRepository;
	
	@Override
	public List<Accommodation> findAll(){
		return this.accommodationRepository.findAll();
	}
	
	@Override
	public Accommodation findById(Long id) {
		return this.accommodationRepository.findById(id).get();
	}

	@Override
	public Accommodation create(Accommodation accommodation) {
		return this.accommodationRepository.save(accommodation);
	}

	@Override
	public Accommodation edit(Accommodation accommodation) {
		return this.accommodationRepository.save(accommodation);
	}

	@Override
	public void deleteById(Long id) {
		this.accommodationRepository.deleteById(id);
	}

	@Override
	public List<Accommodation> findLatest5() {
		// TODO Auto-generated method stub
		return null;
	}
}
