package org.evertones.test.units

import org.scalatest.FunSpec


class MySpec
    extends FunSpec {

    describe("An account test") {
        describe("when it has single account") {
            it("should verify some behavior") {
                println("The end 1!")
            }
        }
        describe("when it DOES NOT have single account") {
            it("should verify some behavior") {
                println("The end 2!")
            }
        }
    }

}