package Files;

/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/

public class Model {
	
//added this into button branch
	int x;
	int y;
	int dir = 3;
	int xChg = 1;
	int yChg = 1;
	static int picNum = 0;
	final int xIncr = 8;
	final int yIncr = 2;
	int orcWidth = 165;
	int orcHeight = 165;
	int frameWidth = 500;
	int frameHeight = 300;
	Direction direction = Direction.SOUTHEAST;
    

	public Model(int frameWidth,int frameHeight, int orcWidth, int orcHeight) {
		this.orcWidth = orcWidth;
		this.orcHeight = orcHeight;
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		
	}
	
	public static void main(String[] args) {
		System.out.println("STARTING POINT");
		Controller ctrl = new Controller();
		ctrl.start();
	}
	
	public void updateLocationAndDirection() {
		//TODO switch to enumerated type ***BRANCH FIRST****
		picNum = (picNum + 1) % View.getFrameCount();
        if(x > (frameWidth - View.getImageWidth()) || x < 0) {
        	switch(direction) {
	        	case NORTHEAST:
	        		direction = Direction.NORTHWEST;
	        		break;
	        	case SOUTHEAST:
	        		direction = Direction.SOUTHWEST;
	        		break;
	        	case SOUTHWEST:
	        		direction = Direction.SOUTHEAST;
	        		break;
	        	case NORTHWEST:
	        		direction = Direction.NORTHEAST;
	        		break;
        	}
        	xChg = -1*xChg;
        	
        }
        if(y > (frameHeight - View.getImageHeight()) || y < 0) {

        	yChg = -1*yChg;
        	switch(direction) {
        		case NORTHEAST:
        			direction = Direction.SOUTHEAST;
        			break;
        		case SOUTHEAST:
        			direction = Direction.NORTHEAST;
        			break;
        		case SOUTHWEST:
        			direction = Direction.NORTHWEST;
        			break;
        		case NORTHWEST:
        			direction = Direction.SOUTHWEST;;
        			break;
        	}
        }
        x += xChg*xIncr;
        y += yChg*yIncr;
        //System.out.println(direction.getHierarchy());
        //System.out.println(x);
        //System.out.println(y);
        //System.out.println("Dir " + dir);
	}
	
	public int getX() { return x; }
	
	public int getY() { return y; }
	
	public Direction getDirect() { return direction; }
	
	public static int getPicNum() { return picNum; }


	
}