package Cuentas;

public class Cuenta {
    protected float saldo;
    protected int numeroConsignaciones = 0;
    protected int numeroRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0;

    public Cuenta(float saldo, float tasaAnual){
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getNumeroConsignaciones() {
        return numeroConsignaciones;
    }

    public void setNumeroConsignaciones(int numeroConsignaciones) {
        this.numeroConsignaciones = numeroConsignaciones;
    }

    public int getNumeroRetiros() {
        return numeroRetiros;
    }

    public void setNumeroRetiros(int numeroRetiros) {
        this.numeroRetiros = numeroRetiros;
    }

    public float getTasaAnual() {
        return tasaAnual;
    }

    public void setTasaAnual(float tasaAnual) {
        this.tasaAnual = tasaAnual;
    }

    public float getComisionMensual() {
        return comisionMensual;
    }

    public void setComisionMensual(float comisionMensual) {
        this.comisionMensual = comisionMensual;
    }

    public void consignar(float cantidad){
        saldo+=cantidad;
        numeroConsignaciones++;
    }

    public void retirar(float cantidad){
        if(saldo>=cantidad){
            saldo-=cantidad;
            numeroRetiros++;
            System.out.println();
        }
        else{
            System.out.println("Saldo insuficiente");
        }
    }

    public void calcularInteres(){
        saldo *= tasaAnual /100 / 12;
    }

    public void extractoMensual(){
        saldo -= comisionMensual;
        calcularInteres();
    }

    @Override
    public String toString() {
        String s = """
               La cuenta tiene un saldo de %.2f.
               Numero de consignaciones: %d
               Numero de retiros: %d
               Tasa Anual: %.2f%%
               Comision Mensual: %.2f
               """.formatted(saldo, numeroConsignaciones, numeroRetiros, tasaAnual,comisionMensual);
        return s;
    }
}
