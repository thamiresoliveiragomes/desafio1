fun main(){
    var digitalHouseManager = DigitalHouseManager()

    digitalHouseManager.registrarProfessorTitular("João", "Silva", 101, "Android")
    digitalHouseManager.registrarProfessorTitular("Maria", "Santos", 102, "FullStack")

    digitalHouseManager.registrarProfessorAdjunto("Gabriel", "Cruz", 203, 100)
    digitalHouseManager.registrarProfessorAdjunto("Julia", "Ferreira", 204, 360)

    digitalHouseManager.registrarCurso("FullStack", 20001, 3)
    digitalHouseManager.registrarCurso("Android", 20002, 2)

    digitalHouseManager.alocarProfessores(20001, 102, 203)
    digitalHouseManager.alocarProfessores(20002, 101, 204)

    digitalHouseManager.registrarAluno("Leticia", "Souza", 90009)
    digitalHouseManager.registrarAluno("Monica", "Gonçalves", 90010)
    digitalHouseManager.registrarAluno("Lucas", "Pereira", 90011)
    digitalHouseManager.registrarAluno("Caio", "Luz", 90012)
    digitalHouseManager.registrarAluno("Beatriz", "Lopes", 90013)

    digitalHouseManager.matricularAluno(90009, 20001)
    digitalHouseManager.matricularAluno(90010, 20001)
    digitalHouseManager.matricularAluno(90011, 20002)
    digitalHouseManager.matricularAluno(90012, 20002)
    digitalHouseManager.matricularAluno(90013, 20002)
}