package com.chocolate.triviatitans.domain.mapper

interface Mapper <INPUT, OUTPUT> {

    fun map (input: INPUT):OUTPUT
    fun map(input: List<INPUT>): List<OUTPUT>{
        return input.map(::map)
    }
    fun map(input: List<List<INPUT>>): List<List<OUTPUT>> {
        return input.map(::map)
    }
}