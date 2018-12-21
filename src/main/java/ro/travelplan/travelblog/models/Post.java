package ro.travelplan.travelblog.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

//import ro.travelplan.travelblog.enums.PostType;

@Entity
@Table(name="posts")
public class Post {
	
	public enum PostType {
		article, trip;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.ORDINAL)
	private PostType postType;
	
    @Column(nullable = false, length = 300)
    @NotBlank (message = "Title is required.")
	private String title;
    
    @Lob @Column(nullable = false)
    @NotBlank (message = "Body is required.")
	private String body;
    
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
	private Date createdDate = new Date();
	
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date updatedDate = new Date();
	
	@OneToMany(mappedBy = "post")
	private Set<Trip> trips = new HashSet<Trip>();
	
	public Post () { }
	
	public Post(Long id, PostType postType, @NotBlank(message = "Title is required.") String title,
			@NotBlank(message = "Body is required.") String body, Date createdDate, Date updatedDate, Set<Trip> trips) {
		this.id = id;
		this.postType = postType;
		this.title = title;
		this.body = body;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.trips = trips;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PostType getPostType() {
		return postType;
	}

	public void setPostType(PostType postType) {
		this.postType = postType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
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

	public Set<Trip> getTrips() {
		return trips;
	}

	public void setTrips(Set<Trip> trips) {
		this.trips = trips;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", postType=" + postType + ", title=" + title + ", body=" + body + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + "]";
	}
}
