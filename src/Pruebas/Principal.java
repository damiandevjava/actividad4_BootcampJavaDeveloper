package Pruebas;

import Cuentas.Cuenta;
import Cuentas.CuentaAhorros;
import Cuentas.CuentaCorriente;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Datos cuenta 1");

        Cuenta c1 = new Cuenta(150000, 40);
        System.out.println(c1);
        System.out.println("Fin datos cuenta 1");

        System.out.println("Datos cuenta 2");

        CuentaAhorros c2 = new CuentaAhorros(500000, 80);
        System.out.println(c2);
        System.out.println(c2.getActiva());
        c2.retirar(495000);
        System.out.println(c2.getSaldo());
        System.out.println(c2.getActiva());

        System.out.println("Fin datos cuenta 2");
        System.out.println();

        System.out.println("Datos cuenta 3");
        System.out.println();

        CuentaCorriente c3 = new CuentaCorriente(15000, 50);
        System.out.println(c3);
        System.out.println();
        c3.consignar(1000);
        System.out.println(c3);
        c3.retirar(19000);
        System.out.println(c3);
        System.out.println("Sobregiros: " + c3.getSobregiro());
    }
}
