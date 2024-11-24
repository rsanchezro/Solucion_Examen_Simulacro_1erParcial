import kotlin.random.Random
import kotlin.random.nextInt

fun main()
               {
                var funcion=  {c:Char,pos:Int->if((pos%2!=0)&&(c=='a'))  'z'
                else
                    c}

                    var array_funciones=listOf({car:Char,pos:Int->
                        when(car.lowercaseChar())
                        {
                            'a'->'e'
                            'e'->'i'
                            'i'->'o'
                            'o'->'u'
                            'u'->'a'
                            else -> car.lowercaseChar()
                        }

                    },{car:Char,pos:Int->
                        if(pos%2!=Random.nextInt(0..1)) car
                        else '_'


                    },{car:Char,pos:Int->
                        if(pos%2==0)
                                 car.lowercaseChar().code-'a'.code+1
                        else
                            car
               })


                   println("balon".transformar (false, array_funciones.get(2) as (Char, Int) -> Char))

                   println("")

                 //  "balon".transformar(false)

                    println("patata".transformar(false,funcion))
                   }





               fun String.transformar(descolocada:Boolean,funcion:(car:Char,pos:Int)->Char,):String{
                   var resultado= mutableListOf<Char>()

                     for(pos in 0..this.length-1){
                            resultado.add(funcion(this.get(pos),pos) )

                        }
                   if(descolocada)
                   {
                       var resultado_temp= mutableListOf<Char>()
                       var set_aleatorios=rellenarSetAleatorio(resultado.size,0..resultado.size-1)
                     set_aleatorios.forEach{
                         resultado_temp.add(resultado.get(it))
                     }
                       resultado=resultado_temp
                   }
                   return resultado.joinToString ("")


               }


               fun rellenarSetAleatorio(tamaño: Int, rango: IntRange): Set<Int> {
                   val conjunto = mutableSetOf<Int>()
                   while (conjunto.size < tamaño) {
                       val numeroAleatorio = Random.nextInt(rango.first, rango.last + 1)
                       conjunto.add(numeroAleatorio)
                   }
                   return conjunto
               }