import java.util.Scanner;
import java.lang.Math;
class Wordle {

public String todaysword;
public int trynum;

public Wordle(){
}

public String pickWord(){
  String word;
  if(trynum!=1){
    word = "invalid";
  }else{
    String [] strs = {"annoy", "hello","abuse",
    "adult","agent","anger","apple","award","basis","beach","birth","block","blood",
    "board","brain","bread","break","brown","buyer","cause","chain","chair","chest","chief","child","china"};
    double rand1 = Math.random();
    int rand = (int)(rand1 *strs.length);
    word = strs[rand];
  }
  return word;
}
public void startWordle(){
  trynum=1;
  int numLetters = 5;
  String g;
  int triesleft;
  todaysword=pickWord();
  for(int i = 1; i<numLetters+1; i++){
    g = guess();
    triesleft = 5-i;
    if (g.equalsIgnoreCase("TRUE")){
      break;
    }else{
      System.out.println("You are on your " + i + "th Try. " + triesleft + " Tries to go!");
    }
  }

}

public String guess(){
  Scanner myObj = new Scanner(System.in);
  String res;
  String tf;
  StringBuilder overlap =new StringBuilder();
  StringBuilder letterTF = new StringBuilder();
  System.out.println("Enter guess"); 
  res = myObj.nextLine(); 
  res = res.toLowerCase();
  for(int i = 0; i<res.length(); i++){
    if(res.length()!=todaysword.length()){
      System.out.println("FALSE");
      break;
    }
    String letter = Character.toString(res.charAt(i));
    if(todaysword.contains(letter)){
      overlap = overlap.append(letter);
    }
    if(res.charAt(i)==todaysword.charAt(i)){
      letterTF = letterTF.append("T");
    }else{
      letterTF = letterTF.append("F");
    }
  } 
  if(res.equalsIgnoreCase(todaysword)){
    System.out.println("that is correct!!");
    tf = "TRUE";
  
  }else{
    System.out.println(letterTF);
    System.out.println(overlap);
    tf = "FALSE";

  }
  return tf;
}

  public static void main(String[] args) {
    Wordle wrd = new Wordle();
    wrd.startWordle();

  }
}

