package com.arxxus.rest.RestTest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alien {
	private String Name;
	private int Points;
	private int id;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPoints() {
		return Points;
	}
	public void setPoints(int points) {
		Points = points;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Alien [Name=" + Name + ", Points=" + Points + ", id=" + id + "]";
	}
	
	
}
