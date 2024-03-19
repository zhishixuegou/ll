public class ComplementaryPasses {  
    private String passID;  
    private String accessLevel;  
  
    public ComplementaryPasses(String passID, String accessLevel) {  
        this.passID = passID;  
        this.accessLevel = accessLevel;  
    }  
  
    public String getPassID() {  
        return passID;  
    }  
  
    public void setPassID(String passID) {  
        this.passID = passID;  
    }  
  
    public String getAccessLevel() {  
        return accessLevel;  
    }  
  
    public void setAccessLevel(String accessLevel) {  
        this.accessLevel = accessLevel;  
    }  
  
    public String toString() {  
        return "ComplementaryPasses{" +  
                "passID='" + passID + '\'' +  
                ", accessLevel='" + accessLevel + '\'' +  
                '}';  
    }  
}