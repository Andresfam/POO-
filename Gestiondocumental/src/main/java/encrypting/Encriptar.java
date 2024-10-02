/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encrypting;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author lll
 */
public class Encriptar {
    public String password = "hola mundo";
    public String encrypt(String pw){
        return BCrypt.hashpw(pw, BCrypt.gensalt());
    }
}
