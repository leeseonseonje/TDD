package test.driven.development.tdd.chapter1

class Dollar(amount: Int) : Money(amount) {

    fun times(multiplier: Int): Dollar {
        return Dollar(amount.times(multiplier))
    }
}