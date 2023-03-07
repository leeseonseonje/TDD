package test.driven.development.tdd.chapter1

interface Expression {
    fun reduce(bank: Bank, to: String): Money

    fun plus(addend: Expression): Expression

    fun times(multiplier: Int): Expression
}