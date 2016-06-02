import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Paulina Sadowska on 02.06.2016.
 */
public class Printer
{
    private KalkulatorPodatkowy kalkulatorPodatkowy;
    private Formatter f = new Formatter();

    public Printer(KalkulatorPodatkowy kalkulatorPodatkowy){
        this.kalkulatorPodatkowy = kalkulatorPodatkowy;
    }

    public void print()
    {
        /*Method[] methods = this.getClass().getDeclaredMethods(); // zla kolejnosc :(
        for (Method method : methods)
        {
            if(!method.getReturnType().equals(Void.TYPE)){
                System.out.println(method.invoke(this, null));
            }
        }*/
        System.out.println(typUmowy());
        System.out.println(podstawaWymiaruSkladek());
        System.out.println(skladkaEmerytalna());
        System.out.println(skladkaRentowa());
        System.out.println(skladkaChorobowa());
        System.out.println(podstawaSkladkiZdrowotnej());
        System.out.println(skladkaZdrowotna());
        System.out.println(kosztyUzyskania());
        System.out.println(podstawaOpodatkowania());
        System.out.println(zaliczkaNaPodatekDochodowy());
        System.out.println(kwotaZmiejszajacaPodatek());
        System.out.println(podatekPotracony());
        System.out.println(zaliczkaDoUrzeduSkarbowego());
        System.out.println(wynagrodzenie());

    }

    private String typUmowy(){
        if(kalkulatorPodatkowy.getTypUmowy() == TypUmowy.umowaOPrace){
            return "UMOWA O PRACĘ";
        }
        else if(kalkulatorPodatkowy.getTypUmowy() == TypUmowy.umowaZlecenie){
            return "UMOWA ZLECENIE";
        }
        return null;
    }

    private String podstawaWymiaruSkladek(){
        return "Podstawa wymiaru składek " + f.format(kalkulatorPodatkowy.getPodstawaWymiaruSkladek());
    }

    private String skladkaEmerytalna(){
        return "Składka na ubezpieczenie emerytalne " + f.format(kalkulatorPodatkowy.getSkladkaEmerytalna());
    }

    public String skladkaRentowa(){
        return "Składka na ubezpieczenie rentowe " + f.format(kalkulatorPodatkowy.getSkladkaRentowa());
    }

    private String skladkaChorobowa(){
        return "Składka na ubezpieczenie chorobowe " + f.format(kalkulatorPodatkowy.getSkladkaChorobowa());
    }

    private String podstawaSkladkiZdrowotnej(){
        return "Podstawa wymiaru składki na ubezpieczenie zdrowotne: " + f.format(kalkulatorPodatkowy.getPodstawaSkladkiZdrowotnej());
    }

    private String skladkaZdrowotna(){
        return "Składka na ubezpieczenie zdrowotne: 9% = " + f.format(kalkulatorPodatkowy.getSkladkaZdrowotna_9()) +
        " 7,75% = " + f.format(kalkulatorPodatkowy.getSkladkaZdrowotna_7_75());
    }

    private String kosztyUzyskania(){
        return "Koszty uzyskania przychodu w stałej wysokości " + f.format(kalkulatorPodatkowy.getKosztyUzyskania());
    }

    private String podstawaOpodatkowania(){
        return "Podstawa opodatkowania " + f.format(kalkulatorPodatkowy.getPodstawaOpodatkowania()) +
                " zaokrąglona " + f.format(kalkulatorPodatkowy.getPodstawaOpodatkowania_zaokraglone());
    }

    private String zaliczkaNaPodatekDochodowy(){
        return "Zaliczka na podatek dochodowy 18 % = " + f.format(kalkulatorPodatkowy.getZaliczkaNaPodatekDochodowy());
    }

    private String kwotaZmiejszajacaPodatek(){
        return "Kwota wolna od podatku = " + f.format(kalkulatorPodatkowy.getKwotaZmiejszajacaPodatek());
    }

    private String podatekPotracony(){
        return "Podatek potrącony = " + f.format(kalkulatorPodatkowy.getPodatekPotracony());
    }

    private String zaliczkaDoUrzeduSkarbowego(){
        return "Zaliczka do urzędu skarbowego = " + f.format(kalkulatorPodatkowy.getZaliczkaDoUrzeduSkarbowego())
                + " po zaokrągleniu = " + f.format(kalkulatorPodatkowy.getZaliczkaDoUrzeduSkarbowego_zaokraglone());
    }

    private String wynagrodzenie(){
        return "Pracownik otrzyma wynagrodzenie netto w wysokości = " + f.format(kalkulatorPodatkowy.getWynagrodzenie());
    }

}
