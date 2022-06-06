import generics.Parent

fun scopeFun(obj : Parent? = null) {
    val list: MutableList<Int> = mutableListOf<Int>().also {
        it.add(1)
        it.add(2)
    }
    list.apply {
        repeat(10) {
            this.add(it)
        }
        this.add(5)
    }
    val set: MutableSet<Int> = with(list) {
        val set: MutableSet<Int> = mutableSetOf()
        for (value in this) {
            set.add(value)
        }
        set
    }
    println("Set size is ${set.size}")
    obj?.run {
        printName()
        name = "Oleg"
        name?.let {
            println("Now " concat "my name is $name")
        }
    }
}

fun main() {
    scopeFun(Parent("Stas"))
}