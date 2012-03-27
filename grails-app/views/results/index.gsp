<html>
<head>
<meta name='layout' content='graati'/>
</head>
<body>
<div class="post">
<h1 class="title">View results</h1>
<table class="raatilist">
	<thead>
	<tr>
	<th>Name</th>
	<th>Voters</th>
	<th>Voting ends at</th>
	<th>Privacy</th>
	</tr>
	</thead>
	<tbody>
	<g:each in="${raatis}" status="i" var="raati">
	<g:def var="raatiId" value="${raati.id}"/>
	<tr>
	<td>
	<g:link action="view" params="[id:raatiId]">
	${raati.name}
	</g:link>
	</td>
	<td>
	bla	
	</td>
	<td>
	<g:formatDate format="yyyy-MM-dd HH:mm" date="${raati.ends}" />
	</td>
	<td>
	${raati.privacy}
	</td>
	</tr>
	</g:each>
	</tbody>
	</table>
</div>
</body>
</html>