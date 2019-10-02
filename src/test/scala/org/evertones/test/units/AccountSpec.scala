package org.evertones.test.units

import org.evertones.controller.AccountController
import org.evertones.dtos.AccountData
import org.evertones.model.{Account, Details, Timezone}
import org.evertones.processors.AccountDataProcessor
import org.evertones.services.AccountService
import org.mockito.ArgumentMatchers.any
import org.mockito.BDDMockito._
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{BeforeAndAfter, FunSpec}
import org.springframework.data.domain.{PageImpl, Pageable}

import scala.collection.JavaConverters._

class AccountSpec
        extends FunSpec
                with BeforeAndAfter
                with MockitoSugar {

    private   var accountDataProcessor : AccountDataProcessor = _
    private   var accountService       : AccountService       = _
    private   var controller           : AccountController    = _

    before {
        accountDataProcessor = mock[AccountDataProcessor]
        accountService       = mock[AccountService]
        controller           = new AccountController(accountDataProcessor, accountService)

        given(accountService.findBy(any[String](), any[Set[Boolean]](), any[Pageable]()))
                .willReturn(new PageImpl(List.empty[Account].asJava))


        val account = new Account(100, "Main Account - The Queen", new Timezone(1, "MYTime"), new Details(777))
        given(accountService.findBy(any(), any(), any())).willReturn(new PageImpl(List(account).asJava), new PageImpl(List.empty[Account].asJava))
        //        given(accountService.findBy(any(), any(), any(), any())).willReturn(Iterable[Account](account), Iterable[Account]())
    }

    private def buildMocks(singleAccount: Boolean = true): Unit = {
        // return an account wrapped with CarData when CarDataService.process is called
        if (singleAccount) {
            given(accountDataProcessor.process(any[() => Account]())).willAnswer { invocation =>
                val callback = invocation.getArgument(0).asInstanceOf[() => Account]
                AccountData(callback())
            }

            println("Option 1")
        }
        else {
            given(accountDataProcessor.process(any[() => Iterable[Account]]())).willAnswer { invocation =>
                invocation.getArgument(0).asInstanceOf[() => Iterable[Account]]
                        .apply()
                        .map(account => AccountData(account)).toList
            }
            println("Option 2")
        }
    }

    describe("An account test") {
        ignore("when it has single account") {
            it("should verify some behavior") {
                buildMocks()
                controller.findByGroupID()
                println("The end 1!")
            }
        }
        describe("when it DOES NOT have single account") {
            it("should verify some behavior") {
                buildMocks(false)
                controller.findByGroupID()
                println("The end 2!")
            }
        }
    }

}