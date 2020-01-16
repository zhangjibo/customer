package domain;

public class Architect extends Designer {
    private int stock;  //股票

    
    public Architect() {
	super();
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
	super(id, name, age, salary, equipment, bonus);
	this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
	return getEmployeeToString()  + "\t设计师\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment().getDescription();
    }
    
    public String getDetailsForTeam() {
	return getMemberId() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t架构师\t"
		+ getBonus() + "\t" + getStock();
    }
    

}
