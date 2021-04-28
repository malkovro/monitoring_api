package com.malkovro.monitoring_api.infrastructure.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.core.JdbcTemplate
import javax.sql.DataSource

class PiConfig(var user: String = "leo", var host: String = "10.8.0.18", var password: String = "YouWish")

@Configuration
class ApiConfiguration {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    fun dataSource(): DataSource {
        return DataSourceBuilder.create().build()
    }

    @Bean
    fun applicationDataConnection(): JdbcTemplate {
        return JdbcTemplate(dataSource())
    }

    @Bean
    @ConfigurationProperties(prefix = "pi")
    fun piConfig(): PiConfig? {
        return PiConfig()
    }
}