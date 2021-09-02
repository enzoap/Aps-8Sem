package com.example.aps.data.mapper

import com.example.aps.data.model.Response
import com.example.aps.domain.model.ObjectDomain
import com.example.aps.utils.Mapper

class ObjectToDomainMapper: Mapper<Response, ObjectDomain> {
    override fun map(source: Response): ObjectDomain {
        return ObjectDomain(
            name = source.name,
            region = source.region,
            temperature = source.temperature,
            icon = source.icon,
            airQuality = source.airQuality,
            text = source.condition
        )
    }
}