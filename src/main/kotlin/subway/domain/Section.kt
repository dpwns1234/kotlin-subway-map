package subway.domain

class Section(
    val line: Line,
    val stations: MutableList<Station>
)