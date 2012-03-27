<html>
<head>
<meta name='layout' content='graati'/>
</head>

<body>

	<div class="post">
	<h1 class="title"><g:message code='spring.security.ui.login.signin'/></h1>
	
	<form action='${postUrl}' method='POST' id="loginForm" name="loginForm" autocomplete='off'>
	<table class="authtable">
		<tr>
			<td><label for="username"><g:message code='spring.security.ui.login.username'/></label></td>
			<td><input name="j_username" id="username" size="20" /></td>
		</tr>
		<tr>
			<td><label for="password"><g:message code='spring.security.ui.login.password'/></label></td>
			<td><input type="password" name="j_password" id="password" size="20" /></td>
		</tr>
		<tr>
			<td colspan='2'>
				<input type="submit" class="button" value="Sign in!">
				<input type="checkbox" class="checkbox" name="${rememberMeParameter}" id="remember_me" checked="checked" />
				<label for='remember_me'><g:message code='spring.security.ui.login.rememberme'/></label>
				
			</td>
		</tr>
		<tr>
			<td colspan='2'>
				<g:link controller="register"><g:message code="spring.security.ui.login.register"/></g:link>
				| <span class="forgot-link">
					<g:link controller='register' action='forgotPassword'><g:message code='spring.security.ui.login.forgotPassword'/></g:link>
				</span>
			</td>
		</tr>
	</table>
	</form>
	</div>
<script>
$(document).ready(function() {
	$('#username').focus();
});
</script>
</body>
</html>