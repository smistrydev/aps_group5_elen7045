<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Dynamic Drive: CSS Liquid Layout #3.1-
	(Fixed-Fluid-Fixed)</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css"
	media="screen">
<link rel="stylesheet" href="resources/css/login.page.css"
	media="screen">
<script type="text/javascript">
/*** Temporary text filler function. Remove when deploying template. ***/
var gibberish=["This is just some filler text", "Welcome to Dynamic Drive CSS Library", "Demo content nothing to read here"]
function filltext(words){
for (var i=0; i<words; i++)
document.write(gibberish[Math.floor(Math.random()*3)]+" ")
}
</script>

</head>
<body>
	<div id="maincontainer">

		<div id="topsection">
			<div class="innertube">
				<h1>CSS Liquid Layout #3.1- (Fixed-Fluid-Fixed)</h1>
			</div>
		</div>

		<div id="contentwrapper">
			<div id="contentcolumn">
				<div class="innertube">
					<b>Content Column: <em>Fluid</em></b>
					<script type="text/javascript">filltext(45)</script>
				</div>
			</div>
		</div>

		<div id="leftcolumn">
			<div class="innertube">
				<b>Left Column: <em>230px</em></b>
				<script type="text/javascript">filltext(20)</script>
			</div>

		</div>

		<div id="rightcolumn">
			<div class="innertube">
				<b>Right Column: <em>200px</em></b>
				<script type="text/javascript">filltext(15)</script>
			</div>
		</div>

		<div id="footer">
			<a href="http://www.dynamicdrive.com/style/">Dynamic Drive CSS
				Library</a>
		</div>

	</div>
</body>
</html>