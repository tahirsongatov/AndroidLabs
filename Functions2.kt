fun main() {
    println(birthdayGreeting("Rex",5))
    println(birthdayGreeting("Rover",2))
}

fun birthdayGreeting(name:String,age:Int): String {
    val nameGreeting = "Happy Birthday, $name!"
    val ageGreeting = "You are now $age yearsols!"
    return "$nameGreeting\n$ageGreeting"
}
