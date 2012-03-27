<html>
<head>
<meta name='layout' content='graati'/>
</head>
<body>
<div class="post">
<h1 class="title">Results for raati ${raati.name}</h1>
<h2 class="title">Results</h2>
<ul>
<g:each in="${results}" status="i" var="result">
<li>
<g:each in="${result}" status="j" var="r">
${i+1}: ${r.key.name}:
${r.value.meanNormalizedScore}
<br>
<ul>
<g:each in="${r.value.votes}" var="userVote">
<li>${userVote.key.username}: ${userVote.value.normalizedScore} ${userVote.value.score} </li>
</g:each>
</ul>
</g:each>
</li>
</g:each>
</ul>
</div>
</body>
</html>