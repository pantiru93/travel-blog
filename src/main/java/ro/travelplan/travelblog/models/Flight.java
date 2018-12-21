package ro.travelplan.travelblog.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="flights")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int price;
	
	private boolean flyhacksGuarantee;
	
	private boolean defaultFlight;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Trip trip;
	
	public Flight () { }

	public Flight(Long id, int price, boolean flyhacksGuarantee, boolean defaultFlight, Trip trip) {
		this.id = id;
		this.price = price;
		this.flyhacksGuarantee = flyhacksGuarantee;
		this.defaultFlight = defaultFlight;
		this.trip = trip;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isFlyhacksGuarantee() {
		return flyhacksGuarantee;
	}

	public void setFlyhacksGuarantee(boolean flyhacksGuarantee) {
		this.flyhacksGuarantee = flyhacksGuarantee;
	}

	public boolean isDefaultFlight() {
		return defaultFlight;
	}

	public void setDefaultFlight(boolean defaultFlight) {
		this.defaultFlight = defaultFlight;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", price=" + price + ", flyhacksGuarantee=" + flyhacksGuarantee + ", defaultFlight="
				+ defaultFlight + ", trip=" + trip + "]";
	}
}





































