package test.driven.development.tdd.chapter1

interface Expression {
    fun reduce(bank: Bank, to: String): Money
}