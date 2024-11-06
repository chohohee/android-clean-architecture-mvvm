package com.chh.cleanarchitecture.local.mapper

interface EntityMapper<Data, Entity> {

    fun toEntity(data: Data): Entity

    fun toData(entity: Entity): Data
}