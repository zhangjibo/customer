package service;

/**
 * 表示员工状态
 * @author Administrator
 *
 */
public class Status {
    //枚举类
    private final String NAME;
    
    public Status(String name) {
	super();
	this.NAME = name;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
	return NAME;
    }
    
    

}
