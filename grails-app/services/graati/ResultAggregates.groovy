package graati

import org.apache.commons.math.stat.descriptive.SummaryStatistics
import org.apache.commons.math.distribution.NormalDistributionImpl

class ResultAggregates {
	def meanScore
	def stdDev
	NormalDistributionImpl normalDistribution
	
	SummaryStatistics normStats = new SummaryStatistics()
	SummaryStatistics stats = new SummaryStatistics()
	
	public ResultAggregates(def votes) {
		votes.each { vote ->
			if(vote.normalizedScore) {
				normStats.addValue(vote.normalizedScore)
			}
			if(vote.score) {
				stats.addValue(vote.score)
			}
		}

		stdDev = stats.getStandardDeviation()+0.000001 // to avoid divide by zero
		meanScore = stats.getMean()
		def normScores = [:]
		normalDistribution = new NormalDistributionImpl(meanScore, stdDev)
	}
	
	def getNormalizedScore(def score) {
		if(score) {
			normalDistribution.cumulativeProbability(score)*10
		} else {
			null
		}
	}
	
	def getMeanNormalizedScore() {
		normStats.mean
	}
	
}
