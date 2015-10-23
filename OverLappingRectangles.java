package test;

public class OverLappingRectangles{
	
	public static boolean overlapping(Rect r1, Rect r2){
		Point tl1 = r1.topLeft;
		Point br1 = r1.bottomRight;
	
		Point tl2 = r2.topLeft;
		Point br2 = r2.bottomRight;
		
		if(br1.x <= tl2.x || br2.x <= tl1.x){
			return false;
		}
		
		if(br1.y >= tl2.y || br2.y >= tl1.y){
			return false;
		}
		return true;
	}
	
    public static void main(String [] args){
			Rect r1 = new Rect(new Point(0,2), new Point(2,0));
			Rect r2 = new Rect(new Point(0,4), new Point(6,0));
			System.out.println(overlapping(r1, r2));			
	}
}

