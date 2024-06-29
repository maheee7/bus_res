package busres;

public class bus {

	private int Busno;
	private int capacity;
	private boolean ac;
	
	
	bus(int bno, int cap,boolean ac){
		this.Busno =bno;
		this.capacity=cap;
		this.ac = ac;
	}
     public int getcapacity() { // acessor method
  	  return capacity;
    }
     
     boolean getac() {
     	return ac;
     }
     
     public int getBusno() { // acessor method
     	  return Busno;
       }
    
    public void setcapacity(int cap) { // mutator method
    	capacity = cap;
    }
   
    public void setac(boolean acc) {
    	ac=acc;
    }
    
    public void  displayBusinfo(){
    	System.out.println("The bus no is :"+ Busno + " Buscapacity is : " + capacity +
    			" ac type : "+ ac);
    	
    }
    
}
     