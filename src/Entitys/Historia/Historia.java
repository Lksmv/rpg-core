package Entitys.Historia;

public class Historia {

    private Capitulo inicio;


    public Historia(Capitulo inicio) {
        this.inicio = inicio;
    }

    public void iniciarHistoria() {
        inicio.narrar();
    }

}
