//ACTIVIDAD DE CRUD UTILIZANDO ARREGLOS Y OBJETOS EN JAVA
//Nombres: Edgar David Acosta Bernal y Cristian Felipe Ortiz Cucunuba

import java.util.Scanner;

public class Main { //Primero que nada vamos a iniciar copn la creacion de este que vamos con la clase llamada main, esta va a ser la principal debido a que esta es la que va a manejar el menu y las acciones que va a tomar este como lo que es crear,consultar,actualizar y eliminar

    //Creamos las variables que se van a utilizar

    static Persona[] personas = new Persona[100];//Aca es en donde se guardan los datos del CRUD de las personas, y este tiene un limite para 100 personas 

    static int total = 0;//Este es el que nos va a contar cuantas personas hay registradas y este va a seguir aumentando o disminuyendo si se elimina. Y el 0 es porque el CRUD no tiene nd de datos 

    static Scanner input = new Scanner(System.in);//Este es para qeu pueda escribir en la consola
    public static void main(String[] args) {

        int opcion;//se va a guardar la opcion que se escogio 

        //Le hacemos con el dowhile para que este se pueda ir repitiendo (hasta que se de en la opcion de salir obviamente)
        do {
            //El menu con sus opciones :P
            System.out.println("\n- M  E  N  U -");
            System.out.println("1. Registrar a una persona :D");
            System.out.println("2. Consultar a una persona");
            System.out.println("3. Actualizar una persona");
            System.out.println("4. Eliminar a una persona :(");
            System.out.println("5. Lista de personas");
            System.out.println("6. Salir");
            System.out.print("Digite su opcion"); // Le indica al usuario que escriba su opcion
            System.out.print("(Tienes que elegir el numero)-> ");

            opcion = input.nextInt();//Este va a leer la opcion que se eligio
            input.nextLine();//despues de que lea la opcion elegida, se limpia el buffer para qeu o hayan errores para que despues no se dañe

            //Le hacemos con el switch para que la opcion elegida se pueda ejecutar (Cada opcion es para otra cosa distinta)
            switch (opcion) {
                case 1:
                    registrar();//llama a la opcion escogida
                    break; //este es para que no se salte a las otras opciones (es como un pare)
                case 2:
                    consultar();
                    break;
                case 3:
                    actualizar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    lista();
                    break;
                case 6:
                    System.out.println("Saliendo del CRUD..."); //Deje este mensajito para qeu se viera que se realiza cuando se sale
                    System.out.println("GRACIAS POR UTILIZARLO ;)");
                    break;
                default:
                    System.out.println("ERROR >:("); //estos mensajes se dejan por si no se esocigo una de las opciones que estan hay por ejemplo las qeu estan hay que son del 1 al 6
                    System.out.println("POR FAVOR SELECCIONE UNA DE LAS OPCIONES QUE SI ESTAN EN EL CRUD");
            }

        } while (opcion != 6); //Se repite hasta que la opcion sea la de salir (6)
    }

    public static void registrar() { //Declaramos el metodo de registrar para que se pueda pedir los datos de la persona

        if (total >= 100) { //Primero lo impoortante que es lo de las 100 personas que toca verificarlo y si ya hay 100 personas que diga que no se pueden mas
            System.out.println("EL CRUD YA CUENTA CON 100 PERSONAS");
            return;
        }

        Persona nuevaPersona = new Persona("", 0, 0); //Le pedimos el dato a al usuario para poder llenar nuestro objeto en este cas nuevaPersona

        System.out.print("Nombre: ");//Llamamos a cada metodo para que el usuario pueda registrar los datos pedidos
        nuevaPersona.leerNombre();

        System.out.print("Edad: ");
        nuevaPersona.leerEdad();

        System.out.print("Documento: ");
        nuevaPersona.leerDocumento();

        System.out.print("Sexo: ");
        nuevaPersona.leerSexo();

        System.out.print("Sueldo: ");
        nuevaPersona.leerSueldo();

        personas[total] = nuevaPersona;//Lo que hace esto es guardar el objeto en el arreglo

        total++;//Le dejamos la suma 1 para que este pueda seguir con el siguiente espacio

        System.out.println("PERSONA REGISTRADA CON EXITO :O");
    }

    public static void consultar() { //Ahora seguimos con el metodo de consultar que este nos ayuda a buscar a una persona por su documento

        if (total == 0) {//Es por si no hay gente registrada
            System.out.println("NO HAY PERSONAS :(");
            System.out.println("POR FAVOR REGISTRA UNA PERSONA PARA PODER CONSULTAR");
            return;
        }

        System.out.print("Digite el documento que quieres consultar: ");
        int documento = input.nextInt(); //Este nos guarda el documento que el usuario desea buscar
        input.nextLine();

        int guarda = buscar(documento);//Este nos ayuda a buscar la persona que consultamos por su documento

        if (guarda == -1) {
            System.out.println("DOCUMENTO NO ENCONTRADO");//Si este es -1 es que no hay ninguna persona con ese documento
        } else {
            personas[guarda].imprimirDatos(); //Si es el documento que traiga los datos de este
        }
    }

    public static void actualizar() {//Ahora seguimos con el metodo de actualizar que este es para modificar los datos de una persona ya registrada, y lo hace buscando por el documento

        if (total == 0) { //Se verifica que haya personas registradas para poder actualizar
            System.out.println("NO HAY PERSONAS REGISTRADAS :(");
            return;
        }

        System.out.print("Digite el documento a actualizar: ");
        int documento = input.nextInt(); 
        input.nextLine();

        int guardar = buscar(documento);//Este nos ayuda a buscar la persona que queremos actualizar por su documento

        if (guardar == -1) {
            System.out.println("DOCUMENTO NO ENCONTRADO");
            return;
        }

        //Llamamos a los metodos sobre el objeto que ya existe para que despues este se pueda reemplazar
        System.out.print("Nuevo nombre: ");
        personas[guardar].leerNombre();

        System.out.print("Nueva edad: ");
        personas[guardar].leerEdad();

        System.out.print("Nuevo sexo: ");
        personas[guardar].leerSexo();

        System.out.print("Nuevo sueldo: ");
        personas[guardar].leerSueldo();

        System.out.println("ACTUALIZADO :P");
    }

    public static void eliminar() { //Esta es para eliminar a una persona por su documento, y lo hace buscando por este y despues desplaza los datos para que no queden huecos vacios

        if (total == 0) {
            System.out.println("NO HAY PERSONAS REGISTRADAS :(");
            return;
        }

        System.out.print("Digite el documento a eliminar: ");
        int documento = input.nextInt();
        input.nextLine();

        int guardar = buscar(documento);

        if (guardar == -1) {
            System.out.println("DOCUMENTO NO ENCONTRADO");
            return;
        }

        for (int i = guardar; i < total - 1; i++) {//Aca lo que va a hacer es que va a mover todos los datos para una posicion hacia atras para que en este no haya nigun hueco vacio
            personas[i] = personas[i + 1];
        }

        personas[total - 1] = null;// Esto es para que el ultimo espacio quede vacio y no haya datos repetidos
        total--;

        System.out.println("PERSONA ELIMINADA");
    }

    public static void lista() { //Ya casi acabando vamos con el metodo de la lista que este nos permite ver todas las personas del CRUD

        if (total == 0) {
            System.out.println("NO HAY PERSONAS REGISTRADAS :(");
            return;
        }

        for (int i = 0; i < total; i++) {//Este nos aydua a recorrer todos los datos registrados ahsta el ultimo para que se pueda ver el total de todas las personas
            System.out.print((i + 1) + ". ");//Numero de las personas que se registraron en este
            personas[i].imprimirDatos();//Nos muestra los datos de cada persona
        }
    }

    public static int buscar(int documento) { //Y por ultimo en el metodo esta el de buscar el cual en este nos ayuda a buscar en cada una de las personas por su documento
        for (int i = 0; i < total; i++) {//usamos el for que este nos ayuda a revisar uno x uno
            if (personas[i].getDocumento() == documento) {//Usamos el getDocumento para comparar el documento que se busca con el documento de cada persona registrada
                return i; //Cuando sea encontrado el documento, este nos devuelve la posicion de este en el arreglo para que despues se pueda usar esa posicion para mostrar los datos o actualizar o eliminar
            }
        }
        return -1; //Si este ya revisa y no lo encuentra entonces devuelve -1 para indicar que no se encontro el documento
    }
}