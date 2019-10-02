package org.evertones.services

import org.evertones.model.Account
import org.springframework.data.domain.{Page, Pageable}

class AccountService {


    def findBy(roleType: String, statuses: Set[Boolean], pageable: Pageable): Page[Account] = {
        null
    }

}
