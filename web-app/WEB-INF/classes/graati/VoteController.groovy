package graati

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class VoteController {

    def scaffold = true
}
