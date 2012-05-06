package graati

class VotingController {
	
	def springSecurityService
	def userService
	def voteService
	
	def index = { 
		def id = params.id
		if(!id) {
			flash['message'] = "No raati id provided"
			redirect(uri:"/")
		}
		def user = userService.getLoggedOnUser()
		def raati = Raati.get(id)
		if(!raati || !userService.canViewRaati(user, raati)) {
			flash['message'] = "Invalid raati id"
			redirect(uri:"/")
		}
		
		def albums = raati.albums.sort { a, b ->
			if(a.releaseYear == b.releaseYear) {
				a.id - b.id
			} else {
				a.releaseYear - b.releaseYear
			}
		}
		
		// def hasUrls = raati.albums.each { it.songs.filter { song -> song.audioUrl != null } }.size() > 0
		def votes = [:]
		def comments = [:]
		def normScores = [:]
		def canvote = false
		
		if(user) {
			def voteObjects = Vote.findAllByUserAndRaati(user, raati)
			normScores = voteService.getNormalizedScores(user, raati)
			voteObjects.each { vote->
				votes.put((vote.song.id), vote.score)
				comments.put((vote.song.id), vote.comment)
			}
			if(userService.canVote(user, raati)) {
				canvote = true
			}
		}
		
		def res = ['albums' : albums, 'votes' : votes, 'raati' : id, 
			'normalized' : normScores, 'raatiname' : raati.name, 
			'comments' : comments, 'canvote' : canvote, 
			'ownername' :raati.owner.username ]
		println res
		res 
	}
}
