package metadataResources;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.Document;

public class XmlDocumetRes {
	public static File xmlDocEnd(Document doc) throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		File targetFile = new File("E:\\SpringWorkspace\\RestFullAPITest\\metadataxml\\metadata_"
				+ (new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss").format(new Date()).toString()) + ".xml");
		StreamResult result = new StreamResult(targetFile);
		transformer.transform(source, result);
	return targetFile;
	}

}
