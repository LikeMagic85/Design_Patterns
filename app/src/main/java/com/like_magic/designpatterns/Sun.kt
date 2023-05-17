package com.like_magic.designpatterns

object Sun {

    var temp = 100000

    fun addTemp(value:Int){
        temp += value
    }

    fun newInstance() = this

}