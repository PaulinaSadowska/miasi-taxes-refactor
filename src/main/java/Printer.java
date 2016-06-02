/**
 * Created by Paulina Sadowska on 02.06.2016.
 */
public class Printer
{

    private KalkulatorPodatkowy kalkulatorPodatkowy;

    public Printer(KalkulatorPodatkowy kalkulatorPodatkowy){
        this.kalkulatorPodatkowy = kalkulatorPodatkowy;
    }

    public void print(){
        System.out.println(typUmowy());
        System.out.println(podstawaWymiaruSkladek());
    }

    public String typUmowy(){
        if(kalkulatorPodatkowy.getTypUmowy() == TypUmowy.umowaOPrace){
            return "UMOWA O PRACĘ";
        }
        else if(kalkulatorPodatkowy.getTypUmowy() == TypUmowy.umowaZlecenie){
            return "UMOWA ZLECENIE";
        }
        return null;
    }

    public String podstawaWymiaruSkladek(){
        return "Podstawa wymiaru składek " + kalkulatorPodatkowy.getPodstawaWymiaruSkladek();
    }

    public String skladkaEmerytalna(){
        return "Składka na ubezpieczenie emerytalne " + kalkulatorPodatkowy.getSkladkaEmerytalna();
    }

    public String skladkaRentowa(){
        return "Składka na ubezpieczenie rentowe " + kalkulatorPodatkowy.getSkladkaRentowa();
    }

    public String skladkaChorobowa(){
        return "Składka na ubezpieczenie chorobowe " + kalkulatorPodatkowy.getSkladkaChorobowa();
    }

    public String podstawaSkladkiZdrowotnej(){
        return "Podstawa wymiaru składki na ubezpieczenie zdrowotne: " + kalkulatorPodatkowy.getPodstawaSkladkiZdrowotnej();
    }

    public String skladkaZdrowotna(){
        return "Składka na ubezpieczenie zdrowotne: 9% = " + kalkulatorPodatkowy.getSkladkaZdrowotna_9() +
        " 7,75% = " + kalkulatorPodatkowy.getSkladkaZdrowotna_7_75();
    }

    public String kosztyUzyskania(){
        return "Koszty uzyskania przychodu w stałej wysokości " + kalkulatorPodatkowy.getKosztyUzyskania();
    }

    public String podstawaOpodatkowania(){
        return "Podstawa opodatkowania " + kalkulatorPodatkowy.getPodstawaOpodatkowania() +
                " zaokrąglona " + kalkulatorPodatkowy.getPodstawaOpodatkowania_zaokraglone();
    }

    public String zaliczkaNaPodatekDochodowy(){
        return "Zaliczka na podatek dochodowy 18 % = " + kalkulatorPodatkowy.getZaliczkaNaPodatekDochodowy();
    }

    public String kwotaZmiejszajacaPodatek(){
        return "Kwota wolna od podatku = " + kalkulatorPodatkowy.getKwotaZmiejszajacaPodatek();
    }

    public String podatekPotracony(){
        return "Podatek potrącony = " + kalkulatorPodatkowy.getPodatekPotracony();
    }

    public String zaliczkaDoUrzeduSkarbowego(){
        return "Zaliczka do urzędu skarbowego = " + kalkulatorPodatkowy.getZaliczkaDoUrzeduSkarbowego()
                + " po zaokrągleniu = " + kalkulatorPodatkowy.getZaliczkaDoUrzeduSkarbowego_zaokraglone();
    }

    public String wynagrodzenie(){
        return "Pracownik otrzyma wynagrodzenie netto w wysokości = " + kalkulatorPodatkowy.getWynagrodzenie();
    }

}
