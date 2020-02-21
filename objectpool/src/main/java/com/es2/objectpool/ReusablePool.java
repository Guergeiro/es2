package com.es2.objectpool;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ReusablePool {
    // Attributes
    private static ReusablePool instance;
    // Sets maxSize to default 10
    private Integer maxSize = 10;
    // Creates pools
    private ArrayList<HttpURLConnection> free = new ArrayList<HttpURLConnection>();
    private ArrayList<HttpURLConnection> used = new ArrayList<HttpURLConnection>();

    // Constructor
    private ReusablePool() {
        // Cleans up connections every 30s
        new Thread() {
            public void run() {
                while (true) {
                    // Clears connections
                    ReusablePool.getInstance().resetPool();

                    // Sleeps for 30s
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }.start();
    };

    // Getters & Setters
    public static ReusablePool getInstance() {
        if (instance == null) {
            instance = new ReusablePool();
        }
        return instance;
    }

    public synchronized HttpURLConnection acquire() throws PoolExhaustedException, IOException {
        if (used.size() >= maxSize) {
            // Atingiu-se limite de connections
            throw new PoolExhaustedException();
        }

        HttpURLConnection outConn = null;
        if (free.isEmpty() == true) {
            // Não existem mais ligações disponíveis
            outConn = (HttpURLConnection) new URL("http://ipv.pt").openConnection();
        } else {
            // Usar uma ligação livre
            outConn = free.get(0);
            free.remove(0);
            outConn.connect();
        }

        used.add(outConn);
        return outConn;
    }

    public synchronized void release(HttpURLConnection conn) throws ObjectNotFoundException {
        if (used.contains(conn) == false) {
            throw new ObjectNotFoundException();
        }
        conn.disconnect();
        used.remove(conn);
        free.add(conn);
    }

    public synchronized void resetPool() {
        for (HttpURLConnection connection : free) {
            connection.disconnect();
        }
        free.clear();
        for (HttpURLConnection connection : used) {
            connection.disconnect();
        }
        used.clear();
    }

    public synchronized void setMaxPoolSize(int maxSize) {
        this.maxSize = maxSize;
    }
}
