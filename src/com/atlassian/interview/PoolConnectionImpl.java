package com.atlassian.interview;

import java.util.Map;

import javax.sql.ConnectionEventListener;

public class PoolConnectionImpl implements PoolConnection{

    Map<ConnectionEventListener, ConnectionEventListener> listeners;
    Connection conn;
    
    public PoolConnectionImpl(Connection c) {
        conn = c;
    }
    
    
    @Override
    public Connection getConnection() {
        return conn;
    }

    @Override
    public void addConnectionEventListener(ConnectionEventListener listener) {
        listeners.put(listener, listener);
    }

    @Override
    public void removeConnectionEventListener(ConnectionEventListener listener) {
        listeners.remove(listener, listener);
    }

}
