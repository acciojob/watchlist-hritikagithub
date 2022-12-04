package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Component
public class MovieRepository {

     private Map<String,Movie> movies ;
    private Map<String,Director> directors ;
    private Map<String,List<String>> directorMoviesMapping ;

    public MovieRepository() {
        this.movies = new HashMap<>();
        this.directors = new HashMap<>();
        this.directorMoviesMapping =  new HashMap<>();
    }

    public void addMovies(Movie movie){

        movies.put(movie.getName(), movie);
    }
    public  void addDirector(Director director){

        directors.put(director.getName(), director);
    }

    public void saveMovieDirectorPair(String movie, String director){
        if(movies.containsKey(movie) && directors.containsKey(director)){
            movies.put(movie, movies.get(movie));
            directors.put(director, directors.get(director));
            List<String> currentMovies = new ArrayList<String>();
            if(directorMoviesMapping.containsKey(director)) currentMovies = directorMoviesMapping.get(director);
            currentMovies.add(movie);
            directorMoviesMapping.put(director, currentMovies);
        }
    }

    public Movie findMovie(String movie){
        //here we dont make list because we are finding movie by particular name
           return movies.get(movie);
    }
    public Director findDirector(String director){
        //here we dont make list because we are finding movie by particular name
        return directors.get(director);
    }

    public  List<String> findMoviesFromDirector(String director){
        List<String> moviesList = new ArrayList<>();
        if(directorMoviesMapping.containsKey(director)){
         moviesList = directorMoviesMapping.get(director);
        }
        return moviesList;
    }
    public List<String> findAllMovies(){
        return new ArrayList<>(movies.keySet());
    }

    public void deleteDirector(String director){
        List<String> movieslist = new ArrayList<>();
        if(directorMoviesMapping.containsKey(director)){
            movieslist = directorMoviesMapping.get(director);
            for(String movie : movieslist){
                if(movies.containsKey(movie)){
                    movies.remove(movie);
                }
            }
            directorMoviesMapping.remove(director);
        }
        if(directors.containsKey(director)){
            directors.remove(director);
        }
    }

    public void deleteAllDirector(){
        HashSet<String> movieSet = new HashSet<>();
        for(String director : directorMoviesMapping.keySet()){
            for(String movie : directorMoviesMapping.keySet()){
                movieSet.add(movie);
            }
        }
        for(String movie : movieSet){
            if(movies.containsKey(movie)){
                movies.remove(movie);
            }
        }
    }
}
