package graati
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class SongController {

    def scaffold = true
}
