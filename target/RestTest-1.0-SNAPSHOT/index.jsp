<%@page import="dataContainer.DataWarehouse"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="credentials.RestLogin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Tournament</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,user-scalable=no" />
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<link type="text/css" rel="stylesheet"
	href="materialize/css/materialize.min.css" media="screen,projection" />
<script type="text/javascript" src="materialize/js/materialize.min.js"></script>

</head>
<body>
	<div class="container">
		<h4>Salesforce Metadata Web Application!</h4>

		<form action="metadataresources/sfdcmetadata/" method="POST">
			<div class="row">
				<div class="col s12 m6 l6">
					<select class="browser-default" name="sfdcuserid">
						<option value="" disabled selected>Select User</option>
						<%
							
							JSONObject loginObject = RestLogin.GetLoginObject();
							JSONArray UserArray = DataWarehouse.getUserList(loginObject, "", "");
							for (int i = 0; i < UserArray.length(); i++) {
						%>
						<option value="<%=UserArray.getJSONObject(i).getString("Id")%>"><%=UserArray.getJSONObject(i).getString("Name")%></option>
						<%
							}
						%>

					</select>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12 m12 l6">
					<label for="tour_sdate">Start Date</label> <input id="tour_sdate"
						type="text" class="datepicker" name="sdate" required>
				</div>
				<div class="input-field col s12 m12 l6">
					<label for="tour_edate">End Date</label> <input id="tour_edate"
						type="text" class="datepicker1" name="edate" required>
				</div>

			</div>
			<p>
				<label> <input type="checkbox" name="metadata" value="101" />
					<span>Apex Class</span>
				</label>
			</p>
			<p>
				<label> <input type="checkbox" name="metadata" value="104" />
					<span>Apex Trigger</span>
				</label>
			</p>
			<p>
				<label> <input type="checkbox" name="metadata" value="102" />
					<span>Apex Page</span>
				</label>
			</p>
			<p>
				<label> <input type="checkbox" name="metadata" value="103" />
					<span>Apex Component</span>
				</label>
			</p>


			<input type="submit" value="Submit">
		</form>
	</div>
	<script type="text/javascript">
		$(document).ready(
				function() {

					var yesterday = new Date((new Date()).valueOf() - 1000 * 60
							* 60 * 24);

					$("#tour_sdate").click(function() {

						$('.datepicker').pickadate({
							format : 'yyyy-mm-dd',
						/* disable : [ {
							from : [ 0, 0, 0 ],
							to : yesterday
						} ] */
						});
					});

					$("#tour_edate").click(
							function() {
								var afterday = new Date((new Date($(
										"#tour_sdate").val())).valueOf()
										- 1000 * 60 * 60 * 24);
								$('.datepicker1').pickadate({
									format : 'yyyy-mm-dd',
								/* disable : [ {
									from : [ 0, 0, 0 ],
									to : afterday
								} ] */
								});
							});
					$('select').formSelect();
				});
	</script>

</body>

</html>
<!-- pradeep1jangid1 0057F000001zU1GQAU
	pradeep jangid   0057F000000by3AQAQ
  -->