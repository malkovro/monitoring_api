package com.malkovro.monitoring_api.infrastructure.datasources

import com.malkovro.monitoring_api.bounded_contexts.measures.Measure
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

object MeasuresMapper : RowMapper<Measure> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Measure {
        return Measure(
                rs.getString("name"),
                rs.getLong("value"),
                rs.getDate("measured_at")
        )
    }
}