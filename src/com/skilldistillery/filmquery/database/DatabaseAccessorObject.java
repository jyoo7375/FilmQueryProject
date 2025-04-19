package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";
	private static final String USER = "student";
	private static final String PASS = "student";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
  @Override
  public Film findFilmById(int filmId) {
	  Film foundFilm = null;
	  try {
		Connection conn = DriverManager.getConnection(URL, USER, PASS);
		
		String sql = "SELECT * FROM film WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			foundFilm = new Film();
			
			foundFilm.setId(rs.getInt("id"));
			foundFilm.setTitle(rs.getString("title"));
			foundFilm.setDescription(rs.getString("description"));
			foundFilm.setReleaseYear(rs.getInt("release_year"));
			foundFilm.setLanguageId(rs.getInt("language_id"));
			foundFilm.setRentalDuration(rs.getInt("rental_duration"));
			foundFilm.setRentalRate(rs.getDouble("rental_rate"));
			foundFilm.setLength(rs.getInt("length"));
			foundFilm.setReplacementCost(rs.getDouble("replacement_cost"));
			foundFilm.setRating(rs.getString("rating"));
			foundFilm.setSpecialFeatures(rs.getString("special_features"));
			
			
			
			
			return foundFilm;
		}
		conn.close();
		stmt.close();
		rs.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  
    return null;
  }

 @Override
  public Actor findActorById(int actorId) {
	 Actor foundActor = null;
	try {
		Connection conn = DriverManager.getConnection(URL, USER, PASS);
		
		String sql = "SELECT * FROM Actor WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, actorId);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			foundActor = new Actor();
			foundActor.setId(rs.getInt("id"));
			foundActor.setFirstName(rs.getString("first_name"));
			foundActor.setLastName(rs.getString("last_name"));
			
			return foundActor;
		}
		
		conn.close();
		stmt.close();
		rs.close();

	} catch (SQLException e) {
		e.printStackTrace();
	}

	return null;
}

  @Override
  public List<Actor> findActorsByFilmId(int filmId) {
	  List<Actor> foundActor = new ArrayList();
	  
	try {
		Connection conn = DriverManager.getConnection(URL, USER, PASS);
		
		String sql = "Select * From Actor JOIN film_actor ON actor.id = film_actor.actor_id Where film_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			Actor actor = new Actor();
			actor.setId(rs.getInt("id"));
			actor.setFirstName(rs.getString("first_name"));
			actor.setLastName(rs.getString("last_name"));
			foundActor.add(actor);
			
			return foundActor;
			
			
		}
		
		conn.close();
		stmt.close();
		rs.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  
	return foundActor;
}

}
