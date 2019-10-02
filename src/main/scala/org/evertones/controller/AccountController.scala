package org.evertones.controller

import java.lang.{Boolean => JBoolean}

import org.evertones.model.{Account, Details, Timezone}
import org.evertones.processors.AccountDataProcessor
import org.evertones.result.AccountsResult
import org.evertones.services.AccountService
import org.evertones.utils.PageableCollection
import org.springframework.data.domain.{Page, PageImpl, Pageable}

import scala.collection.JavaConverters._


class AccountController(
    accountDataProcessor: AccountDataProcessor,
    accountService: AccountService
) {


    def findByGroupID(): AccountsResult = {
//        val roleType = Try(RoleType.forValue(groupID)).getOrElse {
//            throw SoapException(SoapErrors.InvalidRoleType)
//        }
//
//        if (!roleType.isWorldSpecific) {
//            throw SoapException(SoapErrors.InvalidRoleType)
//        }

//        val status = getStatusFilter(activeOption)



        val accounts = () => PageableCollection(pageable => accountService.findBy("Hey", Set(true), pageable))
        val data = accountDataProcessor.process(accounts)

        new AccountsResult(data.asJava)
    }


}

