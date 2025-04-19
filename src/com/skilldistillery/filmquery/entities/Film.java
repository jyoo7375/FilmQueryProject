package com.skilldistillery.filmquery.entities;

public class Film {
	


	//FIELDs
	private int id;
	private String title;
	private String description;
	private int releaseYear;
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	
	//no-arg ctor
	
	public Film() {
		super();
		
	}
	
	//getters and setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getReleaseYear() {
		return releaseYear;
	}
	
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	public int getLanguageId() {
		return languageId;
	}
	
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	
	public int getRentalDuration() {
		return rentalDuration;
	}
	
	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	
	public double getRentalRate() {
		return rentalRate;
	}
	
	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public double getReplacementCost() {
		return replacementCost;
	}
	
	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}
	
	public String getRating() {
		return rating;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public String getSpecialFeatures() {
		return specialFeatures;
	}
	
	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}
	
	
	//to String
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film [id=").append(id).append(", title=").append(title).append(", description=")
		.append(description).append(", releaseYear=").append(releaseYear).append(", languageId=")
		.append(languageId).append(", rentalDuration=").append(rentalDuration).append(", rentalRate=")
		.append(rentalRate).append(", length=").append(length).append(", replacementCost=")
		.append(replacementCost).append(", rating=").append(rating).append(", specialFeatures=")
		.append(specialFeatures).append("]");
		return builder.toString();
	}
	
	
}
