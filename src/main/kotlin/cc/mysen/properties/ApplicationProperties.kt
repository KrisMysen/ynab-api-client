package cc.mysen.properties

import java.util.*

class ApplicationProperties(private val propertyFileName: String) {

  private val properties: Properties by lazy { loadProperties(propertyFileName) }

  fun getSecret(): String {
    return properties.getProperty("ynab.secret", "")
  }

  private fun loadProperties(filename: String): Properties {
    val resourceAsStream = ApplicationProperties::class.java.classLoader.getResourceAsStream(filename)
    val properties = Properties()

    resourceAsStream.use {
      properties.load(it)
    }

    return properties
  }

}