import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.awt.Point;
import java.awt.Rectangle;
import java.math.BigInteger;
public class Card {
    private final int rank;
    private final int suit;
    public static final String[] RANKS={
        null,"Ace","2","3","4"
        ,"5","6","7","8","9","10","Jack","Queen"
        ,"King"
    };
    public static final String[] SUITS={
        "Clubs","Diamonds","Hearts"
        ,"Spades"
    };
    public Card(int rank,int suit){
        this.rank=rank;
        this.suit=suit;
    }
    public String toString(){
        return RANKS[this.rank]+" of "+SUITS[this.suit];
    }
    public int compareTo(Card that){
        if(this.suit>that.suit){
            return 1;
        }
        if(this.suit<that.suit){
            return -1;
        }
        if(this.rank>that.rank){
            return 1;
        }
        if(this.rank<that.rank){
            return -1;
        }
        return 0;
    }
    public String compareTo1(Card that){
        String a="Bigger than";
        String b="Smaller than";
        String c="Equals to each other";
        if(this.suit>that.suit){
            return a;
        }
        if(this.suit<that.suit){
            return b;
        }
        if(this.rank==1&&that.rank>1){
            return a;
        }else if(this.rank>1&&that.rank==1){
            return b;
        }
        if(this.rank>that.rank){
            return a;
        }
        if(this.rank<that.rank){
            return b;
        }
        return c;
    }
    public int getRank(){
        return this.rank;
    }
    public int getSuit(){
        return this.suit;
    }
    public Card[] makeDeck(){
        Card[] cards=new Card[52];
        int index=0;
        for(int suit=0;suit<4;suit++){
            for(int rank=1;rank<14;rank++){
                cards[index]=new Card(rank,suit);
                index++;
            }
        }
        return cards;
    }
    public static void printDeck(Card[] cards){
        for(int i=0;i<cards.length;i++){
            System.out.println(cards[i]);
        }
    }
    public static void printDoubleDeck(Card[] cards,Card[] cards1){
        for(int i=0;i<cards1.length;i++){
            System.out.println(cards[i]+" -- "+cards1[i]);
        }
    }
    public Card[] randomDeck(){
        Random random=new Random();
        Card[] a=new Card[14];
        for(int i=0;i<14;i++){
            a[i]=new Card(random.nextInt(13),random.nextInt(4));
        }
        return a;
    }
    public static int[] suitHist(Card[] card){
        int[] a=new int[4];
        for(int i=0;i<card.length;i++){
            int index=card[i].suit;
            a[index]++;
        }
        return a;
    }
    public static void xianshi(int[] s){
        System.out.print("["+s[0]);
        for(int i=1;i<s.length-1;i++){
            System.out.print(","+s[i]);
        }
        System.out.println(","+s[s.length-1]+"]");
    }
    public static boolean hasFlush(Card[] card){
        int[] s=suitHist(card);
        for(int i=0;i<s.length;i++){
            if(s[i]>=5){
                return true;
            }
        }
        return false;
    }
    public static void main(String []args) {
        Card a=new Card(1,1);
        Card b=new Card(1,1);
        System.out.println(a.compareTo1(b));
        System.out.println(a);
        Card[] first=a.makeDeck();
        Card[] second=a.randomDeck();
        int[] c=a.suitHist(second);
        a.xianshi(c);
        System.out.println(hasFlush(second));
        a.printDoubleDeck(first,second);
    }
}

