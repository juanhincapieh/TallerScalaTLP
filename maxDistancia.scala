object MaxDistancia {

  def maxDistancia(puntos: List[(Double, Double)], distancia: ((Double, Double), (Double, Double)) => Double): Double = {

    // Con "combinaciones" generamos todas las posibles combinaciones de puntos y calculamos la distancia entre ellos
    val combinaciones = {

      for {

        pt1 <- puntos
        pt2 <- puntos
        if pt1 != pt2 // Sabemos que si son el mismo punto la distancia será de 0, por lo que es irrelevante para calcular la distancia máxima

      } yield distancia(pt1, pt2)

    }

    var maxDist = 0.0 // Empezamos la máxima distancia en 0.0 para que sea reemplazada por la primera distancia calculada

    for (dist <- combinaciones) {
      if (dist > maxDist) {
        maxDist = dist
      }
    }

    maxDist

  }

  def calcularDistancia(pt1: (Double, Double), pt2: (Double, Double)): Double = {
    val (x1, y1) = pt1
    val (x2, y2) = pt2
    Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2))
  }

  def main(args: Array[String]): Unit = {
    val listapuntos = List((4.0, 3.0), (5.0, 7.0), (1.0, 3.0), (8.0, 10.0))

    val distanciaMaxima = maxDistancia(listapuntos, calcularDistancia)

    println(s"La distancia máxima de la lista de puntos es: $distanciaMaxima")
  }
}
