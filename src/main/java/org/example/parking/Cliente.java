package org.example.parking;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cliente {
    private final String dni;
    private final String nombre;
    private final List<Vehiculo> vehiculos;

    public Cliente(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        // TODO implementar la carga de vehiculos en el cliente
        Vehiculo v = buscarVehiculoPorPatente(vehiculo.getPatente());
        if (v == null) {
            vehiculos.add(vehiculo);
        }else
            throw new RuntimeException("Vehiculo con patente repetida");

    }

    public Vehiculo buscarVehiculoPorPatente(String patente) {
        // TODO implementar la busqueda de un vehiculo segun su patente
        //boolean encontrado = false;
        Vehiculo vehiculo = null;
        for (Vehiculo vehiculos : vehiculos) {
            if (vehiculos.getPatente().equals(patente)) {
                vehiculo=vehiculos;
            }
        }

        return vehiculo;
    }
}