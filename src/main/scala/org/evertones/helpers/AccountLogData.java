package org.evertones.helpers;

import org.evertones.model.Account;
import org.evertones.model.LogData;
import org.evertones.model.LogEntity;

import java.util.Set;

public class AccountLogData extends LogEntity<Account> {

    public AccountLogData(Account entity, Set<LogData> data) {
        super(entity, data);
    }
}
