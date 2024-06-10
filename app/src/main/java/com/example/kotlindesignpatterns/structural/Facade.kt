package com.example.kotlindesignpatterns.structural

enum class Language{
    ENGLISH,
    FRENCH,
    GERMAN
}

//Facade that hides complex translation logic
class TranslateManager{
    fun translate(text: String, language: Language){
        TranslatorFactory.createTranslator(language).translate(text)
    }
}

object TranslatorFactory{
    fun createTranslator(language: Language): Translator =
        when(language){
            Language.ENGLISH -> EnglishTranslator()
            Language.FRENCH -> FrenchTranslator()
            Language.GERMAN -> GermanTranslator()
        }
}

interface Translator{
    fun translate(text: String)
}
class EnglishTranslator: Translator{
    override fun translate(text: String) {
        println("$text translated to English")
    }
}

class FrenchTranslator: Translator{
    override fun translate(text: String) {
        println("$text translated to French")
    }
}

class GermanTranslator: Translator{
    override fun translate(text: String) {
        println("$text translated to German")
    }
}

fun main(){
    TranslateManager().translate("Hello", Language.FRENCH)
    TranslateManager().translate("Hola", Language.ENGLISH)
    TranslateManager().translate("Hi", Language.GERMAN)
}