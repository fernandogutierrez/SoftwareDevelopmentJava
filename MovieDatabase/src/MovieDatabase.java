import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class MovieDatabase {
	private ArrayList<Movie> movieList;
	private ArrayList<Actor> actorList;
	private String databaseMoviesActors;
	private String databaseRatings;
	
	public MovieDatabase() {
       this.movieList = new ArrayList<Movie>();
       this.actorList = new ArrayList<Actor>();
       this.databaseMoviesActors = "D:/movies.txt";
       this.databaseRatings = "D:/ratings.txt";	  
	}
	
	public ArrayList<Movie> getMovieList() {
		try {
			FileReader fileReader = new FileReader(new File(this.databaseMoviesActors));
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			ArrayList<Hashtable<String, ArrayList<String>>> actorMovies = new ArrayList<Hashtable<String, ArrayList<String>>>();
			while (true) {
				String line = bufferedReader.readLine();
				if( line == null || line.isEmpty())
				{
					break;
				}
				
				ArrayList<String> strLineSplitted = new ArrayList<String>(Arrays.asList(line.split(",")));
				Hashtable<String, ArrayList<String>> hashTable = new Hashtable<String, ArrayList<String>>();
				String actor = strLineSplitted.remove(0);
				hashTable.put(actor, strLineSplitted);
				actorMovies.add(hashTable);
			}
			fileReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return movieList;
	}

	public ArrayList<Actor> getActorList() {
		return actorList;
	}
	
	public void addMovie(String name, String[] actors){
		
	}
	
	public void addRating(String name, double rating) {
		
	}
	
	public void updateRating(String name, double newRating) {
		
	}
	
	public String getBestActor() {
		return "";
	} 
	
	public String getBestMovie() {
		return "";
	}
	
	public static void main(String[] args) {
		MovieDatabase mov = new MovieDatabase();
		ArrayList<Movie> actorMovies = mov.getMovieList();
		System.out.println("dddddddd");
	}
}
