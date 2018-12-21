package data

import com.artkart.data.Cart
import grails.gorm.services.Service

@Service(Cart)
interface CartService {

    Cart get(Serializable id)

    List<Cart> list(Map args)

    Long count()

    void delete(Serializable id)

    Cart save(Cart cart)


}