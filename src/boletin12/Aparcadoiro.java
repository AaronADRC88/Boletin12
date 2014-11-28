
package boletin12;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JOptionPane;

public class Aparcadoiro {
static int numC = 0;
private String matr;
private float prezo;
private float tempo;
private long t_saida, t_entrada;
   
    
    public int getNumeroCoches() {
        return numC;
    }

    
    public void setNumeroCoches(int numC) {
        Aparcadoiro.numC = numC;
    }

   
    public String getMatricula() {
        return matr;
    }

    
    public void setMatricula(String matr) {
        this.matr = matr;
    }
     
    

public boolean plazas() {
if (numC < 5) {
entraCoche();
return true;
} else {

return false;
}
}
public long entraCoche() {
    if (numC < 5) {
    JOptionPane.showMessageDialog(null, "Hai Prazas: "+(5-numC));    
t_entrada = System.currentTimeMillis();
numC++;
matr = JOptionPane.showInputDialog("Introducir Matrícula");
} 

else {JOptionPane.showMessageDialog(null, "Parking Completo");
        }
    return t_entrada;
}
public long saeCoche() {
t_saida = System.currentTimeMillis();
numC--;
return t_saida;
}
public float tiempo() {
tempo = (float) (t_saida - t_entrada) / 1000;
return tempo;
}
public float prezo() {
prezo = (((tempo / 3) - 1) * 0.2f) + 0.4f;
return prezo;
}
public BigDecimal redondearPrezo(){
    BigDecimal big=new BigDecimal(prezo);
    big= big.setScale(2, RoundingMode.HALF_UP);
    return big;
    
}
        
public void factura() {
saeCoche();
this.tiempo();
this.prezo();
float pagado = Float.parseFloat(JOptionPane.showInputDialog(redondearPrezo()+"Introducir importe"));
if (pagado<prezo){
    do{
        pagado = Float.parseFloat(JOptionPane.showInputDialog(redondearPrezo()+"PAGA HOSTIA!!!!!!"));
        
    }while(pagado<prezo);
float devol = pagado - prezo;
BigDecimal big=new BigDecimal(devol);
big=big.setScale(2, RoundingMode.HALF_UP);
JOptionPane.showMessageDialog(null, "FACTURA\n MATRICULA COCHE: " + matr + "\nTEMPO: " + tempo+" segundos" + "\nPREZO: " + redondearPrezo() + "€" + "\nCARTOS RECIBIDOS: " + pagado + "€" + "\nCARTOS DEVOLTOS: " + big + "€");
    
}
            
}
}
