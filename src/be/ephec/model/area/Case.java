package be.ephec.model.area;

public class Case extends Coord {
	
	private boolean use;
	private boolean touch;
	private String usedBy;
	
	public Case(){
		super();
		use = false;
		touch = false;
		usedBy = "nothing";
	}
	
	public Case(int x, int y){
		super(x, y);
		use = false;
		touch = false;
		usedBy = "nothing";
	}
	
	public boolean isUse() {
		return use;
	}
	public void setUse(boolean use) {
		this.use = use;
	}
	public boolean isTouch() {
		return touch;
	}
	public void setTouch(boolean touch) {
		this.touch = touch;
	}
	
	public String getUsedBy() {
		return usedBy;
	}

	public void setUsedBy(String usedBy) {
		this.usedBy = usedBy;
	}
	
	
	/**
	 * Modify the case to become a pion 
	 * 
	 * @param name name of the pion who use the case
	 */
	public void becomePion(String name){
		this.setUsedBy(name);
		this.setUse(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * Je la modifie un peu comme je veux pour afficher ce qui m'intéresse dans la console
	 *  
	 */
	public String toString(){
		//return(getX()+":"+getY()+" "+isUse());
		if(isUse()) return "1";
		return "O";
		
	}

}
