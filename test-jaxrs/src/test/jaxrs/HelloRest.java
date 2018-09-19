package test.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/hello") 
public class HelloRest { 
 

    @GET 
    public String test() { 
        return "Welcome to your first rest service!"; 
    } 
    
    @Path("/path1") 
    @GET 
    public String testPath1() { 
        return "Hello from path 1!"; 
    } 
 
    @Path("/path2") 
    @POST 
    public String testPath2() { 
        return "Hello from path 2!"; 
    }     
}