<script>
	/**
	 * Invokes the callback to the server, submitting all info selected
	 */
	function invoke(form, event, container) {
		params = {};
		if (event != null) {
			params = event + '&' + $(form).serialize();
		}

		$.post(form.action, params, function(xml) {
			$(container).html(xml);
		});
	}

</script>
<nav class="side_nav">
	<table class="table table-bordered table-hover">
	       <tr>
	           <td>Home</td>
	       </tr>
	       <tr>
	           <td>A Menu Option</td>
	       </tr>
	       <tr>
	           <td>Logoff</td>
	       </tr>
	  </table>
	  <p> &nbsp;
</nav>