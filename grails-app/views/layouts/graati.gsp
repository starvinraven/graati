<%-- 
<html>
    <head>
        <title><g:layoutTitle default="Graati" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'graati.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <g:layoutHead />
        <g:javascript src="jquery/jquery-1.4.2.min.js" />
        <g:javascript library="application" />
    </head>
    <body>
    	<div class="wrapper">
        <div class="top">
        	<h1><g:link controller="main">Graati</g:link></h1>
        	<span>
        	<sec:ifLoggedIn>
				Logged on as <sec:username/>. <g:link controller="logout" action="index">Logout</g:link>
			</sec:ifLoggedIn>
			<sec:ifNotLoggedIn>
				<g:link controller='login' action='auth'>Login</g:link>
			</sec:ifNotLoggedIn>
			</span>
        </div>
       	<g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
        </g:if>
        <g:layoutBody />
        </div>
    </body>
</html>
--%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><g:layoutTitle default="Graati" /></title>
<link rel="stylesheet" href="${resource(dir:'css',file:'style.css')}" />
<link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
<g:layoutHead />
<g:javascript src="jquery/jquery-1.4.2.min.js" />
<g:javascript library="application" />
</head>
<body>
<div id="header">
	<div id="logo">
		<h1><g:link controller="main">Graati</g:link></h1>
		<p></p>
	</div>
	<!-- end #logo -->
	<div style="height:130px; float:right;">
	<div id="menu">
		<ul>
			<li class="first"><g:link controller="main">Home</g:link></li>
			<li><a href="#">FAQ</a></li>
			<sec:ifLoggedIn>
				<li><g:link controller="raati" action="create">Create new</g:link></li>
				<li><a href="#">Logged on as <sec:loggedInUserInfo field="username"/></a></li>
				<li><g:link controller="logout" action="index">Logout</g:link></li>
			</sec:ifLoggedIn>
			<sec:ifNotLoggedIn>
				<li><g:link controller='register'>Register</g:link></li>
				<li><g:link controller='login' action='auth'>Login</g:link></li>
			</sec:ifNotLoggedIn>
		</ul>
	</div>
	<br/>
	<div id="player">
    <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="165" height="38" id="niftyPlayer1" align="">
		<param name=movie value="swf/niftyplayer.swf">
		<param name=quality value=high>
		<param name=bgcolor value=#699C4D>
		<embed src="swf/niftyplayer.swf" quality=high bgcolor=#699C4D width="135" height="38" name="niftyPlayer1" align="" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer">
		</embed>
	</object>
	</div>
	</div>
	<!-- end #menu -->
</div>
<!-- end #header -->
<div id="page">
	<div id="<graati:contentClass/>">
	
		<g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
        </g:if>
        <g:layoutBody />
		<%-- 
		<div class="post">
			<h1 class="title">Welcome to our website </h1>
			<p class="byline"><small>Posted by FreeCssTemplates</small></p>
			<div class="entry">
				<p><strong>Green and Plain</strong> is a free template from <a href="http://www.freecsstemplates.org/">Free CSS Templates</a> released under a <a href="http://creativecommons.org/licenses/by/2.5/">Creative Commons Attribution 2.5 License</a>. You're free to use this template for both commercial or personal use. I only ask that you link back to <a href="http://www.freecsstemplates.org/">my site</a> in some way. Enjoy :)</p>

			</div>
			<div class="meta">
				<p class="links"><a href="#" class="comments">Comments (32)</a> &nbsp;&bull;&nbsp;&nbsp; <a href="#" class="more">Read full post &raquo;</a></p>
			</div>
		</div>
		<div class="post">
			<h2 class="title">Lorem Ipsum Dolor Volutpat</h2>

			<p class="byline"><small>Posted by FreeCssTemplates</small></p>
			<div class="entry">
				<p>Curabitur tellus. Phasellus tellus turpis, iaculis in, faucibus lobortis, posuere in, lorem. Donec a ante. Donec neque purus, adipiscing id, eleifend a, cursus vel, odio. Vivamus varius justo sit amet leo. Morbi sed libero. Vestibulum blandit augue at mi. Praesent fermentum lectus eget diam. Nam cursus, orci sit amet porttitor iaculis, ipsum massa aliquet nulla, non elementum mi elit a mauris.</p>
				<ul>
					<li><a href="#">Magna lacus bibendum mauris</a></li>
					<li><a href="#">Velit semper nisi molestie</a></li>
					<li><a href="#">Magna lacus bibendum mauris</a></li>

					<li><a href="#">Velit semper nisi molestie</a></li>
				</ul>
			</div>
			<div class="meta">
				<p class="links"><a href="#" class="comments">Comments (32)</a> &nbsp;&bull;&nbsp;&nbsp; <a href="#" class="more">Read full post &raquo;</a></p>
			</div>

			
		</div>
		--%>
	</div>
	<!-- end #content -->
	<graati:ifSidebar>
	<div id="sidebar">
		<div id="sidebar-bgtop"></div>
		<div id="sidebar-content">
			<ul>
			<%-- 
				<li id="search">
					<h2>Search</h2>

					<form method="get" action="">
						<fieldset>
						<input type="text" id="s" name="s" value="" />
						<input type="submit" id="x" value="Search" />
						</fieldset>
					</form>
				</li>
			--%>
				<li>
					<h2>Raatis for you</h2>

					<ul>
					<g:each in="${raatis}" status="i" var="raati">
						<li><a href="voting?id=${raati.id}">${raati.name}</a></li>
					</g:each>
					</ul>
				</li>
				<%-- 
				<li>
					<h2>Finished raatis</h2>
					<ul>

						<li><a href="#">Nec metus sed donec</a></li>
						<li><a href="#">Magna lacus bibendum mauris</a></li>
						<li><a href="#">Velit semper nisi molestie</a></li>
						<li><a href="#">Eget tempor eget nonummy</a></li>
					</ul>
				</li>
				--%>
			</ul>
		</div>
		<div id="sidebar-bgbtm"></div>
	</div>
	<!-- end #sidebar -->
	</graati:ifSidebar>
</div>
<!-- end #page -->
<div id="footer">
	<p>&copy; 2010 Esa Virtanen, All Rights Reserved.<%-- Layout design by <a href="http://www.freecsstemplates.org/">Free CSS Templates</a>.--%></p>
</div>
<!-- end #footer -->
</body>
</html>

