package ec.com.uce.pa.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class MailService {

    public void enviarMail(String destino, String asunto, String cuerpo) {
        System.out.println("Hilo: " + Thread.currentThread().threadId());

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        System.out.println("Se envia un mail a:" + destino);
    }
}
