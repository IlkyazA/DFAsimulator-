import java.io.*;
import java.util.*;
public class Dfasimulator{

public String[][] TransitionTable=new String[20][20];
public String [] statebets=new String[20];
ArrayList<String>finalstates = new ArrayList<String>();
public int alphaset,stateset;
public ArrayList<Character> alphabet;

public int indexy;
public void builddfa() throws Exception{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.println("please enter the no. of alphabets in the alphabet set of DFA");
alphaset=Integer.parseInt(br.readLine());

System.out.println("please enter the no. of states in the set of DFA");
stateset=Integer.parseInt(br.readLine());

Scanner sc= new Scanner(System.in);

System.out.println("please enter the states of the DFA one by one(initial state first)");  // q0   q1
for(int j=0; j< stateset;j++)
{ 
	statebets[j] = sc.nextLine();

}
System.out.println("please enter all the alphabets of the DFA simultaneosly ");  // Eg: ab
String alphabets=br.readLine();


alphabet=new ArrayList<Character>();
for(int i=0;i<alphabets.length();i++){
alphabet.add(alphabets.charAt(i));
 }
System.out.println(alphabet);

Scanner sc2= new Scanner(System.in);

System.out.println("Enter the transition for the given states");
for(int s=0;s<stateset;s++)
{
	System.out.println("for state" + " " + statebets[s]);
	for(int q=0 ; q< alphaset ; q++)
		{System.out.println("on input" + " " +alphabets.charAt(q) + " to state");	
	
	TransitionTable[s][q] = sc2.nextLine();
		}
}
System.out.println("Result of transition table : ");
for(int s=0; s<stateset;s++)
	{System.out.println(" ");
	for(int q=0;q<alphaset;q++)
	System.out.print(TransitionTable[s][q] + " | " + " ");}

System.out.println("");
System.out.println("please enter the final states of the DFA\n");
System.out.println("when you are done of giving the inputs enter x to stop feeding final states");



Scanner sc3 = new Scanner(System.in);
String  finalState = sc3.nextLine();
finalstates.add(finalState);
while(!finalState.contains("x"))
{
	
	finalState = sc3.nextLine();
}
System.out.println(finalstates);
DfaTest();
} 

public void DfaTest()throws Exception{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String state=null;
int indexx=0;
String state2 = null;
System.out.println("enter the starting state");
state=br.readLine();

System.out.println("give input to the DFA\n");
System.out.println("end your input with # character\n");
String input=br.readLine();
int index=0;

for(int i=0;i<stateset;i++)
{
	String temp= state;
if(temp== statebets[i]) //   start state = q0 string arrayi = q0,q1   indexx = 0
{ indexx = i;}
	}


while(input.charAt(index)!='#')
{
 char char1=input.charAt(index);

 
 
 int index1=alphabet.indexOf(char1); 
 

////alfabedeki indexi al

 state2=TransitionTable[indexx][index1];
 //System.out.println(state2);
 for(int i=0;i <stateset ;i++)
 {
//System.out.println("for a girdim");
//System.out.println(statebets[i]);
if(state2.equals(statebets[i]))
{ indexx= i; 
//System.out.println("index"+indexx);
}
 }

 index++; 
  }
 System.out.println("\nfinal state after giving the input is "+state2);
 if (finalstates.contains(state2))
   System.out.print("your input string is accepted by the DFA");
  else
   System.out.println("the input string is rejected by  the DFA");
}

public static void main(String args[])throws Exception{
Dfasimulator basla=new Dfasimulator();
basla.builddfa();

  }
}