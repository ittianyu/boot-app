package com.ittianyu.dashboard.po

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


@Entity(name = "config")
data class ConfigPO(@field:NotEmpty(message = "empty.config.key") @Id @Column(name = "key_") var key: String? = null,
                    @field:NotNull(message = "null.config.value") @Column(name = "value_", nullable = false) var value: String? = null)
