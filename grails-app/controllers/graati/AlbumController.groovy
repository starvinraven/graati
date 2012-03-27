package graati

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class AlbumController {

    def scaffold = true
}
