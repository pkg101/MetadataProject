package repository;

import java.io.File;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import metadataResources.MetadataResource;

@Path("sfdcmetadata")
public class MetadataRepository {

	MetadataResource metadataResource = new MetadataResource();

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_OCTET_STREAM,MediaType.APPLICATION_JSON})
	public Response getdata(@FormParam("metadata") List<String> classnames, @FormParam("sfdcuserid") String sfdcuserid,
			@FormParam("sdate") String sdate, @FormParam("edate") String edate,@FormParam("logintoken") List<String> logintoken) throws Exception {
		
		System.out.println(classnames);
		System.out.println(sfdcuserid);
		System.out.println(sdate+"T00:00:00.000Z" + "--" + edate+"T00:00:00.000Z");
		System.out.println("logintoken - "+logintoken);
		sdate+="T23:59:59.000Z";
		edate+="T23:59:59.000Z";
		for (int i = 0; i < classnames.size(); i++) {
			switch (Integer.parseInt(classnames.get(i))) {
			case 101:
				metadataResource.getApexClasses(sfdcuserid,sdate,edate);
				break;
			case 102:
				metadataResource.getApexPages();
				break;
			case 103:
				metadataResource.getApexComponents();
				break;
			case 104:
				metadataResource.getApexTriggers(sfdcuserid,sdate,edate);
				break;
			case 105:
				metadataResource.getCustomField();
				break;
			case 106:
				metadataResource.getCustomField();
				break;
			case 120:
				metadataResource.getRecordType();
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
