package javafxminiproject.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Converter {

    public static Date stringToDate(String strDate){
        Date dte=null;
        if (strDate.isEmpty()){
            return null;
        }

        try{
            String str = strDate;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dt = formatter.parse(str);
            dte=new Date(dt.getTime());
        }catch(Exception e){
            e.printStackTrace();
        }

        return dte;
    }

    public static boolean stringToBoolean(String strBoolean){
        return "Y".equals(strBoolean);
    }

}
