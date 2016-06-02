import java.math.BigDecimal;

/**
 * Created by Paulina Sadowska on 30.05.2016.
 */
public interface TypUmowyStrategia
{
    TypUmowy getTypUmowy();
    BigDecimal getKosztyUzyskania(BigDecimal podstawaSkladkiZdrowotnej);
    BigDecimal getKwotaZmiejszajacaPodatek();
}
