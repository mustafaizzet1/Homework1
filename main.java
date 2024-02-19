
import java.io.*;
import java.util.*;


public class main {
	static int score(Object wheel,int random,int score,int scrcounter) {//score
		if(random!=0&&random!=1&&scrcounter>0) {
			score=score+(scrcounter*(int)wheel);	
		}
		else {
		if(scrcounter>0&&"Double Money"==(String)wheel)
				score=score*2;
		else if(random==0&&scrcounter==0&&"Bankrupt"==(String)wheel){
				score=0;		
		}
		}
		return score;
	}
	static void addWheel(Stack input) {//whell
		input.push(10);
		input.push(50);
		input.push(100);
		input.push(250);
		input.push(500);
		input.push(1000);
		input.push("Double Money");
		input.push("Bankrupt");
	}
	static Object wheel(Stack input,Stack temp,int random) {//randomly selected from the wheel
		Object wheel = null;
		int counter=0;
		while(!input.isEmpty()) {
			if(random==counter) {
				if(random!=0&&random!=1) {
					wheel=input.peek();
					break;
				}
				else {
					wheel=input.peek();
					break;
				}
				
			}
			else {
				temp.push(input.pop());
				counter++;
			}
			
					
		}
		counter=0;
		while(!temp.isEmpty()) {
			input.push(temp.pop());
		}
			
		return wheel;
	}
	static void writeQueue(int size,Queue tmpcountry) {//printing queue to the screen
		for (int i = 0; i <size; i++) {
			System.out.print(tmpcountry.peek());
			tmpcountry.enqueue(tmpcountry.dequeue());	
		}
	}
 	static void letter(Stack input) {//putting the letter into a stack
		for (int i = 90; i > 64; i--) {
			input.push((char)i);
		}
	}
	static void beginning(Queue input,int size) {
		for (int i = 0; i <size; i++) {
			input.enqueue('-');
		}
		
	}
	static Queue addQueue(int random,Stack countries) {////putting the country into a queue
		int counter=0;
		String tmpcountry="";
		while (!countries.isEmpty()) {
			tmpcountry=(String)countries.peek();	
			countries.pop();
			counter++;
			if(counter==random) 
				break;	
	}
		Queue country=new Queue(tmpcountry.length());
		for (int i = 0; i <tmpcountry.length(); i++) {
			country.enqueue(tmpcountry.charAt(i));	
		}
		return country;
	}
	static boolean control(Queue input,Queue tmp) {//Checking if the game is over
		int size=input.size();
		boolean flag=false;
		int counter=0;
		for (int i = 0; i < size; i++) {
			if((char) tmp.peek()==(char)input.peek())
			 {
				counter++;	
			}
			input.enqueue(input.dequeue());
			tmp.enqueue(tmp.dequeue());
			
			}
		if(counter==size)
			flag=true;
		
		return flag;
	}
	static int randomNumber(int num) {//random number determination
		Random r=new Random();
		int random=r.nextInt(num);
		return random;
	}
	static char randomLetter(Stack input,Stack temp,int random) {//random letter selection
		char letter=' ';
		int counter=0;
		while(!input.isEmpty()) {
			if(random==counter) {
				letter=(char)input.peek();
				input.pop();
				break;
			}
			else {
				counter++;
				if(input.size()>1) {
					temp.push(input.pop());
				}
				
				
			}
			
					
		}
		counter=0;
		while(!temp.isEmpty()) {
			input.push(temp.pop());
		}
			
		return letter;
		
	}
	static void readingScore(Stack score,Stack names,String txt) {//reading score file
		try 
		{        
		File file = new File(txt);
		Scanner x=new Scanner(file);
		while(x.hasNextLine())
		{
		String line=x.nextLine();
		int index=line.indexOf(" ");
		names.push(line.substring(0, index).toUpperCase(Locale.ENGLISH));
		score.push(Integer.parseInt(line.substring(index+1,line.length())));
		}
		x.close();
		} catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	static void writeLetter(Stack input) {//printing letters to the screen
		Stack tmpStack=new Stack(input.size());
		 while (!input.isEmpty()){ 
	            System.out.print(input.peek()); 
	            tmpStack.push(input.pop());
	        }
		 while (!tmpStack.isEmpty()){  
	            input.push(tmpStack.pop());
	        }
		 
	}
	static void printingScoreTable(Stack input,Stack names) {//printing score table to the file
		Stack tmpStack=new Stack(input.size());
		Stack tmpNames=new Stack(names.size());
		 while (!input.isEmpty()){ 
	            System.out.println(names.peek()+"   "+input.peek()); 
	            tmpStack.push(input.pop());
	            tmpNames.push(names.pop());
	        }
		 while (!tmpStack.isEmpty()){  
	            input.push(tmpStack.pop());
	            names.push(tmpNames.pop());
	        }
		
	}
	static void sortScore(Stack scores,Stack names,Stack tmpScore,Stack tmpNames) {
		 String peek=" ";
		 int peek1=1;
		while(!scores.isEmpty())
        {
			int tmp = (int)scores.pop();
            String name=(String)names.pop();
         
            while(!tmpScore.isEmpty() && (int)tmpScore.peek()> tmp)
            {  
            scores.push(tmpScore.pop());
            names.push(tmpNames.pop());
            if(!tmpScore.isEmpty()&&(int)tmpScore.peek()<tmp)
            	break;
            }
            if(!tmpScore.isEmpty()&&!tmpNames.isEmpty()) {
            	 peek=(String)tmpNames.peek();
                 peek1=(int)tmpScore.peek();
            }
           
            tmpScore.push(tmp);
            tmpNames.push(name);
            if(!tmpScore.isEmpty()&&(int)peek1==tmp&&peek=="Player") {
            	
            	names.push(tmpNames.pop());
            	tmpNames.pop();
            	tmpNames.push(names.peek());
            	tmpNames.push("Player");
            }
            
        }
       
		
		
		
	}
	static Stack sortString(Stack input){  //sorting for country
	    Stack tmpStack=new Stack(195);
	    
	    while(!input.isEmpty()){ 
	        String tmp = (String)input.pop(); 
	        String peek=(String)tmpStack.peek();
	        while(!tmpStack.isEmpty() && tmp.compareTo(peek)>0){ 
	            input.push(tmpStack.pop());
	            peek=(String)tmpStack.peek();
	            if(!tmpStack.isEmpty()&&tmp.compareTo(peek)<0)
	            	break;
	        } 
	          
	        tmpStack.push(tmp); 
	    } 
	    return tmpStack;
	} 
	static void reading(Stack countries,String txt) {//file reading
			try 
			{        
			File file = new File(txt);
			Scanner x=new Scanner(file);
			while(x.hasNextLine())
			{
			String line=x.nextLine();
			countries.push(line.toUpperCase(Locale.ENGLISH));
			}
			x.close();
			} catch (FileNotFoundException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
				
			}
	static int addLetter(Queue input,Queue tmp,char letter) {//adding correct word into the queue
		int counter=0;
		int counter2=0;
		int counter3=0;
		int size=input.size();
		
	for (int i = 0; i < size; i++) {
		char tmpletter=(char)input.peek();
		if(tmpletter==letter) {
			counter++;
			for (int j = 0; j <size; j++) {
				counter2++;
				if(counter2==counter) {
					counter3++;
					tmp.dequeue();
					tmp.enqueue(letter);
				}
				else {
					tmp.enqueue(tmp.dequeue());
				}
			}
			
			counter2=0;
			counter--;
			
		}
		counter=(counter+1)%size;
		input.enqueue(input.dequeue());
	}
	return counter3;
	}
	static void fileWriter(String txt,Stack scores,Stack names) throws IOException {//writing score table to the file
		Stack tmpStack=new Stack(scores.size());
		Stack tmpNames=new Stack(names.size());
		File file=new File(txt);
		if(!file.exists()) {
			file.createNewFile();
		}
		FileWriter fWriter=new FileWriter(file,false);
		BufferedWriter bWriter=new BufferedWriter(fWriter);
		while(!scores.isEmpty()) {
			bWriter.write(names.peek()+" "+scores.peek());bWriter.newLine();
			 tmpStack.push(scores.pop());
	         tmpNames.push(names.pop());
		}
		while (!tmpStack.isEmpty()){  
            scores.push(tmpStack.pop());
            names.push(tmpNames.pop());
        }
		
		bWriter.close();
	}
	public static void main(String[] args) throws IOException {
		Stack countries=new Stack(195);
		Stack wheel=new Stack(8);
		Stack tmpwheel=new Stack(8);
		Stack letters=new Stack(26);
		Stack tmpletters=new Stack(26);
		Stack names=new Stack(11);
		Stack Scores=new Stack(11);
		Stack tmpNames=new Stack(11);
		Stack tmpScores=new Stack(11);
		readingScore(Scores, names,"HighScoreTable.txt");
		letter(letters);
		reading(countries,"countries.txt");
		Stack tmpStack=sortString(countries);
		//write(tmpStack);
		
		int r=randomNumber(195);
		
		int score=0;
		Queue country=addQueue(r, tmpStack);
		int size=country.size();
		Queue tmpcountry=new Queue(size);
		beginning(tmpcountry, size);
		addWheel(tmpwheel);
		
		System.out.println();
		System.out.println("Randomly generated number: "+r);
		int step=1;
		int counter1=27;
		while(!control(country, tmpcountry)){
			
			
			int scorerndm=randomNumber(8);
			int l=randomNumber(counter1);
			char letter=randomLetter(letters, tmpletters,l);
			System.out.println();
			int scrcounter=addLetter(country, tmpcountry, letter);
			Object wheel1=wheel(tmpwheel, wheel, scorerndm);
			score=score(wheel1, scorerndm, score,scrcounter);
			System.out.println("whell: "+wheel1);
			System.out.print("Guess  "+letter);
			System.out.print("              step: "+step+"            "+"score: "+score+"              ");
			writeLetter(letters);
			System.out.println();
			writeQueue(size, tmpcountry);
			step++;
			counter1--;
		}
		System.out.println();
		System.out.println("You win  "+score+"$");
		Scores.push(score);
		names.push("Player");
		sortScore(Scores, names, tmpScores, tmpNames);
		printingScoreTable(tmpScores, tmpNames);
		fileWriter("HighScoreTable.txt", tmpScores, tmpNames);
	}
	

}
