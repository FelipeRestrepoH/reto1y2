/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

import javax.swing.JOptionPane;


/**
 *
 * @author EQUIPO
 */
public class Calculadora {

    public Calculadora() {
        
    }
    
    //método para inicial el programa
    public void IniciarPrograma(){
        
        String menu = "Seleccione una opción: \n \n"
                + "1. Realizar una operación \n"
                + "2. Salir \n \n";
        int opcionMenu=0;
        do{
            opcionMenu = Integer.parseInt(JOptionPane.showInputDialog(menu));
            if (opcionMenu == 1){
                MenuCalculadora();
            }
            else if (opcionMenu == 2 ){
                JOptionPane.showMessageDialog(null,"La aplicación se cerrará" );
                break;
            }
            else {
                JOptionPane.showMessageDialog(null, "La opción " + opcionMenu + " no es una opción válida");
            }
            
        }while (opcionMenu > 2);
    }
    
    //método que muestra las opciones que tiene la calculadora
    public void MenuCalculadora(){
        String menu = "Seleccione una operación: \n \n"
                + "1. Suma \n"
                + "2. Resta \n"
                + "3. Multiplicación \n"
                + "4. División \n"
                + "5. Potencia \n"
                + "6. Raiz cuadrada \n"
                + "7. Salir \n \n";
        
        int opcionMenu=0;
        do{ 
            opcionMenu = Integer.parseInt(JOptionPane.showInputDialog(menu));
            if (opcionMenu > 0 && opcionMenu < 7){
                             
                switch (opcionMenu){
                    case 1 :
                        JOptionPane.showMessageDialog(null, "El resultado de la suma es: " + Suma());
                        break;
                    case 2 :
                        JOptionPane.showMessageDialog(null, "El resultado de la resta es: " + Resta());
                        break;
                    case 3 :
                        JOptionPane.showMessageDialog(null, "El resultado de la multiplicación es: " + Multiplicacion());
                        break;
                    case 4 :
                        JOptionPane.showMessageDialog(null, "El resultado de la devisión es: " + Division());
                        break;
                    case 5 :
                        JOptionPane.showMessageDialog(null, "El resultado de la potencia es: " + Potencia());
                        break;  
                    case 6 :
                        JOptionPane.showMessageDialog(null, "El resultado de la raiz cuadrada es: " + RaizCuadrada());
                        break;
      
                    //default: 
                        
                }      
            }else if(opcionMenu ==7)JOptionPane.showMessageDialog(null,"La calculadora se cerrará" );
            else{
                JOptionPane.showMessageDialog(null, "La opción " + opcionMenu + " no es una opción válida");
            }
            
        }while (opcionMenu != 7);
        
        
    }  
       
    public boolean EsNumero(String num1){
        try{
           double numero1 = Double.parseDouble(num1);
           return true;
        }catch(Exception e){
            return false;
        } 
    }
    
    public double PedirNumeros(String numero){
        boolean esNumero = false;
        String stringNumero1;
        do{
            stringNumero1 = JOptionPane.showInputDialog("Ingrese " + numero);
            esNumero = EsNumero(stringNumero1);
            if(!esNumero) JOptionPane.showMessageDialog(null, "El valor ingresado no es un número, vuelva e ingrise el valor");   
        }while (!esNumero);
        double numero1 = Double.parseDouble(stringNumero1);
        return numero1;
    }
    
    public double RedondearADosDecimales (double numero){
        double resultado = Math.round(numero*100);
        return resultado/100;
    }
    
    public double Suma (){
        double resultado, numero1=0, numero2=0;
        numero1 = PedirNumeros("el primer primer número: ");
        numero2 = PedirNumeros("el segundo número: ");;
        resultado = numero1 + numero2;
        return RedondearADosDecimales(resultado);
    }
    
    public double Resta (){
        double resultado=0, numero1 =0, numero2 =0;
        numero1 = PedirNumeros("el primer número: ");
        numero2 = PedirNumeros("el segundo número: ");
        resultado = numero1 - numero2;
        return RedondearADosDecimales(resultado);
    }
    
    public double Multiplicacion (){
        double resultado=0, numero1=0, numero2=0;
        numero1 = PedirNumeros("el primer número: ");
        numero2 = PedirNumeros("el segundo número: ");
        resultado = numero1 * numero2;
        return RedondearADosDecimales(resultado);
    }
    
    public double Division (){
        double resultado=0, numero1=0, numero2=0;
        numero1 = PedirNumeros("el dividendo: ");
        do{
            numero2 = PedirNumeros("el divisor: ");
            if(numero2 == 0){
            JOptionPane.showMessageDialog(null,"No es posible realizar la divisón porque el divisor es igual a cero ");
            }
        }while (numero2 == 0);
        
        resultado = numero1 / numero2;
        return RedondearADosDecimales(resultado);
    }
    
    public double Potencia (){
        double resultado=0, numero1 =0, numero2=0;
        numero1 = PedirNumeros("la base: ");
        numero2 = PedirNumeros("el exponente: ");
        resultado = Math.pow(numero1, numero2);
        return RedondearADosDecimales(resultado);
    }
    
    public double RaizCuadrada (){
        double resultado=0, numero1=0;
        do{
            numero1 = PedirNumeros("el radicando: ");
            if(numero1 < 0){
                JOptionPane.showMessageDialog(null, "Ingrese un número positivo");
            }
        }while(numero1<0);
        resultado = Math.sqrt(numero1);
        return RedondearADosDecimales(resultado);
    }  
}
