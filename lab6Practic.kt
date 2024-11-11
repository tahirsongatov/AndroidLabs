// Task 1
data class Event (
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val duration: Int,
)
enum class Daypart {
    Morning, Afternoon,Evening
}
fun main(){
    val event = Event(
    	title = "Study Kotlin",
        description = "Commit to studying Kotlin at least 15 minutes per day.",
        daypart = Daypart.Evening,
        duration = 15,
    )
    println(event)
}
