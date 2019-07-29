package com.aar.examples.basickotlinapp

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class ThymeleafController {


    @RequestMapping("/template/{name}")
    fun listStudents(@PathVariable("name") name: String, model: Model): String {
        model.addAttribute("name", name)
        return "defaultTemplate"
    }
}
