
public class Opcion {
    public String Tipo;
    public String Hora;
    public String Volumen;
    public String Ultimo;
    public String Compra_Vol;
    public String Compra_Precio;
    public String Venta_Vol;
    public String Venta_Precio;
    public String Vencimiento;
    public String Ejercicio;
    public StringDate vencimiento;
    
    public Opcion(Opcion opt){ //copy constructor      
        this.Tipo = opt.Tipo;
        this.Hora = opt.Hora;
        this.Volumen = opt.Volumen;
        this.Ultimo = opt.Ultimo;
        this.Compra_Vol = opt.Compra_Vol;
        this.Compra_Precio = opt.Compra_Precio;
        this.Venta_Vol = opt.Venta_Vol;
        this.Venta_Precio = opt.Venta_Precio;
        this.Vencimiento = opt.Vencimiento;
        this.Ejercicio = opt.Ejercicio;
        this.vencimiento = opt.vencimiento;
    }
    public Opcion(){
    }
    public boolean isEqual(Opcion opt){
        if(opt.Tipo.compareTo(Tipo)!=0)return false;
        if(opt.Hora.compareTo(Hora)!=0)return false;
        if(opt.Volumen.compareTo(Volumen)!=0)return false;
        if(opt.Ultimo.compareTo(Ultimo)!=0)return false;
        if(opt.Compra_Vol.compareTo(Compra_Vol)!=0)return false;
        if(opt.Compra_Precio.compareTo(Compra_Precio)!=0)return false;
        if(opt.Venta_Vol.compareTo(Venta_Vol)!=0)return false;
        if(opt.Venta_Precio.compareTo(Venta_Precio)!=0)return false;
        if(opt.Vencimiento.compareTo(Vencimiento)!=0)return false;
        if(opt.Ejercicio.compareTo(Ejercicio)!=0)return false;
        if(opt.vencimiento.compareTo(vencimiento)!=0)return false;
        return true;
    }
}



