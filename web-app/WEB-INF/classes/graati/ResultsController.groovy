package graati

class ResultsController {

	def userService
	def voteService
	
	/**
	 * Index for all (ended) raatis with results published 
	 */
    def index = {
		def raatis = Raati.findAllByResultsReleased(true)
		[ 'raatis' : raatis ]
	}
	
	/**
	 * Index for single raati
	 */
	def view = {
		def id = params.id
		if (!id || !Raati.get(id)) {
			flash['message'] = "Invalid raati"
			redirect(uri:"/")
		}
		def raati = Raati.get(id)
		def user = userService.getLoggedOnUser()
		if((!userService.canViewRaati(user, raati) || !raati.resultsReleased) && user != raati.owner) {
			flash['message'] = "Cannot view raati results"
			redirect(uri:"/")
		} 
		def votes = Vote.findAllByRaati(raati)
		def votesByUser = votes.groupBy { it.user.username }
		def usernames = votesByUser.keySet()

		def songNames = []
		raati.albums.each { album ->
			album.songs.each { song ->
				songNames.add(song.name)
			}
		}
		def voteList = []
		songNames.each { songName ->
			def m = [:]
			usernames.each { userName ->
				m.put(userName, votes.find { vote -> (vote.user.username == userName && vote.song.name == songName) })
			}
			voteList.add([(songName):m])
		}
		
		['raati' : raati, 'voteList' : voteList, 'usernames' :usernames ]
	}

	/**
	 * View all results of raati on single page
	 */
	def viewAll = {
		def raatiId = params.id
		//def number = params.number
		def raati = Raati.get(raatiId)
		def user = userService.getLoggedOnUser()
		if(!userService.canViewRaatiResults(user, raati) || !raati) {
			flash['message'] = "Cannot view raati results"
			redirect(uri:"/")
		}
		[ results : voteService.getRaatiResults(raati), raati : raati ]
	}

	/**
	 * View one song by its ranking	
	 */
	def viewOne = {
		def raati = Raati.get(params.id)
		def user = userService.getLoggedOnUser()
		if(!userService.canViewRaatiResults(user, raati) || !raati) {
			flash['message'] = "Cannot view raati results"
			redirect(uri:"/")
		}
		def songNumber = params.songNumber
		println "songNumber: ${songNumber}, params: ${params}"
		def results = voteService.getRaatiResults(raati)
		def song 
		def result
		def max = 0
		def raatiAggs = voteService.getRaatiAggregates(raati)
		def raatiStdDev = raatiAggs.normStats.getStandardDeviation()
		def raatiMean = raatiAggs.normStats.getMean()
		results.eachWithIndex { key, value, index ->
			max++
			println index
			if(index == ( (songNumber as int) -1)) {
				println "got it"
				song = key
				result = value
			}
		}
		if(!song) {
			flash['message'] = "Invalid song number"
			redirect(uri:"/")
		}
		println "song: ${song}, result: ${result}, number: ${songNumber}"
		[ result : result, song: song, raati: raati, number: songNumber as int, max: max as int, 
			raatiStdDev:raatiStdDev, raatiMean:raatiMean]
	}


		
}
