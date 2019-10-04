package com.ittianyu.dashboard.repository

import com.ittianyu.dashboard.po.ConfigPO
import org.springframework.data.jpa.repository.JpaRepository

interface ConfigRepository : JpaRepository<ConfigPO, String> {

}
