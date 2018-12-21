package data
import com.artkart.data.secure.User
import grails.plugin.springsecurity.annotation.Secured

@Secured(value=["hasAnyRole('ROLE_USER','ROLE_ADMIN')"])
class UserController {
    def springSecurityService
    def viewProfile() {
        User user=springSecurityService.currentUser
        respond user
    }
}
