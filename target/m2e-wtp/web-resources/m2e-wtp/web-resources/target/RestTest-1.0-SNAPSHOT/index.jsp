<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>

<body>
	<h2>Salesforce Metadata Web Application!</h2>

	<form action="metadataresources/sfdcmetadata/" method="POST">
		ApexClass: <input type="checkbox" name="metadata" value="101"><br>
		ApexPage: <input type="checkbox" name="metadata" value="102"><br>
		ApexComponent: <input type="checkbox" name="metadata" value="103"><br>
		ApexTrigger: <input type="checkbox" name="metadata" value="104"><br>
		RecordType: <input type="checkbox" name="metadata" value="120"><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>
