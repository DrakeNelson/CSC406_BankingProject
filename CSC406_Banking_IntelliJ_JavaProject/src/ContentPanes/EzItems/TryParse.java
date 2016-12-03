package ContentPanes.EzItems;

/**
 * Created by user on 12/1/2016.
 */
public class TryParse {
    public static boolean TryParseDouble(String x){
        try {
            Double.valueOf(x);
            if(x.contains("f")||x.contains("d")||x.contains("D")||x.contains("F")){
                return false;
            }else{
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean TryParseInt(String x){
        try {
            Long.valueOf(x);
            if(x.contains("f")||x.contains("d")||x.contains("D")||x.contains("F")){
                return false;
            }else{
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
