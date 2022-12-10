package subway.domain

import java.util.*
import kotlin.collections.ArrayList


object StationRepository {
    private val stations: MutableList<Station> = ArrayList()
    // 아마 이게 getter?
    fun stations(): List<Station> {
        return Collections.unmodifiableList(stations)
    }

    fun addStation(station: Station) {
        stations.add(station)
    }

    fun deleteStation(name: String?): Boolean {
        return stations.removeIf { station: Station -> station.name == name }
    }
}