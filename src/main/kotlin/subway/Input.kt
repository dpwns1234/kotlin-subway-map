package subway

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

    fun stationName(): String {
        return getCorrectValue("stationName")
    }

    fun lineName(): String {
        return getCorrectValue("lineName")
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

    //TODO 상행선, 하행선 밸리데이트 구현 및 Section에도 추가해줘야함. + 중복되는 코드 너무 많음. 이거 어떻게 리팩터 할 것인지(중요!) 생각
    fun upStationName(): String {
        return getCorrectValue("upStation")
    }
    fun downStationName(upStation: String): String {
        return getCorrectDownStation(upStation)
    }

    fun getCorrectDownStation(upStation: String): String {
        var input: String
        var isWrong: Boolean
        do {
            input = readLine()
            isWrong = catchException2(input, upStation)
        } while (isWrong) //  잘못된 값이면 무한 반복
        return input
    }
    private fun catchException2(input: String, upStation: String): Boolean {
        val isWrong = try {
            rule.checkDownStation(input, upStation)
            false
        } catch (e: IllegalArgumentException) {
            println(e.message)
            true
        }
        return isWrong
    }
}