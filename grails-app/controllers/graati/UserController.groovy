package graati

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class UserController {

    def scaffold = graati.User
}
