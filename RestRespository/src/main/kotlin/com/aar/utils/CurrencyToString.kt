package com.aar.utils

class CurrencyToString {

    val sencillos = mapOf(
            0   to "cero",
            1   to "uno",
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
            29  to "ventinueve"
            30  to "treinta",
            40  to "cuarenta",
            50  to "cincuenta",
            60  to "sesenta",
            70  to "setenta",
            80  to "ochenta",
            90  to "noventa",
            100 to "cien",
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


    fun esCompuestoCoordinado( numero:Int) : Boolean = numero in 31..99 && sencillos[numero] == null
    fun

}