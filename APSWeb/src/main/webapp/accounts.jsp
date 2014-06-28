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
<title>APS: Accounts</title>
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
				<h1>APS: Accounts</h1>
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
									<div class="page-header">
										<h2 id="forms">Accounts</h2>
									</div>
								</div>
							</div>
							<p>
							<div class="row">
								<div class="col-lg-12">
									<ul class="nav nav-tabs" style="margin-bottom: 15px;">
										<li class="active"><a href="#home" data-toggle="tab">Telkom</a></li>
										<li><a href="#profile" data-toggle="tab">City of
												Joburg</a></li>
										<li class="disabled"><a>FNB Credit Card</a></li>
									</ul>
									<div class="tab-content" id="myTabContent">
										<div class="tab-pane fade active in" id="home">
											<p>
											<div class="col-md-6">
												<div class="panel panel-success">
													<div class="panel-heading">
														<h3 class="panel-title">Account Information</h3>
													</div>
													<div class="panel-body">
														<div class="form-group">
															<label for="inputEmail" class="col-md-4 control-label">Account
																Number</label>
															<div class="col-md-8">
																<input type="text" class="form-control" id="inputEmail"
																	value="55533344424001">
															</div>
														</div>
														<div class="form-group">
															<label for="inputEmail" class="col-md-4 control-label">Statement
																Month</label>
															<div class="col-md-8">
																<input type="text" class="form-control" id="inputEmail"
																	value="June 2014">
															</div>
														</div>
														<div class="form-group">
															<label for="inputEmail" class="col-md-4 control-label">Statement
																Due Date</label>
															<div class="col-md-8">
																<input type="text" class="form-control" id="inputEmail"
																	value="06 July 2014">
															</div>
														</div>
														<div class="form-group">
															<label for="inputEmail" class="col-md-4 control-label">Amount
																Due</label>
															<div class="col-md-8">
																<input type="text" class="form-control" id="inputEmail"
																	value="200.00 ZAR">
															</div>
														</div>
														<div class="form-group">
															<label for="inputEmail" class="col-md-4 control-label">Discount</label>
															<div class="col-md-8">
																<input type="text" class="form-control" id="inputEmail"
																	value="5.45%">
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="col-md-6">
												<div class="panel panel-info">
													<div class="panel-heading">
														<h3 class="panel-title">Personal Information</h3>
													</div>
													<div class="panel-body">
														<div class="form-group">
															<label for="inputEmail" class="col-md-4 control-label">Account
																Holder</label>
															<div class="col-md-8">
																<input type="text" class="form-control" id="inputEmail"
																	value="Miss S.K. Peters">
															</div>
														</div>
														<div class="form-group">
															<label for="inputEmail" class="col-md-4 control-label">Telephone
																Number</label>
															<div class="col-md-8">
																<input type="text" class="form-control" id="inputEmail"
																	value="011 474 3675">
															</div>
														</div>
														<div class="form-group">
															<label for="inputEmail" class="col-md-4 control-label">Address</label>
															<div class="col-md-8">
																<input type="text" class="form-control" id="inputEmail"
																	value="PO Box 88493, Newclare">
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-12">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Statement Information</h3>
												</div>
												<div class="panel-body">
													<table width="100%">
														<tr>
															<td>Date</td>
															<td>Time</td>
															<td>Telephone Called</td>
															<td>Duration</td>
														</tr>
														<tr>
															<td>2014-06-01</td>
															<td>10:20</td>
															<td>082 345 6787</td>
															<td>10:00</td>
														</tr>
														<tr>
															<td>2014-06-03</td>
															<td>10:20</td>
															<td>082 345 6787</td>
															<td>10:00</td>
														</tr>
														<tr>
															<td>2014-06-06</td>
															<td>12:20</td>
															<td>084 345 6787</td>
															<td>10:00</td>
														</tr>
													</table>
												</div>
											</div>
										</div>
									</div>
									<div class="tab-pane fade" id="profile">
										<p>Food truck fixie locavore, accusamus mcsweeney's marfa
											nulla single-origin coffee squid. Exercitation +1 labore
											velit, blog sartorial PBR leggings next level wes anderson
											artisan four loko farm-to-table craft beer twee. Qui photo
											booth letterpress, commodo enim craft beer mlkshk aliquip
											jean shorts ullamco ad vinyl cillum PBR. Homo nostrud
											organic, assumenda labore aesthetic magna delectus mollit.</p>
									</div>
									<div class="tab-pane fade" id="dropdown1">
										<p>Etsy mixtape wayfarers, ethical wes anderson tofu
											before they sold out mcsweeney's organic lomo retro fanny
											pack lo-fi farm-to-table readymade. Messenger bag gentrify
											pitchfork tattooed craft beer, iphone skateboard locavore
											carles etsy salvia banksy hoodie helvetica. DIY synth PBR
											banksy irony. Leggings gentrify squid 8-bit cred pitchfork.</p>
									</div>
									<div class="tab-pane fade" id="dropdown2">
										<p>Trust fund seitan letterpress, keytar raw denim
											keffiyeh etsy art party before they sold out master cleanse
											gluten-free squid scenester freegan cosby sweater. Fanny pack
											portland seitan DIY, art party locavore wolf cliche high life
											echo park Austin. Cred vinyl keffiyeh DIY salvia PBR, banh mi
											before they sold out farm-to-table VHS viral locavore cosby
											sweater.</p>
									</div>
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

	<div class="navbar navbar-fixed-bottom navbar-inverse">ELEN7045:
		Group 5</div>

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