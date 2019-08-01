package com.aar.examples.basickotlinapp

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

data class MyForm(val name: String, val country: String)
data class SearchFrom(val text: String)

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


    @GetMapping("/myList")
    fun myList(model: Model): String {

        val myList = listOf(
                MyForm( "Uno",  "ES"),
                MyForm( "Dos",  "EN"),
                MyForm( "Tres", "GR")
        )
        var searchForm = SearchFrom("");

        model.addAttribute("myList", myList)
        model.addAttribute("searchForm",searchForm)
        return "listTemplate"
    }

    @PostMapping("/myList")
    fun myListSubmit(@ModelAttribute searchForm: SearchFrom, model: Model): String {


        val myList = listOf(
                MyForm( "Uno",  "ES"),
                MyForm( "Dos",  "EN"),
                MyForm( "Tres", "GR")
        ).filter{ it.name.contains( searchForm.text, true)}

        model.addAttribute("myList", myList)
        model.addAttribute("searchForm", searchForm)
        return "listTemplate"
    }
}
