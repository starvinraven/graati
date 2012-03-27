package graati

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class BlogEntryController {

    def scaffold = true
}
