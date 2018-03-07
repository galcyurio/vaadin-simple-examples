package com.github.galcyurio.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * @author galcyurio
 */
@Configuration
class WebMvcConfig : WebMvcConfigurerAdapter() {

    override fun addViewControllers(registry: ViewControllerRegistry?) {
        registry!!.apply {
            addViewController("").setViewName("index")
            addViewController("/index").setViewName("index")
            addViewController("/test").setViewName("test")
        }
    }
}