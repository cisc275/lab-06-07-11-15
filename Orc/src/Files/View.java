package Files;
import java.awt.BorderLayout;
/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JPanel {
	
	static int frameWidth = 500;
	static int frameHeight = 300;
	static int orcWidth = 165;
	static int orcHeight = 165;
	
	int x;
	int y;
	Direction dir;
	
	JButton btn = new JButton("Start/Stop");
	private static final int btn_x = 10; // location x 
	private static final int btn_y = 10;  // location y 
	private static final int btn_width = 140;
	private static final int btn_height = 50; 
	
	final static int frameCount = 10;
	
	BufferedImage[][] pics;
	
	public View() { 
		String[] arrOfStr = {"forward_north", "forward_northeast", "forward_east", "forward_southeast",
                "forward_south", "forward_southwest", "forward_west", "forward_northwest"};
        BufferedImage[] img = createImage(arrOfStr);
        pics = new BufferedImage[frameCount][arrOfStr.length];
        int count = 0;
        for (BufferedImage curImg : img) {
            for(int i = 0; i < frameCount; i++) {
                pics[i][count] = curImg.getSubimage(orcWidth*i, 0, orcWidth, orcHeight);
            }
            count ++;
        }
        
		JFrame frame = new JFrame();
        frame.getContentPane().add(this);
        this.setBackground(Color.GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        btn.setBounds(btn_x, btn_y, btn_width, btn_height);
        
        frame.getContentPane().add(btn,BorderLayout.SOUTH);

        frame.setVisible(true);
	}
	
    private BufferedImage[] createImage(String[] strArr){
        BufferedImage[] bufferedImage = new BufferedImage[strArr.length];
        String path = "src/images/orc_";
        int count = 0;
        for (String str : strArr) {
            try {
                bufferedImage[count] = ImageIO.read(new File(path.concat(str).concat(".png")));
                
                count ++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bufferedImage;
    }
	
	public void update(int x, int y, Direction dir) {
		//System.out.println("view update");
		this.x = x;
		this.y = y;
		this.dir = dir;
		repaint();
		try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	public void paint(Graphics g) {
		g.drawImage(pics[Model.getPicNum()][dir.getHierarchy()], x, y, Color.GRAY, this);
	}
	
	public int getWidth() { return frameWidth; }
	
	public int getHeight() { return frameHeight; }
	
	public static int getImageWidth() { return orcWidth; }
	
	public static int getImageHeight() { return orcHeight; }
	
	public static int getFrameCount() { return frameCount; }
}
