package com.aar.examples.basickotlinapp

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

data class MyForm(val name: String, val country: String)

@Controller
class ThymeleafController {

    @RequestMapping("/template/{name}")
    fun listStudents(@PathVariable("name") name: String, model: Model): String {
        model.addAttribute("name", name)
        return "defaultTemplate"
    }

    @GetMapping("/myform")
    fun myForm(model: Model): String {
        model.addAttribute("myform", MyForm("Nombre", "ES"))
        return "formTemplate"
    }

    @PostMapping("/myform")
    fun myFormSubmit(@ModelAttribute myForm: MyForm): String {
        return "formTemplateResult.html"
    }
}
