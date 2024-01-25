//Books
import java.util.*;
class Books {
    private String title;
    private String author;
    private double price;
    private String publisher;
    private int stockPosition;

    public Books(String title, String author, double price, String publisher, int stockPosition) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publisher = publisher;
        this.stockPosition = stockPosition;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public double getPrice() {
        return price;
    }
    public String getPublisher() {
        return publisher;
    }
    public int getStockPosition() {
        return stockPosition;
    }

    public void sellCopies(int copies) {
        if (stockPosition >= copies) {
            stockPosition -= copies;
            System.out.println("Total cost: $" + (price * copies));
        } else {
            System.out.println("Required copies not in stock");
        }
    }

    public static void main(String[] args) {
        Books book1 = new Books("Book1", "Author1", 10.99, "Publisher1", 5);
        Books book2 = new Books("Book2", "Author2", 15.99, "Publisher2", 10);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter title of the book: ");
        String title = scanner.nextLine();
        System.out.print("Enter author of the book: ");
        String author = scanner.nextLine();

        if (title.equals(book1.getTitle()) && author.equals(book1.getAuthor())) {
            System.out.println("Book found!");
            System.out.print("Enter number of copies required: ");
            int copies = scanner.nextInt();
            book1.sellCopies(copies);
        } else if (title.equals(book2.getTitle()) && author.equals(book2.getAuthor())) {
            System.out.println("Book found!");
            System.out.print("Enter number of copies required: ");
            int copies = scanner.nextInt();
            book2.sellCopies(copies);
        } else {
            System.out.println("Book not found!");
        }
    }
}
//hotelmanagementsystem
import java.util.Scanner;

class DaysReservedException extends Exception {
    public DaysReservedException(String message) {
        super(message);
    }
}
class Hotel {
    private String name;
    private int stars;
    public static int availableRooms;

    public Hotel(String name, int stars, int availableRooms) {
        this.name = name;
        this.stars = stars;
        this.availableRooms = availableRooms;
    }

    public void displayAvailableRooms() {
        System.out.println("Available rooms: " + availableRooms);
    }
}
class Room {
    private int roomId;
    private double price;
    private String type;

    public Room(int roomId, String type) {
        this.roomId = roomId;
        this.type = type;
        setPrice();
    }
    private void setPrice() {
        switch (type.toLowerCase()) {
            case "single":
                this.price = 2000.00;
                break;
            case "double":
                this.price = 3500.00;
                break;
            case "triple":
                this.price = 5000.00;
                break;
            default:
                System.out.println("Invalid room type!");
        }
    }
    public double getPrice() {
        return price;
    }
    public int getRoomId() {
        return roomId;
    }
    public String getType() {
        return type;
    }
}
class Resident {
    private int id;
    private String name;
    private int daysToStay;
    private Room room;
    private double finalCost;

    public Resident(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public void reserveRoom(Room room, int daysToStay) throws DaysReservedException {
        if (daysToStay < 1) {
            throw new DaysReservedException("Number of days reserved must be at least 1");
        }
        this.room = room;
        this.daysToStay = daysToStay;
        calculateFinalCost();
    }
    private void calculateFinalCost() {
        finalCost = room.getPrice() * daysToStay;
    }
    public void displayResidentInfo() {
        System.out.println("Resident ID: " + id);
        System.out.println("Resident Name: " + name);
        System.out.println("Days to stay: " + daysToStay);
        System.out.println("Room ID: " + room.getRoomId());
        System.out.println("Room Type: " + room.getType());
        System.out.println("Final Cost: LKR " + finalCost);
    }
}
public class HotelManagementSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Sample Hotel", 4, 3);
        Scanner scanner = new Scanner(System.in);

        hotel.displayAvailableRooms();
        Room singleRoom = new Room(101, "Single");
        Room doubleRoom = new Room(102, "Double");
        Room tripleRoom = new Room(103, "Triple");

        Resident resident1 = new Resident(1, "John Doe");
        try {
            resident1.reserveRoom(singleRoom, 5);
            Hotel.availableRooms--;
            resident1.displayResidentInfo();
        } catch (DaysReservedException e) {
            System.out.println(e.getMessage());
        }

        hotel.displayAvailableRooms();
        Resident resident2 = new Resident(2, "Jane Smith");
        try {
            resident2.reserveRoom(doubleRoom, 3);
            Hotel.availableRooms--;
            resident2.displayResidentInfo();
        } catch (DaysReservedException e) {
            System.out.println(e.getMessage());
        }

        hotel.displayAvailableRooms();
        Resident resident3 = new Resident(3, "Alice Johnson");
        try {
            resident3.reserveRoom(tripleRoom, 7);
            Hotel.availableRooms--;
            resident3.displayResidentInfo();
        } catch (DaysReservedException e) {
            System.out.println(e.getMessage());
        }
        hotel.displayAvailableRooms();
        scanner.close();
    }
}
//largest
import java.util.Scanner;

public class Large {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        if (n < 2) {
            System.out.println("At least two values are required.");
            return;
        }
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        System.out.println("Largest number: " + largest);
        System.out.println("Second largest number: " + secondLargest);
    }
}
//carexcibition
abstract class Car {
    double price;
    int year;

    public Car(double price, int year) {
        this.price = price;
        this.year = year;
    }
    public abstract double calculateSalePrice();
}
class ClassicCar extends Car {
    public ClassicCar(double price, int year) {
        super(price, year);
    }
	
    @Override
    public double calculateSalePrice() {
        return price + 10000;
    }
}
class SportCar extends Car {
    public SportCar(double price, int year) {
        super(price, year);
    }

    @Override
    public double calculateSalePrice() {
        if (year > 2015) {
            return price * 1.75;
        } else if (year > 2005) {
            return price * 1.5;
        } else {
            return price * 1.25;
        }
    }
}

class CarExhibition {
    Car[] cars;

    public CarExhibition(Car[] cars) {
        this.cars = cars;
    }
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Car car : cars) {
            totalPrice += car.calculateSalePrice();
        }
        return totalPrice;
    }
}

public class Maain {
    public static void main(String[] args) {
        ClassicCar classicCar = new ClassicCar(50000, 1995);
        SportCar sportCar = new SportCar(60000, 2010);

        Car[] cars = {classicCar, sportCar};
        CarExhibition exhibition = new CarExhibition(cars);
        System.out.println("Total price of all cars in the exhibition: $" + exhibition.getTotalPrice());
    }
}

//int to roman
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Convert integer to Roman numeral");
        System.out.println("2. Convert Roman numeral to integer");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                System.out.println("Enter an integer to convert to Roman numeral:");
                int number = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Roman numeral: " + intToRoman(number));
                break;
            case 2:
                System.out.println("Enter a Roman numeral to convert to integer:");
                String roman = scanner.nextLine();
                System.out.println("Integer value: " + romanToInt(roman));
                break;
            default:
                System.out.println("Invalid option");
        }
    }
    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num - values[i] >= 0) {
                sb.append(symbols[i]);
                num -= values[i];
            } else {
                i++;
            }
        }
        return sb.toString();
    }
    public static int romanToInt(String s) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int result = 0;
        int i = 0;
        for (int j = 0; j < symbols.length; j++) {
            while (s.startsWith(symbols[j])) {
                result += values[j];
                s = s.substring(symbols[j].length());
            }
        }
        return result;
    }
}
//marks
import java.util.*;

public class menu{
	public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	int ans;
	int quiz_marks;
	int ass_marks;
	int mid_marks;
	int final_marks;
	do{
		System.out.print("Enter student's reg number: ");
		String reg_no = input.next();
		do{
			System.out.print("Enter the quiz score: ");
			quiz_marks = input.nextInt();
			if(quiz_marks>10){
				System.out.println("Invalid input");
			}
		}while(quiz_marks>=10);
		
	    do{
		    System.out.print("Enter the assignment score: ");
	    	ass_marks = input.nextInt();
		    if(ass_marks>10){
			    System.out.println("Invalid input");
		    }
	    }while(ass_marks>=10);
	
	    do{
			System.out.print("Enter the mid-term score: ");
			mid_marks = input.nextInt();
			if(mid_marks>20){
				System.out.println("Invalid input");
			}	
		}while(mid_marks>=20);
		
		do{
			System.out.print("Enter the final exam score: ");
			final_marks = input.nextInt();
			if(final_marks>=60){
				System.out.println("Invalid input");
			}
		}while(final_marks>=60);
		
		int total_marks = (quiz_marks+ass_marks+mid_marks+final_marks);
		System.out.println("Total marks: "+ total_marks);
		
		if(total_marks>=35){
			System.out.println("Grade: Pass");
		}else{
			System.out.println("Grade: Fail");
		}
		
		System.out.println("\nDo you want another student's detail??? (1/0)");
		ans = input.nextInt();
	}while(ans==1);
	}
}
//publication
interface Publication {
    void getData();
    void print();
}
interface Book extends Publication {
    void getData();
    void print();
}
interface Magazine extends Publication {
    void getData();
    void print();
}

class Journal implements Publication {
    private String name;

    Journal(String name) {
        this.name = name;
    }

    @Override
    public void getData() {
        System.out.println("Journal Name: " + name);
    }
    @Override
    public void print() {
        System.out.println("Printing Journal: " + name);
    }
}
public class Nain {
    public static void main(String[] args) {
        Journal journal1 = new Journal("Journal 1");
        Journal journal2 = new Journal("Journal 2");
        Journal journal3 = new Journal("Journal 3");
        Journal journal4 = new Journal("Journal 4");
        Journal journal5 = new Journal("Journal 5");

        Publication[] journals = {journal1, journal2, journal3, journal4, journal5};
        for (Publication journal : journals) {
            journal.getData();
            journal.print();
            System.out.println();
        }
    }
}
//prime or nnot
import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            System.out.print("Enter the number: ");
            int number = scanner.nextInt();
            boolean isPrime = isPrimeNumber(number);
            if (isPrime) {
                System.out.println(number + " is a prime number");
            } else {
                System.out.println(number + " is not a prime number");
            }
            System.out.print("Do you want to check another number (y/n): ");
            choice = scanner.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');

        System.out.println("End");
    }

    // Function to check if a number is prime
    private static boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
//gpa
public class test{
	public static void main(String[] args){
		Student S1=new Student();
		Employee S2=new Employee();
		S1.setName("Priya");
		S2.setName("Thiyagu");
		System.out.println(S1.toString());
		System.out.println(S2.toString());
	}
}
abstract class Person{
	String name;
	String NICNum;
	
	void setName(String name){
		this.name=name;
	}
	String getName(){
		return this.name;
	}
	void setNICNum(String NICNum){
		this.NICNum=NICNum;
	}
	String getNICNum(){
		return this.NICNum;
	}
	public String toString(){
		return name+"\n"+NICNum;
	}
}
class Student extends Person{
	String regNo;
	String status;
	float gpa;
	Student(){
		
	}
	
	Student(String regNo, String status, float gpa, String name, String NICNum){
		this.regNo=regNo;
		this.status=status;
		this.gpa=gpa;
		super.name=name;
		super.NICNum=NICNum;
	}
	void setregNo(String regNo){
		this.regNo=regNo;
	}
	String getregNo(){
		return this.regNo;
	}
	void setStatus(String status){
		this.status=status;
	}
	String getStatus(){
		return this.status;
	}
	void setgpa(float gpa){
		this.gpa=gpa;
	}
	float getgpa(){
		return this.gpa;
	}
	public String toString(){
		return name+"\n"+getClass();
	}
}
class Employee extends Person{
	String empNo;
	int hire_Year;
	String dept;
	double salary;
	Employee(){
		
	}
	Employee(String empNo, int hire_Year, String dept, double salary){
		this.empNo=empNo;
		this.hire_Year=hire_Year;
		this.dept=dept;
		this.salary=salary;
	}
	void setempNo(String empNo){
		this.empNo=empNo;
	}
	String getempNo(){
		return this.empNo;
	}
	void sethire_year(int hire_Year){
		this.hire_Year=hire_Year;
	}
	int gethire_year(){
		return this.hire_Year;
	}
	void setdept(String dept){
		this.dept=dept;
	}
	String getdept(){
		return this.dept;
	}
	void setsalary(double salary){
		this.salary=salary;
	}
	double getsalary(){
		return this.salary;
	}
	public String toString(){
		return name+"\n"+getClass();
	}
}
//palindrome
class palindrome {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a string as an input to check whether it is palindrome or not");
        String input= scanner.nextLine();
        //checking whether palindrome or not
        if(isPalindrome(input))
        {
            System.out.println(input+" is a palindrome string");
        }
        else
        {
            System.out.println(input+" is not a palindrome string");
        }
    }
 
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        
        while(left < right)
        {
            if(str.charAt(left) != str.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    } 
}
//shape
public class menu{
	public static void main(String[] args){
		Triangle t1 = new Triangle(12,3,2,3,3);
		System.out.println(t1.getArea() + "\n" + t1.getCircumference());
	}
}
class Shape{
}

abstract class TwoDimensional extends Shape{
	String type;
	double height;
	abstract double getArea();
	abstract double getCircumference();
	TwoDimensional(){
		
	}
}
abstract class ThreeDimensional extends Shape{
	String type;
	double height;
	abstract double getSurface();
	abstract double getVolume();
}
class Triangle extends TwoDimensional{
	
	double Base;
	double side1;
	double side2;
	double side3;
	
	Triangle(double height, double Base, double side1, double side2, double side3){
		super.type="Triangle";
		this.Base = Base;
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		super.height = height;
	}
	
	double getArea(){
		return 0.5 * height * Base;
	}
	double getCircumference(){
		return side1 + side2 + side3;
	}
}
class Rectangle extends TwoDimensional{
	String type;
	double width;
	
	Rectangle(double height, double width){
		super.type="Rectangle";
		this.width = width;
		super.height = height;
	}
	
	double getArea(){
		return height*width ;
	}
	double getCircumference(){
		return 2*(height+width);
	}
}
class Circle extends TwoDimensional{
	String type;
	double radius;
	
	Circle(double radius){
		super.type="Circle";
		this.radius = radius;
	}
	
	double getArea(){
		return 3.14*radius*radius;
	}
	double getCircumference(){
		return 2*3.14*radius;
	}
}
class Box extends ThreeDimensional{
	String type;
	double width;
	double length;
	Box(double width, double length, double height){
		super.type="Box";
		this.width = width;
		this.length = length;
		super.height = height;
	}
	double getSurface(){
		return 2*(height*width + width*length + length*height);
	}
	double getVolume(){
		return height*width*length;
	}
}
class Cone extends ThreeDimensional{
	String type;
	double radius;
	
	Cone(double radius, double height){
		super.type="Cone";
		this.radius = radius;
		super.height = height;
	}
	double getSurface(){
		return 2*3.14*radius*(radius+height);
	}
	double getVolume(){
		return 1/3.0*3.14*radius*radius*height;
	}
}
class Cylinder extends ThreeDimensional{
	String type;
	double radius;
	
	Cylinder(double radius, double height){
		super.type="Cylinder";
		this.radius = radius;
		super.height = height;
	}
	double getSurface(){
		return 2*3.14*radius*(radius+height);
	}
	double getVolume(){
		return 3.14*radius*radius*radius;
	}
}
class Sphere extends ThreeDimensional{
	String type;
	double radius;
	
	Sphere(double radius){
		super.type="Sphere";
		this.radius = radius;
	}
	double getSurface(){
		return 4*3.14*radius*radius;
	}
	double getVolume(){
		return 4/3.0*3.14*radius*radius*radius;
	}
}
//circle
class cylinder extends circle{
    double height;
    cylinder(double r ,double h) {
        super(r);
        this.height=h;
    }
    public void Volume()
    {
        System.out.println("volume of cylinder:"+super.computrArea()*height);
    }
    public void AreaofCylinder()
    {
        System.out.println("Area of cylinder is:"+((2*super.computrArea())+super.Perimetor()*height));
    }
}
public class Main{
     public static void main(String args[]) throws InterruptedException {
         cylinder c=new cylinder(10.340,30.890);
         System.out.println("area of circle:"+c.computrArea());
         System.out.println("perimetor of circle:"+c.Perimetor());
        c.AreaofCylinder();
        c.Volume();
     }
}