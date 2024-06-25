package com.gabriel.weather

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.io.IOException

class FloatTypeAdapter : TypeAdapter<Float>() {
    @Throws(IOException::class)
    override fun write(out: JsonWriter, value: Float?) {
        out.value(value)
    }

    @Throws(IOException::class)
    override fun read(reader: JsonReader): Float? {
        return try {
            reader.nextDouble().toFloat()
        } catch (e: NumberFormatException) {
            null
        }
    }
}
