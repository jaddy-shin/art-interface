package me.jaddy.adapter.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class UserOverAllController {

    @GetMapping("/api/v1/page_meta")
    fun getPageMeta(): String {
        return "test"
    }
}