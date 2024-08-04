package com.manasa.data.mappers

interface Mapper<k,v> {
    fun mapFrom(obj: k): v
}

