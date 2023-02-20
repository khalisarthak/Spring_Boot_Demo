package springProject.sarthak.Exception;

public class ResourceNotFound extends RuntimeException{
    private String resourceName;
    private String resourceField;
    private int resourceValue;
    public ResourceNotFound(String resourceName,String resourceField,int resourceValue)
    {
        super(resourceName+" with this "+resourceField+" of "+resourceValue + " not found ");
        this.resourceName=resourceName;
        this.resourceValue=resourceValue;
        this.resourceField=resourceField;
    }
}
