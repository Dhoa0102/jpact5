package vn.iotstar.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name="videos")
@NamedQuery(name="Video.findAll",query="Select v from Video v")
public class Video implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="VideoId")
	private int videoId;
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

	public boolean isActive() {
		return active;
	}
	
}
