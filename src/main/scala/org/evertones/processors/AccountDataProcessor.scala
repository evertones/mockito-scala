package org.evertones.processors

import org.evertones.dtos.AccountData
import org.evertones.helpers.TimezoneData
import org.evertones.model.{Account, Timezone}

class AccountDataProcessor
    extends GenericDataProcessor[Account, AccountData] {


    def process(account: Account): AccountData = {
        // process account multi locations
        // TODO: This should not make any difference
        //accountLocationService.loadLocations(account)

        // load relational dependencies
        account.getDetails.getId

        // load timezone data
        //val timezoneData = timezoneDataProcessor.process(account.getTimezone)
        val timezoneData = TimezoneData(new Timezone(1, "Sydney"), "English")

        AccountData(account, timezoneData = Option(timezoneData))
    }

    def process(callback: () => Account): AccountData = {
        process(callback())
    }

    def process(callback: () => Iterable[Account]): List[AccountData] = {
        callback().map(process).toList
    }

}
