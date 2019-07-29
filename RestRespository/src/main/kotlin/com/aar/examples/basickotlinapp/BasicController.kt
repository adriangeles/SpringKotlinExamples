package com.aar.examples.basickotlinapp

import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong


data class Greeting(val id: Long, val content: String)

@RestController
class BasicController {

    private val counter = AtomicLong()

    @GetMapping("/")
    fun index() = "This is home!"

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting(counter.incrementAndGet(), "Hello, $name")

    @PostMapping("/greeting2")
    fun greeting2(@RequestBody g: Greeting): String {
        println(g)
        return "Post Successfully!"
    }


    @GetMapping(
            value = ["/img"],
            produces = [MediaType.IMAGE_PNG_VALUE]
    )
    fun image(): ByteArray {
        println("Request img")
        return ClassPathResource("/static/kotlin-logo.png").inputStream.readAllBytes()
    }
}