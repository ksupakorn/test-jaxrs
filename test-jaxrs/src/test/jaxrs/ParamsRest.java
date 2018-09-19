package test.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/params") 
public class ParamsRest { 
	
    @GET 
    public String testHeaders(@HeaderParam("Authorization") String authorization) { 
        return "Authorization header value is " + authorization; 
    } 	
 
    @GET 
    @Path("/path0")
    //http://localhost:8080/testws/webresources/params?name=Donald
    public String welcome(@QueryParam("name") String username) { 
        return "Welcome " + username + "!"; 
    } 
    
    @GET
    @Path("/path1")
    //http://localhost:8080/testws/webresources/params;name=action/movie;name=foo/?page=1.
    public String welcomeMatrix(@MatrixParam("name") String username) { 
        return "Welcome " + username + "!"; 
    } 
 
}