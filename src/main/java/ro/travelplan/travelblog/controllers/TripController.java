package ro.travelplan.travelblog.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ro.travelplan.travelblog.models.City;
import ro.travelplan.travelblog.models.Trip;
import ro.travelplan.travelblog.services.CityService;
import ro.travelplan.travelblog.services.TripService;

@Controller
public class TripController {
	@Autowired
	private TripService tripService;
	@Autowired
	private CityService cityService;
	
	@RequestMapping("/trips")
	public String index(Model model) {
		List<Trip> latest5Trips = tripService.findAll();
		model.addAttribute("latest5trips",latest5Trips);
		return "trip/index";
	}
	
	@RequestMapping("/trip/{id}")
	public String trip(@PathVariable(value = "id") long id, Model model) {
		Trip trip = tripService.findById(id);
		model.addAttribute("trip", trip);
		return "trip/view";
	}
	
	@GetMapping("/trip/create")
    public String showTripCreateForm(Trip trip, Model model) {
		
		List<Trip.TripType> tripTypes = Arrays.asList(Trip.TripType.values());
		List<City> cities = cityService.findAll();
		
		model.addAttribute("tripTypes", tripTypes);
		model.addAttribute("cities", cities);
		
        return "trip/create";
    }
	
	@PostMapping("/trip/create")
	public String addTrip(@Valid Trip trip, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Trip.TripType> tripTypes = Arrays.asList(Trip.TripType.values());
			
			model.addAttribute("tripTypes", tripTypes);
			return "trip/create";
		}

		tripService.create(trip);
		return "redirect:/trip/" + trip.getId();
	}
	
	@GetMapping("/trip/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Trip trip = tripService.findById(id);
		if (trip == null) {
			throw new IllegalArgumentException("Invalid trip id: " + id);
		}
		List<Trip.TripType> tripTypes = Arrays.asList(Trip.TripType.values());
		
		model.addAttribute("tripTypes", tripTypes);
		
		model.addAttribute("trip", trip);
		return "trip/edit";
	}
	
	@PostMapping("/trip/edit/{id}")
	public String updateTrip(@PathVariable("id") long id, @Valid Trip trip, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        trip.setId(id);
	        return "trip/edit";
	    }
	         
	    tripService.create(trip);
	    return "redirect:/trip/" + trip.getId();
	}
}
