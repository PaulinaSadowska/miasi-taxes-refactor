import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Paulina Sadowska on 25.05.2016.
 */
public class KalkulatorPodatkowy
{
    private static final BigDecimal skladkaEmarytalna_procent = new BigDecimal(0.0976);
    private static final BigDecimal skladkaRentowa_procent = new BigDecimal(0.015);
    private static final BigDecimal skladkaChorobowa_procent = new BigDecimal(0.0245);
    private static final BigDecimal  skladkaZdrowotna_9procent = new BigDecimal(0.09);
    private static final BigDecimal  skladkaZdrowotna_7_75procent = new BigDecimal(0.0775);
    private static final BigDecimal  zaliczkaNaPodatekDochodowy_procent = new BigDecimal(0.18);


    private BigDecimal podstawa;
    private TypUmowyStrategia typUmowyStrategia;

    public KalkulatorPodatkowy(BigDecimal podstawa, TypUmowy typUmowy){
        this.podstawa = podstawa;
        if(typUmowy == TypUmowy.umowaOPrace) {
            this.typUmowyStrategia = new UmowaOPrace();
        }
        else if(typUmowy == TypUmowy.umowaZlecenie){
            this.typUmowyStrategia = new UmowaZlecenie();
        }
    }

    public TypUmowy getTypUmowy()
    {
        return typUmowyStrategia.getTypUmowy();
    }

    public BigDecimal getWynagrodzenie()
    {
        return podstawa.subtract(getSkladkaEmerytalna()).subtract(getSkladkaRentowa()).subtract(getSkladkaChorobowa())
                .subtract(getSkladkaZdrowotna_9()).subtract(getZaliczkaDoUrzeduSkarbowego_zaokraglone());
    }

    public BigDecimal getPodstawaWymiaruSkladek()
    {
        return podstawa;
    }

    public BigDecimal getSkladkaEmerytalna()
    {
        return podstawa.multiply(skladkaEmarytalna_procent);
    }

    public BigDecimal getSkladkaRentowa()
    {
        return podstawa.multiply(skladkaRentowa_procent);
    }

    public BigDecimal getSkladkaChorobowa()
    {
        return podstawa.multiply(skladkaChorobowa_procent);
    }

    public BigDecimal getKosztyUzyskania()
    {
        return typUmowyStrategia.getKosztyUzyskania(getPodstawaSkladkiZdrowotnej());
    }

    public BigDecimal getPodstawaOpodatkowania()
    {
        return getPodstawaSkladkiZdrowotnej().subtract(getKosztyUzyskania());
    }

    public BigDecimal getPodstawaOpodatkowania_zaokraglone()
    {
        return getPodstawaOpodatkowania().setScale(0, RoundingMode.HALF_UP);
    }

    public BigDecimal getSkladkaZdrowotna_9()
    {
        return getPodstawaSkladkiZdrowotnej().multiply(skladkaZdrowotna_9procent);
    }

    public BigDecimal getSkladkaZdrowotna_7_75()
    {
        return getPodstawaSkladkiZdrowotnej().multiply(skladkaZdrowotna_7_75procent);
    }

    public BigDecimal getZaliczkaNaPodatekDochodowy()
    {
        return getPodstawaOpodatkowania_zaokraglone().multiply(zaliczkaNaPodatekDochodowy_procent);
    }

    public BigDecimal getKwotaZmiejszajacaPodatek()
    {
        return typUmowyStrategia.getKwotaZmiejszajacaPodatek();
    }

    public BigDecimal getPodatekPotracony()
    {
        return getZaliczkaNaPodatekDochodowy().subtract(getKwotaZmiejszajacaPodatek());
    }

    public BigDecimal getZaliczkaDoUrzeduSkarbowego()
    {
        return getZaliczkaNaPodatekDochodowy().subtract(getSkladkaZdrowotna_7_75()).subtract(getKwotaZmiejszajacaPodatek());
    }

    public BigDecimal getZaliczkaDoUrzeduSkarbowego_zaokraglone()
    {
        return getZaliczkaDoUrzeduSkarbowego().setScale(0, RoundingMode.HALF_UP);
    }

    public BigDecimal getPodstawaSkladkiZdrowotnej()
    {
        return podstawa.subtract(getSkladkaEmerytalna()).subtract(getSkladkaRentowa()).subtract(getSkladkaChorobowa());
    }



}
