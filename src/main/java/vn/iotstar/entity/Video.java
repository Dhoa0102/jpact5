package vn.iotstar.entity;

import java.io.Serializable;

import jakarta.persistence.*;
@Entity
@Table(name="videos")
@NamedQuery(name="Video.findAll",query="Select v from Video v")
public class Video implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="VideoId")
	private String videoId;
	@Column(name="Active")
	private boolean active;
	@Column(name="Description",columnDefinition="NVARCHAR(MAX) NOT NULL") 
	private String description;
	@Column(name="Poster")
	private String poster;
	@Column(name="Tittle",columnDefinition="NVARCHAR(200) NOT NULL") 
	private String tittle;
	@Column(name="Views")
	private int views;
	
	@ManyToOne
	@JoinColumn(name = "CategoryId")
	private Category category;

	public Video() {
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
