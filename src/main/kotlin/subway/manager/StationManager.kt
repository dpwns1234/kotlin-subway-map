package subway.manager

import subway.Input
import subway.Output
import subway.Rule
import subway.domain.Station
import subway.domain.StationRepository
import subway.utils.Constants.TYPE_STATION

object StationManager: SubwayManager() {
    private val output = Output()
    private val input = Input()

    override fun menuView() {
        output.stationView()
    }

    override fun inputCommand(): String {
        return input.command(TYPE_STATION)
    }

    override fun register() {
        output.registerStation()
        val name = input.name("stationName")
        StationRepository.addStation(Station(name))
        output.registerInfo()
    }

    override fun remove() {
        output.removeStation()
        val name = input.name("stationName")
        StationRepository.deleteStation(name)
        output.removeStationInfo()
    }

    override fun inquiry() {
        output.inquiryStations(StationRepository.stations())
    }
}