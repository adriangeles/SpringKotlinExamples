package com.aar.utils

import kotlin.math.pow

fun main(args: Array<String>) {
    println("Números")
    val conversor = CurrencyToString()
    for (n in 9999..10010) {
        val str = conversor.convertir(n);
        println("$n - $str")
    }
}

class CurrencyToString {

    val sencillos = mapOf(
            0   to "cero",
            1   to "un",
            2   to "dos",
            3   to "tres",
            4   to "cuatro",
            5   to "cinco",
            6   to "seis",
            7   to "siete",
            8   to "ocho",
            9   to "nueve",
            10  to "diez",
            11  to "once",
            12  to "doce",
            13  to "trece",
            14  to "catorce",
            15  to "quince",
            16  to "dieciseis",
            17  to "diecisiete",
            18  to "dieciocho",
            19  to "diecinueve",
            20  to "veinte",
            21  to "ventiuno",
            22  to "ventidos",
            23  to "ventitres",
            24  to "venticuatro",
            25  to "venticinco",
            26  to "ventiseis",
            27  to "ventisiete",
            28  to "ventiocho",
            29  to "ventinueve",
            30  to "treinta",
            40  to "cuarenta",
            50  to "cincuenta",
            60  to "sesenta",
            70  to "setenta",
            80  to "ochenta",
            90  to "noventa",
            100 to "ciento",
            200 to "doscientos",
            300 to "trescientos",
            400 to "cuatrocientos",
            500 to "quinientos",
            600 to "seicientos",
            700 to "setecientos",
            800 to "ochocientos",
            900 to "novecientos",
            1000 to "mil",
            1000000 to "millón",
            1000000000000 to "billón")


    fun normalizar(numero:String):String {
        return when(numero) {
            "un" -> "un euro"
            "ciento" -> "cien euros"
            else -> "$numero euros"
        }
    }

    fun esCompuestoCoordinado( numero:Int) : Boolean = numero in 31..99 && sencillos[numero] == null


    fun calcularCompuestoCoordinado( numero: Int) : String?
    {
        if (esCompuestoCoordinado(numero) || true) {

            var valorFinal = ""
            val longitud = numero.toString().length
            var str = numero.toString().reversed();

            for ( index in longitud-1 downTo 0) {
                var n:Int = str.substring(index,index+1).toInt()
                if ( n  > 0) {
                    n = n * 10f.pow(index).toInt()
                    var valor = sencillos[n]
                    valorFinal = if (index == 0 && numero < 100) "$valorFinal y $valor" else "$valorFinal $valor"
                }
            }
            return valorFinal
        } else {
            println("No es compuesto coordinados")
            return null;
        }
    }

    fun calcularCompuestoYuxtapuesto( numero: Int) : String?
    {
        var valorFinal = ""
        val longitud = numero.toString().length
        var str = numero.toString().reversed();

        for ( index in longitud-1 downTo 0) {
            var n:Int = str.substring(index,index+1).toInt()
            n = if (index != 0) n * index * 10 else n
            var valor = sencillos[n]
            valorFinal = if ( index == 0) "$valorFinal y $valor" else "$valorFinal $valor"
        }
        return valorFinal
    }

    fun convertir( numero:Int) : String
    {
        var str = sencillos[numero] ?: calcularCompuestoCoordinado(numero) ?: "ERROR"
        return normalizar(str)
    }
}