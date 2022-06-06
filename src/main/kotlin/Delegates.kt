import java.util.*
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class Delegate() {
    val id: UUID by Generator()
}

class Generator : ReadOnlyProperty<Delegate, UUID> {

    override fun getValue(thisRef: Delegate, property: KProperty<*>): UUID {
        return UUID.randomUUID()
    }

}
