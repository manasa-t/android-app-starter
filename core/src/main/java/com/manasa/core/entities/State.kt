package com.manasa.core.entities

data class State<out T>(val status: STATUS, val data: T?, val error: String?, val errorCode: Int? =0){
    enum class STATUS {
        LOADING,
        CONTENT,
        ERROR,
    }

    companion object {
        fun <T> success(data: T): State<T> {
            return State(STATUS.CONTENT, data, null)
        }

        fun <T> error(message: String, code: Int? =0): State<T> {
            return State(STATUS.ERROR, null, message, code)
        }

        fun <T> loading(): State<T> {
            return State(STATUS.LOADING, null, null)
        }

    }
}