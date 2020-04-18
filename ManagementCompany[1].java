public class ManagementCompany {
  
   private final int MAX_PROPERTY = 5;
   private String name, taxID;
   private double managementFee;
   private final int MGMT_WIDTH = 10;
   private final int MGMT_DEPTH = 10;
   private Property properties[] ;
   private Plot plot;
 
   public ManagementCompany() {
	   name ="";
	   taxID = "";
	   managementFee = 0.0;
	   plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
	   properties = new Property[MAX_PROPERTY];
	  
   }
   public ManagementCompany(String name, String taxId, double managementFee) {

       this.name = name;
       this.taxID = taxId;
       this.managementFee = managementFee;
       plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
	   properties = new Property[MAX_PROPERTY];

   }
   
  
   public ManagementCompany(String name, String taxId, double managementFee,int x, int y, int width, int depth) {

       this.name = name;
       this.taxID = taxId;
       this.managementFee = managementFee;
       plot = new Plot(x,y,width,depth);
       properties = new Property[MAX_PROPERTY];
   }
   
   public ManagementCompany(ManagementCompany otherCompany) {
	   this(otherCompany.name, otherCompany.taxID, otherCompany.managementFee);
	   plot = new Plot(otherCompany.plot);
	   for ( int i = 0; i< otherCompany.properties.length ; i++)
	   {
		   properties[i] = new Property(otherCompany.properties[i]);

	   }
   }
   public int addProperty(Property property)
   {
       if (property == null){
           return -2;
       }
       else if (!plot.encompasses(property.getPlot())){
           return -3;
       }
       for (int index = 0; index < properties.length; index++){
           if (properties[index] != null){
               if (properties[index].getPlot().overlaps(property.getPlot())){
                   return -4;
               }
           }else{
               properties[index] = property;
               return index;
           }
       } return -1;
   }
   public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
   {
       return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
   }
   public int addProperty(String name, String city, double rent, String owner)
   {
       return addProperty(new Property(name, city, rent, owner));
   }

public double totalRent() {
	    double total = 0;
	    for (int index= 0; index<properties.length; index++) {
	      if (properties[index]==null) {
	        break;
	      }
	      total += properties[index].getRentAmount();
	    }
	    return total;
	  }

public int maxRentPropertyIndex()
   {
       int index = -1;
       double maxRent= 0.0;
       for (int i = 0; i <properties.length; i++){
           if (properties[i] == null){
               break;
           }
           if( maxRent <properties[i].getRentAmount()){
               maxRent =properties[i].getRentAmount();
               index = i;
           }
       }
       return  index;
   }
public double maxRentProp()
{
    double maxRent = 0.0;
    for (Property propperty : properties){
        if (propperty == null){
            break;
        }
        if (maxRent <propperty.getRentAmount()){
            maxRent =propperty.getRentAmount();
        }
    }
    return maxRent;
}
public String displayPropertyAtIndex(int index)
   {
       String toReturn;
       toReturn =properties[index].toString();
       return toReturn;
   }
public String toString()
   {
       String allProperties = "";
       allProperties += "List of the properties for " + name + ", taxID: " + taxID + "\n";
       allProperties += "__________________________________________________________________________\n";
       for (Property property : properties){
           if (property == null){
               break;
           }
           allProperties += property.toString();
           allProperties += "\n";
       }
       allProperties += "__________________________________________________________________________\n";
       allProperties += "total management Fee: " + (totalRent() * managementFee / 100);
       return  allProperties;
   }
public int getMAX_PROPERTY() {

	return MAX_PROPERTY;
}
public String getName() {

	return name;
}
public String getTaxID() {
	return taxID;
}
public double getManagemantFee() {
	return managementFee;
}
public Plot getPlot() {
	return new Plot(plot);
}
}