package AES;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.tools.gui.ACLAIDDialog;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class ServerAgent extends Agent {
    @Override
    protected void setup() {
        String passwor = (String) getArguments()[0];
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage receive = receive();
                if (receive != null) {
                    String encryptEncodedMsg = receive.getContent();
                    System.out.println(encryptEncodedMsg);
                    byte [] encryptmsg = Base64.getDecoder().decode(encryptEncodedMsg);
                    SecretKey secretKey = new SecretKeySpec(passwor.getBytes(),"AES");
                    try {
                        Cipher cipher = Cipher.getInstance("AES");
                        cipher.init(Cipher.DECRYPT_MODE,secretKey);
                        byte [] decryptMSG = cipher.doFinal(encryptmsg);
                        System.out.println(decryptMSG);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
