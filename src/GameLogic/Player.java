package GameLogic;

import java.util.ArrayList;

public class Player {

	private String name;
    private int balance;
    private int location;
    private boolean hasRentDebt;
    private boolean isBankrupt;
    private boolean isInJail;
    private ArrayList<Card> cards;
    private ArrayList<Property> properties;   
    private String color;
    private boolean hasRolledDice;

    public Player( String name, String color)
    {
    	this.name = name;
        balance = 1500; 
        location = 0;
        isBankrupt = false;
        isInJail = false;
        cards = new ArrayList<>();
        properties = new ArrayList<>();
        this.color = color;
        hasRentDebt = false;
        hasRolledDice = false;
    }
    
    public Property getProperty(int index)
    {
    	return properties.get(index);
    }
    
    public int getPropertyCount()
    {
        int propertyCount = 0;    	
        
        for(int i = 0; i < properties.size(); i++)
        {
        	propertyCount++;
        }
        
        return propertyCount;
    }
    
    public void changeBalance(int change)
    {
    	balance = balance + change;
    }
    
    public ArrayList<Property> getProperties(){return properties;}
    
    public int getHouseCount()
    {
    	int houseCount = 0;
    	
    	for(int i = 0; i < properties.size(); i++)
    	{
    		if(properties.get(i) instanceof ColoredProperty)
    		{
    			houseCount = houseCount + ((ColoredProperty) properties.get(i)).getNumberOfHouses();
    		}
    	}
    	
    	return houseCount;
    }
    
    public int getHotelCount()
    {
    	int hotelCount = 0;
    	
    	for(int i = 0; i < properties.size(); i++)
    	{
    		if(properties.get(i) instanceof ColoredProperty)
    		{
    			hotelCount = hotelCount + ((ColoredProperty) properties.get(i)).getNumberOfHotels();
    		}
    	}
    	
    	return hotelCount;
    }
    
    public String getName()
    {
    	return name;
    }
   
    public String getColor()
    {
    	return color;
    }
    
    public int getBalance()
    {
        return balance;
    }
    
    public void addProperty(Property property)
    {
    	properties.add(property);
    }
    
    public void decrementBalance(int amount)
    {
    	balance = balance - amount;
    }
    
    public void incrementBalance(int amount)
    {
    	balance = balance + amount;
    }

    public void move(int movementAmount)
    {
        location = (location + movementAmount) % Constants.TileConstants.TILE_COUNT;
    }
    
    public int getLocation()
    {
        return location;
    }

    public boolean isBankrupt()
    {
        return isBankrupt;
    }

    public boolean isInJail()
    {
        return this.isInJail;
    }
    
    public void setHasRentDebt(boolean hasRentDebt)
    {
    	this.hasRentDebt = hasRentDebt;
    }
    
    public boolean hasRentDebt()
    {
    	return hasRentDebt;
    }   

    public void setHasRolledDice(boolean hasRolledDice)
    {
    	this.hasRolledDice = hasRolledDice;
    }
    
    public boolean hasRolledDice()
    {
    	return hasRolledDice;
    }

	public void setLocation(int location) 
	{
		this.location = location;
		
	}  
	
	public void setIsInJail(boolean isInJail)
	{
		this.isInJail = isInJail;
	}
	
	//method that checks if the player has a monopoly on a specific color block
    public boolean hasMonopoly(String color)
    {
        int count = 0;
        for (int i = 0; i < properties.size(); i++) {
            if(properties.get(i) instanceof ColoredProperty) {
                if (((ColoredProperty) (properties.get(i))).getColor() == "brown") ;
                {
                    count++;
                }
            }
        }

        //if color is blue or brown and the count is 2 since they contain only two tiles
        if(count == 2 && (color == "dark blue" || color == "brown"))
        {
            return true;
        }

        //if count is 3 then it automatically means we are considering the tiles of the other color blocks
        else if(count == 3)
        {
            return true;
        }

        //that means the player does not have a monopoly
        else
        {
            return false;
        }
    }
}