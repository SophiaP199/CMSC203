public class Plot {
	
	//initialize the attributes that go with the Plot class
	private int x;
	private int y;
	private int depth;
	private int width;
	
	//constructor methods go here
	
	// #1 has all 4 information
	public Plot(int x1, int y1, int depth1, int width1)
	{
		x=x1;
		y=y1;
		depth=depth1;
		width=width1;
	}
	
	//copy constructor
	public Plot(Plot a)
	{
		x=a.getX();
		y=a.getY();
		depth=a.getDepth();
		width=a.getWidth();
	}
	
	
	//getter methods
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getDepth()
	{
		return depth;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	//setter class
	public void setX(int x1)
	{
		x=x1;
	}
	
	public void setY(int y1)
	{
		y= y1;
	}
	
	public void setWidth(int width1)
	{
		width= width1;
	}
	
	public void setDepth(int depth1)
	{
		depth= depth1;
	}
	
	//overlaps method, error checks to see if plots overlap
	//returns true if it does overlap
	
	public boolean overlaps(Plot a )
	{
		if((a.y-a.depth)>= y|| y-depth >= a.y)
		{
			if((a.x+a.width)<=x|| x+width <=a.x)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		else
		{
			return true;
		}
	}
	
	//method encompasses checks to see if there is a plot inside of another plot
	//returns true if current plot has plot "a" inside of it
	public boolean encompasses(Plot a)
	{
		if((y>= a.y )&& (y-depth <= a.y-a.depth))
		{
			if(x <=a.x && x+width >= a.x +a.width)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	//toString method which returns Plot info
	@Override
	public String toString()
	{
		return x+","+y+","+depth+","+width;
	}
}

