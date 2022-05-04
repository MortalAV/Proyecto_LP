
package Aeropuerto;

import java.util.Scanner;

public class Principal {

    static Scanner datos = new Scanner(System.in);
    final static int num = 4; //Numero de aeropuertos
    static Aeropuerto aeropuerto[] = new Aeropuerto[num];
    
    public static void main(String[] args) {
        
        //Datos de los aeropuertos
        insertarAeropuerto(aeropuerto);
        
        //Menú:
        menu();
        
    }
    
    public static void insertarAeropuerto(Aeropuerto aero[]){
        aero[0] = new AeropuertoPublico(80000000, "Jorge Chavez", "Lima", "Perú");
        aero[0].insertarCompañia(new Compañia("AeroPeru"));
        aero[0].insertarCompañia(new Compañia("Latam"));
        aero[0].getCompañia("AeroPeru").insertarVuelo(new Vuelo("IB20", "Lima", "Mexico", 150.90, 150));
        aero[0].getCompañia("AeroPeru").insertarVuelo(new Vuelo("IB21", "Lima", "Buenos Aires", 180.99, 120));
        aero[0].getCompañia("Latam").insertarVuelo(new Vuelo("FC12", "Lima", "Londres", 500.99, 180));
        aero[0].getCompañia("AeroPeru").getVuelo("IB20").insertarPasajero(new Pasajero("Joel", "KLO98", "Peruano"));
        aero[0].getCompañia("AeroPeru").getVuelo("IB20").insertarPasajero(new Pasajero("Betsy", "PUY67", "Argentina"));
        aero[0].getCompañia("Latam").getVuelo("FC12").insertarPasajero(new Pasajero("Xiomara", "YU341", "Peruana"));
        
        aero[1] = new AeropuertoPrivado("Central Ciudad Real", "Ciudad Real", "España");
        aero[1].insertarCompañia(new Compañia("AirEuropa"));
        String empresas[]={"Cobresol","Fulien"};
        ((AeropuertoPrivado)aero[1]).insertarEmpresas(empresas);
        aero[1].getCompañia("AirEuropa").insertarVuelo(new Vuelo("AE025", "Madrid", "Buenos Aires", 170.50, 140));                                                                          
        aero[1].getCompañia("AirEuropa").getVuelo("AE025").insertarPasajero(new Pasajero("Jose", "HJU12", "Español"));
        
        aero[2] = new AeropuertoPublico(100000000, "Changui", "Changui", "Singapur");
        aero[2].insertarCompañia(new Compañia("AirTour"));
        aero[2].insertarCompañia(new Compañia("AirSinga"));
        aero[2].getCompañia("AirTour").insertarVuelo(new Vuelo("AE030", "Changui", "Lima", 200.99, 165));
        aero[2].getCompañia("AirTour").insertarVuelo(new Vuelo("AE031", "Changui", "New York", 350.99, 170));
        aero[2].getCompañia("AirTour").getVuelo("AE030").insertarPasajero(new Pasajero("Emily", "GYU78", "Peruana"));
        aero[2].getCompañia("AirTour").getVuelo("AE030").insertarPasajero(new Pasajero("Xon Yi", "YIP12", "Chino"));
        
        aero[3] = new AeropuertoPublico(300000000,"Incheon International", "Incheon", "Corea del Sur");
        aero[3].insertarCompañia(new Compañia("AirAsia"));
        aero[3].getCompañia("AirAsia").insertarVuelo(new Vuelo("IB2040", "Incheon", "Mexico", 230.50, 180));
        aero[3].getCompañia("AirAsia").insertarVuelo(new Vuelo("IB2042", "Incheon", "Lima", 300.90, 200));  
        aero[3].getCompañia("AirAsia").getVuelo("IB2040").insertarPasajero(new Pasajero("Luna", "QYU45", "Español"));
        
    }
    
    public static void menu(){
        int opc;
        String nombreAeropuerto,nombreCompañia;
        String ciudadOrigen,ciudadDestino;
        Aeropuerto aeropuertoHallado;
        Compañia compañiaSeleccionada;
        
        do {            
            
            System.out.println("\n\t.Menú.");
            System.out.println("1.Consultar Aeropuertos Gestionados");
            System.out.println("2.Ver sustentación de los aeropuertos");
            System.out.println("3.Lista de Compañias de un Aeropuerto");
            System.out.println("4.Lista de Vuelos por Compañias");
            System.out.println("5.Listar vuelos por Origen a Destino");
            System.out.println("6.Salir");
            
            System.out.print("\nDigite una opción: ");
            opc = datos.nextInt();
            
            switch(opc){
                
                case 1://Ver opcion 1
                        mostrarAeropuertos(aeropuerto);
                        break;
                        
                case 2://Ver opcion 2
                        mostrarPatrocinio(aeropuerto);
                        break;
                        
                case 3://Ver opcion 3
                        datos.nextLine();
                        System.out.print("\nDigite nombre del Aeropuerto: ");
                        nombreAeropuerto = datos.nextLine();
                        aeropuertoHallado = buscarAeropuerto(nombreAeropuerto, aeropuerto);
                        if (aeropuertoHallado==null) {
                            System.out.println("\nEl aeropuerto no existe");
                        }else{
                            mostrarCompañia(aeropuertoHallado);
                        }
                        break;
                
                case 4://Ver opcion 6
                        datos.nextLine();
                        System.out.print("\nDigite nombre del Aeropuerto: ");
                        nombreAeropuerto = datos.nextLine();
                        aeropuertoHallado = buscarAeropuerto(nombreAeropuerto, aeropuerto);
                        if (aeropuertoHallado==null) {
                            System.out.println("\nEl aeropuerto no existe");
                        }else{
                            System.out.print("\nDiigte nombre de la compañia: ");
                            nombreCompañia = datos.nextLine();
                            compañiaSeleccionada = aeropuertoHallado.getCompañia(nombreCompañia);
                            System.out.println(" ");
                            mostrarVuelos(compañiaSeleccionada);
                        }
                        break;
                        
                case 5://Ver opcion 5
                        datos.nextLine();
                        System.out.print("\nDigite la ciudad de origen: ");
                        ciudadOrigen = datos.nextLine();
                        System.out.print("\nDigite la ciudad destino: ");
                        ciudadDestino = datos.nextLine();
                        mostrarVueloOrigenDestino(ciudadOrigen, ciudadDestino, aeropuerto);
                        break;
                        
                case 6://Ver opcion 6
                        break;
                        
                default: System.out.println("\nOpción inválida");
                         break;
            }
            
        } while (opc != 6);
    }
    
    public static void mostrarAeropuertos(Aeropuerto aeropuertos[]){
        for (int i = 0; i < aeropuertos.length; i++) {
            if (aeropuertos[i] instanceof AeropuertoPrivado ) {
                System.out.println("\nAeropuerto Privado");
                System.out.println("Nombre: "+aeropuertos[i].getNombre());
                System.out.println("Ciudad: "+aeropuertos[i].getCiudad());
                System.out.println("País: "+aeropuertos[i].getPais());
            }else{
                System.out.println("\nAeropuerto Público");
                System.out.println("Nombre: "+aeropuertos[i].getNombre());
                System.out.println("Ciudad: "+aeropuertos[i].getCiudad());
                System.out.println("País: "+aeropuertos[i].getPais());
            }
        }
 
    }
    
    public static void mostrarPatrocinio(Aeropuerto aeropuertos[]){
        
        String empresas[];
        
        for (int i = 0; i < aeropuertos.length; i++) {
            if (aeropuertos[i] instanceof AeropuertoPrivado ) {
                System.out.println("\nAeropuerto Privado: "+aeropuertos[i].getNombre());
                empresas = ((AeropuertoPrivado)aeropuertos[i]).getListaEmpresas();
                System.out.println("\nEmpresas:");
                for (int j = 0; j < empresas.length; j++) {
                    System.out.println(empresas[j]);
                }
            }else{
                System.out.println("\nAeropuerto Público: "+aeropuertos[i].getNombre());
                System.out.println("\nSubvención: "+((AeropuertoPublico)aeropuertos[i]).getSubvencion());
            }
        }
    }
    
    public static Aeropuerto buscarAeropuerto(String nombre, Aeropuerto aeropuertos[]){
        boolean encontrado = false;
        int i=0;
        Aeropuerto aero = null;
        
        while ((!encontrado)&&(i<aeropuertos.length)) {            
            if (nombre.equals(aeropuertos[i].getNombre())) {
                encontrado = true;
                aero = aeropuertos[i];
            }
            i++;
        }
        return aero;
    }
    
    public static void mostrarCompañia(Aeropuerto aeropuerto){
        System.out.println("\nCompañias del Aeropuerto "+aeropuerto.getNombre()+" :");
        for (int i = 0; i < aeropuerto.getNumCompañia(); i++) {
            System.out.println("  *"+aeropuerto.getCompañia(i).getNombre());
        }
    }
    
    public static void mostrarVuelos(Compañia compañia){
        
        Vuelo vuelo;
        
        for (int i = 0; i < compañia.getNumVuelo(); i++) {
            vuelo = compañia.getVuelo(i);
            System.out.println("Identificador: "+vuelo.getIdentificador());
            System.out.println("Ciudad Origen: "+vuelo.getCiudadOrigen());
            System.out.println("Ciudad Destino: "+vuelo.getCiudadDestino());
            System.out.println("Precio: "+vuelo.getPrecio());
            System.out.println(" ");
        }
    }
    
    public static Vuelo[] buscarVuelosOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[]){
        
        Vuelo vuelo;
        int cantidadVuelos=0;
        Vuelo listaVuelosHallados[];
        
        for (int i = 0; i < aeropuertos.length; i++) {//Aeropuertos
            for (int j = 0; j < aeropuertos[i].getNumCompañia(); j++) {//Compañias
                for (int k = 0; k < aeropuertos[i].getCompañia(j).getNumVuelo(); k++) {//Vuelos
                    
                    vuelo=aeropuertos[i].getCompañia(j).getVuelo(k);
                    
                    if ((origen.equals(vuelo.getCiudadOrigen())&&(destino.equals(vuelo.getCiudadDestino())))) {
                        cantidadVuelos++;
                    }
                    
                }
            }
        }
        
        listaVuelosHallados = new Vuelo[cantidadVuelos];
        
        int q=0;
        
        for (int i = 0; i < aeropuertos.length; i++) {//Aeropuertos
            for (int j = 0; j < aeropuertos[i].getNumCompañia(); j++) {//Compañias
                for (int k = 0; k < aeropuertos[i].getCompañia(j).getNumVuelo(); k++) {//Vuelos
                    
                    vuelo=aeropuertos[i].getCompañia(j).getVuelo(k);
                    
                    if ((origen.equals(vuelo.getCiudadOrigen())&&(destino.equals(vuelo.getCiudadDestino())))) {
                        
                        listaVuelosHallados[q]=vuelo;
                        q++;
                    }
                    
                }
            }
        }
        
        return listaVuelosHallados;
        
    }
    
    public static void mostrarVueloOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[]){
        Vuelo vuelos[];
        vuelos = buscarVuelosOrigenDestino(origen, destino, aeropuertos);
        if (vuelos.length==0) {
            System.out.println("No existen vuelos de esa ciudad origen a destino");
        }else{
            System.out.println("\nVuelos encontrados: ");
            for (int i = 0; i < vuelos.length; i++) {
                System.out.println("\nIdentificador: "+vuelos[i].getIdentificador());
                System.out.println("Ciudad Origen: "+vuelos[i].getCiudadOrigen());
                System.out.println("Ciudad Destino: "+vuelos[i].getCiudadDestino());
                System.out.println("Precio: $"+vuelos[i].getPrecio());
            }
        }
    }
}


