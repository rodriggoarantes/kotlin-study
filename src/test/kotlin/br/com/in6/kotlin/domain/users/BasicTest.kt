package br.com.in6.kotlin.domain.users

import org.assertj.core.api.Assertions.*
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class BasicTest {

    private val basic = Basic()

    @Test
    fun `Envio de email com inline-class`() {
        val email = "rodriggoarantes@gmail.com"
        assertEquals(email, basic.email(EmailAddress(email)))
    }

    @Test
    fun `Obter usuario valor padrao`() {
        val obj = basic.usuario()
        assertThat(obj).isNotNull
        assertThat(obj).isEqualTo(Usuario(1, "Rodrigo"))
    }

    @Test
    fun `Teste Equals com AssertJ`() {
        val u1 = Usuario(1, "A")

        val list = basic.putList(u1)

        val index1 = list.indexOf(u1)
        val index2 = list.indexOf(Usuario(1, "A"))

        assertThat(index1).isEqualTo(0)
        assertThat(index2).isEqualTo(0)
        assertThat(list).containsExactly(Usuario(1, "A"))
    }
}