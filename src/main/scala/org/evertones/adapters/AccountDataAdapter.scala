package org.evertones.adapters

import javax.xml.bind.annotation.adapters.XmlAdapter
import org.evertones.dtos.AccountData
import org.evertones.helpers.TimezoneData
import org.evertones.model.{Account, Details, Timezone}

import scala.util.Random

class AccountDataAdapter extends XmlAdapter[String, AccountData] {

    override def unmarshal(output: String): AccountData = {
        val account = new Account
        account.setId(Random.nextInt(10))
        account.setName("Random name " + Random.nextInt(100))

        val details = new Details(Random.nextInt(10))
        account.setDetails(details)

        AccountData(account, timezoneData = Option(TimezoneData(new Timezone(1, "Sydney"), "AU")))
    }

    override def marshal(accountData: AccountData): String = {
        "All done!"
    }
}
