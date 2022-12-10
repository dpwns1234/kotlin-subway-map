package subway

class Input {
    private val rule = Rule()
    fun mainView(): String {
        val input = readLine()
        return rule.checkMainInput(input)
    }
}