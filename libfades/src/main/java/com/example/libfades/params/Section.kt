package com.example.libfades.params

enum class Section {
    HOT,
    TOP;
    // convert enum to string
    override fun toString(): String {
        return when (this) {
            HOT -> "hot"
            TOP -> "top"
        }
    }
}