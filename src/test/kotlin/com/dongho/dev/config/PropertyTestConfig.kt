package com.dongho.dev.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.validation.annotation.Validated

@Validated
@TestConfiguration
@ConfigurationProperties(prefix = "fixtures")
class PropertyTestConfig {

    lateinit var test: String

}
