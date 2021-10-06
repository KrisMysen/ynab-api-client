package cc.mysen

import cc.mysen.commandline.Input
import cc.mysen.commandline.Output
import cc.mysen.files.FileEventStream
import cc.mysen.files.FileStorage
import cc.mysen.files.InputFolders
import cc.mysen.files.LocalFileStorage
import cc.mysen.properties.ApplicationProperties
import cc.mysen.transactions.TransactionReader
import cc.mysen.ynab.ApiClient
import org.koin.dsl.module
import java.io.File
import java.nio.charset.Charset

val myModule = module {

  single { ApplicationProperties("application.properties") }

  single { ApiClient(get()) }

  single { Api(get()) }

  single { FileEventStream() }

  single { TransactionReader(get()) }

  single { Input(System.`in`.reader(Charset.defaultCharset())) }

  single { Output(System.out.writer(Charset.defaultCharset())) }

  single { InputFolders(".") }

  single { CommandLine(get(), get(), get()) }

  single { LocalFileStorage(File("./uploaded"), get()) as FileStorage }

}