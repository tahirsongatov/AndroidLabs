class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: String
)
fun main() {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", "medium")
    val question2 = Question<Boolean>("The sky is green. True or false", false, "easy")
    val question3 = Question<Int>("How many days are there between full moons?", 28, "hard")
}
// enums
class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty,
)
enum class Difficulty {
    EASY, MEDIUM, HARD
}
fun main() {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
}
//data class
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty,
)
enum class Difficulty {
    EASY, MEDIUM, HARD
}

fun main() {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    println(question1.toString())
}
// companion object and singleton
object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
}
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty,
)
enum class Difficulty {
    EASY, MEDIUM, HARD
}
class Quiz {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}

fun main() {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    println("${Quiz.answered} of ${Quiz.total} answered.")
    println(question1.toString())
}
// extended class with new property and method
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty,
)
enum class Difficulty {
    EASY, MEDIUM, HARD
}
class Quiz {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}
val Quiz.StudentProgress.progressText: String
	get() = "${answered} of ${total} answered"

fun Quiz.StudentProgress.printProgressBar(){
 	repeat(Quiz.answered) { print("▓") }
    repeat(Quiz.total - Quiz.answered) { print("▒") }
    println(Quiz.progressText)
}

fun main() {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    println("${Quiz.answered} of ${Quiz.total} answered.")
    println(Quiz.progressText)
    Quiz.printProgressBar()
    println(question1.toString())
}
// interface
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty,
)
enum class Difficulty {
    EASY, MEDIUM, HARD
}
interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

class Quiz: ProgressPrintable {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
	override val progressText: String 
    	get() = "${answered} of ${total} answered"

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println(progressText)
	}
}

fun main() {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    println("${Quiz.answered} of ${Quiz.total} answered.")
    Quiz().printProgressBar()
    println(question1.toString())
}

// scope functions
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty,
)
enum class Difficulty {
    EASY, MEDIUM, HARD
}
interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

class Quiz: ProgressPrintable {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
	override val progressText: String 
    	get() = "${answered} of ${total} answered"

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println(progressText)
	}
    fun printQuiz() {
    question1.let {
        println(it.questionText)
        println(it.answer)
        println(it.difficulty)
    }
    println()
    question2.let {
        println(it.questionText)
        println(it.answer)
        println(it.difficulty)
    }
    println()
    question3.let {
        println(it.questionText)
        println(it.answer)
        println(it.difficulty)
    }
    println()
}
}
fun main() {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    println("${Quiz.answered} of ${Quiz.total} answered.")
    Quiz().printProgressBar()
    println(question1.toString())
    val quiz = Quiz()
    quiz.printQuiz()
    Quiz().apply {
        printQuiz()
    }
}

// array
val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
val solarSystem = rockPlanets + gasPlanets

fun main(){
    println(solarSystem[0])
    println(solarSystem[1])
    println(solarSystem[2])
    println(solarSystem[3])
    println(solarSystem[4])
    println(solarSystem[5])
    println(solarSystem[6])
    println(solarSystem[7])
    solarSystem[3] = "Little Earth"
	println(solarSystem[3])
	val newSolarSystem = arrayOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto")
	println(newSolarSystem[8])
}
// lists
fun main() {
    val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    solarSystem.add("Pluto")
    solarSystem.add(3, "Theia")
    solarSystem[3] = "Future Moon"
    
    for (planet in solarSystem) {
        println(planet)
    }
    solarSystem.removeAt(9)
	solarSystem.remove("Future Moon")
    println()
    println("Future Moon" in solarSystem)
    
	for (planet in solarSystem) {
        println(planet)
    }
}
// sets
fun main() {
    val solarSystem = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
	println(solarSystem.size)
	solarSystem.add("Pluto")
	println(solarSystem.size)
	println(solarSystem.contains("Pluto"))
    solarSystem.add("Pluto")
	println(solarSystem.size)
	solarSystem.remove("Pluto")
    println(solarSystem.size)
    println(solarSystem.contains("Pluto"))

}

