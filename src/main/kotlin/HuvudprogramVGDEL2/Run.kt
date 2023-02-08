package HuvudprogramVGDEL2

import Entities.Tomte

class Run {

    //INSTANSVARIABLER FÖR KLASSEN

    //Nu kan vi ha tomtens namn med underordnade listor
    //1
    val tomten = Tomte("Tomten")

    //2
    val glader = Tomte("Glader")
    val butter = Tomte("Butter")

    //3 (glader)
    val troger = Tomte("Troger")
    val trotter = Tomte("Trotter")
    val blyger = Tomte("Blyger")

    //3 (butter)
    val radjuret = Tomte("Rådjuret")
    val nyckelpigan = Tomte("Nyckelpigan")
    val haren = Tomte("Haren")
    val raven = Tomte("Raven")

    //4 (trotter)
    val skumtomten = Tomte("Skumtomten")

    //5 (skumtomten)
    val dammrattan = Tomte("Dammråttan")

    //6 (raven)
    val grasuggan = Tomte("Gråsuggan")
    val myran = Tomte("Myran")

    //7 (myran)
    val bladlusen = Tomte("Bladlusen")

    //KONSTRUKTOR FÖR KLASSEN - VI HAR EN TOM KONSTRUKTOR OCH VI INITIERAR MED KOD SOM GÖR ATT VI SKAPAR UPP VÅRT RUN.OBJEKT. SPARAT SOM EN VARIABEL I TEST
    init {
        //tomtens arbetare
        tomten.workers.add(glader)
        tomten.workers.add(butter)
        //gladers arbetare
        glader.workers.add(troger)
        glader.workers.add(trotter)
        glader.workers.add(blyger)
        //butters arbetare
        butter.workers.add(radjuret)
        butter.workers.add(nyckelpigan)
        butter.workers.add(haren)
        butter.workers.add(raven)
        //trotters arbetare
        trotter.workers.add(skumtomten)
        //skumtomtens arbetare
        skumtomten.workers.add(dammrattan)
        //ravens arbetare
        raven.workers.add(grasuggan)
        raven.workers.add(myran)
        //myrans arbetare
        myran.workers.add(bladlusen)
    }

    //FUNKTIONEN SOM ÄR REKURSIV
    fun getAllReportingSantas(santa: Tomte): ArrayList<Tomte> {
        val allReportingSantas = ArrayList<Tomte>()
        val size: Int = santa.workers.size
        //här lägger vi till alla santas i listan som vi slutligen returnerar
        for (item in santa.workers) {
            allReportingSantas.add(item)
        }
        //därefter måste vi gå vidare med en dubbelloop som hämtar alla underliggande santas mao ->
        //loopa för varje index 'i' så vi har gått igenom alla workers i underliggande santas.
        for (i in 0 until size) { //yttre loopens storlek (traverserar horisontiellt för santas med fler än 1 underliggande worker)
            val reportingSanta =
                getAllReportingSantas(santa.workers[i]) //anropa funktionen så vi kan addera santas till listan som returneras uppåt
            for (j in 0 until reportingSanta.size) {
                allReportingSantas.add(reportingSanta[j]) //här plockar vi ut resultatet och sparar ner det i det vi returnerar ut
            }
        }
        return allReportingSantas
    }

}