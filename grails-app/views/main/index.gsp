<html>
    <head>
        <meta name="layout" content="graati" />
    </head>
    <body>
    	<g:if test="${blogEntries?.size()<1}">
    	<div class="post">
    	<h2 class="title">No blog entries</h2>
    	</div>
    	</g:if>
    	
    	<g:each in="${blogEntries}" var="entry">
    	<div class="post">
    	<h2 class="title">${entry.title}</h2>
    	<p class="byline">
    		<small>
    		By ${entry.author.username} at <g:formatDate format="yyyy-MM-dd HH:mm" date="${entry.dateCreated}" />
    		<g:if test="${entry.dateCreated < entry.lastUpdated }">
    		 edited at <g:formatDate format="yyyy-MM-dd HH:mm" date="${entry.lastUpdated}" />
    		</g:if>
    		</small>
    	</p>
    	${entry.text}
    	</div>
    	</g:each>
    	
  		
    	
    	<%-- 
		<h1 class="title">Raatis</h1>
		<p class="byline">
			<small>A list of the charts you can view</small>
		</p>
		<table class="raatilist">
		<thead>
		<tr>
		<th>Name</th>
		<th>Albums</th>
		<th>Songs</th>
		<th>Completed</th>
		<th>Voting ends at</th>
		<th>Privacy</th>
		<th>Results</th>
		</tr>
		</thead>
		<tbody>
		<g:each in="${raatis}" status="i" var="raati">
		<tr>
		<td>
		<a href="voting?id=${raati.id}">
		${raati.name}
		</a>
		</td>
		<td>
		${raati.albums}
		</td>
		<td>
		${raati.songs}
		</td>
		<td>
		<g:formatNumber number="${raati.voted}" format="##0"/>%
		</td>
		<td>
		<g:formatDate format="yyyy-MM-dd HH:mm" date="${raati.ends}" />
		</td>
		<td>
		${raati.privacy}
		</td>
		<td>
		<g:if test="${raati.resultsReleased}">
			<a href="results?id=${raati.id}">View</a>
		</g:if>
		<g:else>
			Not released
		</g:else>
		</td>
		</tr>
		</g:each>
		</tbody>
		</table>
		--%>
				
    </body>
</html>