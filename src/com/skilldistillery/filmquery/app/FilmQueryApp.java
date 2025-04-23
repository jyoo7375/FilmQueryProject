package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
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
			        System.out.println("=========================================");
			        System.out.println("              Film Details               ");
			        System.out.println("=========================================");
			        System.out.println("Title        : " + film.getTitle());
			        System.out.println("Description  : " + film.getDescription());
			        System.out.println("Release Year : " + film.getReleaseYear());
			        System.out.println("Rating       : " + film.getRating());
			        //User story 4
			        System.out.println("Language     : " + film.getLanguageName());
			        System.out.println("=========================================");
			        System.out.println("Casts:");
			        for (Actor actor : film.getActors()) {
			            System.out.println("- " + actor.getFirstName() + " " + actor.getLastName());
			        }
			        System.out.println("=========================================");
			        //goal 1
			        System.out.println("\nWhat would you like to do next?");
			        System.out.println("1. Return to main menu");
			        System.out.println("2. View all film details");
			        
			        int subChoice = input.nextInt();
			        input.nextLine();
			        
			        if(subChoice == 2) {
			        	System.out.println("+===============================================+");
			        	System.out.println("Rental Duration: " + film.getRentalDuration());
			        	System.out.println("Rental Rate: $" + film.getRentalRate());
			        	System.out.println("Length: " + film.getLength());
			        	System.out.println("Replacement Cost: $" + film.getReplacementCost());
			        	System.out.println("Special Features: " + film.getSpecialFeatures());
			        	System.out.println("+===============================================+");
			        	
			        }
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
			            System.out.println("=========================================");
			            System.out.println("              Film Details               ");
			            System.out.println("=========================================");
			            System.out.println("Title        : " + f.getTitle());
			            System.out.println("Description  : " + f.getDescription());
			            System.out.println("Release Year : " + f.getReleaseYear());
			            System.out.println("Rating       : " + f.getRating());
			            //User story 4
			            System.out.println("Language     : " + f.getLanguageName());
			            System.out.println("=========================================");
			            System.out.println("Casts:");
			            for (Actor actor : f.getActors()) {
			                System.out.println("- " + actor.getFirstName() + " " + actor.getLastName());
			            }
			            System.out.println("=========================================");
			            //goal 1
			            System.out.println("\nWhat would you like to do next?");
				        System.out.println("1. Return to main menu");
				        System.out.println("2. View all film details");
				        
				        int subChoice = input.nextInt();
				        input.nextLine();
				        
				        if(subChoice == 2) {
				        	System.out.println("+===============================================+");
				        	System.out.println("Rental Duration: " + f.getRentalDuration());
				        	System.out.println("Rental Rate: $" + f.getRentalRate());
				        	System.out.println("Length: " + f.getLength());
				        	System.out.println("Replacement Cost: $" + f.getReplacementCost());
				        	System.out.println("Special Features: " + f.getSpecialFeatures());
				        	System.out.println("+===============================================+");
				        	
				        }
				        break;
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
