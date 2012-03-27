package graati

import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils

class UserService {
	
	static transactional = true
	
	def springSecurityService
	
	def getLoggedOnUser() {
		def user = null
		if(springSecurityService.isLoggedIn()) {
			def username = springSecurityService.principal?.username
			user = User.findByUsername(username)
		}
		return user
	}
	
	def getViewableRaatis() {
		def user = getLoggedOnUser()
		
		def c = Raati.createCriteria()
		def results = c.list {
			or {
				eq("privacy", RaatiPrivacy.PUBLIC)
				eq("privacy", RaatiPrivacy.PARTICIPANT_VOTING)
				participants {
					eq("id", user?.id)
				}
				owner {
					eq("id", user?.id)
				}
			}
		}
		results
	}
	
	
	def canViewRaatiResults(User user, Raati raati) {
		SpringSecurityUtils.ifAllGranted("ROLE_ADMIN") || (canViewRaati(user, raati) && raati.resultsReleased)
	}
	
	def canViewRaati(User user, Raati raati) {
		if(user == raati.owner) {
			return true
		} /*else if(raati.resultsReleased || raati.ends < new Date()) {
			return false
		}*/
		def privacy = raati.privacy
		switch(privacy) {
			case RaatiPrivacy.PUBLIC:
			case RaatiPrivacy.PARTICIPANT_VOTING:
				return true
			case RaatiPrivacy.PARTICIPANT_VIEWING:
				return user in raati.participants
		}
	}
	
	def canVote(User user, Raati raati) {
		if(raati?.resultsReleased || raati?.ends < new Date()) {
			return false
		}
		def privacy = raati.privacy
		switch(privacy) {
			case RaatiPrivacy.PUBLIC:
				return true
			case RaatiPrivacy.PARTICIPANT_VIEWING:
			case RaatiPrivacy.PARTICIPANT_VOTING:
				return (user == raati.owner || user in raati.participants)
		}
	}
	
	/*
	def canViewRaatiResults(User user, Raati raati) {
		if(raati.owner == user) {
			return true
		}
		
		if(raati.ends < new Date()) {
			return false
		}
		
		def privacy = raati.privacy
		switch(privacy) {
			case RaatiPrivacy.PUBLIC:
			case RaatiPrivacy.PARTICIPANT_VIEWING:
				return true
			case RaatiPrivacy.PARTICIPANT_VOTING:
				return (user in raati.participants)
		}
	}
	*/
}
