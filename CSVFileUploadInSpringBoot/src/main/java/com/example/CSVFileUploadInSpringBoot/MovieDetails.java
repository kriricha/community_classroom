package com.example.CSVFileUploadInSpringBoot;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class MovieDetails {

@Column(name="id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
@jakarta.persistence.Id
private int MovieID;
private String Title;
private String Genres;
public int getMovieID() {
	return MovieID;
}
public void setMovieID(int movieID) {
	MovieID = movieID;
}
public String getTitle() {
	return Title;
}
public void setTitle(String title) {
	Title = title;
}
public String getGenres() {
	return Genres;
}
public void setGenres(String genres) {
	Genres = genres;
}
public MovieDetails(int movieID, String title, String genres) {
	super();
	MovieID = movieID;
	Title = title;
	Genres = genres;
}
public MovieDetails() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "MovieDetails [MovieID=" + MovieID + ", Title=" + Title + ", Genres=" + Genres + ", getMovieID()="
			+ getMovieID() + ", getTitle()=" + getTitle() + ", getGenres()=" + getGenres() + ", getClass()="
			+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}


	

}
