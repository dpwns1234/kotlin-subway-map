package subway

class Input {
    private val rule = Rule()

    fun commandMain(): String {
        val input = readLine()
        return rule.checkCommandMain(input)
    }
    fun commandStation(): String {
        val input = readLine()
        return rule.checkCommandStation(input)
    }

    fun commandLine(): String {
        val input = readLine()
        return rule.checkCommandLine(input)
    }
    fun commandSection(): String {
        val input = readLine()
        return rule.checkCommandSection(input)
    }

    fun stationName(): String {
        val input = readLine()
        // rule 체크
        TODO()
    }

}