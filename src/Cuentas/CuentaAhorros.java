package Cuentas;

public class CuentaAhorros extends Cuenta {
    protected boolean activa;

    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        if(saldo > 10000){
            activa = true;
        };
    }

    public boolean getActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    @Override
    public void consignar(float cantidad) {
        if(activa){
            super.consignar(cantidad);
            activarODesactivar();
        }
    }

    @Override
    public void retirar(float cantidad) {
        if(activa){
            super.retirar(cantidad);
            activarODesactivar();
        }

    }

    @Override
    public void extractoMensual(){
        if(super.numeroRetiros>4){
            super.extractoMensual();
            this.comisionMensual += 10000;
        }
        activarODesactivar();
    }

    private void activarODesactivar() {
        setActiva(saldo>10000);
    }

    @Override
    public String toString() {
        int transacciones = numeroConsignaciones + numeroRetiros;
        String s = """
                El saldo de la cuenta de ahorros es %.2f
                La comision mensual de la cuenta es %.2f
                El numero de transacciones realizadas es: %d
                """.formatted(saldo, comisionMensual, transacciones);
        return s;
    }
}
