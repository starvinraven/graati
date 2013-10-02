package graati

import grails.converters.JSON
import grails.plugins.springsecurity.Secured

class JsonController {
	
	def userService
	def voteService
	
	@Secured(['ROLE_USER', 'ROLE_ADMIN'])
	def savevote = {
		def user = userService.getLoggedOnUser()
		def vote = params.vote
		if(!((1..20).collect {it/2 as String}).contains(vote)) {
			vote = null
		}
		def song = Song.get(params.song)
		def raati = Raati.get(params.raati)
		if(!userService.canVote(user, raati)) {
			def res = ["result" : "error", "why": "cannotvote"]
			render res as JSON
			return
		}
		def comment = params.comment
		def res
		def scoreChanged = false
		
		if(user && song) {
			def existing = Vote.find("from Vote as v where user=:user and song=:song and raati=:raati",
			[user:user, song:song, raati:raati])
			if(existing) {
				println "updating existing with id ${existing?.id}"
				if(existing.score != vote as Float) {
					scoreChanged = true;
				}
				existing.score = vote as Float
				existing.comment = comment
				res = existing.save(flush:true)
				println "updated vote: $res"
			} else {
				if(vote != null) {
					scoreChanged = true;
				}
				println "saving vote, user: $user, vote: $vote, song: $song, raati: $raati"
				res = new Vote(user: user, score:vote, song:song, raati:raati, comment:comment).save(flush:true)
				println "saved vote: $res"
			}  
		}
		def result = res ? [ result:"ok" ] : [ result : "error" ]
		if(res && scoreChanged) {
			result.put("normalized", voteService.getNormalizedScores(user, raati))
		}
		render result as JSON
	}
}
