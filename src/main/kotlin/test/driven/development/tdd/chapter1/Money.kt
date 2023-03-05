package test.driven.development.tdd.chapter1

import java.util.*

open class Money(protected val amount: Int,
                     protected val currency: String) {

    open fun times(multiplier: Int): Money {
        return Money(amount.times(multiplier), currency)
    }

    fun currency(): String {
        return currency
    }

    companion object {
        fun dollar(amount: Int): Money {
            return Dollar(amount, "USD")
        }

        fun franc(amount: Int): Money {
            return Franc(amount, "CHF")
        }
    }

    override fun equals(other: Any?): Boolean {
        val money: Money = other as Money
        return this.amount == money.amount
                && currency().equals(money.currency())
    }

    override fun toString(): String {
        return "$amount  $currency"
    }
}
