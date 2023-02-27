package test.driven.development.tdd.chapter1

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*

internal class MoneyTest : DescribeSpec({

    describe("money") {
        context("money를 상속한 자식클래스의 경우") {
            it("동치성을 보장한다.") {
                Dollar(5).equals(Dollar(5)) shouldBe true
                Dollar(5).equals(Dollar(6)) shouldBe false
                Franc(5).equals(Franc(5)) shouldBe true
                Franc(5).equals(Franc(6)) shouldBe false
            }
            }
        }
}){

}