/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electrozone_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author leo2
 */
public class Tienda {

    private List<Inventario> productos;
    private List<SesionCliente> clientes;
    private List<SesionVendedor> vendedores;
    private List<Usuario> usuarios;
    private List<Domicilio> domicilios;

    private final String RUTA_PRODUCTOS = "C:\\Users\\selva\\Desktop\\Proyecto\\Archivos\\productos.txt";
    private final String RUTA_USUARIOS = "C:\\Users\\selva\\Desktop\\Proyecto\\Archivos\\usuarios.txt";
    private final String RUTA_DOMICILIOS = "C:\\Users\\selva\\Desktop\\Proyecto\\Archivos\\domicilios.txt";

//Se declaran nuevas las listas de la tienda
    public Tienda() {
        this.productos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.vendedores = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.domicilios = new ArrayList<>();
    }
//metodo que se usa en el main para ya tener cargados mercancia 

    public void cargarDatos() {
        cargarProductos();
        cargarDomicilios();
        cargarUsuarios();
    }

    private void cargarProductos() {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_PRODUCTOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Inventario producto= new Inventario();
                productos.add(producto.convertiraProducto(linea));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_USUARIOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Usuario usuario=new Usuario();
                usuarios.add(usuario.convertiraUsuario(linea));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarDomicilios() {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_DOMICILIOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Domicilio domicilio= new Domicilio();
                domicilios.add(domicilio.convertiraDomicilio(linea));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarProductos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_PRODUCTOS))) {
            for (Inventario producto : productos) {
                bw.write(producto.convertiraTexto());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void guardarUsuarios() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_USUARIOS))) {
            for (Usuario usuario : usuarios) {
                bw.write(usuario.convertiraTexto());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void guardarDomicilios() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_DOMICILIOS))) {
            for (Domicilio domicilio : domicilios) {
                bw.write(domicilio.convertiraTexto());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Métodos para agregar clientes y vendedores
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        guardarUsuarios();
    }

    public void agregarProducto(Inventario producto) {
        productos.add(producto);
        guardarProductos();
    }

    public void agregarDomicilio(Domicilio domicilio) {
        domicilios.add(domicilio);
        guardarDomicilios();
    }

    // Métodos de búsqueda
    public Inventario buscarProducto(String codigo) {
        for (Inventario producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    public void menuPrincipal() {
        SesionCliente compra = new SesionCliente();
        SesionVendedor vende = new SesionVendedor();
        boolean loop = true;

        do {
            System.out.println("Bienvenido a ElectroZone");
            System.out.println("Seleccione 1 para inicar sesion o 2 para registrarse.(Ingrese 0 para salir).");
            try {
                Scanner input = new Scanner(System.in);
                int opc = input.nextInt();
                switch (opc) {
                    case 0:
                        loop = false;
                        System.out.println("Que tenga un buen dia!!");
                        break;
                    case 1:
                        iniciarSesion(usuarios, compra, vende);
                        break;
                    case 2:
                        System.out.println("Seleccione 01 para Cliente o 02 para Vendedor");

                        try {
                            Scanner scanner = new Scanner(System.in);
                            int opcion = scanner.nextInt();
                            switch (opcion) {
                                case 1:
                                    registrarCliente();
                                    menuCliente();
                                    break;
                                case 2:
                                    registrarVendedor();
                                    menuVendedor();
                                    break;
                                default:
                                    System.out.println("Opcion no existente. Intente de nuevo");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Opcion no valida. Intente de nuevo");
                        }
                        break;

                    default:
                        System.out.println("Opcion no existente. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opcion no valida. Intente de nuevo.");

            }
        } while (loop);

    }

    public void registrarCliente() {
        Scanner scanner = new Scanner(System.in);
        int numeroCasa = 0;
        int codigoPostal = 0;
        long numeroCel = 0;
        long numeroTarjeta = 0;
        boolean valido = false;

        System.out.println("Registro de Cliente");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Clave: ");
        String clave = scanner.nextLine();

        System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
        String fechaNacimiento = scanner.nextLine();
        System.out.print("Sexo (H/M): ");
        String sexo = scanner.nextLine();
        System.out.println("-----Domicilio----- ");
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println("Número de Casa: ");
                numeroCasa = input.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Dato ingresado no valido intente de nuevo");

            }
        } while (!valido);

        System.out.println("Calle: ");
        String calle = scanner.nextLine();
        System.out.println("Colonia: ");
        String colonia = scanner.nextLine();
        System.out.println("País: ");
        String pais = scanner.nextLine();
        System.out.println("Estado: ");
        String estado = scanner.nextLine();
        System.out.println("Municipio: ");
        String municipio = scanner.nextLine();
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println("Código Postal: ");
                codigoPostal = input.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Datos no validos. Intente nuevamente.");
                valido = false;
            }
        } while (!valido);
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println("Número de Cel: ");
                numeroCel = input.nextLong();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Datos no validos. Intente nuevamente.");
                valido = false;
            }
        } while (!valido);
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println("Número de Tarjeta: ");
                numeroTarjeta = input.nextLong();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Datos no validos. Intente nuevamente.");
                valido = false;
            }
        } while (!valido);

        Domicilio domicilio = new Domicilio(numeroCasa, calle, colonia, codigoPostal, municipio, estado, pais);
        SesionCliente cliente = new SesionCliente(apellidos, domicilio, nombre, clave, fechaNacimiento, sexo, numeroCel, numeroTarjeta);
        Usuario usuario = (Usuario) cliente;
        agregarUsuario(usuario);
        agregarDomicilio(domicilio);
    }

    public void registrarVendedor() {
        Scanner scanner = new Scanner(System.in);
        long numeroCel = 0;
        long numeroTarjeta = 0;
        boolean valido = false;

        System.out.println("Registro de Vendedor");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Clave: ");
        String clave = scanner.nextLine();
        System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
        String fechaNacimiento = scanner.nextLine();
        System.out.print("Sexo (H/M): ");
        String sexo = scanner.nextLine();
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println("Número de Cel: ");
                numeroCel = input.nextLong();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Datos no validos. Intente nuevamente.");
                valido = false;
            }
        } while (!valido);
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println("Número de Tarjeta: ");
                numeroTarjeta = input.nextLong();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Datos no validos. Intente nuevamente.");
                valido = false;
            }
        } while (!valido);

        SesionVendedor vendedor = new SesionVendedor(nombre, clave, fechaNacimiento, sexo, numeroCel, numeroTarjeta);
        Usuario usuario = (Usuario) vendedor;
        agregarUsuario(usuario);
    }


 public void iniciarSesion(List<Usuario> usuarios, SesionCliente compra, SesionVendedor vende) {
        
        Scanner input = new Scanner(System.in);
        String nombre, clave;
        boolean existe = false;
        Usuario usu = null;
        int i;
        do {

            System.out.println("Ingrese su nombre de usuario: ");
            nombre = input.nextLine();
            System.out.println("Clave:  ");
            clave = input.nextLine();
            for (i = 0; i < usuarios.size(); i++) {
                existe = validarUsuario(usuarios, nombre, clave, i);
                if (existe == true) {
                    usu = usuarios.get(i);
                    break;
                }
            }

        } while (!existe);
        System.out.print("Bienvenido");
        if (usu instanceof SesionVendedor) {
            System.out.println(" vendedor.");
            menuVendedor();
        } else {
            System.out.println(" comprador.");
            menuCliente();
        }
    }
    public boolean validarUsuario(List<Usuario> usuarios, String nom, String clave, int i) {
        if ((nom.equals(usuarios.get(i).getNombre()))
                && clave.equals(usuarios.get(i).getClave())) {
            return true;
        } else {
            return false;
        }

    }

    public void menuCliente() {
        Scanner scanner = new Scanner(System.in);
        Carrito carrito = new Carrito();
        boolean valido = false;
        boolean loop = true;
        int opcion = 0;
        int unidades = 0;
        double total = 0;

        while (loop) {
            System.out.println("Menú Cliente:");
            System.out.println("1. Comprar Producto");
            System.out.println("2. Agregar al Carrito");
            System.out.println("3. Seleccionar Unidades");
            System.out.println("4. Pagar carrito");
            System.out.println("5. Borrar articulo del carrito");
            System.out.println("6. Salir");
            do {
                try {
                    Scanner input = new Scanner(System.in);
                    opcion = input.nextInt();
                    valido = true;

                } catch (InputMismatchException e) {
                    System.out.println("Dato no valido. Intente de nuevo.");
                    valido = false;
                }
            } while (!valido);

            switch (opcion) {
                case 1:
                    System.out.println("-----CATALOGO-----");
                    for (int i = 0; i < productos.size(); i++) {
                        System.out.println(productos.get(i));
                        System.out.println("---------------");
                    }
                    System.out.print("Ingrese el código del producto: ");
                    String codigo = scanner.nextLine();
                    Inventario producto = buscarProducto(codigo);
                    if (producto != null) {
                        System.out.println("Producto seleccionado: " + producto.getNombre().toUpperCase());
                        System.out.println("Precio: $" + producto.getPrecio());
                        System.out.print("Ingrese la cantidad de unidades: ");
                        do {
                            try {
                                Scanner input = new Scanner(System.in);
                                unidades = input.nextInt();
                                if (unidades < 1) {
                                    throw new InputMismatchException();
                                }
                                valido = true;

                            } catch (InputMismatchException e) {
                                System.out.println("Datos no validos. Intente nuevamente.");
                                valido = false;
                            }

                        } while (!valido);
                        if (unidades <= producto.getUnidades()) {
                            for (int i = 0; i < unidades; i++) {
                                producto.setUnidades(producto.getUnidades() - 1);
                                total += producto.getPrecio();
                            }
                            guardarProductos();
                            System.out.println("Unidades por comprar: " + unidades);
                            System.out.println("Total: $" + total);
                            System.out.println("\n Gracias por su compra. \n");
                        } else {
                            System.out.println("\n Lo sentimos!! Solo hay en existencia " + producto.getUnidades() + " unidades del producto: "
                                    + producto.getNombre().toUpperCase() + "\n");
                        }

                    } else {
                        System.out.println("\n Producto no encontrado \n");
                    }
                    break;
                case 2:
                    System.out.println("-----CATALOGO-----");
                    for (int i = 0; i < productos.size(); i++) {
                        System.out.println(productos.get(i));
                        System.out.println("---------------");
                    }
                    System.out.print("Ingrese el código del producto: ");
                    codigo = scanner.nextLine();
                    producto = buscarProducto(codigo);
                    if (producto != null) {
                        if (producto.getUnidades() > 0) {
                            carrito.agregarInventario(producto);
                            producto.setUnidades(producto.getUnidades() - 1);
                            guardarProductos();
                            System.out.println("\n Producto agregado al carrito: " + producto.getNombre().toUpperCase() + "\n");
                        } else {
                            System.out.println("\n Lo sentimos!! No hay inventario del producto: " + producto.getNombre().toUpperCase() + "\n");
                        }

                    } else {
                        System.out.println("\n Producto no encontrado \n");
                    }
                    break;
                case 3:
                    System.out.println("-----CATALOGO-----");
                    for (int i = 0; i < productos.size(); i++) {
                        System.out.println(productos.get(i));
                        System.out.println("---------------");
                    }
                    System.out.print("Ingrese el código del producto: ");
                    codigo = scanner.nextLine();
                    producto = buscarProducto(codigo);
                    if (producto != null) {
                        System.out.println("Producto seleccionado: " + producto.getNombre().toUpperCase());
                        System.out.print("Ingrese la cantidad de unidades: ");
                        do {
                            try {
                                Scanner input = new Scanner(System.in);
                                unidades = input.nextInt();
                                if (unidades < 1) {
                                    throw new InputMismatchException();
                                }
                                valido = true;

                            } catch (InputMismatchException e) {
                                System.out.println("Datos no validos. Intente nuevamente.");
                                valido = false;
                            }

                        } while (!valido);
                        if (unidades <= producto.getUnidades()) {
                            for (int i = 0; i < unidades; i++) {
                                carrito.agregarInventario(producto);
                                producto.setUnidades(producto.getUnidades() - 1);
                            }
                            guardarProductos();
                            System.out.println("\n Unidades agregadas al carrito: " + unidades + "\n");
                        } else {
                            System.out.println("\n Lo sentimos!! Solo hay en existencia " + producto.getUnidades() + " unidades del producto: "
                                    + producto.getNombre().toUpperCase() + "\n");
                        }
                    } else {
                        System.out.println("\n Producto no encontrado \n");
                    }
                    break;
                case 4:
                    carrito.getInventario();
                    System.out.println("Seguro de comprar el carrito? ");
                    System.out.println("1. SI    2. NO");
                    int opc;
                    do {
                        try {
                            Scanner input = new Scanner(System.in);
                            opc = input.nextInt();
                            valido = true;
                            switch (opc) {
                                case 1:
                                    total = carrito.calcularTotal();
                                    System.out.println("Total a pagar: $" + total);
                                    carrito = new Carrito(); // Vaciar el carrito después de pagar
                                    System.out.println("\n Pago realizado. Carrito vacío. \n");
                                    break;
                                case 2:
                                    System.out.println("\n Operacion cancelada. \n ");
                                    break;
                                default:
                                    System.out.println("Opción no válida. Elija una opcion.");
                                    valido = false;
                                    break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Datos no validos. Intente nuevamente.");
                            valido = false;
                        }
                    } while (!valido);

                    break;
                case 5:
                    carrito.getInventario();
                    System.out.print("Ingrese el código del producto: ");
                    codigo = scanner.nextLine();
                    producto = buscarProducto(codigo);
                    for (int i = 0; i < carrito.getSize(); i++) {
                        if (producto == carrito.getProducto(i)) {
                            System.out.println("Seguro de querer borrar el articulo " + producto.getNombre().toUpperCase() + "?");
                            System.out.println("1. SI    2. NO");
                            do {
                                try {
                                    Scanner input = new Scanner(System.in);
                                    opc = input.nextInt();
                                    valido = true;
                                    switch (opc) {
                                        case 1:

                                            carrito.quitarInventario(producto);
                                            producto.setUnidades(producto.getUnidades() + 1);
                                            guardarProductos();
                                            System.out.println("\n Articulo removido. \n");
                                            break;
                                        case 2:
                                            System.out.println("\n Operacion cancelada. \n ");
                                            break;
                                        default:
                                            System.out.println("Opción no válida. Elija una opcion.");
                                            valido = false;
                                            break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Datos no validos. Intente nuevamente.");
                                    valido = false;
                                }
                            } while (!valido);
                            break;
                        }
                    }

                    break;
                case 6:
                    loop = false; // Salir del menú
                    break;
                default:
                    System.out.println("Opción no válida. Elija una opcion.");
                    break;
            }
        }
    }

    public void menuVendedor() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        boolean valido = false;
        boolean loop = true;
        int unidades = 0;
        double precio = 0;
        double nuevoPrecio = 0;
        int nuevasUnidades = 0;

        while (loop) {
            System.out.println("Menú Vendedor: Seleccione una opcion.");
            System.out.println("1. Agregar Producto Nuevo");
            System.out.println("2. Editar Producto");
            System.out.println("3. Eliminar Producto");
            System.out.println("4. Modificar Precio");
            System.out.println("5. Agregar unidades");
            System.out.println("6. Salir");
            do {
                try {
                    Scanner input = new Scanner(System.in);
                    opcion = input.nextInt();
                    valido = true;

                } catch (InputMismatchException e) {
                    System.out.println("Dato no valido. Intente de nuevo.");
                    valido = false;
                }
            } while (!valido);

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Descripción del producto: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Código del producto: ");
                    String codigo = scanner.nextLine();
                    do {
                        try {
                            System.out.print("Unidades: ");
                            unidades = scanner.nextInt();
                            if (unidades < 1) {
                                throw new InputMismatchException("Valor ingresado no valido.");
                            }
                            valido = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Datos no validos. Intente nuevamente.");
                            valido = false;
                        }

                    } while (!valido);

                    System.out.print("Precio: ");
                    do {
                        try {
                            Scanner input = new Scanner(System.in);
                            precio = input.nextDouble();
                            if (precio <= 0) {
                                throw new InputMismatchException("Valor ingresado no valido.");
                            }
                            valido = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Datos no validos. Intente nuevamente.");
                            valido = false;
                        }
                    } while (!valido);

                    Inventario producto = new Inventario(nombre, descripcion, unidades, precio, codigo);
                    agregarProducto(producto);
                    System.out.println("\n Producto agregado: " + nombre);
                    System.out.println(producto.toString() + "\n");
                    break;
                case 2:
                    System.out.println("-----CATALOGO-----");
                    for (int i = 0; i < productos.size(); i++) {
                        System.out.println(productos.get(i));
                        System.out.println("---------------");
                    }
                    System.out.print("Ingrese el código del producto a editar: ");
                    codigo = scanner.nextLine();
                    producto = buscarProducto(codigo);
                    if (producto != null) {
                        System.out.println(producto.toString());
                        System.out.print("Nuevo nombre: ");
                        nombre = scanner.nextLine();
                        System.out.print("Nueva descripción: ");
                        descripcion = scanner.nextLine();

                        do {
                            try {
                                Scanner input = new Scanner(System.in);
                                System.out.print("Nuevas unidades: ");
                                unidades = input.nextInt();
                                if (unidades < 1) {
                                    throw new InputMismatchException("Valor ingresado no valido.");
                                }
                                valido = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Datos no validos. Intente nuevamente.");
                                valido = false;
                            }
                        } while (!valido);
                        do {
                            try {
                                Scanner input = new Scanner(System.in);
                                System.out.print("Nuevo precio: ");
                                precio = input.nextDouble();
                                if (precio <= 0) {
                                    throw new InputMismatchException("Valor ingresado no valido.");
                                }
                                valido = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Datos no validos. Intente nuevamente.");
                                valido = false;
                            }
                        } while (!valido);

                        producto.setNombre(nombre);
                        producto.setDescripcion(descripcion);
                        producto.setUnidades(unidades);
                        producto.setPrecio(precio);
                        guardarProductos();
                        System.out.println("\n Producto editado \n");
                        System.out.println(producto.toString() + "\n");
                    } else {
                        System.out.println("\n Producto no encontrado \n");
                    }
                    break;
                case 3:
                    System.out.println("-----CATALOGO-----");
                    for (int i = 0; i < productos.size(); i++) {
                        System.out.println(productos.get(i));
                        System.out.println("---------------");
                    }
                    System.out.print("Ingrese el código del producto a eliminar: ");
                    codigo = scanner.nextLine();
                    producto = buscarProducto(codigo);
                    if (producto != null) {
                        productos.remove(producto);
                        guardarProductos();
                        System.out.println("\n Producto: " + producto.getNombre().toUpperCase() + " eliminado \n");
                    } else {
                        System.out.println("\n Producto no encontrado \n");
                    }
                    break;
                case 4:
                    System.out.println("-----CATALOGO-----");
                    for (int i = 0; i < productos.size(); i++) {
                        System.out.println(productos.get(i));
                        System.out.println("---------------");
                    }
                    System.out.print("Ingrese el código del producto a modificar: ");
                    codigo = scanner.nextLine();
                    producto = buscarProducto(codigo);
                    if (producto != null) {
                        System.out.println("Nombre de Producto: " + producto.getNombre().toUpperCase());
                        System.out.println("Precio: $" + producto.getPrecio());
                        do {
                            try {
                                Scanner input = new Scanner(System.in);
                                System.out.print("Nuevo precio: ");
                                nuevoPrecio = input.nextDouble();
                                if (nuevoPrecio <= 0) {
                                    throw new InputMismatchException();
                                }
                                valido = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Datos no validos. Intente nuevamente.");
                                valido = false;
                            }
                        } while (!valido);

                        producto.setPrecio(nuevoPrecio);
                        guardarProductos();
                        System.out.println("\n Precio modificado");
                        System.out.println("Nombre de producto: " + producto.getNombre().toUpperCase());
                        System.out.println("Precio: $" + producto.getPrecio() + "\n");
                    } else {
                        System.out.println("\n Producto no encontrado \n");
                    }
                    break;
                case 5:
                    System.out.println("-----CATALOGO-----");
                    for (int i = 0; i < productos.size(); i++) {
                        System.out.println(productos.get(i));
                        System.out.println("---------------");
                    }
                    System.out.print("Ingrese el código del producto para agregar unidades: ");
                    codigo = scanner.nextLine();
                    producto = buscarProducto(codigo);
                    if (producto != null) {
                        System.out.println("Nombre del producto: " + producto.getNombre().toUpperCase());
                        System.out.println("Unidades disponibles: " + producto.getUnidades());

                        do {
                            try {
                                Scanner input = new Scanner(System.in);
                                System.out.print("Unidades por agregar: ");
                                nuevasUnidades = input.nextInt();
                                if (nuevasUnidades < 1) {
                                    throw new InputMismatchException("Valor ingresado no valido.");
                                }
                                valido = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Datos no validos. Intente de nuevo.");
                                valido = false;
                            }
                        } while (!valido);

                        producto.setUnidades(producto.getUnidades() + nuevasUnidades);
                        guardarProductos();
                        System.out.println("\n Inventario agregado");
                        System.out.println("Nombre del producto: " + producto.getNombre().toUpperCase());
                        System.out.println("Unidades disponibles: " + producto.getUnidades() + "\n");
                    } else {
                        System.out.println("\n Producto no encontrado \n");
                    }
                    break;
                case 6:
                    loop = false; // Salir del menú
                    break;
                default:
                    System.out.println("Opción no válida. Elija una opcion.");
                    break;
            }
        }
    }

}
