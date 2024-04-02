abstract class AbstractDairy(val name: String, val weight: Double, val fatContent: Double, val manufacturer: String, val price: Double) : Dairy {
    override fun printInfo() {
        println("Название: $name")
        println("Вес: $weight кг")
        println("Жирность: $fatContent%")
        println("Производитель: $manufacturer")
        println("Цена: $price")
    }
}