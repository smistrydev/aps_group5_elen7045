<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	try
	{
		StringBuilder sb = new StringBuilder(request.getScheme());
		sb.append("://");
		sb.append(request.getServerName());
		sb.append(":");
		sb.append(request.getServerPort());
		sb.append(request.getContextPath());
		sb.append("/");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>APS: Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="distribution" content="global">
<meta name="location" content="South Africa, Johannesburg, Gauteng">
<meta name="robots" content="index, follow, all">
<meta name="no-archive" content="googlebot">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css"
	media="screen">
<link rel="stylesheet" href="resources/css/login.page.css"
	media="screen">
</head>
<body>
	<div id="maincontainer">
		<div id="topsection">
			<div class="innertube">
				<h1>APS: Home</h1>
			</div>
		</div>
		<div id="contentwrapper">
			<div id="contentcolumn">
				<div class="innertube">
					<!-- Content Column: -->
					<div class="container">
						<div class="bs-docs-section">
							<div class="row">
								<div class="col-lg-12">
									<div class="col-lg-12">
										<div class="page-header">
											<h2 id="forms">Notifications</h2>
										</div>
									</div>
								</div>
								<p>
								<div class="row">
									<div class="col-lg-12">
										<table class="table table-striped table-hover ">
											<thead>
												<tr>
													<th>#</th>
													<th>Notification Timestamp</th>
													<th>Message</th>
													<th>Acknowledge</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>20 June 2014 14:20</td>
													<td>0001: Invalid credentials supplied to Telco.
														Please recapture required details.</td>
													<td>
														<div class="checkbox">
															<label> <input type="checkbox">
															</label>
														</div>
													</td>
												</tr>
												<tr>
													<td>2</td>
													<td>22 June 2014 08:05</td>
													<td>0003: Action required to continue eBilling. Please
														log onto Municipality to action request.</td>
													<td>
														<div class="checkbox">
															<label> <input type="checkbox">
															</label>
														</div>
													</td>
												</tr>
												<tr>
													<td>3</td>
													<td>24 June 2014 13:45</td>
													<td>0002: Not signed up for eBilling. The system could
														not log into Credit Card to retrieve your statement</td>
													<td>
														<div class="checkbox">
															<label> <input type="checkbox">
															</label>
														</div>
													</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div id="leftcolumn">
			<div class="innertube">
				<!-- Left Column -->
				<nav>
					<ul class="nav nav-pills nav-stacked span2">
						<li><a href="home.jsp">Home</a></li>
						<li><a href="accounts.jsp">Statement</a></li>
						<li><a href="#">Settings</a></li>
						<li><a href="index.jsp">Logout</a></li>
					</ul>
				</nav>
			</div>
		</div>

		<div id="rightcolumn">
			<div class="innertube">
				<!-- Right Column -->
				&nbsp;
			</div>
		</div>
		<div class="navbar navbar-fixed-bottom navbar-inverse">&nbsp;</div>
	</div>
</body>
</html>
<%
	}
	catch(Throwable t)
	{
		System.out.println(t.toString());
		pageContext.getServletContext().log("*** Error in JSP page", t);
	}
%>