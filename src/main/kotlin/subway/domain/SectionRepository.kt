package subway.domain

import java.util.*
import kotlin.collections.ArrayList

object SectionRepository {
    private val sections: MutableList<Section> = ArrayList() // 한 섹션 = 한 Line(노선)
    fun initSection(line: Line, finalStations: Pair<String, String> ) {
        val upStation = Station(finalStations.first)
        val downStation = Station(finalStations.second)
        val section = Section(line, mutableListOf(upStation, downStation))
        sections.add(section)
    }
    fun addStationOfSection(line: Line, order:Int, station: Station) {
        // 해당 노선을 찾아서 역을 원하는 순서에 추가해주기
        for(section in sections) {
            if(section.line == line) {
                section.stations.add(order, station)
                break
            }
        }
    }

    fun deleteSectionByStation(line: Line, station: Station): Boolean {
        // 해당 노선을 찾아서 해당 역 삭제해주기
        for(section in sections) {
            if(section.line == line) {
                section.stations.remove(station)
                return true
            }
        }
        return false
    }
    // TODO 객체가 달라서 삭제가 안됨. Section 클래스의 Line이 아니라 lineName: String 이렇게 해서 처리해야 할 듯
    fun deleteSectionByLine(line: Line) {
        sections.removeIf { section: Section -> section.line == line }
    }

}