package test.driven.development.tdd.chapter1

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class DollarTest : DescribeSpec({

    describe("times") {
        context("입력값이 정수인 경우") {
            it("dollar의 amount가 입력 값 만큼 곱해진다.") {
                val sut = Dollar(5)

                sut.times(2)

                sut.amount shouldBe 10
            }
        }
    }
}) {
}