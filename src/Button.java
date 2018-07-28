import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import processing.core.PApplet;

/**
 * 
 * @author Sohil Nadarajin (not part of responsibility list)
 * 
 * This class models menu buttons in game.
 *
 */
public class Button {

	public static final int RECTANGLE = 1, CIRCLE = 2, GHOST = 3;
	private String name;
	private int buttonShape, textSize, edgeCurve;
	private double x, y, width, height;
	private Color color, highlightColor;
	private Rectangle2D.Double rectangleButton;
	private Ellipse2D.Double circleButton;

	public Button(String name, int shape, double x, double y, double width, double height) {
		this.name = name;
		this.buttonShape = shape;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		color = new Color(135, 206, 255);
		highlightColor = new Color(38, 38, 38);
		textSize = 40;
		edgeCurve = 25;
	}
	
	public Button(String name, int shape, double y, double width, double height) {
		this.name = name;
		this.buttonShape = shape;
		this.y = y;
		this.width = width;
		this.height = height;
		x = Main.WINDOW_WIDTH/2 - width/2;
		color = new Color(135, 206, 255);
		highlightColor = new Color(38, 38, 38);
		textSize = 40;
		edgeCurve = 25;
	}
	
	public void draw(PApplet marker) {

		marker.fill(color.getRed(), color.getGreen(), color.getBlue());

		if (buttonShape == RECTANGLE) {
			rectangleButton = new Rectangle2D.Double(x, y, width, height);
			marker.rect((float) x, (float) y, (float) width, (float) height, edgeCurve);
		}

		if (buttonShape == CIRCLE) {
			circleButton = new Ellipse2D.Double(x, y, width, height);
			marker.ellipse((float) x, (float) y, (float) width, (float) height);
		}
		
		if (buttonShape == GHOST) {
			rectangleButton = new Rectangle2D.Double(x, y, width, height);
			int margin = 4;
			marker.fill(highlightColor.getRed(), highlightColor.getGreen(), highlightColor.getBlue());
			marker.rect((float) (x - margin), (float) (y - margin), (float) (width + margin * 2), (float) (height + margin * 2));
			marker.fill(38, 38, 38);
			marker.noStroke();
			marker.rect((float) x, (float) y, (float) width, (float) height);
		}
		
		marker.fill(255);
		marker.textSize(textSize);
		marker.textAlign(marker.CENTER, marker.CENTER);
		marker.text(name, (float) (x + (width) / 2), (float) (y + (height) / 2));

	}

	public boolean isPointInside(double x, double y) {
		if (buttonShape == RECTANGLE) {
			return rectangleButton.contains(new Point2D.Double(x, y));
		}

		if (buttonShape == CIRCLE) {
			return circleButton.contains(new Point2D.Double(x, y));
//			double centerX = this.x + width / 2, centerY = this.y + height / 2;
//			if ((Math.pow((x - centerX), 2) / Math.pow((width / 2), 2))
//					+ (Math.pow((y - centerY), 2) / Math.pow((height / 2), 2)) <= 1) {
//				return true;
//			} else{
//				return false;
//			}
		}
		
		if (buttonShape == GHOST) {
			return rectangleButton.contains(new Point2D.Double(x, y));
		}
		
		return false;
	}

	// GETTERS AND SETTERS

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getHighlightColor() {
		return highlightColor;
	}

	public void setHighlightColor(Color highlightColor) {
		this.highlightColor = highlightColor;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getTextSize() {
		return textSize;
	}
	
	public void setTextSize(int textSize) {
		this.textSize = textSize;
	}
	
	public void setEdgeCurve(int edgeCurve) {
		this.edgeCurve = edgeCurve;
	}
	
}


