import java.util.Map;

public class Server implements Server_itf {

    public Map<String, Integer> idObjets;
    public Map<Integer, ServerObjet> Objets;

	public int lookup(String name) {
        try { 
            return idObjets.get(name);
        } catch (Exception e) {
            e.printStackTrace();        // A modifier 
        }
        
    }


	public void register(String name, int id) {
        idObjets.put(name, id);
    }


	public int create(Object o) {
        int id = Objets.size();
        Objets.put(id, new ServerObjet(o));
        return id;
    }


	public Object lock_read(int id, Client_itf client) {
        try {
            Objets.get(id).lock_read(client);
            return Objets.get(id);
        } catch (Exception e) {
            e.printStackTrace();        // A modifier 
        }
    }
        
	public Object lock_write(int id, Client_itf client) {
        try {
            return Objets.get(id).lock_write(client);
        } catch (Exception e) {
            e.printStackTrace();        // A modifier 
        }
    }


}
