
/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver
{
    public static void main(String[] args){
        //create owner
        Person owner = new Person("Julia", "hello");
        //create house
        House Wellesley = new House("Wellesley", 400, owner, 4);
        Block a = Wellesley.getGenesis();
        //create person
        Person lian = new Person("Lian", "hi");
        //buy tokens from owner
        Block b = lian.buyTokens(2, owner, "000");
        
        
        //create another person
        
        //person buy from other person
    }   
}
