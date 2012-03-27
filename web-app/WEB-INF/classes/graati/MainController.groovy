package graati

class MainController {
	
	def userService
	
	def index = { 
		def raatis = userService.getViewableRaatis().sort { it.ends }
		println raatis
		def raatiList = []
		def user = userService.getLoggedOnUser()
		raatis.each { raati ->
			def raatiMap = [:]
			def numSongs = raati.albums.collect { album -> album.songs.size() }.sum()
			def numVotes = Vote.findAllByUserAndRaati(user, raati).findAll { it.score > 0 }?.size()

			raatiMap.put("id", raati.id)
			raatiMap.put("name", raati.name)
			raatiMap.put("albums", raati.albums.size())
			raatiMap.put("songs", numSongs)
			raatiMap.put("voted", (((numVotes?:0) as Float)/numSongs)*100)
			raatiMap.put("privacy", raati.privacy.description)
			raatiMap.put("ends", raati.ends)
			raatiList.add(raatiMap)
		}
		
		def blogEntries = BlogEntry.findAllByPublished(true, [sort:"dateCreated", order:"desc"])
		
		// raatis.each { println it.properties }
		println raatiList
		[ "raatis" : raatiList, "blogEntries" : blogEntries ]	
	}
}
