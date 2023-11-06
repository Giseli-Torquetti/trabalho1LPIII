package br.edu.unijui.logging;

import br.edu.unijui.dataBase.Interface.BuscarClientes;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class HotelLogger {

    private static final Logger logger = Logger.getLogger(HotelLogger.class.getPackage().getName());

    public static void log(Level logLevel, String message, String arquivo) {
        Handler handler;
        try {
            handler = new FileHandler(arquivo, true);
            logger.addHandler(handler);
            logger.log(logLevel, message);
        } catch (IOException | SecurityException ex) {
            Logger.getLogger(BuscarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
