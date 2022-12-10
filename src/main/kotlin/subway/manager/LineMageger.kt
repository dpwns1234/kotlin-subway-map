package subway.manager

import subway.Input
import subway.Output

object LineManager: SubwayManager() {
    private val input = Input()
    private val output = Output()
    override fun menuView() {
        output.lineView()
    }

    override fun inputCommand(): String {
        return input.commandLine()
    }

    override fun register() {
        TODO("Not yet implemented")
    }

    override fun remove() {
        TODO("Not yet implemented")
    }

    override fun inquiry() {
        TODO("Not yet implemented")
    }


}