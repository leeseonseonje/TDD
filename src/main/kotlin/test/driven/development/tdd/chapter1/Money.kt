package test.driven.development.tdd.chapter1

class Money(val amount: Int,
            private val currency: String) : Expression {

    override fun times(multiplier: Int): Expression {
        return Money(amount.times(multiplier), currency)
    }

    override fun plus(addend: Expression): Expression {
        return Sum(this, addend)
    }

    fun currency(): String {
        return currency
    }

    companion object {
        fun dollar(amount: Int): Money {
            return Money(amount, "USD")
        }

        fun franc(amount: Int): Money {
            return Money(amount, "CHF")
        }
    }

    override fun reduce(bank: Bank, to: String): Money {
        val rate = bank.rate(currency, to)
        return Money(amount.div(rate), to)
    }

    override fun equals(other: Any?): Boolean {
        val money: Money = other as Money
        return this.amount == money.amount
                && currency() == money.currency()
    }

    override fun toString(): String {
        return "$amount  $currency"
    }
}
