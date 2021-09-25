package com.example.tugas_18

import java.io.Serializable


data class ModelNote (
    val notes:List<Data>
        ){
    data class Data (val id: String?, val note: String?) : Serializable
}