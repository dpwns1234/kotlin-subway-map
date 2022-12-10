package subway

import subway.domain.StationRepository
import subway.manager.LineManager
import subway.manager.SectionManager
import subway.manager.StationManager
import subway.manager.SubwayManager
import subway.utils.Constants
import subway.utils.Constants.MANAGE_LINE
import subway.utils.Constants.MANAGE_OUTPUT_SUBWAY_MAP
import subway.utils.Constants.MANAGE_SECTION
import subway.utils.Constants.MANAGE_STATION
import subway.utils.Constants.QUIT

fun main() {
    val input = Input()
    val output = Output()
    mainView(input, output)
}

private fun mainView(input:Input, output: Output) {
    var subwayManger: SubwayManager? = null
    while(true) {
        output.mainView()
        when (input.commandMain()) {
            MANAGE_STATION -> subwayManger = StationManager
            MANAGE_LINE -> subwayManger = LineManager()
            MANAGE_SECTION -> subwayManger = SectionManager()
            MANAGE_OUTPUT_SUBWAY_MAP -> outputSubwayMap()
            QUIT -> break
        }
        subwayManger?.perform()
    }
}
fun outputSubwayMap() {
    // 전체 노선의 역들을 순서대로 출력
    StationRepository.stations()
}