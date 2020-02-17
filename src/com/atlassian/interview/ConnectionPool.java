package com.atlassian.interview;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;

public class ConnectionPool implements ConnectionEventListener {

    final Queue<PoolConnection> connections;

    public ConnectionPool(int n) {
        connections = new LinkedBlockingQueue<PoolConnection>(n);
    }

    public Connection getConnection() {
        final PoolConnection conn = connections.remove();
        conn.addConnectionEventListener(this);
        return conn.getConnection();
    }

    @Override
    public void connectionClosed(ConnectionEvent event) {
        // TODO Auto-generated method stub
        final PoolConnection conn = (PoolConnection) event.getSource();
        connections.add(conn);

    }

    @Override
    public void connectionErrorOccurred(ConnectionEvent event) {
        // TODO Auto-generated method stub

    }
}
