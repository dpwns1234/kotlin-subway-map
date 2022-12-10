package subway

import subway.domain.Station
import camp.nextstep.edu.missionutils.Console.readLine
import subway.utils.Constants.TYPE_LINE
import subway.utils.Constants.TYPE_MAIN
import subway.utils.Constants.TYPE_SECTION
import subway.utils.Constants.TYPE_STATION

class Input {
    private val rule = Rule()

    fun commandMain(): String {
        return getCorrectValue(TYPE_MAIN)
    }
    fun commandStation(): String {
        return getCorrectValue(TYPE_STATION)
    }

    fun commandLine(): String {
        return getCorrectValue(TYPE_LINE)
    }
    fun commandSection(): String {
        return getCorrectValue(TYPE_SECTION)
    }

    private fun getCorrectValue(type: String): String {
        var input: String
        var isWrong: Boolean
        do {
            input = readLine()
            isWrong = catchException(input, type)
        } while (isWrong)
        return input
    }

    private fun catchException(input: String, type: String): Boolean {
        val isWrong = try {
            rule.checkValue(input, type)
            false
        } catch (e: IllegalArgumentException) {
            println(e.message)
            true
        }
        return isWrong
    }

    fun stationName(stations: List<Station>): String {
        var input: String
        var isWrong: Boolean
        do {
            input = readLine()
            isWrong = catchException(input, stations)
        } while (isWrong)
        return input
    }

    private fun catchException(input: String, stations: List<Station>): Boolean {
        val isWrong = try {
            rule.checkStationName(input, stations)
            false
        } catch (e: IllegalArgumentException) {
            println(e.message)
            true
        }
        return isWrong
    }

}