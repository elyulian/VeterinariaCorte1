package org.example;

public class Perro {
    private static int contador = 1;

    private int id;
    protected String nombre;
    protected String raza;
    protected int edadMeses;
    protected boolean vacunado;
    protected boolean esterilizado;
    protected boolean adoptado;
    protected String adoptante = "Nulo";
    protected Tamano tamano;

    public enum Tamano {
        PEQUENO, MEDIANO, GRANDE;
    }


    public Perro( String nombre, String raza, int edadMeses, boolean vacunado, boolean esterilizado, boolean adoptado, String adoptante, Tamano tamano) {
        this.id = contador++;
        this.nombre = nombre;
        this.raza = raza;
        this.edadMeses = edadMeses;
        this.vacunado = vacunado;
        this.esterilizado = esterilizado;
        this.adoptado = adoptado;
        this.adoptante = adoptante;
        this.tamano = tamano;
    }

    public Perro() {
        this.id = ++contador;
    }

    public Tamano getTamano() {
        return tamano;
    }

    public void setTamano(Tamano tamano) {
        this.tamano = tamano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdadMeses() {
        return edadMeses;
    }

    public void setEdadMeses(int edadMeses) {
        this.edadMeses = edadMeses;
    }



    public boolean isVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    public boolean isEsterilizado() {
        return esterilizado;
    }

    public void setEsterilizado(boolean esterilizado) {
        this.esterilizado = esterilizado;
    }

    public boolean isAdoptado() {
        return adoptado;
    }

    public void setAdoptado(boolean adoptado) {
        this.adoptado = adoptado;
    }

    public String getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(String adoptante) {
        this.adoptante = adoptante;
    }

    public void mostrarInfo() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Raza: " + raza);
        System.out.println("Edad (meses): " + edadMeses);
        System.out.println("Tamaño: " + tamano);
        System.out.println("Vacunado: " + (vacunado ? "Sí" : "No"));
        System.out.println("Esterilizado: " + (esterilizado ? "Sí" : "No"));
        System.out.println("Adoptado: " + (adoptado ? "Sí" : "No"));
        System.out.println("Adoptante: " + adoptante);
    }

    public void vacunar() {
        System.out.println(nombre + " ha sido vacunado");
        this.vacunado = true;
    }

    public void esterilizar() {
        System.out.println(nombre + " ha sido esterilizado");
        this.esterilizado = true;
    }

    public void marcarAdoptado(String adoptante) {
        if (!this.adoptado) {
            System.out.println(adoptante + "Ha adoptado a: " + nombre);
            this.adoptado = true;
        } else {
            System.out.println("El perro ya esta adoptado");
        }
    }

    public void calcularEdadHumanaAprox() {
        double edadHumana = (edadMeses / 12) * 7;
        System.out.println("Edad humana aproximada en años: " + edadHumana);

    }

    public boolean aptoParaDepartamento() {
        if ((this.tamano.equals(Tamano.PEQUENO) || this.tamano.equals(Tamano.MEDIANO)) && vacunado) {
            System.out.println("es apto para vivir en un departamento");
            return true;
        }
        return false;
    }
}
