package subway

import camp.nextstep.edu.missionutils.Console.readLine

class Input {
    private val rule = Rule()

    fun command(type: String): String {
        while(true) {
            val input = readLine()
            kotlin.runCatching { rule.checkCommand(input, type) }
                .onSuccess { return input }
                .onFailure { e -> Output().printErrorMessage(e.message) }
        }
    }

    fun name(type: String): String {
        while(true) {
            val input = readLine()
            kotlin.runCatching { rule.checkName(input, type) }
                .onSuccess { return input }
                .onFailure { e -> Output().printErrorMessage(e.message) }
        }
    }

    fun downStationName(upStation: String): String {
        while (true) {
            val input = readLine()
            kotlin.runCatching { rule.checkDownStation(input, upStation) }
                .onSuccess { return input }
                .onFailure { e -> Output().printErrorMessage(e.message) }
        }
    }

}