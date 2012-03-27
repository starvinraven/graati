<head>
<meta name='layout' content='graati'/>
</head>

<body>

<div class="post">
<h1 class="title">Forgot password?</h1>

	<g:form action='forgotPassword' name="forgotPasswordForm" autocomplete='off'>

	<g:if test='${emailSent}'>
	<g:message code='spring.security.ui.forgotPassword.sent'/>
	</g:if>

	<g:else>
	<p>
	<g:message code='spring.security.ui.forgotPassword.description'/>
	</p>
	<table class="authtable">
		<tr>
			<td><label for="username"><g:message code='spring.security.ui.forgotPassword.username'/></label></td>
			<td><g:textField name="username" size="25" /></td>
		</tr>
	</table>

	<input class="button" type="submit" value="Submit"/>

	</g:else>

	</g:form>
</div>
<script>
$(document).ready(function() {
	$('#username').focus();
});
</script>

</body>
