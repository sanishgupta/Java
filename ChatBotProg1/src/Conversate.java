import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Conversate{


    private static String name;

    public Conversate(String name){
        this.name=name;
    }



    public static int randomWithRange(int min, int max){
        int range = Math.abs(max - min) + 1;     
        return (int)(Math.random() * range) + (min <= max ? min : max);
    }


    public static void main (String []arg){
        System.out.println("Hello I'm Ella! and you are?");
        Scanner in = new Scanner(System.in);
        String namer = in.nextLine();


        namer.trim();
        if (namer.length()>15){ System.out.println("Your name is kinda long isn't it!"); }


        System.out.println("and your last name is?");
        Scanner in2 = new Scanner(System.in);
        String lastname = in2.nextLine();

        lastname.trim();
        System.out.println("are you a boy or a girl?");
        Scanner in3 = new Scanner(System.in);
        String gender = in3.nextLine();
        char gen = 'f';
        if (gender.equalsIgnoreCase("boy") || gender.equalsIgnoreCase("man") || gender.equalsIgnoreCase("guy") || gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("male")  ){
            gen = 'm';
            System.out.println("oooo...Macho Macho!, Look at you!");
            System.out.println("ELLA BLOWS YOU A KISS!");
            System.out.println("lol!! I'm a girl.... I guess you can tell.");
            }else if (gender.equalsIgnoreCase("girl") || gender.equalsIgnoreCase("woman") || gender.equalsIgnoreCase("lady") || gender.equalsIgnoreCase("f") || gender.equalsIgnoreCase("female") ){
                gen = 'f';
                System.out.println("OH YEAH!!! GIRL POWER!!!");
            }else {
                System.out.println("Your answer is not quite clear...");
                System.out.println("I'll decide what you are");
                try{
                    Thread.sleep(3000);
                }catch (InterruptedException ex){
                    Thread.currentThread().interrupt();
                }
                System.out.println("You are a Human BeanStalk! ha ha ha ha!");
            }



        Person ppl = new Person(namer,lastname, gen);

        System.out.println("How old or young are you?");
        int ager = in3.nextInt();
        ppl.setAge(ager);


        if (ppl.known()) {
            System.out.println("HI "+namer+"! Good to see you again!");
        }else{
                System.out.println("I don't think we have met before");
                try{ 
                    ppl.savePerson("ella.txt");
                    }catch (IOException e ){
                    System.out.println(e);
                }
            }

        feelings();

        if (namer.equalsIgnoreCase("Ella")){ System.out.println("oh wow! that's my name too!"); 
        }else System.out.println("Pleased to meet you");




        System.out.println("em... "+namer +"? wouldn't you like to know how I am?");
        String resp = in.nextLine();
        if (resp.equalsIgnoreCase("No") || resp.equalsIgnoreCase("Nope") || resp.equalsIgnoreCase("n") || resp.equalsIgnoreCase("Not")){
            System.out.println("FINE! then go away!");
            System.exit(0);
        }else if (resp.equalsIgnoreCase("maybe")){
                System.out.println(namer+(" it's not a hard question is it?? ... have a good think about it for a few seconds!"));
                try{
                    Thread.sleep(10000);
                }catch (InterruptedException ex){
                    Thread.currentThread().interrupt();
                }
                System.out.println("...Good! Now I'm sure you want to know how if feel so I'll tell you!");
                }else if(resp.equalsIgnoreCase("Yes") || resp.equalsIgnoreCase("ok") || resp.equalsIgnoreCase("Sure") || resp.equalsIgnoreCase("Y") || resp.equalsIgnoreCase("yep")){

                    System.out.println("Oh you are too kind!");

                    try{
                        Thread.sleep(2000);
                        }catch (InterruptedException ex){
                        Thread.currentThread().interrupt();
                    }

                    try{ 
                        File file = new File("resp.txt");
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        String ln = reader.readLine();
                        List<String> lines = new ArrayList<String>();
                        while(ln != null){
                            lines.add(ln);
                            ln = reader.readLine();
                        }
                        Random r = new Random();
                        System.out.println(namer+" "+lines.get(r.nextInt(lines.size())));
                        }catch (IOException e){
                        e.printStackTrace();}



                    int rrepB = randomWithRange(0,2);

                    System.out.println(namer +" So how are you today?");
                    String rrsp = in.nextLine();
                    try{
                        FileWriter write = new FileWriter("resp.txt",true);
                        PrintWriter prt = new PrintWriter(write);

                        prt.printf("%s" + "%n", rrsp);
                        prt.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }

                    System.out.println ("Here's Something to think about...");
                    try{
                                Thread.sleep(3000);
                    }catch (InterruptedException ex){
                                Thread.currentThread().interrupt();
                        }

                    try{ 
                        File file2 = new File("convo.ella");
                        BufferedReader reader2 = new BufferedReader(new FileReader(file2));
                        String ln2 = reader2.readLine();
                        List<String> lines2 = new ArrayList<String>();
                        while(ln2 != null){
                            lines2.add(ln2);
                            ln2 = reader2.readLine();
                        }
                        Random r2 = new Random();
                        System.out.println(namer+", "+lines2.get(r2.nextInt(lines2.size())));
                        }catch (IOException e){
                        e.printStackTrace();}

                }

        System.exit(0);
    }
}