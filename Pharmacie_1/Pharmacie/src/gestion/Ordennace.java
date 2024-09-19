package gestion;


public class Ordennace {
    private int id;
    private int userId;

    public Ordennace(int id, int userId) {
        this.id = id;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Ordennace{" + "id=" + id + ", userId=" + userId + '}';
    }
    
    
}
