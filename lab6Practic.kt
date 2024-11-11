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
// Task 2
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
// Task 3
data class Event (
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int,
)
enum class Daypart {
    Morning, Afternoon,Evening
}
fun main(){
    val events = mutableListOf(
    	Event(title = "Wake up", description = "Time to get up", daypart = Daypart.Morning, durationInMinutes = 0),
       	Event(title = "Eat breakfast", daypart = Daypart.Morning, durationInMinutes = 15),
        Event(title = "Learn about Kotlin", daypart = Daypart.Afternoon, durationInMinutes = 30),
        Event(title = "Practice Compose", daypart = Daypart.Afternoon, durationInMinutes = 60),
        Event(title = "Watch latest DevBytes video", daypart = Daypart.Afternoon, durationInMinutes = 10),
        Event(title = "Check out latest Android Jetpack library", daypart = Daypart.Evening, durationInMinutes = 45),
    )
    events.forEach{
        println(it)
    }
}
