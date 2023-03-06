package test.driven.development.tdd.chapter1

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class MoneyTest : DescribeSpec({

    describe("money") {

        context("입력값이 정수인 경우") {
            it("money의 amount가 입력 값 만큼 곱해진다.") {
                val sut: Money = Money(5, "CHF")

                sut.times(2) shouldBe Money(10, "CHF")
                sut.times(3) shouldBe Money(15, "CHF")
            }

            it("money의 amount가 입력 값 만큼 더해진다.") {
                val five = Money.dollar(5)
                val sum: Expression = five.plus(five)
                val bank = Bank()

                val reduced: Money = bank.reduce(sum, "USD")

                reduced shouldBe Money.dollar(10)
            }
        }

        context("money를 상속한 자식클래스의 경우") {
            it("동치성을 보장한다.") {
                (Money.dollar(5) == Money.dollar(5)) shouldBe true
                (Money.dollar(5) == Money.dollar(6)) shouldBe false
                (Money.franc(5) == Money.dollar(5)) shouldBe false
            }
        }

        context("currency() 메소드를 호출할 경우") {
            it("생성된 객체의 통화를 반환한다.") {
                "USD" shouldBe Money.dollar(1).currency()
                "CHF" shouldBe Money.franc(1).currency()
            }
        }
    }
}) {

    @Test
    fun `test plus returns sum`() {
        val five = Money.dollar(5)
        val result = five.plus(five)

        val sum = result as Sum

        five shouldBe sum.augend
        five shouldBe sum.addend
    }

    @Test
    fun `test reduce sum`() {
        val sum = Sum(Money.dollar(3), Money.dollar(4))
        val bank = Bank()

        val result: Money = bank.reduce(sum, "USD")

        result shouldBe Money.dollar(7)
    }

    @Test
    fun `test reduce money`() {
        val bank = Bank()

        val result: Money = bank.reduce(Money.dollar(1), "USD")

        result shouldBe Money.dollar(1)
    }

    @Test
    fun `test reduce money different currency`() {
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result = bank.reduce(Money.franc(2), "USD")
        result shouldBe Money.dollar(1)
    }

    @Test
    fun `test array equals`() {
        val array = Array(1) { "abc" }
        val array2 = Array(1) { "abc" }
        array shouldBe array2
    }

    @Test
    fun `test identity rate`() {
        val rate = Bank().rate("USD", "USD")

        rate shouldBe 1
    }

    @Test
    fun `equals == test`() {
        val result = Pair("A", "B") == Pair("A", "B")

        result shouldBe true
    }

    @Test
    fun `test mixed addition`() {
        val fiveBucks = Money.dollar(5)
        Money.franc(10)
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
    }
}