package artkart
import com.artkart.data.secure.Role
import com.artkart.data.secure.User
import com.artkart.data.secure.UserRole
import com.artkart.data.Item

class BootStrap {

    def init = { servletContext ->
        def item1=new Item(name:"Landscape",cost:2300.0d).save()
        item1.save()
        def item2=new Item(name:"Wildlife",cost:26666.0d).save()
        item2.save()
        def item3=new Item(name:"Aerial",cost:23904.0d).save()
        item3.save()
        def item4=new Item(name:"Sports",cost:23304.0d).save()
        item4.save()
        def item5=new Item(name:"Black and White",cost:33234.0d).save()
        item5.save()
        def item6=new Item(name:"Architectural",cost:55234.0d).save()
        item6.save()
        def item7=new Item(name:"Fashion",cost:7234.0d).save()
        item7.save()
        def item8=new Item(name:"Beauty",cost:2334.0d).save()
        item8.save()
        def item9=new Item(name:"Bird",cost:2345.0d).save()
        item9.save()

        def user_role = new Role(authority: 'ROLE_USER')
        user_role.save()

        def admin_role = new Role(authority: 'ROLE_ADMIN')
        admin_role.save()

        def me = new User(username : 'ramesh', password : 'ramesh',firstName:"Ramesh",lastName:"Datti",age:29, mobileNumber:"9000144104",email:"ramesh.grails@gmail.com")
        me.save()

        UserRole.create(me, user_role)

        def admin = new User(username : 'admin', password : 'admin',firstName:"Naresh",lastName:"Datti",age:29, mobileNumber:"9000144108",email:"naresh.grails@gmail.com")
        admin.save()
        UserRole.create(admin, admin_role)

    }
    def destroy = {
    }
}
