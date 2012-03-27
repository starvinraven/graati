package graati

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class RaatiController {

    def scaffold = true
}
