package com.artkart.data

import com.artkart.data.secure.User

class Cart {
    User user
    static hasMany=[items:Item]
    static constraints = {
    }
}
