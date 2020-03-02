package com.app.fogether.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_images")
public class UserImage {

	@Transient
	public static final String SEQUENCE_NAME = "images_sequence";

	@Id
	private Long id;
	private Long uploadTime;
	private String imageLocation;
	private String description;
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserImage(Long id, Long uploadTime, String imageLocation, String description, Long userId) {
		this.id = id;
		this.uploadTime = uploadTime;
		this.imageLocation = imageLocation;
		this.description = description;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Long uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

}
