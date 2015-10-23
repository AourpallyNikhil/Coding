package test;


interface Shape{
	
	public void draw();
}

class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println("Draw circle");
	}
}


class Rectangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Draw Rectangle");
}
}

class Square implements Shape{
	@Override
	public void draw() {
		System.out.println("Draw Rectangle");
	
}
}	
class ShapeFactory {
	public Shape getShape(String shapeName){
		if (shapeName == null){
			return null;
		}
		if(shapeName == "Circle"){
			return new Circle();
		}else if(shapeName == "Square"){
			return new Square();
		}else if(shapeName == "Rectangle"){
			return new Rectangle();
		}
		return null;
	}
}	


class FactoryPattern{
	public static void main (String[] args){
		ShapeFactory factory = new ShapeFactory();
		Shape test = factory.getShape("Circle");
		test.draw();
	}
}

