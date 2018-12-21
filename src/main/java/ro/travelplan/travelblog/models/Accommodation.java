package ro.travelplan.travelblog.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="accommodations")
public class Accommodation {
	
	public enum PriceRange {
		lowcost, mediumcost;
	}
	
	public enum RoomType {
		TwinRoom, DoubleRoom, TripleRoom, QuadRoom
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private boolean defaultAccommodation;
	
	private int price;
	
	@Enumerated(EnumType.ORDINAL)
	private PriceRange priceRange;
	
	private byte persons;
	
	@Enumerated(EnumType.ORDINAL)
	private RoomType roomType;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Trip trip;
	
	public Accommodation () { }

	public Accommodation(Long id, boolean defaultAccommodation, int price, PriceRange priceRange, byte persons,
			RoomType roomType, Trip trip) {
		this.id = id;
		this.defaultAccommodation = defaultAccommodation;
		this.price = price;
		this.priceRange = priceRange;
		this.persons = persons;
		this.roomType = roomType;
		this.trip = trip;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isDefaultAccommodation() {
		return defaultAccommodation;
	}

	public void setDefaultAccommodation(boolean defaultAccommodation) {
		this.defaultAccommodation = defaultAccommodation;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public PriceRange getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(PriceRange priceRange) {
		this.priceRange = priceRange;
	}

	public byte getPersons() {
		return persons;
	}

	public void setPersons(byte persons) {
		this.persons = persons;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	@Override
	public String toString() {
		return "Accommodation [id=" + id + ", defaultAccommodation=" + defaultAccommodation + ", price=" + price
				+ ", priceRange=" + priceRange + ", persons=" + persons + ", roomType=" + roomType + ", trip=" + trip
				+ "]";
	}
}
