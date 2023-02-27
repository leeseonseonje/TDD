package test.driven.development.tdd.chapter1

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class FrancTest : DescribeSpec({

    describe("franc") {
        context("입력값이 정수인 경우") {
            it("franc의 amount가 입력 값 만큼 곱해진다.") {
                val sut = Franc(5)

                sut.times(2) shouldBe Franc(10)
                sut.times(3) shouldBe Franc(15)
            }
        }

        context("두 개의 franc객체의 값이 같을 경우") {
            it("equals는 true를 반환하다.") {
                Franc(5).equals(Franc(5)) shouldBe true
                Franc(5).equals(Franc(6)) shouldBe false
            }
        }
    }
}) {
}