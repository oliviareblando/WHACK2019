
/**
 * Write a description of class Person here.
 *
 * @Hannah and ogblando
 */
public class Person
{
    // instance variables - replace the example below with your own
    int tokens; //you can buy half a token
    String name;
    String key;
    boolean votingRights;
   

    /**
     * Constructor for objects of class Person
     */
    public Person( String nm, String k)
    {
        // initialise instance variables
        this.tokens = 0;
        this.name = nm;
        this.key = k;
        this.votingRights = false;
    }
    
    public int getTokens(){
        return this.tokens;
    }
    
    public void setTokens(int x){
        this.tokens = x;
    }
    
    public void changeVotingRights(){
        votingRights = !votingRights;
    }

    /**
     * The person is buying tokens
     * This means someone else has sold their tokens to you
     * At the very beginning, all of the tokens are owned by the house owner
     */
    public Block buyTokens(int x, Person seller, String previousHash)
    {
        tokens += x;
        seller.setTokens(seller.getTokens() - x);
        
        //you create a block because an action was taken
        String blockData = seller+"_sells_" + x + "_to_" + this.name+ "_Block";
        Block b = new Block(blockData, previousHash, this);
        return b;
        
    }

    /**
     * The person is selling a token to a buyer
     */
    // public void sellToken(int x, Person buyer, String previousHash){
        // tokens -= x;
        // buyer.setTokens(buyer.getTokens() + x);
        
        // //you create a block because an action was taken
        // String blockData = this+"_sells_" + x + "_to_" + buyer+ "_Block";
        // Block b = new Block(blockData, previousHash, this);
        
        
    // }
}
