package graati

import org.apache.commons.math.stat.descriptive.SummaryStatistics
import org.apache.commons.math.distribution.NormalDistributionImpl

class VoteService {
	
	static transactional = true
	
	def findByRaatiAndAlbum(Raati raati, Album album) {
		def c = Vote.createCriteria()
		c.list {
			and {
				eq("raati", raati)
				song {
					eq("album", album)
				}
			}
		}
	} 
	
	def getRaatiAggregates(Raati raati) {
		def votes = Vote.findAllByRaati(raati)
		if(votes.any { !it.normalizedScore }) {
			createNormalizedScores(raati)
		}
		ResultAggregates aggs = new ResultAggregates(votes)
	}
	
	// [ song : SongResults, song : SongResults, ... ]
	def getRaatiResults(Raati raati) {
		def votes = Vote.findAllByRaati(raati)
		if(votes.any { !it.normalizedScore }) {
			createNormalizedScores(raati)
		}
		def songs = raati.albums.collect { it.songs } ?.flatten().unique()
		def results = [:]
		songs.each { song ->
			def votesForSong = Vote.findAllByRaatiAndSong(raati, song).sort { a, b ->
				b.normalizedScore <=> a.normalizedScore
			}
			def votesForSongByUser = votesForSong?.groupBy {it.user}
			
			def resultsForSong = new ResultsForSong()
			
			resultsForSong.votes = votesForSongByUser
			resultsForSong.songResultAggregates = new ResultAggregates(votesForSong)
			resultsForSong.meanNormalizedScore = resultsForSong.songResultAggregates?.getMeanNormalizedScore()
	
			results.put((song), resultsForSong)
		}
		results = results.sort { a, b ->
			b.value.meanNormalizedScore <=> a.value.meanNormalizedScore // descending order
		}
		println "results: "+results
		results
	}
	/*
	 * Write normalized scores to db
	 */
	def createNormalizedScores(Raati raati) {
		def votes = Vote.findAllByRaati(raati).groupBy { it.user }
		
		votes.each { vote ->
			// println "vote: "+vote
			vote.each { // key: user, value: list of votes
				def userVotes = it.value
				// println "votes for user: ${it.key.username}: ${userVotes.collect {it.score}}"
				ResultAggregates aggregates = new ResultAggregates(userVotes)
				userVotes.each { userVote -> 
					userVote.normalizedScore = aggregates.getNormalizedScore(userVote.score)
					userVote.save(flush:true)
				}
			}
		}
	}

	/**
	 * return [ [songid : normScore] , .. ] collection for provided votes	
	 * @param votes
	 * @return
	 */
	def getNormalizedScores(def votes) {
		ResultAggregates aggregates = new ResultAggregates(votes)
		def normScores = [:]
		
		votes.each {
			def score = it.score
			if(score != null && score > 0) {
				normScores.put(it.song.id, aggregates.getNormalizedScore(score))
			} else {
				normScores.put(it.song.id, 0)
			}
		}
		
		normScores
	}
	
	def getNormalizedScores(User user, Raati raati) {
		double start = System.currentTimeMillis()
		def votes = Vote.findAllByUserAndRaati(user, raati)
		def res = getNormalizedScores(votes)
		println "getting normalized scores took ${System.currentTimeMillis()-start}ms"
		return res
	}

	class ResultsForSong {
		def songResultAggregates
		def votes // map keyed by user
		def meanNormalizedScore
	}
}
