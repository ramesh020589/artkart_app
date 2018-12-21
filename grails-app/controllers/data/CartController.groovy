package data

import com.artkart.data.Cart
import com.artkart.data.Item
import com.artkart.data.secure.User
import grails.plugin.springsecurity.annotation.Secured

@Secured(value=["hasAnyRole('ROLE_USER','ROLE_ADMIN')"])
class CartController {

    CartService cartService
    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def index(){
        redirect(action:"show")
    }
    def show(Long id) {
        Cart cart
        if(id==null){
            User user=springSecurityService.currentUser
            cart= Cart.findByUser(user)
        }else{
            cart=cartService.get(id)
        }
        respond cart
    }

    def addItemToCart() {
        User user=springSecurityService.currentUser
        Item item= Item.findById(params.id)
        Cart cart= Cart.findByUser(user)
        if(cart==null){
            cart = new Cart(user:user)
        }
        cart.addToItems(item)
        cart.save(flush:true)
        redirect(action: "show", params:[id: cart.id])
    }
    def removeFromCart() {
        User user=springSecurityService.currentUser
        Item item= Item.findById(params.id)
        Cart cart= Cart.findByUser(user)
        cart.removeFromItems(item)
        cart.save(flush:true)
        redirect(action: "show", params:[id: cart.id])
    }


}
