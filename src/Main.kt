import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.text.SimpleDateFormat
import java.util.*

fun main() {
    val input = Scanner(System.`in`)

    println("Введите название молочного продукта:")
    val name = input.nextLine()

    println("Введите вес (кг):")
    var weight = 0.0
    var validWeight = false
    while (!validWeight) {
        try {
            weight = input.nextDouble()
            validWeight = true
        } catch (e: Exception) {
            println("Ошибка ввода веса. Повторите ввод:")
            input.next() // очистка буфера
        }
    }

    println("Введите жирность (%):")
    var fatContent = 0.0
    var validFatContent = false
    while (!validFatContent) {
        try {
            fatContent = input.nextDouble()
            validFatContent = true
        } catch (e: Exception) {
            println("Ошибка ввода жирности. Повторите ввод:")
            input.next() // очистка буфера
        }
    }

    println("Введите производителя:")
    val manufacturer = input.nextLine()

    println("Введите цену:")
    var price = 0.0
    var validPrice = false
    while (!validPrice) {
        try {
            price = input.nextDouble()
            validPrice = true
        } catch (e: Exception) {
            println("Ошибка ввода цены. Повторите ввод:")
            input.next() // очистка буфера
        }
    }

    println("Введите дату производства (год-месяц-день):")
    var productionDate = ""
    var validDate = false
    while (!validDate) {
        try {
            productionDate = input.nextLine()
            SimpleDateFormat("yyyy-MM-dd").parse(productionDate) // проверка корректности формата даты
            validDate = true
        } catch (e: Exception) {
            println("Ошибка ввода даты. Повторите ввод (год-месяц-день):")
        }
    }

    println("Введите дату окончания срока годности (год-месяц-день):")
    val expiryDate = input.nextLine()

    println("Введите количество раз для запуска вывода информации асинхронно:")
    var times = 0
    var validTimes = false
    while (!validTimes) {
        try {
            times = input.nextInt()
            validTimes = true
        } catch (e: Exception) {
            println("Ошибка ввода количества. Повторите ввод:")
            input.next()
        }
    }

    runBlocking {
        val milk = Milk(name, weight, fatContent, manufacturer, price, expiryDate, productionDate)

        println("Информация о молочном продукте:")
        milk.printInfo()
        println()

        launch {
            milk.printInfoAsync(times)
        }

        println()
        println("Проверка срока годности:")
        milk.checkExpiryDate()
    }
}