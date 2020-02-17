package com.atlassian.interview;

import javax.sql.ConnectionEventListener;

public interface PoolConnection {

    public Connection getConnection();
    
    public void addConnectionEventListener(ConnectionEventListener listener);
    
    public void removeConnectionEventListener(ConnectionEventListener listener);
}
