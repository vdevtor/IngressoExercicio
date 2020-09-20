fun main() {
    var ticket = ingresso(30.0)
    var ticketVip = ingressoVip(12.0,30.0)
    var ticketNormal = ingressoVip.ingressoNormal(30.0)
    var camaroteinf = ingressoVip.camaroteInferior("M14", 30.0)
    var camaroteSup = ingressoVip.camaroteSuperior(15.0,30.0,"h18")

    camaroteinf.imprimeLocal()
    camaroteSup.imprimeLocal()
    println(camaroteSup.valorIngressoCamarote())


//        ticket.imprimeValor()
//        ticketNormal.imprimeValor()
//        println("O valor do ingresso Vip é : ${ticketVip.somaAdc()} Reais")

}
open class ingresso(valor: Double){

    open var preco = valor


    open fun imprimeValor(){
        println("O Valor do Ingresso é: ${preco}  Reais")
    }

}

open class ingressoVip(valorAdicional: Double, preco: Double) : ingresso(preco) {
    open var precoAdicional = valorAdicional

    fun somaAdc() : Double{
        return super.preco + precoAdicional

    }

    class ingressoNormal(valor: Double) : ingresso(valor){
        override var preco = valor
        override fun imprimeValor() {
            println("O preço do Ingresso Normal é : ${preco}  Reais")
        }
    }
    open class camaroteInferior(localizacao: String,preco: Double) : ingressoVip(preco, preco){
        var local = localizacao
        open fun imprimeLocal(){
            println("Seu acento esta localizado : ${local}")

        }
    }
    class camaroteSuperior(valorAdicional: Double,preco: Double, localizacao: String) : ingressoVip(valorAdicional, preco){
        var local = localizacao
        var valorA = valorAdicional


        fun imprimeLocal(){
            println("Seu acento esta localizado : ${local}")
        }
        fun valorIngressoCamarote(): Double{
            return valorA + preco

        }

    }

}


