package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
  
  DatabaseAccessor db = new DatabaseAccessorObject();

  public static void main(String[] args) {
    FilmQueryApp app = new FilmQueryApp();
    //app.test();
    app.launch();
  }

  private void test() {
    Film film = db.findFilmById(1);
    System.out.println(film);
  }

  private void launch() {
    Scanner input = new Scanner(System.in);
    
    startUserInterface(input);
    
    input.close();
  }

  private void startUserInterface(Scanner input) {
	  boolean exit = false;
	  
	  //user Story 1
	  while(exit != true) {
		  System.out.println("+-----------------------------+");
		  System.out.println("|       Film Query Menu       |");
		  System.out.println("|-----------------------------|");
		  System.out.println("+-----------------------------+");
		  System.out.println("|1. Look up films by ID       |");
		  System.out.println("|2. Look up films by keyword: |");
		  System.out.println("|3. Exit the application|     |");
		  System.out.println("+-----------------------------+");
		  System.out.println("Enter your choice (1 - 3): ");
	  
		  int choice = input.nextInt();
		  input.nextLine();
	  
		  switch(choice) {
		  //user Story 2
		  case 1:
			  System.out.println("Enter film Id: ");
			  int filmId = input.nextInt();
			  input.nextLine();
			  
			  Film film = db.findFilmById(filmId);
			  
			  if(film == null) {
				  System.out.println("There are no films with that ID");
			  } else {
				  System.out.println("Film Title: " + film.getTitle());
				  System.out.println("Film Description: " + film.getDescription());
				  System.out.println("Release Year: " + film.getReleaseYear());
				  System.out.println("Rating: " + film.getRating());
				  //user Story 4
				  System.out.println("Language: " + film.getLanguageName());
				  
			  }
			  break;
		  //user Story 3
		  case 2:
			  System.out.println("Enter a keyword: ");
			  String filmKeyword = input.nextLine();
			  
			  List<Film> films = db.findFilmByKeyword(filmKeyword);
			  
			  if(films == null || films.isEmpty()) {
				  System.out.println("There are no films with that keyword");
			  } else {
				  for (Film f : films) {
					  System.out.println("Film Title: " + f.getTitle());
					  System.out.println("Film Description: " + f.getDescription());
					  System.out.println("Release Year: " + f.getReleaseYear());
					  System.out.println("Rating: " + f.getRating());
					  //user Story 4
					  System.out.println("Language: " + f.getLanguageName());
					  
					  
				  }
			  }
			  break;
			  
			  
		  case 3:
			  exit = true;
			  break;
		  
		  default:
			  System.out.println("Invalid input please try again.");
		
		  
		  
	  }
	  
	  
	  }
    
  }

}
