public class ServerObjet implements ServerObjet_itf {
    
    private Object o;
    private Client_itf client;
    private boolean isLocked;
    private boolean isWriteLocked;

    public ServerObjet(Object o) {
        this.o = o;
        this.isLocked = false;
        this.isWriteLocked = false;
    }

    public Object lock_read(Client_itf client) throws java.rmi.RemoteException {
        if (this.isWriteLocked) {
            System.out.println("L'objet est write_locked");
            return null;
        }
        this.isLocked = true;
        this.client = client;
        return this.o;
    }

    public Object lock_write(Client_itf client) throws java.rmi.RemoteException {
        if (this.isLocked) {
            System.out.println("L'object est locked");
            return null;
        }
        this.isWriteLocked = true;
        this.client = client;
        return this.o;
    }

    public void unlock() throws java.rmi.RemoteException {
        this.isLocked = false;
        this.isWriteLocked = false;
        this.client = null;
    }
}