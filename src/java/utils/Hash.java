/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


/**
 *
 * @author Giang Minh
 */
public class Hash {

//    User: eos is an exam manager application
//User: create a database for admin to manage eos
//User: give me sample data for the database
//User: function to hash password
//User: in java please
//User: a function to unhash pass
//User: org.mindrot.jbcrypt does not exist
//User: how to add the library if i use jsp servlet
//User: where i can download jbcrypt
    public static String hashPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
//        byte[] salt = new byte[16];
//        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec("password".toCharArray(), password.getBytes(), 65536, 128);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = f.generateSecret(spec).getEncoded();
        Base64.Encoder enc = Base64.getEncoder();
        return enc.encodeToString(hash);
    }

}