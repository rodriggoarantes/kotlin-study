package br.com.in6.kotlin

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory
import org.springframework.boot.web.server.WebServerFactoryCustomizer
import org.springframework.stereotype.Component

@Component
class ContainerConfig : WebServerFactoryCustomizer<JettyServletWebServerFactory> {
    override fun customize(factory: JettyServletWebServerFactory?) {
        factory?.contextPath = "/api"
        factory?.port = 8181
    }
}