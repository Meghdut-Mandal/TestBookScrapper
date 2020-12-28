package api.solution

data class Stats(
    var attempts: Attempts?,
    var averageTime: Double?,
    var bestTime: Double?,
    var totalStudents: Int?
)