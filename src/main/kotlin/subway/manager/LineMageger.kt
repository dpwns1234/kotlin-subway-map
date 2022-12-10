package subway.manager

import subway.Input
import subway.Output
import subway.domain.Line
import subway.domain.LineRepository
import subway.domain.StationRepository

object LineManager: SubwayManager() {
    private val input = Input()
    private val output = Output()
    override fun menuView() {
        output.lineMenu()
    }

    override fun inputCommand(): String {
        return input.commandLine()
    }

    override fun register() {
        output.registerLine()
        val lineName = input.lineName(LineRepository.lines())
        LineRepository.addLine(Line(lineName))

        // 상행 종점역
        val upStation = input.upStationName()

        // 하행 종점역
        val downStation = input.downStationName(upStation)

        output.registerInfo()
    }

    override fun remove() {
        output.removeLine()
        val name = input.lineName(LineRepository.lines())
        LineRepository.deleteLineByName(name)
        output.removeLineInfo()
    }

    override fun inquiry() {
        output.inquiryStations(StationRepository.stations())
    }


}