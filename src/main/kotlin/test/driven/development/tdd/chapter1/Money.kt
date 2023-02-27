package test.driven.development.tdd.chapter1

open class Money(protected val amount: Int) {

    override fun equals(other: Any?): Boolean {
        val money: Money = other as Money
        return this.amount == money.amount
    }
}
