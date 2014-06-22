<!DOCTYPE html>
<html>
	<head>
		<title>Account Presentation System</title>
		<jsp:include page="shim.jsp" flush="true"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/tabSlideOut.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.tabSlideOut.v1.3.js"></script>
	</head>
	<body>
		<jsp:include page="header.jsp" flush="true"/>
		Hello...
		<jsp:include page="footer.jsp" flush="true"/>
		<!-- Pull-out menu -->
		<div class="slide-out-div">
			<a class="handle" href="http://link-for-non-js-users.html">Selection Menu</a>
			<jsp:include page="sidenav.jsp" flush="true"/>
		</div>
		<!-- End of Pull out menu -->

	</body>
</html>