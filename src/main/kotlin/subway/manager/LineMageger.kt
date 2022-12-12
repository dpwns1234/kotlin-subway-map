package subway.manager

import camp.nextstep.edu.missionutils.Console
import subway.Input
import subway.Output
import subway.domain.*
import subway.utils.Constants.TYPE_LINE

object LineManager: SubwayManager() {
    private val input = Input()
    private val output = Output()
    override fun menuView() {
        output.lineMenu()
    }

    override fun inputCommand(): String {
        return input.command(TYPE_LINE)
    }

    override fun register() {
        output.registerLine()
        val lineName = input.name("lineName")
        // 상행 종점역
        println("## 등록할 노선의 상행 종점역 이름을 입력하세요.")
        val upStation = input.name("upStationName")
        // 하행 종점역
        println("## 등록할 노선의 하행 종점역 이름을 입력하세요.")
        val downStation = input.downStationName(upStation)

        LineRepository.addLine(Line(lineName))
        SectionRepository.initSection(Line(lineName), Pair(upStation, downStation))
        output.registerInfo()
    }

    override fun remove() {
        output.removeLine()
        val name = Console.readLine()
        LineRepository.deleteLineByName(name)
        SectionRepository.deleteSectionByLine(Line(name)) // 라인이 삭제되면 section도 삭제되게 하기
        output.removeLineInfo()
    }

    override fun inquiry() {
        output.inquiryStations(StationRepository.stations())
    }


}