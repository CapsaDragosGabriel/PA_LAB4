# PA_LAB4
 Pentru a recrea exemplul din laborator am folosit functiile acestea:
initializeStreets -> copiez hashset-ul de intersectii intr-un arraylist pentru a accesa elementele mai usor in vederea initializarii strazilor
                     +folosire Faker pentru numele strazilor
initializeIntersectionsSet ->  utilizarea var + stream() pentru a initializa un array de intersection pe care-l folosesc pentru a crea hashset-ul
                    +folosire Faker pentru numele intersectiilor
                    
city.selectStreets(int length) -> selecteaza strazile care au lungimea cel putin egala cu cea specificata si care se invecineaza cu cel putin 3 strazi
getVecinityStreets(Street street) -> parcurge lista strazilor si numara cate strazi se invecineaza cu o anumita strada

am facut clasa City sa dea implement la interfata graph din  jgrapht  si am suprascris metodele, lasand unele dintre ele doar cu "return null" intrucat nu sunt apelate in cadrul algoritmului lui prim.
