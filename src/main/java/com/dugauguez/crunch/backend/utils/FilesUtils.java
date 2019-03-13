package com.dugauguez.crunch.backend.utils;

import org.springframework.util.StringUtils;

public class FilesUtils {


    public static final String TYPE_GENERAL = "GENERAL";
    public static final String TYPE_DETAILS = "DETAILS";

    public static boolean isValidType(String type){

        if (StringUtils.isEmpty(type)){
            return false;
        }

        if ( type.equalsIgnoreCase(TYPE_GENERAL) || type.equalsIgnoreCase(TYPE_DETAILS) ){
            return true;
        }

        return false;

    }

}
