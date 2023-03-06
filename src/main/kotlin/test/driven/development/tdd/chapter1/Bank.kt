package test.driven.development.tdd.chapter1

import java.util.*

class Bank(private val rates: Hashtable<Pair, Int> = Hashtable()) {

    fun reduce(source: Expression, to: String): Money {
        return source.reduce(this, to)
    }

    fun rate(from: String, to: String): Int {
        if (from == to) return 1
        return rates[Pair(from, to)] ?: 0
    }

    fun addRate(from: String, to: String, rate: Int) {
        rates[Pair(from, to)] = rate
    }
}