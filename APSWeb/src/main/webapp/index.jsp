<!DOCTYPE html>
<html>
	<head>
		<title>Account Presentation System</title>
		<%= render("/layouts/shim") %>
        <%= stylesheet_link_tag    "bootstrapImport", media: "all" %>
        <%= stylesheet_link_tag    "custom", media: "all" %>
        <%= stylesheet_link_tag    "sitewide/tabSlideOut", media: "all" %>
  		<%= javascript_include_tag "application" %>
        <%= javascript_include_tag "sitewide/tabSlideOut" %>
        <%= javascript_include_tag "sitewide/jquery.tabSlideOut.v1.3" %>
		<%= yield(:head) %>
		<%= csrf_meta_tags %>
	</head>
	<body>
		<jsp:include page="header.jsp" flush="true"/>
		
		<jsp:include page="footer.jsp" flush="true"/>
		<!-- Pull-out menu -->
		<div class="slide-out-div">
			<a class="handle" href="http://link-for-non-js-users.html">Selection Menu</a>
			<jsp:include page="sidenav.jsp" flush="true"/>
		</div>
		<!-- End of Pull out menu -->

	</body>
</html>