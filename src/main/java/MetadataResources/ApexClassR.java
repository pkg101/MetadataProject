package MetadataResources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;
import DataContainer.DataWarehouse;
import MetadataPOJO.ApexClass;
import credentials.RestLogin;

@Path("/apexclass")
public class ApexClassR {
	
	JSONObject loginObject = RestLogin.GetLoginObject();
	String startdate = "2018-02-01T17:23:04.000Z";
	String enddate = "2018-03-01T17:23:04.000Z";
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<ApexClass> appexClass()
	{
		JSONArray customFieldList = DataWarehouse.__getCustomFieldList(loginObject,startdate,enddate);
		List<ApexClass> apexClassList = new ArrayList<ApexClass>();
		try {
			String customObjectName = "";
			for (int j = 0; j < customFieldList.length(); j++) {
				if (customFieldList.getJSONObject(j).getString("TableEnumOrId").matches("^[A-Za-z]+[0-9]*"))
					customObjectName = customFieldList.getJSONObject(j).getString("TableEnumOrId");
				else {
					customObjectName = DataWarehouse.getCustomObjectName(loginObject,
							customFieldList.getJSONObject(j).getString("TableEnumOrId"));
					customObjectName += "__c";
				}
				ApexClass apexClass = new ApexClass();
				apexClass.setName(customObjectName + "."+ customFieldList.getJSONObject(j).getString("DeveloperName") + "__c");
				System.out.println(apexClass.getName());
				apexClassList.add(apexClass);
				
				}
		/*for (int i = 0; i < apexclassArray.length(); i++) {
			ApexClass apexClass = new ApexClass();
		//	apexClass.setId(apexclassArray.getJSONObject(i).getString("Id"));
			apexClass.setName(apexclassArray.getJSONObject(i).getString("Name"));
		//	apexClass.setLastModifiedDate(apexclassArray.getJSONObject(i).getString("LastModifiedDate"));
			apexClassList.add(apexClass);	
		}*/
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apexClassList;
	}

}
