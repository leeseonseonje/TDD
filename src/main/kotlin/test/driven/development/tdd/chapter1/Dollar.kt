package test.driven.development.tdd.chapter1

class Dollar(var amount: Int) {

    fun times(multiplier: Int) {
        amount *= multiplier
    }
}