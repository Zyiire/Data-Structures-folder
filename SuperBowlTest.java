// Custom Exception
class StadiumMissingException extends Exception{
    public StadiumMissingException(String message){
        super(message);
    }
}


interface GameRules{
    void startGame();  //Abstract

    default void halftimeShow(){    //default method
        System.out.println("Half time show with famous performers! ");
}

static void showOfficialTime(){
    System.out.println("Official Super Bowl time: 6:30pm EST ");
    }
}

//Composition: where the super class owns the feild in this instance/ a team owns a playbook
class Playbook {
    public void showPlays(){
        System.out.println("Plays: Run, Pass, Trick Play! ");
        }
    }

    //abstract class with compositon

    abstract class SuperBowlTeam{
        protected String name;
        protected Playbook playbook = new Playbook(); //compositon
    
        public SuperBowlTeam(String name){
            this.name = name;
        }

        public abstract void scoreTouchDown(); // abstract method

        public void usePlaybook(){
            playbook.showPlays();
        }
    }

    class Patriots extends SuperBowlTeam implements GameRules{
        public Patriots(){
            super("New England Patriots ");
        }

        public void startGame(){
            System.out.println(name + "TAKE THE FEILD!! ");
        }

        public void scoreTouchDown(){
                        System.out.println(name + "SCORE A TOUCHDOWN!! ");
        }
    
    //recursion

        public void countdown(int n){
            if(n == 0){
                System.out.println("KICKOFF!! ");
                return;
            }
            System.out.println(n);
            countdown(n-1);
        }   
    }

    //Aggregation class: SuperBowl USES a Stadium
class Stadium{
    private String location;

    public Stadium(String location){
        this.location = location;
    }

    public String getLocation(){
        return location;
    }
}

class SuperBowl{
    private Stadium stadium; //aggregation if you take away the stadium it still exists

    public SuperBowl(Stadium stadium){
        this.stadium = stadium;
    }

    public void stratEvent()throws StadiumMissingException{
        if(stadium == null){
            throw new StadiumMissingException("Custom Error: Stadium is missing ");
        }
        System.out.println("Super Bowl at " + stadium.getLocation());
    }
}

public class SuperBowlTest{
    public static void main(String[] args){
        try{
            Stadium s = new Stadium("Las Vegas");
            SuperBowl sb = new SuperBowl(s); // aggregation

            Patriots patriots = new Patriots(); //subclass

            sb.stratEvent();//may throw an exception

            GameRules.showOfficialTime(); // static method
            patriots.startGame();
            patriots.halftimeShow();
            patriots.usePlaybook(); // Compostion
            
            patriots.countdown(3); //recursion
            
            patriots.scoreTouchDown();
            }catch(StadiumMissingException e){
                System.out.println(e.getMessage());
            }
    }
}



    