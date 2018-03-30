package repository;

import java.io.File;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import metadataPOJO.ApexClass;
import metadataResources.MetadataResource;

@Path("/sfdcmetadata")
public class MetadataRepository {

	MetadataResource metadataResource = new MetadataResource();

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response getdata(@FormParam("metadata") List<String> classnames) throws Exception {

		for (int i = 0; i < classnames.size(); i++) {
			switch (Integer.parseInt(classnames.get(i))) {
			case 101:
				metadataResource.getApexClasses();
				break;
			case 102:
				metadataResource.getApexPages();
				break;
			case 103:
				metadataResource.getApexComponents();
				break;
			case 104:
				metadataResource.getApexTriggers();
				break;
			}
		}
		File file = metadataResource.saveXml();
	    ResponseBuilder response = Response.ok((Object) file);
	    response.header("Content-Disposition", "attachment;filename="+file.getName());
	    return response.build();
		
	//	URI uri = new URI("/sfdcmetadata/downloadxml/");
	//	return Response.seeOther(uri).build();
	}

	@GET
	@Path("/apexclasses/")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<ApexClass> getAlienResources() throws Exception {
		return metadataResource.getApexClasses();
	}

	/*@GET
	@Path("/downloadxml/")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response downloadFile() throws TransformerException {
		System.out.println("called");
	    File file = metadataResource.saveXml();
	    ResponseBuilder response = Response.ok((Object) file);
	    response.header("Content-Disposition", "attachment;filename="+file.getName());
	    return response.build();
	}*/
	

}
