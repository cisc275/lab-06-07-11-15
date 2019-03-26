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
	
	int x;
	int y;
	int xChg = 1;
	int yChg = 1;
	static int motionPicNum = 0;
	static int actionPicNum = 0;
	final int xIncr = 8;
	final int yIncr = 2;
	int orcWidth = 165;
	int orcHeight = 165;
	int frameWidth = 500;
	int frameHeight = 300;
	static String action = "run";
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
		if(action == "run") {
			motionPicNum = (motionPicNum + 1) % View.getFrameCount();
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
		        	default:
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
	        			direction = Direction.SOUTHWEST;
	        			break;
	        		default:
	        			break;
	        	}
	        	
	        }
	        x += xChg*xIncr;
        	y += yChg*yIncr;
		}
        
        if(action == "fire") {
        	actionPicNum = (actionPicNum + 1) % View.getFireFrameCount();
        	
        	switch(direction) {
    		case NORTHEAST:
    			direction = Direction.FIRE_NORTHEAST;
    			break;
    		case SOUTHEAST:
    			direction = Direction.FIRE_SOUTHEAST;
    			break;
    		case SOUTHWEST:
    			direction = Direction.FIRE_SOUTHWEST;
    			break;
    		case NORTHWEST:
    			direction = Direction.FIRE_NORTHWEST;
    			break;
    		default:
    			break;
        	}
        	
        	if(actionPicNum == (View.getFireFrameCount()-1)) {
        		action = "run";
        		motionPicNum = 0;
        		actionPicNum = 0;
        		switch(direction) {
        		case FIRE_NORTHEAST:
        			direction = Direction.NORTHEAST;
        			break;
        		case FIRE_SOUTHEAST:
        			direction = Direction.SOUTHEAST;
        			break;
        		case FIRE_SOUTHWEST:
        			direction = Direction.SOUTHWEST;
        			break;
        		case FIRE_NORTHWEST:
        			direction = Direction.NORTHWEST;
        			break;
        		default:
        			break;
            	}
        	}
        }
        
        else if(action == "jump") {
        	actionPicNum = (actionPicNum + 1) % View.getFrameCount();
        	
        	switch(direction) {
    		case NORTHEAST:
    			direction = Direction.JUMP_NORTHEAST;
    			break;
    		case SOUTHEAST:
    			direction = Direction.JUMP_SOUTHEAST;
    			break;
    		case SOUTHWEST:
    			direction = Direction.JUMP_SOUTHWEST;
    			break;
    		case NORTHWEST:
    			direction = Direction.JUMP_NORTHWEST;
    			break;
    		default:
    			break;
        	}
        	
        	if(actionPicNum == (View.getJumpFrameCount()-1)) {
        		action = "run";
        		motionPicNum = 0;
        		actionPicNum = 0;
        		switch(direction) {
        		case JUMP_NORTHEAST:
        			direction = Direction.NORTHEAST;
        			break;
        		case JUMP_SOUTHEAST:
        			direction = Direction.SOUTHEAST;
        			break;
        		case JUMP_SOUTHWEST:
        			direction = Direction.SOUTHWEST;
        			break;
        		case JUMP_NORTHWEST:
        			direction = Direction.NORTHWEST;
        			break;
        		default:
        			break;
            	}
        	}
        }
	}
	
	public int getX() { return x; }
	
	public int getY() { return y; }
	
	public Direction getDirect() { return direction; }
	
	public static int getPicNum() { return motionPicNum; }
	public static int getSmlPicNum() { return actionPicNum; }
	
	public static void setAction(String a) { action = a; }
	public static String getAction() { return action; }


	
}