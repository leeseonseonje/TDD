package test.driven.development.tdd.chapter1

class Franc(amount: Int) : Money(amount) {

    fun times(multiplier: Int): Franc {
        return Franc(amount.times(multiplier))
    }
}