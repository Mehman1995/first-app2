fun main() {
    val seconds = 61
    val result = agoToText(seconds)
    println("Был(а) в сети $result")

}

fun agoToText(seconds: Int): String {
    var time: Int = seconds
    return when {
        (time in 0..60) -> "только что"
        (time in 61..60 * 60) -> secsToMins(time)
        (time in 60 * 60..24 * 60 * 60) -> secsToHours(time)
        (time in 24 * 60 * 60..48 * 60 * 60) -> "сегодня"
        (time in 48 * 60 * 60..72 * 60 * 60) -> "вчера"
        else -> "давно"
    }
}

fun secsToMins(seconds: Int): String {
    var time = seconds
    time = time / 60 % 60
    return if (time % 10 == 1) "$time минуту назад"
    else if ((time % 10 > 1) && (time % 10 < 5)) "$time минуты назад"
    else "$time минут назад"
}

fun secsToHours(seconds: Int) : String {
    var time = seconds
    time /= 3600
    return if(time % 10 ==1) "$time час назад"
    else if((time % 10 > 1) && (time % 10 < 5)) "$time часа назад"
    else "$time часов назад"
}