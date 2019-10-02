package org.evertones.dtos

import java.util.{List => JList}

import org.evertones.helpers.{AccountLogData, LogFileData, TimezoneData}
import org.evertones.model.{Account, LogData}

import scala.collection.JavaConverters._

case class AccountData(
                              account: Account,
                              logData: JList[LogData] = Nil.asJava,
                              logFiles: JList[LogFileData] = Nil.asJava,
                              timezoneData: Option[TimezoneData] = None
                  ) extends AccountLogData(account, (logData.asScala ++ logFiles.asScala).toSet.asJava) {

    

    
    
}
