package com.swaggerdemo.resource;

import com.swaggerdemo.model.City;
import com.swaggerdemo.service.ICityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("cities")
public class MyResource {

    @Inject
    private ICityService cityService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "get dummy",
            description = "Get Dummy",
            tags = {"dummy"}
    )
    @ApiResponse(responseCode = "200", description = "OK")
    public Response getCities() {

        List<City> cities = cityService.findAll();

        if (!cities.isEmpty()) {

            return Response.ok(cities).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCity(@PathParam("id") Long id) {

        City city = cityService.find(id);

        if (city.getId() != null) {
            return Response.ok(city).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response saveCity(@FormParam("name") String name,
                             @FormParam("population") int population) {

        City city = new City();
        city.setName(name);
        city.setPopulation(population);

        boolean r = cityService.save(city);

        if (r) {
            return Response.ok().status(Response.Status.CREATED).build();
        } else {
            return Response.notModified().build();
        }
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response updateCity(@FormParam("name") String name,
                               @FormParam("population") int population,
                               @PathParam("id") Long id) {

        City city = new City();
        city.setName(name);
        city.setPopulation(population);

        boolean r = cityService.update(city, id);

        if (r) {
            return Response.ok().status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.notModified().build();
        }
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCity(@PathParam("id") Long id) {

        boolean r = cityService.delete(id);

        if (r) {
            return Response.ok().status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.notModified().build();
        }
    }
}
