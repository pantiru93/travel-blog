package ro.travelplan.travelblog.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="trips")
public class Trip {
	
	public enum TripType {
		article, trip;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private boolean defaultTrip;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private TripType tripType;
	
	@Column(nullable = false)
	private Date checkin;
	
	@Column(nullable = false)
	private Date checkout;
	
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	private City originCity;
	
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	private City destinationCity;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Post post;
		
	@OneToMany(mappedBy = "trip")
	private Set<Flight> flights = new HashSet<Flight>();
	
	@OneToMany(mappedBy = "trip")
	private Set<Accommodation> accommodations = new HashSet<Accommodation>();
	
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date createdDate;
	
	@UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date updatedDate;
	
	public Trip () { }

	public Trip(Long id, boolean defaultTrip, TripType tripType, Date checkin, Date checkout, City originCity,
			City destinationCity, Post post, Set<Flight> flights, Set<Accommodation> accommodations, Date createdDate,
			Date updatedDate) {
		this.id = id;
		this.defaultTrip = defaultTrip;
		this.tripType = tripType;
		this.checkin = checkin;
		this.checkout = checkout;
		this.originCity = originCity;
		this.destinationCity = destinationCity;
		this.post = post;
		this.flights = flights;
		this.accommodations = accommodations;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isDefaultTrip() {
		return defaultTrip;
	}

	public void setDefaultTrip(boolean defaultTrip) {
		this.defaultTrip = defaultTrip;
	}

	public TripType getTripType() {
		return tripType;
	}

	public void setTripType(TripType tripType) {
		this.tripType = tripType;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public City getOriginCity() {
		return originCity;
	}

	public void setOriginCity(City originCity) {
		this.originCity = originCity;
	}

	public City getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(City destinationCity) {
		this.destinationCity = destinationCity;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}

	public Set<Accommodation> getAccommodations() {
		return accommodations;
	}

	public void setAccommodations(Set<Accommodation> accommodations) {
		this.accommodations = accommodations;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", defaultTrip=" + defaultTrip + ", tripType=" + tripType + ", checkin=" + checkin
				+ ", checkout=" + checkout + ", originCity=" + originCity + ", destinationCity=" + destinationCity
				+ ", post=" + post + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
}
