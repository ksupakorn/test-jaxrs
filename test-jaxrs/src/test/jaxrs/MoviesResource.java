package test.jaxrs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;





@Path("movies") 
public class MoviesResource { 
 
    private static Map<Long, Movie> moviesDB = new HashMap<>(); 
 
    static { 
        moviesDB.put(11L, new Movie(11, "Beauty and the Beast")); 
        moviesDB.put(12L, new Movie(12, "Suicide Squade")); 
    } 
 
    public MoviesResource() { 
    } 
 
    @GET 
    @Path("/{id}") 
    @Produces(MediaType.APPLICATION_JSON) 
    public Movie getById(@PathParam("id") long id) { 
        return moviesDB.get(id); 
    } 
  
    @GET 
    @Produces(MediaType.APPLICATION_JSON) 
    public Collection<Movie> listMovies() { 
        return moviesDB.values(); 
    } 
    
    @POST 
    @Consumes(MediaType.APPLICATION_JSON) 
    public void addMovie(Movie movie) { 
        if (moviesDB.containsKey(movie.getId())) { 
            throw new RuntimeException("A movie with such id already exists!"); 
        } 
        moviesDB.put(movie.getId(), movie); 
    }   
    
    @POST 
    @Path("new") 
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMovieNew(Movie movie) { 
    	
    	String RESPONSE_CONTENT = "";
        if (moviesDB.containsKey(movie.getId())) {
            RESPONSE_CONTENT = "A movie with such id already exists!";
            return Response.ok(RESPONSE_CONTENT).build();
        } 
        moviesDB.put(movie.getId(), movie); 
        RESPONSE_CONTENT = "Add new moview success";
        return Response.ok(RESPONSE_CONTENT).build(); 
        
        
        //Response.status(STATUS_CODE).entity(RESPONSE_CONTENT).build(); 
        //Response.status(STATUS_CODE).entity(RESPONSE_CONTENT).build(); 
    }     
    
}