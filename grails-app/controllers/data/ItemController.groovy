package data

import com.artkart.data.Cart
import com.artkart.data.Item
import com.artkart.data.secure.User
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.*

@Secured(value=["hasAnyRole('ROLE_ADMIN','ROLE_USER')"])
class ItemController {

    ItemService itemService
    def springSecurityService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    @Secured('permitAll')
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        User user=springSecurityService.currentUser
        Cart cart= Cart.findByUser(user)
        respond itemService.list(params), model:[itemCount: itemService.count(),cart:cart]
    }

    def show(Long id) {
        respond itemService.get(id)
    }

    def create() {
        respond new Item(params)
    }

    def save(Item item) {
        if (item == null) {
            notFound()
            return
        }

        try {
            itemService.save(item)
        } catch (ValidationException e) {
            respond item.errors, view:'create'
            return
        }

        redirect(action: "index")
    }

    def edit(Long id) {
        respond itemService.get(id)
    }

    def update(Item item) {
        if (item == null) {
            notFound()
            return
        }

        try {
            itemService.save(item)
        } catch (ValidationException e) {
            respond item.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'item.label', default: 'Item'), item.id])
                redirect item
            }
            '*'{ respond item, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        itemService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'item.label', default: 'Item'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'item.label', default: 'Item'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
