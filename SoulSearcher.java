import java.util.*;
class Node{
    public char data;
    public int count;
    public List<Node> child;
   
    Node(){
        this.count=0;
        this.child=new ArrayList<Node>();
    }

    Node(char c){
        this.data=c;
        this.count=0;
        this.child=new ArrayList<Node>();
    }
    boolean contains(char c){
        for(int i=0;i<count;i++){
            if(this.child.get(i).data==c){
                return true;
            }
        }
        return false;
    }
    
    Node get(char c){
        for(int i=0;i<count;i++){
            if(this.child.get(i).data==c){
                return child.get(i);
            }
        }
        return null;}
}

public class Trie{
    public Node root;
    public List<String> suggestionArray=new ArrayList<>();
    void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(curr.contains(c)){
               curr=curr.get(c); 
            }else{
                Node newNode=new Node(c);
                curr.child.add(newNode);
                curr.count++;
                curr=newNode;
            }
        }
    }
    public String output; 
    void perfman(Node curr){
        if(curr.count==0) return;
        for(int i=0;i<curr.count;i++){
            output.concat(curr.child.get(i).data.toString());
            perfman(curr.child.get(i));
        }
    }

    void print(String c){
        Node curr=root;
        output=new String(); 
        for(int i=0;i<c.length();i++){
            if(curr.contains(c.charAt(i))){
                output.concat(toString(c.charAt(i)));
                curr=curr.get(toString(c.charAt(i)));
            }else{
                System.out.println("not found");
                return;
            }

        }
        perfman(curr);
        suggestionArray.add(output);
        printarr(); 
    }
    
    void printarr(){
        for(int i=0;i<suggestionArrary.size();i++){
            System.out.println(suggestionArray[i]);
        }
    }

    void delete(String word){

    }
    public static void main(String[] args){
        Trie t=new Trie();
        t.insert("cat");
        t.insert("bat");
        t.insert("ass");
        t.insert("jerk");
        t.insert("never");
        t.insert("yes");
        System.out.println("Enter a word to search");
        Scanner sc=new Scanner(System.in);
        String s=sc.nextByte().toString();
        t.print(s);
    }
}
