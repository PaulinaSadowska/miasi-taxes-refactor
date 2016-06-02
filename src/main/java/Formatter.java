import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Paulina Sadowska on 03.06.2016.
 */
public class Formatter
{
    public String format(BigDecimal value){
        return trimTrailingZeros(value.setScale(2, RoundingMode.HALF_UP)+"");
    }

    public String trimTrailingZeros(String s){
        return !s.contains(".") ? s : s.replaceAll("0*$", "").replaceAll("\\.$", "");
    }
}
