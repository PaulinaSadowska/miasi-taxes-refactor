import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * Created by Paulina Sadowska on 03.06.2016.
 */
public class Main
{
    public static void main(String [ ] args)
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        BigDecimal kwotaDochodu = null;
        TypUmowy typUmowy = null;

        try
        {
            System.out.print("Podaj kwotę dochodu: ");
            kwotaDochodu = new BigDecimal(Double.parseDouble(br.readLine()));
            System.out.print("Typ umowy: (P)raca, (Z)lecenie: ");
            typUmowy = getTypUmowy(br.readLine().charAt(0));
            if (typUmowy != null)
            {
                KalkulatorPodatkowy kalkulatorPodatkowy = new KalkulatorPodatkowy(kwotaDochodu, typUmowy);
                Printer printer = new Printer(kalkulatorPodatkowy);
                printer.print();
            }
            else{
                System.out.println("Podano niewłaściwy typ umowy");
            }

        }
        catch(NumberFormatException e){
            System.out.println("Podano niewłaściwą wartość wynagrodzenia");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static TypUmowy getTypUmowy(char typUmowy)
    {
        if(typUmowy == 'p' || typUmowy == 'P'){
            return TypUmowy.umowaOPrace;
        }
        if(typUmowy == 'z' || typUmowy == 'Z'){
            return TypUmowy.umowaZlecenie;
        }
        return null;
    }
}
