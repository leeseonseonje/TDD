package test.driven.development.tdd.chapter1

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*

internal class MoneyTest : DescribeSpec({

    describe("money") {
        context("money를 상속한 자식클래스의 경우") {
            it("동치성을 보장한다.") {
                Money.dollar(5).equals(Money.dollar(5)) shouldBe true
                Money.dollar(5).equals(Money.dollar(6)) shouldBe false
                Money.franc(5).equals(Money.franc(5)) shouldBe true
                Money.franc(5).equals(Money.franc(6)) shouldBe false
                Money.franc(5).equals(Money.dollar(5)) shouldBe false
            }
        }

        context("currency() 메소드를 호출할 경우") {
            it("생성된 객체의 통화를 반환한다.") {
                "USD" shouldBe Money.dollar(1).currency()
                "CHF" shouldBe Money.franc(1).currency()
            }
        }

        context("값은 같지만 클래스가 다른 경우") {
            it("값이 같기 때문에 True를 반환한다.") {
                Money(10, "CHF") shouldBe Franc(10, "CHF")
            }
        }
    }
}) {

}