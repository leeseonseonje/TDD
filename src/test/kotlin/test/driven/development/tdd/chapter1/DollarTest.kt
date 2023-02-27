package test.driven.development.tdd.chapter1

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class DollarTest : DescribeSpec({

    describe("dollar") {
        context("입력값이 정수인 경우") {
            it("dollar의 amount가 입력 값 만큼 곱해진다.") {
                val sut = Dollar(5)

                sut.times(2) shouldBe Dollar(10)
                sut.times(3) shouldBe Dollar(15)
            }
        }

        context("두 개의 Dollar객체의 값이 같을 경우") {
            it("equals는 true를 반환하다.") {
                Dollar(5).equals(Dollar(5)) shouldBe true
                Dollar(5).equals(Dollar(6)) shouldBe false
            }
        }
    }
}) {
}