package cc.mysen

import cc.mysen.ynab.ApiClient
import org.koin.dsl.module
import java.io.File

val myModule = module {

  single { ApiClient("secret") }

  single { Api(get()) }

  single { LocalFileStorage(File("./imported")) as FileStorage }

}