package Cuentas;

public class CuentaCorriente extends Cuenta{
    protected float sobregiro = 0;

    public float getSobregiro() {
        return sobregiro;
    }

    public void setSobregiro(float sobregiro) {
        this.sobregiro = sobregiro;
    }

    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
    }

    @Override
    public void retirar(float saldo) {
        if(this.saldo < saldo){
            sobregiro = (saldo - this.saldo);
            this.saldo = 0;
        }else{
            this.saldo -= saldo;
        }
    }

    @Override
    public void consignar(float saldo) {
        if(sobregiro>0){
            if(sobregiro>=saldo){
                sobregiro -= saldo;
            }
            else{
                float diferencia = saldo-sobregiro;
                sobregiro = 0;
                this.saldo += diferencia;
            }
        }
        else{
            super.consignar(saldo);
        }

        super.consignar(saldo);
    }

    @Override
    public String toString(){
        int transaccionesRealizadas = numeroConsignaciones + numeroRetiros;
        String s = """
                Saldo de la cuenta corriente: %.2f.
                Comisión mensual: %.2f 
                Número de transacciones realizadas: %d
                """.formatted(saldo, comisionMensual, transaccionesRealizadas);
        return s;
    }
}
