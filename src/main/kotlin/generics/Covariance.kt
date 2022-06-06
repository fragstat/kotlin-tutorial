package generics

class Covariance

//interface CovarianceContainer<out T: Parent> {
//    fun pack(name:String) : T // T может быть возращаемым значением
//    fun unpack(container: T) : String // Compile-time error! T не может быть аргументом функции
//}
//
//fun parentToChildContainer(parentContainer : CovarianceContainer<Parent>) {
//    val childContainer : CovarianceContainer<Child> = parentContainer //Type mismatch
//}
//fun childToParentContainer(childContainer: CovarianceContainer<Child>) {
//    val parentContainer: CovarianceContainer<Parent> = childContainer
//}