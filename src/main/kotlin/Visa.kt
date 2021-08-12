fun main() {
    val masterCard = "MasterCard"
    val maestro = "Maestro"
    val visa = "Visa"
    val vKPay = "VkPay"
    val world = "Мир"
    val sum = 7_000.0
    println(comissionCalculater(visa, sum))

}

fun comissionCalculater(card: String = "VK Pay", sum: Double = 0.0): String {
    return when (card) {
        "MasterCart", "Maestro" ->
            if (sum < 50 || sum > 150_000) "Ошибка перевода средств"
            else if (sum in 300.0..75000.0) "Осуществлен перевод на сумму $sum"
            else "Осуществлен перевод на сумму ${masterCardCommission(sum)}"
        "Visa", "Мир" ->
            if (sum < 50 || sum > 150_000) "Ошибка перевода средств"
            else "Осуществлен перевод на сумму ${visaCardCommission(sum)}"
        else -> if (sum > 15_000) "Ошибка перевода средств" else "Осуществлен перевод на сумму $sum"
    }
}

fun masterCardCommission(commission: Double): Double {
    var result = commission
    result -= (result * 0.6 / 100 - 20)
    return result
}

fun visaCardCommission(commission: Double): Double {
    var result = commission
    result -= (result * 0.75 / 100 - 35)
    return result
}