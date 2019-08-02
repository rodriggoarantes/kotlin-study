package br.com.in6.kotlin.domain.users

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

enum class RedeSocialTipo {
    FACEBOOK,
    LINKEDIN,
    WHATSAPP,
    GOOGLE,
    INSTAGRAM
}
