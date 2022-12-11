package subway.manager

import subway.Input
import subway.Output
import subway.Rule
import subway.domain.Station
import subway.domain.StationRepository

object StationManager: SubwayManager() {
    private val output = Output()
    private val input = Input()
    private val rule = Rule()

    override fun menuView() {
        output.stationView()
    }

    override fun inputCommand(): String {
        return input.commandStation()
    }

    override fun register() {
        output.registerStation()
        val name = input.stationName()
        StationRepository.addStation(Station(name))
        output.registerInfo()
    }

    override fun remove() {
        output.removeStation()
        val name = input.stationName()
        StationRepository.deleteStation(name)
        output.removeStationInfo()
    }

    override fun inquiry() {
        output.inquiryStations(StationRepository.stations())
    }
}