public class Coche {
    public String placa;
    public String marca;
    public String modelo;
    public int año;
    public String ultimoDueño;
    public int kilometraje;
    public double precio;

    public Coche(){}

    public Coche(String placa, String marca, String modelo, int año, String ultimoDueño, int kilometraje, double precio){
        this.placa=placa;
        this.marca=marca;
        this.modelo=modelo;
        this.año=año;
        this.ultimoDueño=ultimoDueño;
        this.kilometraje=kilometraje;
        this.precio=precio;
    }
}
