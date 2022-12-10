package subway.manager

import subway.Input

class LineManager: SubwayManager() {
    private val input = Input()
    override fun menuView() {
        TODO("Not yet implemented")
    }

    override fun inputCommand(): String {
        return input.commandLine()
    }

    override fun registerView() {
        TODO("Not yet implemented")
    }

}