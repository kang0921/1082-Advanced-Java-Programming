internal interface Animal {
    fun speak()
    fun preferredAction()
}

internal class Dog : Animal {
    override fun speak() {
        println("Dog says: Bow-Wow.")
    }

    override fun preferredAction() {
        println("Dogs prefer barking...\n")
    }
}

internal class Tiger : Animal {
    override fun speak() {
        println("Tiger says: Halum.")
    }

    override fun preferredAction() {
        println("Tigers prefer hunting...\n")
    }
}

internal abstract class AnimalFactory {
    abstract fun createAnimal(): Animal
}

internal class DogFactory : AnimalFactory() {
    override fun createAnimal(): Animal {
        return Dog()
    }
}

internal class TigerFactory : AnimalFactory() {
    override fun createAnimal(): Animal {
        return Tiger()
    }
}


fun main() {
    println("***Factory Pattern Demo***\n")
    val tigerFactory: AnimalFactory = TigerFactory()
    val aTiger = tigerFactory.createAnimal()
    aTiger.speak()
    aTiger.preferredAction()

    
    val dogFactory: AnimalFactory = DogFactory()
    val aDog = dogFactory.createAnimal()
    aDog.speak()
    aDog.preferredAction()
}