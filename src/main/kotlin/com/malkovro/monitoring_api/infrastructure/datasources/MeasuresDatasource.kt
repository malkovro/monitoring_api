package com.malkovro.monitoring_api.infrastructure.datasources

import com.malkovro.monitoring_api.bounded_contexts.measures.Measure
import com.malkovro.monitoring_api.bounded_contexts.measures.CreateMeasureDatasource
import com.malkovro.monitoring_api.bounded_contexts.measures.FindAllMeasuresDatasource
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.util.*

import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.jdbc.support.KeyHolder


@Repository
class MeasuresDatasource(private val jdbc: NamedParameterJdbcTemplate) : FindAllMeasuresDatasource, CreateMeasureDatasource {
    override fun findAll(name: String, rangeFrom: Date?, rangeTo: Date?): List<Measure> {
        val sql = "SELECT name, value, measured_at FROM measures"
        return jdbc.query(sql, MeasuresMapper)
    }

    override fun create(name: String, value: Double): Measure {
        val holder: KeyHolder = GeneratedKeyHolder()

        val sql = "INSERT INTO measures (name, value) VALUES (:name, :value)"
        jdbc.update(sql, MapSqlParameterSource(mapOf("name" to name, "value" to value)), holder)
        val id = holder.key?.toLong()
        if (id != null) {
            return find(id)
        }
        throw Exception("Something went wrong while creating the user... 😢")
    }

    private fun find(id: Long): Measure {
        val sql = "SELECT name, value, measured_at FROM measures WHERE id = :id"
        val res = jdbc.query(sql, MapSqlParameterSource(mapOf("id" to id)), MeasuresMapper)
        return res.first()
    }
}