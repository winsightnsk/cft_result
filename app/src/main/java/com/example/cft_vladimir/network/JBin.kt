package com.example.cft_vladimir.network

data class JBin(
    val bank: Bank,
    val brand: String,
    val country: Country,
    val number: Number,
    val prepaid: Boolean,
    val scheme: String,
    val type: String,
)

fun JBin.toS(): String{
    var s = "Bank:"
    s+= "\n   city: ${this.bank.city}"
    s+= "\n   name: ${this.bank.name}"
    s+= "\n   url: ${this.bank.url}\n"
    s+= "\nCountry:"
    s+= "\n   name: ${this.country.name}"
    s+= "\n   alpha2: ${this.country.alpha2}"
    s+= "\n   emoji: ${this.country.emoji}"
    s+= "\n   currency: ${this.country.currency}"
    s+= "\n   latitude: ${this.country.latitude}"
    s+= "\n   longitude: ${this.country.longitude}"
    s+= "\n   numeric: ${this.country.numeric}\n"
    s+= "\nbrand: ${this.brand}\n"
    s+= "\nNumber:"
    s+= "\n   length: ${this.number.length}"
    s+= "\n   luhn: ${this.number.luhn}\n"
    s+= "\nprepaid: ${this.prepaid}\n"
    s+= "\nscheme: ${this.scheme}\n"
    s+= "\ntype: ${this.type}\n"
    return s
}