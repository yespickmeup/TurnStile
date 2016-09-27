/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstile.util;

import jssc.SerialPort;
import jssc.SerialPortException;

/**
 *
 * @author Maytopacka
 */
public class Port {

    public static void command(String stmt,String port) {
        SerialPort serial = new SerialPort(port);
        try {
            //Open port
            serial.openPort();
            //We expose the settings. You can also use this line - serialPort.setParams(9600, 8, 1, 0);
            serial.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            //Writes data to port
            String message = stmt; //01L
            
            serial.writeBytes(message.getBytes());
            //Read the data of 10 bytes. Be careful with the method readBytes(), if the number of bytes in the input buffer
            //is less than you need, then the method will wait for the right amount. Better to use it in conjunction with the
            //interface SerialPortEventListener.
            byte[] buffer = serial.readBytes(10);
            //Closing the port
            serial.closePort();
        } catch (SerialPortException ex) {
            System.out.println(ex);
        }
    }
}
