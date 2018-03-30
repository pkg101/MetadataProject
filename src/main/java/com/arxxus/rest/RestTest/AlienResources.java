package com.arxxus.rest.RestTest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResources {
	
	AlienRepository repo = new AlienRepository();
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Alien> getAlienResources()
	{
		return repo.getAliens();
	}
	
	@GET
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien getAlien(@PathParam("id") int id)
	{
		return repo.getAlien(id);
	}
	
	@POST
	@Path("alien")
	public Alien createAlien(Alien a)
	{
		System.out.println(a);
		repo.create(a);
		return a;
	}
	@POST
	@Path("alien")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Alien createAlien(@FormParam("id") int id,@FormParam("name") String name,@FormParam("points") int points)
	{
		Alien alien =new Alien();
		alien.setId(id);
		alien.setName(name);
		alien.setPoints(points);
		System.out.println("Form - "+alien);
		return alien;
	}
}
