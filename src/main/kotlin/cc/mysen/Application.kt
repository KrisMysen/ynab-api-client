package cc.mysen

import org.koin.core.KoinComponent
import org.koin.core.inject

class Application : KoinComponent {

    private val api by inject<Api>()

    fun start() {
        api.init()
    }
}