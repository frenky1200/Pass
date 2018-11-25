package com.example.vpb.pass

data class Entity(val id: Int, val name: String, val login: String, val pass: String){
    override fun toString(): String {

        return """$name
        login $login
        pass $pass"""
    }
}