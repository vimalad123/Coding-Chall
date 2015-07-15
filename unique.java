# Coding-Chall


    import java.io.*;
    import java.util.*;

    class words{
    String word;
    int count;
    }
    public class CountRepeatedWords{
    static Hashtable h=new Hashtable();
    static words w;
    static void countWords(String s){
    if((w=(words)h.get((java.lang.Object)s))==null){
    w=new words();
    w.word=s;
    w.count=1;
    h.put(s,w);
    }else{
    w.count++;
    h.remove(s);
    h.put(s,w);
    }


    }

    public static void main(String args[]){
    DataInputStream dis=null;
    String s;
    StringTokenizer st;
    String t;
    try{
    if(args.length>1)
    dis=new DataInputStream(new FileInputStream(args[0]));
    else
    dis=new DataInputStream(new FileInputStream("Word.java"));
    s=dis.readLine();
    while(s!=null){
    st=new StringTokenizer(s," "); 
    while(st.hasMoreTokens()){
    t=st.nextToken();
    countWords(t);
    }
    s=dis.readLine();
    }
    }catch(Exception e){
    e.printStackTrace();
    }
    Enumeration e=h.elements();
    w=(words)e.nextElement();
    while(e.hasMoreElements()){
    System.out.println("["+w.count+"]"+w.word);
    w=(words)e.nextElement();

    }
    }
    } 

