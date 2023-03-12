import java.util.Scanner;
public class Proyecto{
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=1, i=0, opcion, opcion2, opcion3, encontrado, pos=5;
        System.out.println("Introduce el numero de autos");
        n=input.nextInt();
        Coche[] coches=new Coche[n+5];
        cargar(coches);
        do{
            opcion=menu();
            switch(opcion){
                case 1:
                    if(pos<coches.length){
                        coches[pos]=new Coche();
                        leerDatos(coches[pos]);
                        pos++;
                        break;
                    }
                    
                case 2:
                    encontrado=buscador(coches, pos);
                    if(encontrado!=-1){
                        imprimir(coches, 1, encontrado);
                    }
                    else{
                        System.out.println("No encontrado");
                    }
                    break;

                case 3:
                    do{
                        opcion2=menuOrdenadores();
                        switch(opcion2){
                            case 1:
                                do{
                                    opcion3=menuOrdenadores2();
                                    switch(opcion3){
                                        case 1: 
                                            burbuja(coches, pos);
                                            opcion3=0;
                                            break;
                
                                        case 2:
                                            seleccion(coches, pos);
                                            opcion3=0;
                                            break;
                
                                        case 3:
                                            insercion(coches, pos);
                                            opcion3=0;
                                            break;
                
                                        default:
                                            System.out.println("La opcion no es valida, vuelve a intentar");
                                            break;
                                    }
                                }while(opcion3>0);
                                imprimir(coches, pos, i);
                                opcion2=0;
                                break;

                            case 2:
                                do{
                                    opcion3=menuOrdenadores2();
                                    switch(opcion3){
                                        case 1: 
                                            burbuja2(coches, pos);
                                            opcion3=0;
                                            break;
                
                                        case 2:
                                            seleccion2(coches, pos);
                                            opcion3=0;
                                            break;
                
                                        case 3:
                                            insercion2(coches, pos);
                                            opcion3=0;
                                            break;
                
                                        default:
                                            System.out.println("La opcion no es valida, vuelve a intentar");
                                            break;
                                    }
                                }while(opcion3>0);
                                imprimir(coches, pos, i);
                                opcion2=0;
                                break;
                            
                            case 3:
                                do{
                                    opcion3=menuOrdenadores2();
                                    switch(opcion3){
                                        case 1: 
                                            burbuja3(coches, pos);
                                            opcion3=0;
                                            break;
                
                                        case 2:
                                            seleccion3(coches, pos);
                                            opcion3=0;
                                            break;
                
                                        case 3:
                                            insercion3(coches, pos);
                                            opcion3=0;
                                            break;
                
                                        default:
                                            System.out.println("La opcion no es valida, vuelve a intentar");
                                            break;
                                    }
                                }while(opcion3>0);
                                imprimir(coches, pos, i);
                                opcion2=0;
                                break;

                            default:
                                System.out.println("La opcion no es valida, vuelve a intentar");
                                break;
                        }
                    }while(opcion2>0);
                    break;

                case 4:
                    encontrado=buscador(coches, pos);
                    if(encontrado!=-1){
                        imprimir(coches, 1, encontrado);
                        editar(coches, encontrado);
                    }
                    else{
                        System.out.println("No encontrado");
                    }
                    break; 
                    
                case 5:
                    opcion=0;
                    break;
                default:
                    System.out.println("La opcion no es valida, vuelve a intentar");
                    break; 
            }
        }while(opcion>0);
        
    }

    public static int menuOrdenadores2(){
        Scanner input=new Scanner(System.in);
        int opcion;
        System.out.println("\n---Elige una opcion---");
        System.out.println("1) Ordenar con burbuja");
        System.out.println("2) Ordenar con seleccion directa");
        System.out.println("3) Ordenar con insercion directa");
        opcion=input.nextInt();
        return opcion;
    }

    public static int menuOrdenadores(){
        Scanner input=new Scanner(System.in);
        int opcion;
        System.out.println("\n---Elige una opcion---");
        System.out.println("1) Ordenar por año");
        System.out.println("2) Ordenar por kilometraje");
        System.out.println("3) Ordenar por precio");
        opcion=input.nextInt();
        return opcion;
    }

    public static void editar(Coche[] c, int pos){
        Scanner input=new Scanner(System.in);
        System.out.println("\n--Ingresa los nuevos datos--");
        System.out.println("Introduce el nombre del antiguo dueño (Nombre_Apellido Paterno)");
        c[pos].ultimoDueño=input.next();
        System.out.println("Introduce la marca del automovil");
        c[pos].marca=input.next();
        System.out.println("Introduce el modelo del auto");
        c[pos].modelo=input.next();
        System.out.println("Introduce el año del auto");
        c[pos].año=input.nextInt();
        System.out.println("Introduce la placa del auto");
        c[pos].placa=input.next();
        System.out.println("Introduce el kilometraje del auto");
        c[pos].kilometraje=input.nextInt();
        System.out.println("Introduce el precio del auto");
        c[pos].precio=input.nextInt();
    }

    public static int buscador(Coche[] c, int pos){
        Scanner input=new Scanner(System.in);
        String nombre;
        int ubicacion=-1;
        System.out.println("\n--Introduce el nombre del antiguo dueño--");
        nombre=input.next();
        int i=0;
        do{
            if(nombre.equals(c[i].ultimoDueño)){
                ubicacion=i;
            }
            i++;
        }while(ubicacion==-1 && i<pos);
        return ubicacion;
    }

    public static void cargar(Coche[] c){
        c[0]=new Coche("GTA-12-23", "Toyota", "Sienna", 2020, "Juan_Gonzales", 50000, 530000);
        c[1]=new Coche("GYO-16-34", "Ford", "Focus", 2015, "Jose_Rodriguez", 30000, 250000);
        c[2]=new Coche("FTA-56-94", "Nissan", "Versa", 2017, "Antonio_Perez", 20000, 100000);
        c[3]=new Coche("LPO-54-17", "Ford", "Fiesta", 2019, "Rodrigo_Juarez", 60000, 120000);
        c[4]=new Coche("TYU-90-74", "Toyota", "RAV 4", 2021, "Luis_Camacho", 32400, 400000);

    }


    public static int menu(){
        Scanner input=new Scanner(System.in);
        int opcion;
        System.out.println("\n---Elige una opcion---");
        System.out.println("1) Agregar automovil");
        System.out.println("2) Buscar");
        System.out.println("3) Mostrar lista de autos");
        System.out.println("4) Editar");
        System.out.println("5) Salir");
        opcion=input.nextInt();
        return opcion;
    }

    public static void leerDatos(Coche c){
        Scanner input=new Scanner(System.in);
        System.out.println("Introduce el nombre del antiguo dueño (Nombre_Apellido Paterno)");
        c.ultimoDueño=input.next();
        System.out.println("Introduce la marca del automovil");
        c.marca=input.next();
        System.out.println("Introduce el modelo del auto");
        c.modelo=input.next();
        System.out.println("Introduce el año del auto");
        c.año=input.nextInt();
        System.out.println("Introduce la placa del auto");
        c.placa=input.next();
        System.out.println("Introduce el kilometraje del auto");
        c.kilometraje=input.nextInt();
        System.out.println("Introduce el precio del auto");
        c.precio=input.nextInt();
    }

    public static void imprimir(Coche [] c, int pos, int i){
        System.out.println("\nAño\tAntiguo dueño\tMarca\tModelo\tPlaca del auto\tKilometraje\tPrecio");
        while(i<pos){ 
            System.out.print(c[i].año + "\t");
            System.out.print(c[i].ultimoDueño + "\t");
            System.out.print(c[i].marca + "\t");
            System.out.print(c[i].modelo + "\t");
            System.out.print(c[i].placa + "\t");
            System.out.print(c[i].kilometraje + "\t\t");
            System.out.println(c[i].precio);
            i++;
        }
    }

    /*public static void imprimirUno(Coche [] c, int pos){
        System.out.println("\nAño\tAntiguo dueño\tMarca\tModelo\tPlaca del auto\tKilometraje\tPrecio");
        for(int i=0;i<1;i++){ 
            System.out.print(c[pos].año + "\t");
            System.out.print(c[pos].ultimoDueño + "\t");
            System.out.print(c[pos].marca + "\t");
            System.out.print(c[pos].modelo + "\t");
            System.out.print(c[pos].placa + "\t");
            System.out.print(c[pos].kilometraje + "\t\t");
            System.out.println(c[pos].precio);
        }
    }*/

    public static void burbuja(Coche[] c, int pos){
        
        for(int i=0;i<pos-1;i++){
            for(int g=0;g<pos;g++){
                System.out.print(c[g].año + "\t");
            }
            System.out.println("\n");
            for(int j=0;j<pos-1;j++){
                
                if(c[j].año>c[j+1].año){   
                    Coche aux=c[j];
                    c[j]=c[j+1];
                    c[j+1]= aux;
                }

                for(int g=0;g<pos;g++){
                    System.out.print(c[g].año + "\t");
                }
                System.out.println("\n");
            }
            

            
        }
    }


    public static void seleccion(Coche[] c, int pos2){
        int menor, pos;
        Coche aux;
        for(int g=0;g<pos2;g++){
            System.out.print(c[g].año + "\t");
        }
        System.out.println("\n");
        for(int i=0;i<pos2-1;i++){
            menor=c[i].año;
            pos=i;
            for(int j=i;j<pos2;j++){
                
                if(c[j].año < menor){
                    menor=c[j].año;
                    pos=j;
                }
            }

            aux=c[i];
            c[i]=c[pos];
            c[pos]=aux;

            for(int g=0;g<pos2;g++){
                System.out.print(c[g].año + "\t");
            }
            System.out.println("\n");
            
        }
        
    }

    public static void insercion(Coche[] c, int pos){
        Coche aux;
        for(int g=0;g<pos;g++){
            System.out.print(c[g].año + "\t");
        }
        System.out.println("\n");
        for(int i=1;i<pos;i++){
            aux=c[i];
            for(int j=i-1;(j>=0 && (aux.año < c[j].año));j--){
                c[j+1]=c[j];
                c[j]=aux;

                for(int g=0;g<pos;g++){
                    System.out.print(c[g].año + "\t");
                }
                System.out.println("\n");
            }
        }
    }

    public static void burbuja2(Coche[] c, int pos){
        for(int i=0;i<pos-1;i++){
            for(int g=0;g<pos;g++){
                System.out.print(c[g].kilometraje + "\t");
            }
            System.out.println("\n");
            for(int j=0;j<pos-1;j++){
                
                if(c[j].kilometraje>c[j+1].kilometraje){   
                    Coche aux=c[j];
                    c[j]=c[j+1];
                    c[j+1]= aux;
                }

                for(int g=0;g<pos;g++){
                    System.out.print(c[g].kilometraje + "\t");
                }
                System.out.println("\n");
            }
        }
    }


    public static void seleccion2(Coche[] c, int pos2){
        int menor, pos;
        Coche aux;
        for(int g=0;g<pos2;g++){
            System.out.print(c[g].kilometraje + "\t");
        }
        System.out.println("\n");
        for(int i=0;i<pos2-1;i++){
            
            menor=c[i].kilometraje;
            pos=i;
            for(int j=i;j<pos2;j++){
                
                if(c[j].kilometraje < menor){
                    menor=c[j].kilometraje;
                    pos=j;
                }
            }
            aux=c[i];
            c[i]=c[pos];
            c[pos]=aux;

            for(int g=0;g<pos2;g++){
                System.out.print(c[g].kilometraje + "\t");
            }
            System.out.println("\n");
        }
        
    }

    public static void insercion2(Coche[] c, int pos){
        Coche aux;
        for(int g=0;g<pos;g++){
            System.out.print(c[g].kilometraje + "\t");
        }
        System.out.println("\n");
        for(int i=1;i<pos;i++){
            aux=c[i];
            for(int j=i-1;(j>=0 && (aux.kilometraje < c[j].kilometraje));j--){
                c[j+1]=c[j];
                c[j]=aux;

                for(int g=0;g<pos;g++){
                    System.out.print(c[g].kilometraje + "\t");
                }
                System.out.println("\n");
            }
        }
    }


    public static void burbuja3(Coche[] c, int pos){
        for(int i=0;i<pos-1;i++){
            for(int g=0;g<pos;g++){
                System.out.print(c[g].precio + "\t");
            }
            System.out.println("\n");
            for(int j=0;j<pos-1;j++){
                
                if(c[j].precio>c[j+1].precio){   
                    Coche aux=c[j];
                    c[j]=c[j+1];
                    c[j+1]= aux;
                }

                for(int g=0;g<pos;g++){
                    System.out.print(c[g].precio + "\t");
                }
                System.out.println("\n");
            }
        }
    }


    public static void seleccion3(Coche[] c, int pos2){
        int pos;
        double menor;
        Coche aux;
        for(int g=0;g<pos2;g++){
            System.out.print(c[g].precio + "\t");
        }
        System.out.println("\n");
        for(int i=0;i<pos2-1;i++){
            
            menor=c[i].precio;
            pos=i;
            for(int j=i;j<pos2;j++){
                
                if(c[j].precio < menor){
                    menor=c[j].precio;
                    pos=j;
                }
            }
            aux=c[i];
            c[i]=c[pos];
            c[pos]=aux;

            for(int g=0;g<pos2;g++){
                System.out.print(c[g].precio + "\t");
            }
            System.out.println("\n");
        }
        
    }

    public static void insercion3(Coche[] c, int pos){
        Coche aux;
        for(int g=0;g<pos;g++){
            System.out.print(c[g].precio + "\t");
        }
        System.out.println("\n");
        for(int i=1;i<pos;i++){
            aux=c[i];
            for(int j=i-1;(j>=0 && (aux.precio < c[j].precio));j--){
                c[j+1]=c[j];
                c[j]=aux;

                for(int g=0;g<pos;g++){
                    System.out.print(c[g].precio + "\t");
                }
                System.out.println("\n");
            }
        }
    }
}