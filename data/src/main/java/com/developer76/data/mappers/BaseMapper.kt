package com.developer76.data.mappers

import io.realm.RealmObject

interface BaseMapper<T: RealmObject, F> {
    fun transform(input: T): F
    fun transform(input: F): T
}

interface BaseRemoteMapper<T, F> {
    fun transform(input: T): F
}