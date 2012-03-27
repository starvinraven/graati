package graati

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER'])
class ManagerController {

	def userService
	
    def index = {
		def user = userService.getLoggedOnUser()
		def raatis = Raati.findAllByOwner(user)
		['raatis' : raatis]
	}
}
