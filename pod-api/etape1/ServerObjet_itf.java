public interface ServerObjet_itf {

    public Object lock_read(Client_itf client) throws java.rmi.RemoteException;
    public Object lock_write(Client_itf client) throws java.rmi.RemoteException;
    public void unlock() throws java.rmi.RemoteException;

}
