package subway

import subway.domain.Line
import subway.domain.Station
import subway.utils.Constants.ERROR_LESS_THAN_TWO
import subway.utils.Constants.ERROR_COMMAND
import subway.utils.Constants.ERROR_REDUPLICATED
import subway.utils.Constants.QUIT
import subway.utils.Constants.TYPE_LINE
import subway.utils.Constants.TYPE_MAIN
import subway.utils.Constants.TYPE_SECTION
import subway.utils.Constants.TYPE_STATION

class Rule {

    fun checkValue(input: String, type: String) {
        when(type) {
            TYPE_MAIN -> checkCommandMain(input)
            TYPE_STATION -> checkCommandStation(input)
            TYPE_LINE -> checkCommandLine(input)
            TYPE_SECTION -> checkCommandSection(input)
            "upStation" -> checkUpStation(input)
            "downStation" -> checkDownStation(input)
        }
    }
    private fun checkCommandMain(input: String?): String {
        if (input == "1" || input == "2" || input == "3" || input == "4" || input == QUIT)
            return input

        throw IllegalArgumentException(ERROR_COMMAND)
    }

    private fun checkCommandStation(input: String?): String {
        if (input == "1" || input == "2" || input == "3" || input == "b")
            return input

        throw IllegalArgumentException(ERROR_COMMAND)
    }

    private fun checkCommandLine(input: String?): String {
        if (input == "1" || input == "2" || input == "3" || input == "b")
            return input

        throw IllegalArgumentException(ERROR_COMMAND)
    }

    private fun checkCommandSection(input: String?): String {
        if (input == "1" || input == "2" || input == "b")
            return input
        else
            throw IllegalArgumentException(ERROR_COMMAND)
    }

    fun checkStationName(input: String, stations: List<Station>): String {
        // 2글자 이상, 중복 x
        if(input.length < 2)
            throw IllegalArgumentException(ERROR_LESS_THAN_TWO)
        else if(stations.contains(Station(input)))
            throw IllegalArgumentException(ERROR_REDUPLICATED)

        return input
    }

    fun checkLineName(input: String, lines: List<Line>): String {
        // 2글자 이상, 중복 x
        if(input.length < 2)
            throw IllegalArgumentException(ERROR_LESS_THAN_TWO)
        else if(lines.contains(Line(input)))
            throw IllegalArgumentException(ERROR_REDUPLICATED)

        return input
    }

    private fun checkUpStation(name: String, stations: List<Station>): String {
        // 이미 등록된 역이름이라면 통과
        if(!stations.contains(Station(name)))
            throw IllegalArgumentException("[ERROR] 없는 역입니다.")

        return name
    }

    private fun checkDownStation(upStationName: String, downStationName: String, stations: List<Station>): String {
        // 이미 등록된 역이름이라면 통과
        if(!stations.contains(Station(downStationName)))
            throw IllegalArgumentException("[ERROR] 없는 역입니다.")
        if(downStationName == upStationName)
            throw IllegalArgumentException("[ERROR] 상행 종점과 하행 종점이 중복됩니다.")

        return downStationName
    }

    // main
    /*
    1, 2, 3, 4, Q -> cmd 에러
     */

    // station
    /*
    1, 2, 3, B -> cmd 에러
    등록: 역 2글자 이상, 중복 x
    삭제:
    - 등록되지 않은 역 삭제
    - TODO 단, 노선에 등록된 역은 삭제할 수 없다
    조회: 없는 경우
     */

    // line
    /*
    1, 2, 3, B -> cmd 에러
    등록:
    - 노선이 중복될 경우

    - 역 2글자 이상
    - 상행, 하행 중복일 경우
    - 상행, 하행 하나라도 등록된 역이 없을 경우
    -
    삭제: 등록되지 않은 노선 삭제
     */

    // section
    /*
    1, 2, B -> cmd 에러
    등록:
    - 역 2글자 이상, 중복 x
    - 이미 해당 노선에 같은 역이 있을 경우
    삭제: 
    - 역 2개 이하일 경우 제거 x
    - 종점의 역을 삭제할 경우 종점을 바꿔주는 추가 기능
    - 해당 역이 없을 경우
     */
}