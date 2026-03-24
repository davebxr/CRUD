import java.util.Scanner;

public class Persona {//Listo ahroa si empezamos con la otra clase que es la de Persona, esat sirve para guardar los datos de las personas para el CRUD

    //Declaramos los atributos y en privados para que nadie los pueda modificar directamente, solo usando los metodos
    private String nombre = "";
    private int edad = 0;
    private int documento = 0;
    private String sexo = ""; 
    private float sueldo = 0;    

    Persona(String nombre_, int edad_, int documento_) { //Se va a ejcecutar cada vez que se cree una nueva persona, y va a recibir el nombre, la edad y el documento para guardarlos
        this.nombre = nombre_;
        this.edad = edad_;
        this.documento = documento_;
    }

    public void leerNombre() {//Primer metodo de esta clase el cual es el nombre y este es para pedir el nombre de este y lo guarda(Y asi mismo con el resto de los metodos)
        Scanner input = new Scanner(System.in);
        this.nombre = input.nextLine();
    }

    public void leerEdad() {
        Scanner input = new Scanner(System.in);
        this.edad = input.nextInt(); 
    }

    public void leerDocumento() {
        Scanner input = new Scanner(System.in);
        this.documento = input.nextInt();
    }

    public void leerSexo() {
        Scanner input = new Scanner(System.in);
        int opcion; //Creamos una variable demas debido a que esta nos sirve guardar digamos que temporalmente el numero que el usuario escriba

        do { //le hacemos con do debido a que este se va a repetir hasta que el usuario escriba una opcion valida
            System.out.println("Sexo:");
            System.out.println("1. Masculino");
            System.out.println("2. Femenino");
            System.out.print("Digite su opcion: ");
            opcion = input.nextInt();

            if (opcion != 1 && opcion != 2) {//Le hacemos con if para que avise que lo vuelva a colocar la opcion correcta
                System.out.println("OPCION NO REGISTRADA, DIGITA LAS OPCIONES VALIDAS");
            }

        } while (opcion != 1 && opcion != 2); //Se repite hasta que se escoja uno de las opciones validas

         //Guarda la opcion que se escogio tipo si esocigo 1 que diga masculino y si escojio 2 que diga femenino
        if (opcion == 1) {
            this.sexo = "Masculino";
        } else {
            this.sexo = "Femenino";
        }
    }


    public void leerSueldo() {
        Scanner input = new Scanner(System.in);
        this.sueldo = input.nextFloat();
    }

    //Ahora llegamos con los setters a este apartado que con este vamos a poder editar los datos de una persona

    public void setNombre(String nombre_) { this.nombre = nombre_; } //Cambia el nombre por el que quieracolocar el usuario (Y asi con el resto)

    public void setEdad(int edad_) { this.edad = edad_; }

    public void setDocumento(int documento_) { this.documento = documento_; }

    public void setSexo(String sexo_) { this.sexo = sexo_; }

    public void setSueldo(float sueldo_) { this.sueldo = sueldo_; }

    //Seguimo con los getters que estos nos ayudan a consultar a una persona por su numero de documento

    public String getNombre() { return this.nombre; } //Retorna el nombre de la persona (asi mismo con el resto de los getters)

    public int getEdad() { return this.edad; }

    public int getDocumento() { return this.documento; }

    public String getSexo() { return this.sexo; }

    public float getSueldo() { return this.sueldo; }

    public void imprimirDatos() { //Imprimimos los datos de la persona

        int sueldo = (int) this.sueldo;

        System.out.println("Nombre: " + this.nombre + " | Edad: " + this.edad + " | Documento: " + this.documento +  " | Sexo: " + this.sexo + " | Sueldo: $" + sueldo);
    }
}