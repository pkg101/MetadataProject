package com.arxxus.rest.RestTest;

import java.util.ArrayList;
import java.util.List;

public class AlienRepository {
	List<Alien> aliens;
	
	public AlienRepository()
	{
		aliens = new ArrayList<Alien>();
		for(int i=1;i<=3;i++)
		{
			Alien alien = new Alien();
			alien.setId(4510+(i*10));
			alien.setName("Test-"+i);
			alien.setPoints(60+(i*10));
			aliens.add(alien);
		}
	}
	
	public List<Alien> getAliens()
	{
		return aliens;
	}
	
	public Alien getAlien(int id)
	{
		for(Alien a : aliens)
		{
			if(a.getId()==id)
				return a;
		}
		return null;
	}

	public void create(Alien a) {
		aliens.add(a);
	}
}
