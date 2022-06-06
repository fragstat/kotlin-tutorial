import java.util.UUID

class Constructors (val id: UUID = UUID.randomUUID(), val name: String) {  // Primary Constructor

}

fun createInstance() {
    Constructors(UUID.randomUUID(), "Name")
    Constructors(name = "Name")  // При создании объекта значаение можно передавать по имени поля
}