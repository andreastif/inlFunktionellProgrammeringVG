package HuvudprogramVGDEL2.Entities

class Tomte(val name: String) {
    val workers = mutableListOf<Tomte>()

    override fun toString(): String {
        return "Tomte(name='$name')"
    }


}



