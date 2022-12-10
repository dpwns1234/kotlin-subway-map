package subway

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
    - 단, 노선에 등록된 역은 삭제할 수 없다
    조회: 없는 경우
     */

    // line
    /*
    1, 2, 3, B -> cmd 에러
    등록:
    - 역 2글자 이상, 중복 x
    - 등록된 노선이 없을 경우
    - 상행, 하행 중복일 경우
    - 상행, 하행 하나라도 등록된 역이 없을 경우
    -
    삭제: 등록되지 않은 역 삭제
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