package com.order.app.models.utilities;

import com.google.common.base.Strings;

import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * Created by bryan.bernabe on 3/28/2017.
 */
public class EncryptionUtil {

  private EncryptionUtil(){
    //intended to be private and empty
  }

  public static String encrypt(String rawString){
    if(!Strings.isNullOrEmpty(rawString)){
      return BCrypt.hashpw(rawString, BCrypt.gensalt());
    }else {
      return null;
    }
  }

  public static boolean checkPassword(String rawString, String hash){
    if(!Strings.isNullOrEmpty(rawString) && !Strings.isNullOrEmpty(hash)){
      return BCrypt.checkpw(rawString, hash);
    }else {
      return false;
    }
  }
}
