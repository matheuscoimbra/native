package org.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;

@Path("/hello")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Path(value = "svg/{image}")
    public Response getImage( @PathParam(value = "image") String image){
        ClassLoader classLoader = getClass().getClassLoader();

        InputStream is = classLoader.getResourceAsStream("svg/"+image+".svg");


        return Response.status(Response.Status.OK).entity(is)
                .type("image/svg+xml").build();
    }
}