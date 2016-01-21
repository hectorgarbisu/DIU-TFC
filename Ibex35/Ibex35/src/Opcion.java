
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
    public Opcion(String str){
        String[] split = str.split("><");
        for (String split1 : split) {
        }
        this.Tipo = split[0];
        this.Hora =  split[1];
        this.Volumen = split[2];
        this.Ultimo = split[3];
        this.Compra_Vol = split[4];
        this.Compra_Precio = split[5];
        this.Venta_Vol = split[6];
        this.Venta_Precio = split[7];
        this.Vencimiento = split[8];
        this.Ejercicio = split[9];
        this.Vencimiento = split[10];
        this.vencimiento = new StringDate(Vencimiento);
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
    public String toString(){
        String str = "";
        str += this.Tipo;
        str += "><"+this.Hora;
        str += "><"+this.Volumen;
        str += "><"+this.Ultimo;
        str += "><"+this.Compra_Vol;
        str += "><"+this.Compra_Precio;
        str += "><"+this.Venta_Vol;
        str += "><"+this.Venta_Precio;
        str += "><"+this.Vencimiento;
        str += "><"+this.Ejercicio;
        str += "><"+this.vencimiento;
        return str;
    }
}



