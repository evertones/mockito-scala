package org.evertones.result

import java.util.{List => JList}

import javax.xml.bind.annotation._
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter
import org.evertones.adapters.AccountDataAdapter
import org.evertones.dtos.AccountData


@XmlType(name = "WmAccountsResult")
@XmlAccessorType(XmlAccessType.NONE)
class AccountsResult {

    def this(dataList: JList[AccountData]) = {
        this()
        this.dataList = dataList
    }

    @XmlJavaTypeAdapter(classOf[AccountDataAdapter])
    @XmlElementWrapper(name = "accounts", required = true, nillable = false)
    @XmlElement(name = "item", required = false, nillable = false)
    var dataList: JList[AccountData] = _
}
