package generics

class Contravariance

//interface ContravarianceContainer<out T: Parent> {
//    fun pack(name:String) : T // T может быть возращаемым значением
//    fun unpack(container: T) : String // Compile-time error! T не может быть аргументом функции
//}
//
//fun parentToChildContainer(parentContainer : ContravarianceContainer<Parent>) {
//    val childContainer : ContravarianceContainer<Child> = parentContainer //Type mismatch
//}
//fun childToParentContainer(childContainer: ContravarianceContainer<Child>) {
//    val parentContainer: ContravarianceContainer<Parent> = childContainer
//}