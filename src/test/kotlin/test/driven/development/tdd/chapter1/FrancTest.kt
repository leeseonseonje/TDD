package test.driven.development.tdd.chapter1

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class FrancTest : DescribeSpec({

    describe("franc") {
        context("입력값이 정수인 경우") {
            it("franc의 amount가 입력 값 만큼 곱해진다.") {
                val sut = Money.franc(5)

                sut.times(2) shouldBe Money.franc(10)
                sut.times(3) shouldBe Money.franc(15)
            }
        }

        context("두 개의 franc객체의 값이 같을 경우") {
            it("equals는 true를 반환하다.") {
                Money.franc(5).equals(Money.franc(5)) shouldBe true
                Money.franc(5).equals(Money.franc(6)) shouldBe false
            }
        }
    }
}) {
}