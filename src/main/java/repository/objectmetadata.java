package repository;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import metadataPOJO.ApexClass;
import metadataPOJO.AssignmentRule;
import metadataResources.MetadataResource;

@Path("objectmetadata")
public class objectmetadata {
	
	MetadataResource metadataResource = new MetadataResource();
	@GET
	@Path("/apexclasses")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<ApexClass> getApexClass() {
		List<ApexClass> list =null;
		try
		{
			list = metadataResource.getApexClasses();
		}
		catch(Exception e)
		{
			System.out.println("Error - "+e);
		}
		
		return list;
	}
	
	@GET
	@Path("/assignmentrule")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<AssignmentRule> getAssignmentRule() throws Exception {
		
		List<AssignmentRule> list =null;
		try
		{
			list = metadataResource.getAssignmentRule();
		}
		catch(Exception e)
		{
			System.out.println("Error - "+e);
		}
		
		return list;
	}
	
	
	
	
	
}
