<html>
<head>
<meta name='layout' content='graati'/>
</head>
<body>
<div class="post">
<h1 class="title">Results for raati ${raati.name}</h1>

<h2 class="title">Voters map</h2>
<table border="true">
<thead>
<tr>
<th></th>
<g:each in="${usernames}" status="i" var="username">
<th>${username}</th>
</g:each>
</tr>
</thead>
<tbody>
<g:each in="${voteList}" status="i" var="songandvotes">
<g:each in="${songandvotes}" status="j" var="songandvotesmap">
	<tr>
	<td>
	${songandvotesmap.key}
	</td>
		<g:each in="${usernames}" status="l" var="username">
			<td>
			<g:if test="${songandvotesmap.value[username]?.score > 0}">
				<g:if test="${params.showScores}">
				${songandvotesmap.value[username]?.score}
				</g:if>
				<g:else>
				V	
				</g:else>
			</g:if>
			<g:if test="${songandvotesmap.value[username]?.comment?.length() > 0}">C</g:if>
			</td>
		</g:each>
	</tr>
</g:each>
</g:each>
</tbody>
</table>
<h2 class="title">View more info</h2>
<ul>
<li>Start viewing song details starting @ last ranked <g:link action="viewOne" params="[id:raati.id, songNumber:voteList.size()]">here</g:link>  </li>
<li>View general raati details</li>
</ul>
</div>
</body>
</html>