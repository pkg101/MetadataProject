package metadataResources;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import credentials.RestLogin;
import dataContainer.DataWarehouse;
import metadataPOJO.ApexClass;
import metadataPOJO.ApexComponent;
import metadataPOJO.ApexPage;
import metadataPOJO.ApexTrigger;

public class MetadataResource {

	JSONObject loginObject = RestLogin.GetLoginObject();
	String startdate = "2018-02-01T17:23:04.000Z";
	String enddate = "2018-03-01T17:23:04.000Z";
	Document doc;
	Element xmlroot;

	public MetadataResource() {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.newDocument();
			xmlroot = doc.createElement("Package");
			Attr attrType = doc.createAttribute("xmlns");
			attrType.setValue("http://soap.sforce.com/2006/04/metadata");
			xmlroot.setAttributeNode(attrType);
			doc.appendChild(xmlroot);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public List<ApexClass> getApexClasses() throws Exception {
		JSONArray apexclassArray = DataWarehouse.getApexClassList(loginObject, startdate, enddate);
		Element xmlapexclasstype = doc.createElement("types");
		xmlroot.appendChild(xmlapexclasstype);
		List<ApexClass> apexClassList = new ArrayList<ApexClass>();
		try {

			for (int i = 0; i < apexclassArray.length(); i++) {
				Element xmlapexclassMembers = doc.createElement("members");
				xmlapexclassMembers.appendChild(doc.createTextNode(apexclassArray.getJSONObject(i).getString("Name")));
				xmlapexclasstype.appendChild(xmlapexclassMembers);

				ApexClass apexClass = new ApexClass();
				apexClass.setName(apexclassArray.getJSONObject(i).getString("Name"));
				apexClassList.add(apexClass);
			}
			Element xmlapexclassName = doc.createElement("name");
			xmlapexclassName.appendChild(doc.createTextNode("ApexClass"));
			xmlapexclasstype.appendChild(xmlapexclassName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apexClassList;
	}

	public List<ApexTrigger> getApexTriggers() throws Exception {
		JSONArray apexTriggerArray = DataWarehouse.getApexTriggerList(loginObject, startdate, enddate);
		Element xmlapextriggertype = doc.createElement("types");
		xmlroot.appendChild(xmlapextriggertype);
		List<ApexTrigger> apexTriggerList = new ArrayList<ApexTrigger>();
		for (int i = 0; i < apexTriggerArray.length(); i++) {
			try {
				Element xmlapextriggerMembers = doc.createElement("members");
				xmlapextriggerMembers
						.appendChild(doc.createTextNode(apexTriggerArray.getJSONObject(i).getString("Name")));
				xmlapextriggertype.appendChild(xmlapextriggerMembers);
				ApexTrigger apexTrigger = new ApexTrigger();
				apexTrigger.setName(apexTriggerArray.getJSONObject(i).getString("Name"));
				apexTriggerList.add(apexTrigger);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Element xmlapextriggerName = doc.createElement("name");
		xmlapextriggerName.appendChild(doc.createTextNode("ApexTrigger"));
		xmlapextriggertype.appendChild(xmlapextriggerName);
		return apexTriggerList;
	}

	public List<ApexPage> getApexPages() throws Exception {
		List<ApexPage> apexPageList = new ArrayList<ApexPage>();
		JSONArray apexPageArray = DataWarehouse.getApexPageList(loginObject, startdate, enddate);
		if (apexPageArray != null) {
			if (apexPageArray.length() > 0) {
				Element xmlapexPagetype = doc.createElement("types");
				xmlroot.appendChild(xmlapexPagetype);
				for (int i = 0; i < apexPageArray.length(); i++) {
					try {
						Element xmlapexPageMembers = doc.createElement("members");
						xmlapexPageMembers
								.appendChild(doc.createTextNode(apexPageArray.getJSONObject(i).getString("Name")));
						xmlapexPagetype.appendChild(xmlapexPageMembers);
						ApexPage apexPage = new ApexPage();
						apexPage.setName(apexPageArray.getJSONObject(i).getString("Name"));
						apexPageList.add(apexPage);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlapexPageName = doc.createElement("name");
				xmlapexPageName.appendChild(doc.createTextNode("ApexPage"));
				xmlapexPagetype.appendChild(xmlapexPageName);
			}
		}
		return apexPageList;
	}

	public List<ApexComponent> getApexComponents() throws Exception {
		List<ApexComponent> ApexComponentList = new ArrayList<ApexComponent>();
		JSONArray apexComponentArray = DataWarehouse.getApexComponentList(loginObject, startdate, enddate);
		if (apexComponentArray != null) {
			if (apexComponentArray.length() > 0) {
				Element xmlapexComponenttype = doc.createElement("types");
				xmlroot.appendChild(xmlapexComponenttype);
				for (int i = 0; i < apexComponentArray.length(); i++) {
					try {
						Element xmlapexComponentMembers = doc.createElement("members");
						xmlapexComponentMembers
								.appendChild(doc.createTextNode(apexComponentArray.getJSONObject(i).getString("Name")));
						xmlapexComponenttype.appendChild(xmlapexComponentMembers);
						ApexComponent apexComponent = new ApexComponent();
						apexComponent.setName(apexComponentArray.getJSONObject(i).getString("Name"));
						ApexComponentList.add(apexComponent);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlapexComponentName = doc.createElement("name");
				xmlapexComponentName.appendChild(doc.createTextNode("ApexComponent"));
				xmlapexComponenttype.appendChild(xmlapexComponentName);
			}
		}
		return ApexComponentList;
	}

	public File saveXml() throws TransformerException {
		File file = XmlDocumetRes.xmlDocEnd(doc);
		return file;
	}
}