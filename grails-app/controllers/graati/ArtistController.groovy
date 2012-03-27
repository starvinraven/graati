package graati

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class ArtistController {

    def scaffold = true
}
