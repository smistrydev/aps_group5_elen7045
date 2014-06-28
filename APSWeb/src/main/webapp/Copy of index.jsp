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
</head>
<body>
	<div class="container">
		<div class="bs-docs-section">
			<div class="row">
				<div class="col-lg-12">
					<div class="page-header">
						<h2 id="forms">Account Presentation System</h2>
					</div>
				</div>
			</div>
			<p>
			<div class="row">
				<div class="col-lg-6">
					<div class="well bs-component">
						<form method="POST" action="home.jsp" class="form-horizontal">
							<fieldset>
								<legend>Login</legend>
								<div class="form-group">
									<label for="inputEmail" class="col-lg-2 control-label">Email</label>
									<div class="col-lg-10">
										<input type="text" class="form-control" id="inputEmail"
											placeholder="Email">
									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword" class="col-lg-2 control-label">Password</label>
									<div class="col-lg-10">
										<input type="password" class="form-control" id="inputPassword"
											placeholder="Password">
										<div class="checkbox">
											<label> <input type="checkbox"> Remember me
											</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-lg-10 col-lg-offset-2">
										<button type="submit" class="btn btn-primary">Submit</button>
										<button class="btn btn-default">Forgot Password</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
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