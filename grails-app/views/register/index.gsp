<head>
	<meta name='layout' content='graati'/>
</head>

<body>
<div class="post">

<h1 class="title">Register</h1>

<g:form action='register' name='registerForm'>

	<g:if test='${emailSent}'>
	<br/>
	<%-- 
	<g:message code='spring.security.ui.register.sent'/>
	--%>
	Welcome! Email sending has been disabled, so your account should be good to go.
	</g:if>
	<g:else>

	<br/>

	<table class="authtable">
	<tbody>
		<s2ui:textFieldRow name='username' labelCode='user.username.label' bean="${command}"
                         size='20' labelCodeDefault='Username' value="${command.username}"/>
		<s2ui:textFieldRow name='email' bean="${command}" value="${command.email}"
		                   size='20' labelCode='user.email.label' labelCodeDefault='E-mail'/>
		<s2ui:passwordFieldRow name='password' labelCode='user.password.label' bean="${command}"
                             size='20' labelCodeDefault='Password' value="${command.password}"/>
		<s2ui:passwordFieldRow name='password2' labelCode='user.password2.label' bean="${command}"
                             size='20' labelCodeDefault='Password (again)' value="${command.password2}"/>

	</tbody>
	</table>

	<input class="button" type="submit" value="Submit" />
	</g:else>

</g:form>

<script>
$(document).ready(function() {
	$('#username').focus();
});
</script>

</div>
</body>
