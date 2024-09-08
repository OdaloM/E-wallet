package com.example.e_wallet20.model

import android.icu.util.CurrencyAmount


class Client {
    var name: String=""
    var amount: String = ""
    var id: String=""
    constructor(
                name: String,
                amount: String,
                id: String){

        this.name=name
        this.amount= amount
        this.id=id
    }
    constructor()

}