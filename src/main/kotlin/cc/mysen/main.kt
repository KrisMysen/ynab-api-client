package cc.mysen

import org.koin.core.context.startKoin

fun main() {

    startKoin {
        modules(myModule)
    }

    Application().start()
}

