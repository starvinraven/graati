<html>
<head>
<title>
${raati.name}: ${number}/${max}
</title>
<link rel="stylesheet" href="${resource(dir:'css',file:'results.css')}" />
<g:javascript src="jquery/jquery-1.4.2.min.js" />
<script type="text/javascript">
$(document).ready(function() {
	$("#songwhat").click(function() {
		$("#songwhat").fadeOut(1000, function() {
			$("#songname").fadeIn(1000);
		});
	});
});
</script>
</head>
<body>
<div class="resultsTop">
<div class="topNav left huge">
<g:if test="${number>1}">
<g:def var="prev" value="${number-1}"/>
<g:link action="viewOne" params="[id:raati.id,songNumber:prev]">
     < ${prev}
</g:link>
</g:if>
</div>
<div class="topNav right huge">
<g:if test="${number<max}">
<g:def var="next" value="${number+1}"/>
<g:link action="viewOne" params="[id:raati.id,songNumber:next]">
     ${next} >
</g:link>
</g:if>
</div>
<div id="topCenter" class="huge">
<span class="smaller">${number}/${max}</span><span id="songname">${song?.name}</span><span id="songwhat">?</span>
</div>
</div>

<div class="resultsStats left">
<div class="score left reallyhuge" style="background-color:<graati:voteToColor score='${result.meanNormalizedScore}'/>">
<g:formatNumber number="${result.meanNormalizedScore}" format="0.0" />
</div>
<div class="stats">
<table class="left">
<tr><td colspan="2">${result.votes.size()} votes</td></tr>
<tr><td>&mu; norm</td><td><g:formatNumber number="${result.meanNormalizedScore}" format="0.00" /></td></tr>
<tr><td>&mu; unnorm</td><td><g:formatNumber number="${result.songResultAggregates.meanScore}" format="0.00" /></td></tr>
<tr><td>&sigma; norm</td><td><g:formatNumber number="${result.songResultAggregates.normStats.getStandardDeviation()}" format="0.00" /></td></tr>
<tr><td>&sigma; unnorm</td><td><g:formatNumber number="${result.songResultAggregates.stdDev}" format="0.00" /></td></tr>
</table>
</div>
	<div>
    <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="165" height="38" id="niftyPlayer1" align="">
		<param name=movie value="swf/niftyplayer.swf">
		<param name=quality value=high>
		<param name=bgcolor value=#699C4D>
		<embed src="/graati/swf/niftyplayer.swf?file=${song.audioUrl.encodeAsURL()}&as=1" quality=high bgcolor=#699C4D width="165" height="38" name="niftyPlayer1" align="" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer">
		</embed>
	</object>
	</div>
</div>
<div class="resultsVotes">

<g:each in="${result.votes}" var="vote">
<g:def var="toSongStdDev" value="${(vote.value.normalizedScore[0] - result.meanNormalizedScore)/result.songResultAggregates.normStats.getStandardDeviation()}"/>
<g:def var="toRaatiStdDev" value="${(vote.value.normalizedScore[0] - raatiMean)/raatiStdDev}"/>
<div class="vote">
<div class="user left">
${vote.key.username}
</div>
<div class="voteScore left huge" style="background-color:<graati:voteToColor score='${vote.value.normalizedScore[0]}'/>">
<g:formatNumber number="${vote.value.normalizedScore[0]}" format="0.0" />
</div>
<div class="other left">
Vote = <g:formatNumber number="${vote.value.score[0]}" format="0.0" /><br/>
&Delta; = <g:formatNumber number="${vote.value.normalizedScore[0] - result.meanNormalizedScore}" format="0.0"/><br/>
&Delta;&mu;<sub>s</sub> = <g:formatNumber number="${toSongStdDev}" format="0.00" /><br/>
&Delta;&mu;<sub>r</sub> = <g:formatNumber number="${toRaatiStdDev}" format="0.00" /><br/>
</div>
<div class="comment left">
<g:if test="${vote.value.comment[0]}">
${vote.value.comment[0]}
</g:if>
</div>
</div>
</g:each>

</div>
</body>
</html>

