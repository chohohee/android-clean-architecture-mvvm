package com.chh.mvvm.local.mapper

interface EntityMapper<Data, Entity> {

    fun toEntity(data: Data): Entity

    fun toData(entity: Entity): Data

}