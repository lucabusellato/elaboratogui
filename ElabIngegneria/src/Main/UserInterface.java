package Main;

public interface UserInterface{
    
    String getUsr();
    int getTypeInt();
    boolean setUser(String newUser);
    boolean setPassword(String newPassword);
    boolean setType(int newType);
    
    @Override String toString();
    @Override int hashCode();
    @Override boolean equals(Object obj);
}
