package com.arq.millermosquera.samplesmc;

import android.content.Context;
import android.util.Base64;
import android.widget.EditText;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TextUtils {
    public static SimpleDateFormat getDefaultDateFormater(Context context ){
        return new SimpleDateFormat(context.getString(R.string.default_date_format), Locale.getDefault());
    }

    public static Date formatDefaultStringToDate(Context context, String date){
        SimpleDateFormat sdf = new SimpleDateFormat(context.getString(R.string.default_date_format), Locale.getDefault());
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String getMoneyFormat(String textToFormat){
        if (textToFormat.isEmpty()) {
            return "";
        } else {
            return getMoneyFormat(Double.valueOf(textToFormat));
        }
    }

    public static String getMoneyFormat(Double doubleToFormat){
        return String.format(Locale.getDefault(), "$%,.0f", doubleToFormat);
    }

    public static String getCleanCellphone(String cellphone) {
        return cellphone.replaceAll("[()-]", "").replaceAll("\\s+", "");
    }

    public static String toCase(String s){

        final String DELIMITERS = " '-/";

        StringBuilder sb = new StringBuilder();
        boolean capNext = true;

        for (char c : s.toCharArray()) {
            c = (capNext) ? Character.toUpperCase(c) : Character.toLowerCase(c);
            sb.append(c);
            capNext = (DELIMITERS.indexOf((int) c) >= 0);
        }
        return sb.toString();
    }


    public static String getHash(String textToHash, String salt) {
        try {
            String data = salt + textToHash;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] digest = messageDigest.digest(data.getBytes("UTF-8"));
            return new String(Base64.encode(digest, Base64.DEFAULT));
        } catch( Exception e ){
            e.printStackTrace();
            return "";
        }
    }

    public static long toLong(String value) {

        if (value != null && !value.isEmpty()) {
            return Long.parseLong(value);
        }
        return 0;
    }

    public static long editTexToLong(EditText etValue) {
        if(!etValue.isEnabled())
            return 0;
        return toLong(etValue.getText().toString().replaceAll("[^0-9]", ""));
    }

    public static String normalizeString( String text ) {
        text = text.toLowerCase().replace("á","a").replace("é","e").replace("í","i").replace("ó","o").replace("ú","u");
        return text;
    }

    public static String replaceWords( String valor, String[][] words ) {
        for( int i=0; i<words.length; i++ ){
            valor = valor.replace( words[i][0], words[i][1] );
        }
        return valor;
    }

}
