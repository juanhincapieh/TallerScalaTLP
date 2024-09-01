import scala.util.matching.Regex

object regex {

  // Expresiones regulares para el segmentado de los datos
  val correoRegex = new Regex("^[a-zA-Z0-9.]+@(gmail\\.com|unal\\.edu\\.co|med\\.gov\\.co)$")
  val celularRegex = new Regex("^[0-7]{3}-[0-7]{3}-[3-5]{2}-[3-5]{2}$")
  val direccionRegex = new Regex("^(Cra|Cll) [0-9]{2} # [0-9]{2}-[0-9]{1}$")

  // Base de datos de prueba
  val listDatos: List[String] = List(
    "oscar@gmail.com",
    "juhincapieh@unal.edu.co",
    "alcalde@med.gov.co",
    "123-456-34-45",
    "765-432-54-32",
    "Cra 12 # 34-5",
    "casa-juanito",
    "Cq 1 # 70-01",
    "allopezp@unal.edu.co",
    "omsalazaro@unal.edu.co",
    "Cll 56 # 78-9",
    "usuario@hotmail.com",
    "123-456-66-77",
    "Cra 12 # 23-4",
    "direccion-casa"
  )

  // Usamos las expresiones regulares (Regex) para ver cuales de los datos son validos
  def main(args: Array[String]): Unit = {
    val validCorreos = listDatos.filter(correo => correoRegex.matches(correo))
    println("\nCorreos Validos: ")
    for (i <- validCorreos) println(i)

    val validCelulares = listDatos.filter(celular => celularRegex.matches(celular))
    println("\nCelulares Validos: ")
    for (j <- validCelulares) println(j)

    val validDirecciones = listDatos.filter(direccion => direccionRegex.matches(direccion))
    println("\nDirecciones Validas: ")
    for (k <- validDirecciones) println(k)
  }
}
