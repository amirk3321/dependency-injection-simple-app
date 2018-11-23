package com.meer.dependencyinjection.data.model

data class Quotes(val auther : String ,
                  val autherQuote : String) {
    override fun toString(): String {
        return "$auther - $autherQuote"
    }
}