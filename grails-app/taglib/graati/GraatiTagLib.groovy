package graati

class GraatiTagLib {

	static namespace = "graati"
	
	def sidebarViews = [ "main" : [ "index" ]]
	
	def contentClass = {
		// println webRequest.controllerName +":"+webRequest.actionName
		if(webRequest.actionName in sidebarViews[webRequest.controllerName]) {
			out << "contentNarrow"
		} else {
			out << "content"
		}
	}
	
	def ifSidebar = { attrs, body ->
		if(webRequest.actionName in sidebarViews[webRequest.controllerName]) {
			out << body()
		}
	}
	
	def voteToColor = { attrs ->
		// println attrs
		def score = attrs.score ? attrs.score as Float : null
		if(!score) {
			out << "#ffffff"
			return
		}
		def k_r = -22.1
		def c_r = 255
		def k_g = 22.1
		def c_g = 34
		def a = -4.9
		def b = 49
		def c = 22
		
		def red = (k_r * score) + c_r as Integer
		def green = (k_g * score) + c_g as Integer 
		def blue = a*score*score + b*score + c as Integer
		
		def result = "#${Integer.toString(red, 16)}${Integer.toString(green, 16)}${Integer.toString(blue, 16)}"
		//println result
		out << result
	/*
    k_r = -22.1
    c_r = 255

    k_g = 22.1
    c_g = 34

    a = -4.9
    b = 49
    c = 22

    red = (k_r * score) + c_r
    grn = (k_g * score) + c_g
    blu = a*score*score + b*score + c

    result = "#%x%x%x" % (red, grn, blu)
	*/
	}
}
