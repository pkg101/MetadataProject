package metadataPOJO;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AssignmentRule {
private String id;
private String entityDefinitionId;
private String name;
private String lastModifiedDate;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getEntityDefinitionId() {
	return entityDefinitionId;
}
public void setEntityDefinitionId(String entityDefinitionId) {
	this.entityDefinitionId = entityDefinitionId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLastModifiedDate() {
	return lastModifiedDate;
}
public void setLastModifiedDate(String lastModifiedDate) {
	this.lastModifiedDate = lastModifiedDate;
}


}
