package test.driven.development.tdd.chapter1

class Pair(private val from: String, private val to: String) {

    override fun equals(other: Any?): Boolean {
        val pair = other as Pair
        return from == pair.from && to == pair.to
    }

    override fun hashCode(): Int {
        return 0
    }
}