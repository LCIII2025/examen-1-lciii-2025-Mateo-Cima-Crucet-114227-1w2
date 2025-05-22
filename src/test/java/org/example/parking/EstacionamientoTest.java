package org.example.parking;

import org.junit.Test;

import static junit.framework.Assert.*;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        //TODO test
        //teniendo
        Estacionamiento estacionamiento = new Estacionamiento();
        Cliente cliente = new Cliente("4","as");
        String patente = "Patente";
        Vehiculo vehiculo = new Vehiculo(patente,"A",Vehiculo.Tipo.AUTO);
        Ticket ticket = new Ticket(cliente,vehiculo);
        estacionamiento.ingresarVehiculo(cliente.getDni(),cliente.getNombre(),vehiculo);
        //cuando
        Ticket retirado = estacionamiento.retirarVehiculo(patente);
        //entonces
        assertEquals(retirado.getCliente().getNombre(),ticket.getCliente().getNombre());
        assertEquals(retirado.getVehiculo(),ticket.getVehiculo());
        assertNotNull(retirado.getHoraSalida());
    }

    @Test
    public void testCalcularPrecio() throws Exception {
        // TODO test
        //teniendo
        Cliente cliente = new Cliente("4","as");
        Vehiculo vehiculo = new Vehiculo("as","A",Vehiculo.Tipo.AUTO);
        Ticket ticket = new Ticket(cliente,vehiculo);
        ticket.marcarSalida();
        //cuando
        double precio = ticket.calcularPrecio();
        //entonces
        assertNotNull(precio);
        assertTrue(precio >= 100);

    }

}