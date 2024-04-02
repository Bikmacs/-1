import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*

class Milk(name: String, weight: Double, fatContent: Double, manufacturer: String, price: Double, val expiryDate: String, val productionDate: String) : AbstractDairy(name, weight, fatContent, manufacturer, price) {
    override suspend fun printInfoAsync(n: Int) {
        repeat(n) {
            println("Асинхронный вывод информации о $name...")
            delay(1000)
            printInfo()
            delay(1000)
        }
    }

    fun checkExpiryDate() {
        println("Дата производства: $productionDate")
        println("Срок годности: $expiryDate")
        val currentDate = Calendar.getInstance().time
        try {
            val expiryDateObj = SimpleDateFormat("yyyy-MM-dd").parse(expiryDate)
            val expired = currentDate.after(expiryDateObj)
            if (expired) {
                println("Продукт просрочен!")
            } else {
                println("Продукт еще годен к употреблению.")
            }
        } catch (e: Exception) {
            println("Ошибка при проверке срока годности: ${e.message}")
        }
    }
}
