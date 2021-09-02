package com.example.aps.domain.mapper

import com.example.aps.domain.model.ObjectDomain
import com.example.aps.presentation.model.ObjectPresentation
import com.example.aps.utils.Mapper

class ObjectToPresentationMapper: Mapper<ObjectDomain, ObjectPresentation> {
    override fun map(source: ObjectDomain): ObjectPresentation {
        return ObjectPresentation(
            name = source.name,
            region = source.region,
            temperature = source.temperature,
            icon = source.icon,
            airQualityIndex = source.airQuality,
            text = source.text
        )
    }
}