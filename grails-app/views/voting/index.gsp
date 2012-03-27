<html>
    <head>
        <meta name="layout" content="graati" />
        <script type="text/javascript" language="javascript" src="js/niftyplayer.js"></script>
    </head>
    <body>
    <div class="post">
    <h1 class="title">${raatiname}</h1>
    <p class="byline">
    <small>Created by ${ownername}</small>
    </p>
    </div>

    <g:each in="${albums}" status="i" var="album">
    	<div class="post">
    	<h2 class="title">${fieldValue(bean: album, field: "name")}</h2>
    	<p class="byline">
    	<small>${album.artist.name} ${album.releaseYear}</small>
    	</p>
    	<table class="albumlisting">
    	<tbody>
    	<g:each in="${album.songs}" status="j" var="song">
    		<tr>
    		<td class="index">${fieldValue(bean: song, field: "indexNumber")}</td> 
    		<td class="songname">${fieldValue(bean: song, field: "name")}</td>
    			<g:if test="${song.audioUrl}">
    				<td><img class="playimg" onclick="playSong(${song.id}, '${song.audioUrl}');" src="images/play.png" id="play${song.id}" width="30" height="30"/></td>
    			</g:if>
       		<td>
    			<select <g:if test="${!canvote}">disabled="disabled"</g:if> class="voteselect" name="song${fieldValue(bean: song, field: 'id')}" id="song${fieldValue(bean: song, field: 'id')}">
    				<option>-</option>
    				<g:each in="${(1..20).collect { it/2 }}" var="val">
    					<option<g:if test="${votes != null && val == (votes[song.id]) }"> selected="selected"</g:if> value="${val}"><g:formatNumber number="${val}" format="#0.0"/></option>
    				</g:each>
    			</select>
    		</td>
    		<td class="normscorediv">
    			<div class="normScore" style="background-color:<graati:voteToColor score='${normalized[song.id]}'/>" id="normScore${song.id}">
    				<g:if test="${normalized[song.id]}"><g:formatNumber number="${normalized[song.id]}" format="#0.0"/></g:if>
    				<g:else>0.0</g:else>
    			</div>
    		</td>
    		<td>
    			<textarea <g:if test="${!canvote}">disabled="disabled"</g:if> class="comment" id="comment${song.id}">${comments[song.id]}</textarea>
    		</td>
     		</tr>
    	</g:each>
    	</tbody>
    	</table>
    	</div>
    </g:each>
    </body>
</html>