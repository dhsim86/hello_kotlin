package com.dongho.dev

import com.dongho.dev.config.PropertyTestConfig
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
@Import(PropertyTestConfig::class)
class PropertyTest(
    @Autowired val propertyTestConfig: PropertyTestConfig) {

    @Test
    fun testProperty() {
        assertThat(propertyTestConfig.test).isEqualTo("test")
    }
}