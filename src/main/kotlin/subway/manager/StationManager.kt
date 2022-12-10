package subway.manager

import subway.Input
import subway.Output
import subway.Rule
import subway.domain.Station
import subway.domain.StationRepository

class StationManager: SubwayManager() {
    private val repository = StationRepository()
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
        val name = input.stationName(repository.stations())
        StationRepository().addStation(Station(name))
        output.registerInfo()
    }

}