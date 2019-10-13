package org.evertones.controller

import org.evertones.processors.AccountDataProcessor
import org.evertones.result.AccountsResult
import org.evertones.services.AccountService
import org.evertones.utils.PageableCollection

import scala.collection.JavaConverters._


class AccountController(
    accountDataProcessor: AccountDataProcessor,
    accountService: AccountService
) {

    def findByGroupID(): AccountsResult = {
        val accounts = () => PageableCollection(pageable => accountService.findBy("MyRoleType", Set(true), pageable))
        val data = accountDataProcessor.process(accounts)

        new AccountsResult(data.asJava)
    }

}

