#Kotlin tutorial

##Конструкторы

https://metanit.com/kotlin/tutorial/4.3.php

```kotlin

class Constructors (val id: UUID = UUID.randomUUID(), val name: String) {  // Через = можно задать значение по умолчанию

}
Constructors(UUID.randomUUID(), "Name")
Constructors(name = "Name")  // При создании объекта значаение можно передавать по имени поля
```

##Условные конструкции
https://metanit.com/kotlin/tutorial/2.6.php

##Data-классы
https://metanit.com/kotlin/tutorial/4.12.php
```kotlin
data class DataClass (val name:String) //Как минимум одна переменна я в primary constructor
```

##Вложенные классы и интерфейсы
https://metanit.com/kotlin/tutorial/4.7.php

##Objects/Companion objects
https://kotlinlang.ru/docs/reference/object-declarations.html

##Дженерики, инвариантность, контрвариантность, ковариантность
https://metanit.com/kotlin/tutorial/6.3.php

Создадим классы:

```kotlin
open class Parent(val name: String)

class Child(name: String, val surname: String) : Parent(name) 
```

###Инвариантность
```kotlin
interface Container<T:Parent> {
    fun pack(name:String) : T // T может быть возращаемым значением
    fun unpack(container: T) : String // T может быть аргументом функции
}

fun parentToChildContainer(parentContainer : Container<Parent>) {
    val childContainer : Container<Child> = parentContainer //Type mismatch
}
fun childToParentContainer(childContainer: Container<Child>) {
    val parentContainer : Container<Parent> = childContainer //Type mismatch
}
```

###Ковариантность
```kotlin
interface Container<out T:Parent> {
    fun pack(name:String) : T // T может быть возращаемым значением
    fun unpack(container: T) : String // Compile-time error! T не может быть аргументом функции 
}

fun parentToChildContainer(parentContainer : Container<Parent>) {
    val childContainer : Container<Child> = parentContainer //Type mismatch
}
fun childToParentContainer(childContainer: Container<Child>) {
    val parentContainer: Container<Parent> = childContainer
}
```

###Контрвариантность
```kotlin
interface Container<in T:Parent> {
    fun pack(name:String) : T // Compile-time error! T не может быть возращаемым значением
    fun unpack(container: T) : String // T может быть аргументом функции
}

fun parentToChildContainer(parentContainer : Container<Parent>) {
    val childContainer : Container<Child> = parentContainer
}
fun childToParentContainer(childContainer: Container<Child>) {
    val parentContainer: Container<Parent> = childContainer //Type mismatch
}
```


##Scope-функции
https://metanit.com/kotlin/tutorial/5.7.php  
```kotlin
val list: MutableList<Int> = mutableListOf<Int>().apply { 
    this.add(1)
    this.add(2)
}
```

##Коллекции
https://kotlinlang.ru/docs/reference/collections-overview.html

```kotlin
    val list: List<Int> = ArrayList() //Коллекция только для чтения
    list.add(5) //compile-time error
    val mutableList: MutableList<Int> = mutableListOf() //Колекция с возможностью записи
    mutableList.add(5)
```

##Extension-функции
https://kotlinlang.ru/docs/reference/extensions.html

```kotlin
// Функция удаляющая пробелы
fun String.deleteSpaces() : String {
    return this.replace(" ", "")
}
```

##Infix функции
https://metanit.com/kotlin/tutorial/5.4.php
```kotlin
println("Hello " concat "world !") //"Hello world !"

infix fun String.concat(string: String) : String {
    return this + string
}
```

##Lambdas
https://kotlinlang.ru/docs/reference/lambdas.html

https://metanit.com/kotlin/tutorial/3.6.php
```kotlin
val list: List<String> = listOf("Moscow", "Ufa", "Voronezh")
list.filter { city -> city.length > 5 }.toList()
```

##Delegates
https://kotlinlang.ru/docs/reference/delegated-properties.html
```kotlin
fun main(args: Array<String>) {
    println(Delegate().id) // "1605210a-23cb-4514-9b75-045968badc5a"
}

class Delegate() {
    val id: UUID by Generator()
}

class Generator() {
    operator fun getValue(thisRef: Delegate, property: KProperty<*>): UUID {
        return UUID.randomUUID();
    }
}
```