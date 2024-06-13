package com.example.kotlindesignpatterns.behavioural

/**
 * Apart from below example each handler can decide whether it cqn process the request and if yes
 * handle it else pass it to next handler. Fra
 */

interface HeaderChain{
    fun addHeader(header: String): String
}

class AuthTokenHeader(private val token: String, private val nextHeader: HeaderChain?): HeaderChain{
    override fun addHeader(header: String): String = "$header\n Authorzation: Bearer $token".let {
        nextHeader?.addHeader(it) ?: it
    }
}

class ContentTypeHeader(private val contentType: String, private val nextHeader: HeaderChain?): HeaderChain{
    override fun addHeader(header: String): String = "$header\n content_type: $contentType".let {
        nextHeader?.addHeader(it) ?: it
    }
}

class BodyHeader(private val body: String, private val nextHeader: HeaderChain?): HeaderChain{
    override fun addHeader(header: String): String = "$header\n body: $body".let {
        nextHeader?.addHeader(it) ?: it
    }
}

fun main(){
    val header = "header"
    val bodyHeader = BodyHeader("{\"data\":[]}", null)
    val contentTypeHeader = ContentTypeHeader("json", bodyHeader)
    val tokenHeader = AuthTokenHeader("123456", contentTypeHeader)
    println(tokenHeader.addHeader(header))
}